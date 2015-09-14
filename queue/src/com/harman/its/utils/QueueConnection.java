package com.harman.its.utils;

import java.io.File;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;

/**\
 * 
 * @author HDamodaran
 *
 */
public class QueueConnection {

	// Private variables 
	 private ConnectionFactory connectionFactory;
	 private Connection connection;
	 private Session session;
	 private Destination destination;
	 private MessageConsumer consumer;
	 private MessageProducer producer;	
	 
	 private final static String url = ActiveMQConnection.DEFAULT_BROKER_URL;  // Default Connection URL
	 private final static String queueName = "Files";    // Queue Name
	 
	 /**\
	  * 
	  * Queue Connections
	  * 
	  */
	 
	 public boolean initialConnections() {
		 connectionFactory=new ActiveMQConnectionFactory(url);
		 try {
			connection=connectionFactory.createConnection();
			connection.start();                                 // Starting the Connection
		    session=connection.createSession(false, ActiveMQSession.AUTO_ACKNOWLEDGE);
		    destination=session.createQueue(queueName);
		 } catch (JMSException e) {
				// TODO Auto-generated catch block
			System.out.println("Error in Connection !!  "+e);
			return false;
			}	
		 return true;
	 }
	 
	/**\
	 * 
	 * Initiates the consumer to retrieve the message from
	 * queue
	 */
	 
	public Message queueConsumer() {
		Message message=null;
		try {
			consumer=session.createConsumer(destination);
			message=consumer.receive(10000);			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in retreiving the message from queue");
			e.printStackTrace();
			return null;
		}
		return message;
	}
	
	/**\
	 * Initiates to put the message into the queue
	 * 
	 */
	
	public boolean queueProducer(File file) {
		Message message=null;
		try {
			producer=session.createProducer(destination);
			message=session.createObjectMessage(file);
			producer.send(message);
						
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in putting the message into the queue");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**\
	 * 
	 * Queue Connection Terminates
	 * 
	 */

	public void queueConnectionClose() {
		try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in terminating the connection with queue");
			e.printStackTrace();
		}
	}
}
