package com.harman.its.listenerqueue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Message;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageConsumer;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.command.ActiveMQDestination;

public class Consumer {
   
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String queueName = "Files";

    public static void main(String[] args) {
   
         ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(url);
         Connection connection;
		try {
		 connection = (ActiveMQConnection) connectionFactory.createConnection();
		 connection.start();
		 Session session=(ActiveMQSession) connection.createSession(false, ActiveMQSession.AUTO_ACKNOWLEDGE);
	     Destination destination=(ActiveMQDestination) session.createQueue(queueName);
		 MessageConsumer consumer=(ActiveMQMessageConsumer) session.createConsumer(destination);
		 Message msg=consumer.receive();
		 if (msg instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) msg;
            System.out.println("Received message '"+ textMessage.getText() + "'");
        }
        connection.close();
        
		} catch (JMSException e) {
			// TODO Auto-generated catch block

		}
    }
}