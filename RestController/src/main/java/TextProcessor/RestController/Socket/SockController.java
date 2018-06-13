package TextProcessor.RestController.Socket;

import TextProcessor.RestController.Domain.MostUsedCharacterModel;
import TextProcessor.RestController.Domain.SocketModel;
import TextProcessor.RestController.Domain.WordCountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class SockController {

	private final SimpMessagingTemplate template;

	@Autowired
	SockController(SimpMessagingTemplate template){
		this.template = template;
	}

	public void SendWordCount(WordCountModel model){
		SocketModel toSend = new SocketModel("Count",Integer.toString(model.wordCount));
		this.template.convertAndSend("/update/"+model.id,toSend);
	}

	public void SendMostUsedCharacter(MostUsedCharacterModel model){
		SocketModel toSend = new SocketModel("Most",Integer.toString(model.value),model.character);
		this.template.convertAndSend("/update/"+model.id,toSend);
	}
}
