package com.harman.its.listenerqueue;

import java.io.File;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import com.harman.its.afcs.Server;
import com.harman.its.utils.FileValidation;
import com.harman.its.utils.QueueConnection;

/**\
 * 
 * @author HDamodaran
 *
 */
class ListenerQueue extends Thread{

	static int valueset=0; 
	QueueConnection queueCon;	
	FileValidation validation; 
	Server afcsServer;
	File fd;
	boolean connection;
	boolean flag;
	boolean response;
	boolean val = false;

	ListenerQueue(){
		queueCon=new QueueConnection();
		validation=new FileValidation();
		afcsServer=new Server();
		fd=null;
	}

	/**\
	 * 
	 * Consumer of ActiveMQ
	 * 
	 */
	synchronized public boolean consumer(){
		try {
			if(valueset == 1){
				wait();
			}
			else{				 
				Message message=queueCon.queueConsumer();
				if(message == null)	{
					System.out.println("No messages in the queue...");
					System.out.println("Connection Closed");
					queueCon.queueConnectionClose();
					return false;
				}
				System.out.println("Message Consumed"); 
				if (message instanceof ObjectMessage) {
					ObjectMessage textMessage = (ObjectMessage) message;
					fd=(File) textMessage.getObject();
					flag=validation.fileName(fd);
					if(flag == false){
						System.out.println("Connection Closed");
						queueCon.queueConnectionClose();
						return false;
					}
				}
				valueset=0;
				notifyAll();
			} 
		} catch (JMSException | InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return false;
		}
		return true;
	}

	/**\
	 * 
	 * In this  run method retrieves the files from ActiveMQ and
	 * send it to AFCS server.If it fails to send to server then
	 * again it pushes to queue
	 * 
	 */

	@Override
	public void run() {
		System.out.println("Run Method");
		connection=queueCon.initialConnections();
		//while(true) {	
		if(connection == false) {
			System.out.println("Connection Closed");
			queueCon.queueConnectionClose();
		}
		flag=consumer();	
		if(flag != false) {
			response=afcsServer.serverConnection(fd);
			if(response == false){
				val=queueCon.queueProducer(fd);
			}
			System.out.println("File is transferred to Server :" +(!(val)));
			System.out.println("File is put back to Queue :"+val);
			System.out.println("Connection Closed");
		}
		queueCon.queueConnectionClose();
	//}
}
	
}

/**\
 * 
 * Main Class
 *
 *
 */
public class QueueManagement {
	public static void main(String[] args) {
		System.out.println("Listener Queue");
		ListenerQueue listener=new ListenerQueue();
		System.out.println("Thread Started");
		Thread t1=new Thread(listener);
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in thread");
			e.printStackTrace();
		}
	}
}
