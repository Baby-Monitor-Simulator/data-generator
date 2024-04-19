package babysimulator.datagenerator;

import babysimulator.datagenerator.messagebus.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataGeneratorApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DataGeneratorApplication.class, args);

		MessageBus broker = new RabbitMQ();

		// Connection retries still have to be added
		broker.connect("localhost");

		// Once the API call has been added, the topic and message should be variables instead of hardcoded
		broker.publishToTopic("1", "test message");
	}

}
