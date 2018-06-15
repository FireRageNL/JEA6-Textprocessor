package TextProcessor.LetterCountService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class Receiver {

	@Autowired
	private LetterCount service;

	@Autowired
	private Sender sender;

	@RabbitListener(queues = "MostJob")
	public void recieve(TextProcess text){
		if(text.mostOccuringCharacter){
			System.out.println("Recieved most letter job!");
			sender.SendMessage(service.getMostOccuringLetter(text.text,text.id));
		}
	}


}
