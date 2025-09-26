import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    @Test
    @DisplayName("초기 Node 생성 테스트")
    void createInitialNode() {
        // given & when & then
        assertThat(Node.from(0).getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("방향 계산 테스트")
    void computeDirectionTest() {
        // given
        Node node =  Node.from(0);

        //when
        Position start = Position.from(0, 0);
        Position end = Position.from(3, 0);
        node.computeDirection(start, end);

        //then
        assertThat(node.getValue()).isEqualTo(end.getX() - start.getX());
    }
}