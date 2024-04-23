package babysimulator.datagenerator.messagebus;

import com.rabbitmq.client.*;

import java.util.ArrayList;
import java.util.List;

public class RabbitMQ implements MessageBus {
    Connection connection;
    final private String graphExchange = "graphdata";
    private Channel publishChannel;

    public void connect(String connectionString) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(connectionString);
        connection = factory.newConnection();

        publishChannel = connection.createChannel();
    }

    public void publishToTopic(String topicName, String message) throws Exception {
        publishChannel.basicPublish(graphExchange, topicName, null, message.getBytes("UTF-8"));
        System.out.println("Sent message: " + message + " to topic: " + topicName);
    }
}
