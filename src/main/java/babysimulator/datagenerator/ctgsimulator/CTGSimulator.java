package babysimulator.datagenerator.ctgsimulator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class CTGSimulator {
    private GraphSet set = new GraphSet();

    public void createJSONData() {

    }

    private GraphSet generateYValue() {
        for (GraphValue val: set.values) {
            Random random = new Random();
            val.value = random.nextInt(val.upperBoundary - val.lowerBoundary) + 1;
        }

        return set;
    }
}
