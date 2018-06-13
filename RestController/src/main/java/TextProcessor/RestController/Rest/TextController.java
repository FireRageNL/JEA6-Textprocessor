package TextProcessor.RestController.Rest;

import TextProcessor.RestController.Domain.TextProcess;
import TextProcessor.RestController.Helpers.RestHelper;
import TextProcessor.RestController.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.OPTIONS;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/text")
public class TextController {

	@Autowired
	MessagingService service;

	@PostMapping
	@CrossOrigin
	public void postMessage(@RequestBody TextProcess msg){
		service.sendMessage(msg);
	}

	@GetMapping
	public String sendReply(){
		return "hi";
	}


}
