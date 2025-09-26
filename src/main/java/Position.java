public class Position {
    private NaturalNumber index;

    public Position(NaturalNumber index, NaturalNumber last) {
        if(index.value() >= last.value()) {
            throw new IllegalArgumentException("범위를 벗어났습니다.");
        }
        this.index = index;
    }

    public int value() {
        return index.value();
    }

    //오른쪽 이동
    public Position moveRight(NaturalNumber max) {
        return new Position(index.add(1), max);
    }

    //왼쪽 이동
    public Position moveLeft(NaturalNumber max) {
        return new Position(index.subtract(1), max);
    }
}
