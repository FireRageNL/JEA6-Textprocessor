package TextProcessor.RestController;

import TextProcessor.RestController.Domain.TextProcess;
import TextProcessor.RestController.Domain.WordCountModel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagingService {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private Queue wordJob;

	@Autowired
	private Queue mostJob;

	public void sendMessage(TextProcess message){
		if(message.amountOfWords){
			template.convertAndSend(wordJob.getName(),message);
		}
		if(message.mostOccuringCharacter){
			template.convertAndSend(mostJob.getName(),message);
		}
	}

}
