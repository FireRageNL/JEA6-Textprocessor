package TextProcessor.WordCountService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class Receiver {

	@Autowired
	private WordCount service;

	@Autowired
	private Sender sender;

	@RabbitListener(queues = "WordCountJob")
	public void recieve(TextProcess text){
		if(text.amountOfWords){
			System.out.println("Processing wordcount job!");
			int Amount = service.getWordCount(text.text);
			WordCountModel count = new WordCountModel(Amount,text.id);
			sender.SendMessage(count);
		}
	}


}
