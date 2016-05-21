package in.mhatre.sagar.spring.integration;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

public class HelloService {
	
	private static Logger logger = Logger.getLogger(HelloService.class);
	
	public String sayHello(String name) {
		return "Hello " + name;
	}
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("hello-world.xml");
		MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);
		PollableChannel outputChannel = context.getBean("outputChannel", PollableChannel.class);
		inputChannel.send(new GenericMessage<String>("World"));
		logger.info("==> HelloWorldDemo: " + outputChannel.receive(0).getPayload());
	}

}
