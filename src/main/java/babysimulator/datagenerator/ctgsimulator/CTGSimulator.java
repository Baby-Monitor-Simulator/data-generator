package babysimulator.datagenerator.ctgsimulator;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

@Service
public class CTGSimulator {
    private static final GraphSet set = new GraphSet();

    public JsonObject createJSONData(long currentTime, long startTime) {
        JsonObject obj = new JsonObject();
        obj.addProperty("x", currentTime - startTime);

        for (GraphValue val: set.values) {
            Random random = new Random();
            val.value = random.nextInt(val.upperBoundary - val.lowerBoundary) + 1;
            obj.addProperty(val.title, val.value);
        }

        return obj;
    }
}
