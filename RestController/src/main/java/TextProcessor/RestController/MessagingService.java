package TextProcessor.RestController;

import TextProcessor.RestController.Domain.TextProcess;
import TextProcessor.RestController.Domain.WordCountModel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagingService {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private FanoutExchange exchange;

	public void sendMessage(TextProcess message){
		template.convertAndSend(exchange.getName(),"",message);
	}

}
