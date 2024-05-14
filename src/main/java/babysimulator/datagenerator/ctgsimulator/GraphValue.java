package babysimulator.datagenerator.ctgsimulator;

public class GraphValue {
    String title;
    String unit;
    Integer lowerBoundary;
    Integer upperBoundary;
    Integer value;

    public GraphValue(String title, String unit, Integer lb, Integer ub) {
        this.title = title;
        this.unit = unit;
        this.lowerBoundary = lb;
        this.upperBoundary = ub;
    }
}
