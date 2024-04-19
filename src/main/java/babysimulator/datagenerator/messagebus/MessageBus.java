package babysimulator.datagenerator.messagebus;

public interface MessageBus {
    public void connect(String connectionString) throws Exception;
    public void publishToTopic(String topicName, String message) throws Exception;
}
