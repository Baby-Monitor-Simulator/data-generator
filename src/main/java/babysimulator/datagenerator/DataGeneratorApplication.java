package babysimulator.datagenerator;

import babysimulator.datagenerator.ctgsimulator.CTGSimulator;
import babysimulator.datagenerator.messagebus.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataGeneratorApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DataGeneratorApplication.class, args);

		TestCTGSimulator();

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

		// NOTE: Once the API call has been added, the topic and message should be variables instead of hardcoded
		broker.publishToTopic("1", "test message");
	}

	// NOTE: Remove this method to the websockets implementation once it's done
	private static void TestCTGSimulator() throws InterruptedException {
		CTGSimulator sim = new CTGSimulator();

		long startTime = System.currentTimeMillis();
		for(int count = 0; count <= 10; count++) {
			System.out.println(sim.createJSONData(System.currentTimeMillis(), startTime));
			Thread.sleep(50);
		}
	}
}
