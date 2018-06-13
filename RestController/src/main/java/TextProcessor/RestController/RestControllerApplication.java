package TextProcessor.RestController;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestControllerApplication {


	private static final String topicName = "TextsToProcess";

	public static void main(String[] args) {
		SpringApplication.run(RestControllerApplication.class, args);
	}


	@Bean
	public FanoutExchange fanout(){
		return new FanoutExchange(topicName);
	}

	@Bean
	public Queue queue1(){
		return new AnonymousQueue();
	}

	@Bean
	public Queue replyQueue(){
		return new Queue("WordCountReply");
	}

	@Bean
	public Queue mostReplyQueue() { return new Queue("MostOccuringLetter");}

	@Bean
	public Binding binding1(FanoutExchange fanout, Queue queue1){
		return BindingBuilder.bind(queue1).to(fanout);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public MessageReceiver reciever(){
		return new MessageReceiver();
	}

}
