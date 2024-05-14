package babysimulator.datagenerator.ctgsimulator;

import java.util.ArrayList;

public class GraphSet {
    public ArrayList<GraphValue> values = new ArrayList<GraphValue>();

    public GraphSet() {
        GraphValue fetalBlood = new GraphValue("fetalBlood", "Po2", 10, 20);
        GraphValue fetalBloodPressure = new GraphValue("fetalBloodPressure", "MAP", 35, 55);
        GraphValue uterineContractions = new GraphValue("uterineContractions", "UP", 0, 100);
        GraphValue fetalHeartRate = new GraphValue("fetalHeartRate", "FHR", 60, 200);

        values.add(fetalBlood);
        values.add(fetalBloodPressure);
        values.add(uterineContractions);
        values.add(fetalHeartRate);
    }
}
