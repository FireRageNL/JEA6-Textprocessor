package TextProcessor.LetterCountService;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class Sender {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private Queue replyQueue;

	public void SendMessage(MostUsedCharacterModel model){
		this.template.convertAndSend(replyQueue.getName(),model);
		model = null;
	}
}
