package in.mhatre.sagar.spring.integration;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

public class BasicJMS {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("jms.xml");
		MessageChannel inputChannel = context.getBean("stdinToJmsoutChannel", MessageChannel.class);		
		inputChannel.send(new GenericMessage<String>("Hello JMS World"));
		
		PollableChannel outputChannel = context.getBean("jmsInChannel", PollableChannel.class);		
		System.out.println("Received from JMS : " + outputChannel.receive(0).getPayload());
	}
}
