import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NodeTest {
    @Test
    @DisplayName("오른쪽 이동 확인")
    void moveRight () {
        //given
        Position position = Position.from(0);
        //when
        Node node = Node.from(Direction.RIGHT);
        node.move(position);
        //then
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽 이동 확인")
    void moveLeft () {
        //given
        Position position = Position.from(1);
        //when
        Node node = Node.from(Direction.LEFT);
        node.move(position);
        //then
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("none일 때 이동하지 않음")
    void noMove () {
        //given
        Position position = Position.from(0);
        //when
        Node node = Node.from(Direction.NONE);
        node.move(position);
        //then
        assertThat(position.getPosition()).isEqualTo(0);
    }
}
