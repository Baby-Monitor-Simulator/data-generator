package babysimulator.datagenerator.ctgsimulator;

//public enum GraphSet {
//    FETAL_BLOOD("fetalBlood", "Po2"),
//    FETAL_BLOOD_PRESSURE("fetalBloodPressure", "MAP"),
//    UTERINE_CONTRACTIONS("uterineContractions", "UP"),
//    FETAL_HEART_RATE("fetalHeartRate", "FHR");
//
//    public final String text;
//    public final String unit;
//    GraphSet(String text, String unit) {
//        this.text = text;
//        this.unit = unit;
//    }
//}

import java.util.ArrayList;

public class GraphSet {
    public ArrayList<GraphValue> values = new ArrayList<GraphValue>();

    public GraphSet() {
        GraphValue fetalBlood = new GraphValue("fetalBlood", "Po2", 0, 20);
        GraphValue fetalBloodPressure = new GraphValue("fetalBloodPressure", "MAP", 0, 20);
        GraphValue uterineContractions = new GraphValue("uterineContractions", "UP", 0, 20);
        GraphValue fetalHeartRate = new GraphValue("fetalHeartRate", "FHR", 0, 20);

        values.add(fetalBlood);
        values.add(fetalBloodPressure);
        values.add(uterineContractions);
        values.add(fetalHeartRate);
    }
}
