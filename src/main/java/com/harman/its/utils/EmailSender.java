//package com.harman.its.utils;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Properties;
//import java.util.Timer;
//import java.util.TimerTask;
//
//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.activation.FileDataSource;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.NoSuchProviderException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//
//import org.apache.log4j.Logger;
//
//import com.harman.its.dao.impl.EmailDetailsDaoImpl;
//import com.harman.its.dao.impl.UserToOperatorDaoImpl;
//import com.harman.its.entity.EmailDeatilsEntity;
//import com.harman.its.entity.ReportGenerateEntity;
//import com.harman.its.entity.UserToOperator;
//
//public class EmailSender extends TimerTask {
//	private  static long ONCE_PER_DAY = 1000*60*60*24;
//	private  static int ELEVEN_PM = 23;
//	private  static int FIFTY_MINUTE = 50;
//	private  static int ZERO = 0;
//	Logger logger = Logger.getLogger(getClass());
//	private static  String SMTP_HOST_NAME = "smtp.gmail.com";
//	private static  int SMTP_HOST_PORT = 465;
//	//Username : brts-reports
//	private static final String SMTP_AUTH_USER = "brts-reports@i10n.com";
//	private static final String SMTP_AUTH_PWD = "kacHa8hu";
//
//
//	@Override
//	public void run() {
//		logger.debug("Task has been started @ "+new Date());
//		UserToOperatorDaoImpl userToOperatorDaoImpl = new UserToOperatorDaoImpl();
//		List<UserToOperator> operatorList = userToOperatorDaoImpl.selectAll();
//		for(int operatorIndex=0;operatorIndex<operatorList.size()-1;operatorIndex++){
//			UserToOperator operator = operatorList.get(operatorIndex);
//			try {
//				EmailDetailsDaoImpl emailDaoImpl = new EmailDetailsDaoImpl();
//				List<EmailDeatilsEntity> emailsList = emailDaoImpl.selectByOperatorId(operator.getOperatorId());
//				logger.debug("Users List is "+emailsList.size());
//				if(emailsList.size() == 0){
//					logger.warn("No user has subscribed for email reports ");
//					continue;
//				}
//				String[] filePaths = new String[2]; 
//				Calendar startDate = Calendar.getInstance();
//				startDate.set(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), startDate.get(Calendar.DATE), 0, 0, 0);
//
//				Calendar endDate = Calendar.getInstance();
//				endDate.set(endDate.get(Calendar.YEAR), endDate.get(Calendar.MONTH), endDate.get(Calendar.DATE), 23, 59, 59);
//				
//				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				ReportGenerateUtils repoGenerateUtils = new ReportGenerateUtils();
//				ReportGenerateEntity summaryReportEntity = repoGenerateUtils.getReportEntity(operator.getOperatorId(),"Transaction",
//						"summary",dateformat.format(startDate.getTime()),dateformat.format(endDate.getTime()));
//				ReportGenerateEntity deatiledReportEntity = repoGenerateUtils.getReportEntity(operator.getOperatorId(),"Transaction",
//						"deatiled",dateformat.format(startDate.getTime()),dateformat.format(endDate.getTime()));
//				ExportUtils exportUtils = new ExportUtils();
//				logger.debug("Data list size is "+summaryReportEntity.getReportDataList().size());
//				if(summaryReportEntity.getReportDataList().size() != 0 ){
//					filePaths[0] = exportUtils.exportData("excel",summaryReportEntity, "summary");
//					filePaths[1] = exportUtils.exportData("excel",deatiledReportEntity, "detailed");	
//				}else{
//					logger.warn("No Data for sepecified criteria ");
//					continue;
//				}
//				try {
//					String bodyMessage = "Transaction report from "+dateformat.format(startDate.getTime())
//							+" to "+dateformat.format(endDate.getTime())+" of operator "+operator.getOperatorName();
//					sendEmailWithMultipleAttachments(emailsList, "Transaction Reports ", bodyMessage, filePaths);
//				} catch (AddressException e) {
//					logger.debug("Erorr while sending Mail ",e);
//				} catch (MessagingException e) {
//					logger.debug("Erorr while sending Mail ",e);
//				}
//			} catch (ClassNotFoundException e) {
//				logger.error("Error while fetching report for Mail reports ",e);
//			} catch (SQLException e) {
//				logger.error("Error while fetching report for Mail reports ",e);
//			} catch (Exception e){
//				logger.error("Error while sending reports over email",e);
//			}
//		}
//	}
//	public void startMailReportsTask(){
//		EmailSender task = new EmailSender();
//		Timer timer = new Timer();  
//		timer.schedule(task,getScheduledTime(),ONCE_PER_DAY);
//	}
//	
//	private Date getScheduledTime(){
//		Calendar scheduledAt = Calendar.getInstance();
//		scheduledAt.set(scheduledAt.get(Calendar.YEAR), scheduledAt.get(Calendar.MONTH), scheduledAt.get(Calendar.DATE), ELEVEN_PM, FIFTY_MINUTE, ZERO);
//		logger.debug("Scheduled time is : "+scheduledAt.getTime().toString());
//		return scheduledAt.getTime();
//	}
//	public void sendMail(String mailId,int duration, int deviceType) {
//
//		Properties props = new Properties();
//		props.put("mail.transport.protocol", "smtps");
//		props.put("mail.smtps.host", SMTP_HOST_NAME);
//		props.put("mail.smtps.auth", "true");
//
//		Session mailSession = Session.getDefaultInstance(props);
//		mailSession.setDebug(false);
//		Transport transport = null;
//		try {
//			transport = mailSession.getTransport();
//			MimeMessage message = new MimeMessage(mailSession);
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailId));
//			message.setSubject("Device Alert");
//			message.setText("Your terminal device of type "+deviceType+" has not updated for the past "+duration+" minutes");
//			transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER,SMTP_AUTH_PWD);
//			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
//
//		} catch (MessagingException e) {
//			logger.error("Error while sending Mail alert ",e);
//			throw new RuntimeException(e);
//		}
//	}
//	/**
//	 * Send attachments to the subscribed users. 
//	 * @param mailId
//	 * @param mailText
//	 * @param reportFilePath
//	 * @param filename
//	 */
//	public void sendMailWithAttachement(List<EmailDeatilsEntity> receipentsList, String mailText, String reportFilePath, String filename){
//
//		Properties props = new Properties();
//
//		props.put("mail.transport.protocol", "smtps");
//		props.put("mail.smtps.host", SMTP_HOST_NAME);
//		props.put("mail.smtps.auth", "true");
//
//		Session mailSession = Session.getDefaultInstance(props);
//		mailSession.setDebug(false);
//		Transport transport = null;
//		try {
//			transport = mailSession.getTransport();
//			MimeMessage message = new MimeMessage(mailSession);
//			Calendar cal = Calendar.getInstance();
//			Date date = cal.getTime();
//			message.setSubject("Automated Transaction Reports from H-ITS for "+date.toString());
//
//			// creates message part
//			MimeBodyPart messageBodyPart = new MimeBodyPart();
//			messageBodyPart.setContent(message, "html");
//
//			MimeBodyPart messagePart = new MimeBodyPart();
//			messagePart.setText(mailText);
//
//			// creates multi-part
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBodyPart);
//			DataSource source = new FileDataSource(reportFilePath);
//			messageBodyPart.setDataHandler(new DataHandler(source));
//			messageBodyPart.setFileName(filename);
//			multipart.addBodyPart(messagePart);
//			multipart.addBodyPart(messageBodyPart);
//
//
//			message.setContent(multipart);
//			for(EmailDeatilsEntity emailEntity : receipentsList){
//				logger.debug("Sending mail to "+emailEntity.getEmailId());
//				message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailEntity.getEmailId()));	
//			}
//			transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER,SMTP_AUTH_PWD);
//			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
//			logger.debug("Mail Sent successfully to "+message.getRecipients(Message.RecipientType.TO));
//		} catch ( NoSuchProviderException e) {
//			logger.error("Error while getting trasport instance for Mail session",e);
//		} catch ( MessagingException e) {
//			logger.error("Error while sending mail ",e);
//		} finally {
//			if(transport != null )
//				try {
//					transport.close();
//				} catch ( MessagingException e) {
//					logger.error("Error while closing the mail transport service");
//				}
//		}
//	}
//	/**
//	 * @param emailsList
//	 * @param subject
//	 * @param message
//	 * @param attachFiles
//	 * @throws AddressException
//	 * @throws MessagingException
//	 */
//	public void sendEmailWithMultipleAttachments(List<EmailDeatilsEntity> emailsList,String subject, String message, String[] attachFiles)
//			throws AddressException, MessagingException {
//		logger.debug("You are in sending mail with attachments ");
//		// sets SMTP server properties
//		Properties properties = new Properties();
//		properties.put("mail.transport.protocol", "smtps");
//		properties.put("mail.smtps.host", SMTP_HOST_NAME);
//		properties.put("mail.smtps.auth", "true");
//		// creates a new session without an authenticator
//		Session session = Session.getInstance(properties);
//		session.setDebug(false);
//		// creates a new e-mail message
//		Message msg = new MimeMessage(session);
//		for(EmailDeatilsEntity emailDeatilsEntity : emailsList){
//			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailDeatilsEntity.getEmailId()));
//		}
//		msg.setRecipients(Message.RecipientType.TO, msg.getRecipients(Message.RecipientType.TO));	
//		msg.setSubject(subject);
//		msg.setSentDate(new Date());
//
//		// creates message part
//		MimeBodyPart messageBodyPart = new MimeBodyPart();
//		messageBodyPart.setContent(message, "text/html");
//
//		// creates multi-part
//		Multipart multipart = new MimeMultipart();
//		multipart.addBodyPart(messageBodyPart);
//		// adds attachments
//		if (attachFiles != null && attachFiles.length > 0) {
//			for (String filePath : attachFiles) {
//				MimeBodyPart attachPart = new MimeBodyPart();
//				try {
//					attachPart.attachFile(filePath);
//				} catch (IOException ex) {
//					logger.error("Error while sending mail ",ex);
//				}
//				multipart.addBodyPart(attachPart);
//			}
//		}
//		// sets the multi-part as e-mail's content
//		msg.setContent(multipart);
//		Transport transport = session.getTransport();
//		transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER,SMTP_AUTH_PWD);
//		transport.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
//	}
//}
