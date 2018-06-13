package TextProcessor.LetterCountService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class Receiver {

	@Autowired
	private LetterCount service;

	@Autowired
	private Sender sender;

	@RabbitListener(queues = "#{queue1.name}")
	public void recieve(TextProcess text){
		if(text.mostOccuringCharacter){
			sender.SendMessage(service.getMostOccuringLetter(text.text,text.id));
			text = null;
		}
	}


}
