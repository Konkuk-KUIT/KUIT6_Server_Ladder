import java.util.HashMap;
import java.util.Map;

public class DrawLineStrategyFactory {
    private static final Map<DrawLineStrategyType, DrawLineStrategy> strategies =  new HashMap<>();

    static{
        strategies.put(DrawLineStrategyType.LEFT, new DrawLeftLineStrategy());
        strategies.put(DrawLineStrategyType.RIGHT, new DrawRightLineStrategy());
        strategies.put(DrawLineStrategyType.MIDDLE, new DrawMiddleLineStrategy());
    }

    public static DrawLineStrategy getInstance(DrawLineStrategyType type){
        DrawLineStrategy strategy = strategies.get(type);
        if(strategy == null){
            throw new NullPointerException("DrawLineStrategy Not Found");
        }
        return strategy;
    }
}
