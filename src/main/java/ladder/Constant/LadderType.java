package ladder.Constant;

public enum LadderType {
    LADDER_TYPE_AUTO("AUTO"),
    LADDER_TYPE_MANUAL("MANUAL");

    private final String type;

    LadderType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
