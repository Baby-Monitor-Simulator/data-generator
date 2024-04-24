package babysimulator.datagenerator.controllers;

import babysimulator.datagenerator.ctgsimulator.CTGSimulator;
import babysimulator.datagenerator.messagebus.MessageBus;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room")
public class SimulatorController {
    private CTGSimulator simulator;
    private MessageBus broker;

    @Autowired
    public SimulatorController(CTGSimulator sim, MessageBus messageBus){
        simulator = sim;
        broker = messageBus;
    }

    // NOTE: this method should be split into multiple parts
    // first a room is created (addRoom), body should be more than just an integer
    // then a room can be started -> this should be a separate api call, an update maybe?
    // in the update room, the status of the room should be checked
    // if it goes from not started -> started, then the data should get pushed every few ms
    @PostMapping
    public void addRoom(@RequestBody Integer roomId) {
        System.out.println("Room added with roomId: " + roomId);
        startPublishing();
    }

    private void startPublishing() {
        long startTime = System.currentTimeMillis();
        for(int count = 0; count <= 10; count++) {
            JsonObject json = simulator.createJSONData(System.currentTimeMillis(), startTime);

            // NOTE: Once the API call has been added, the topic and message should be variables instead of hardcoded
            try {
                broker.publishToTopic("1", json.toString());
                Thread.sleep(50);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
