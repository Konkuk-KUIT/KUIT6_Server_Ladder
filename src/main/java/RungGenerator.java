/**
 * 사다리의 가로선(Rung)을 생성하는 전략에 대한 인터페이스입니다.
 */
public interface RungGenerator {
    /**
     * 주어진 Ladder 객체에 정책에 맞게 가로선을 그립니다.
     * @param ladder 가로선을 그릴 사다리 객체
     */
    void generate(Ladder ladder);
}