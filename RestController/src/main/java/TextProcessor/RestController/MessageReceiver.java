package TextProcessor.RestController;

import TextProcessor.RestController.Domain.MostUsedCharacterModel;
import TextProcessor.RestController.Domain.WordCountModel;
import TextProcessor.RestController.Socket.SockController;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageReceiver {


	@Autowired
	private SockController controller;

	@RabbitListener(queues="WordCountReply")
	public void recieve(WordCountModel model){
		System.out.println(model.wordCount);
		controller.SendWordCount(model);
	}

	@RabbitListener(queues="MostOccuringLetter")
	public void recieve(MostUsedCharacterModel model){
		controller.SendMostUsedCharacter(model);
	}
}
