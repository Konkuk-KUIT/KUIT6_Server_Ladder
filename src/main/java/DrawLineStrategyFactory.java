import java.util.HashMap;
import java.util.Map;

public class DrawLineStrategyFactory {
    private static final DrawLineStrategyMap strategies = new DrawLineStrategyMap();

    public static DrawLineStrategy getInstance(DrawLineStrategyType type){
        return strategies.get(type);
    }
}
