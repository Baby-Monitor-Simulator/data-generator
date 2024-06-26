package babysimulator.datagenerator;

import babysimulator.datagenerator.messagebus.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataGeneratorApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DataGeneratorApplication.class, args);

		MessageBus broker = new RabbitMQ();

		int maxTries = 5;
		for (int count = 0; count <= maxTries; count++) {
			try {
				broker.connect("localhost");
				break;
			} catch (Exception e) {
				if (count == maxTries) {
					throw new Exception("Cannot connect to RabbitMQ. Shutting down.");
				}
				int sleepTime = 500 * (int) Math.pow(2, count);
				Thread.sleep(sleepTime);
				System.out.println("Retrying connection...");
			}
		}

		// Once the API call has been added, the topic and message should be variables instead of hardcoded
		broker.publishToTopic("1", "test message");
	}

}
