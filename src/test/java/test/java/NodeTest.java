package test.java;

import ladder.core.Direction;
import ladder.core.Node;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;



class NodeTest {

    @Test
    @DisplayName("NONE/LEFT/RIGHT 상태 조회")
    void directionFlags() {
        assertThat(Node.from(Direction.NONE).isNone()).isTrue();
        assertThat(Node.from(Direction.LEFT).isLeft()).isTrue();
        assertThat(Node.from(Direction.RIGHT).isRight()).isTrue();
    }

    @Test
    @DisplayName("setRightNode/setLeftNode로 상태 전환")
    void mutateDirection() {
        Node n = Node.from(Direction.NONE);
        assertThat(n.isNone()).isTrue();

        n.setRightNode();
        assertThat(n.isRight()).isTrue();

        n.setLeftNode();
        assertThat(n.isLeft()).isTrue();
    }

    @Test
    @DisplayName("방향이 설정되었는지 여부")
    void alreadySet() {
        assertThat(Node.from(Direction.NONE).isAleadySetDirection()).isFalse();
        assertThat(Node.from(Direction.LEFT).isAleadySetDirection()).isTrue();
        assertThat(Node.from(Direction.RIGHT).isAleadySetDirection()).isTrue();
    }
}