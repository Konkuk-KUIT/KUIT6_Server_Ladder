public class CheckIndex {
    private CheckIndex() {} // 인스턴스화 방지

    public static void checkIndex(int i, Index index) {
        if (i == Direction.LEFT.getValue()) {
            index.sub();
            return;
        }
        if (i == Direction.RIGHT.getValue()) {
            index.add();
            return;
        }
    }
}