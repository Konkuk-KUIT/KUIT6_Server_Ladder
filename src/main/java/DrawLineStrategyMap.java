import java.util.EnumMap;
import java.util.Map;

public class DrawLineStrategyMap {
    private final Map<DrawLineStrategyType, DrawLineStrategy> strategies;

    public DrawLineStrategyMap() {
        strategies = new EnumMap<>(DrawLineStrategyType.class);
        strategies.put(DrawLineStrategyType.NORMAL, new DrawNormalLineStrategy());
        strategies.put(DrawLineStrategyType.RIGHT, new DrawRightLineStrategy());
    }

    public DrawLineStrategy get(DrawLineStrategyType type) {
        DrawLineStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("No strategy for type: " + type);
        }
        return strategy;
    }
}
