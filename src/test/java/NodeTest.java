import ladder.unit.Direction;
import ladder.unit.Node;
import ladder.unit.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NodeTest {
    @Test
    @DisplayName("오른쪽 방향 위치 이동 확인")
    void rightDirectionMove () throws Exception {
        //given
        Node node = Node.from(Direction.RIGHT);
        Position position = Position.from(0);

        //when
        node.move(position);

        //then
        assertThat(position.getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("NONE 방향 위치 이동 확인")
    void noneDirectionMove () throws Exception {
        //given
        Node node = Node.from(Direction.NONE);
        Position position = Position.from(0);

        //when
        node.move(position);

        //then
        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("왼쪽 방향 위치 이동 확인")
    void leftDirectionMove () throws Exception {
        //given
        Node node = Node.from(Direction.LEFT);
        Position position = Position.from(1);

        //when
        node.move(position);

        //then
        assertThat(position.getValue()).isEqualTo(0);
    }
}