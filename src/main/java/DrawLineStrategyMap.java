import java.util.EnumMap;
import java.util.Map;

public class DrawLineStrategyMap {
    private final Map<DrawLineStrategyType, DrawLineStrategy> strategies;

    public DrawLineStrategyMap() {
        strategies = new EnumMap<>(DrawLineStrategyType.class);
        strategies.put(DrawLineStrategyType.LEFT, new DrawLeftLineStrategy());
        strategies.put(DrawLineStrategyType.RIGHT, new DrawRightLineStrategy());
        strategies.put(DrawLineStrategyType.MIDDLE, new DrawMiddleLineStrategy());
    }

    public DrawLineStrategy get(DrawLineStrategyType type) {
        DrawLineStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("No strategy for type: " + type);
        }
        return strategy;
    }
}
