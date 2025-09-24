package ladder;

import ladder.domain.Direction;
import ladder.domain.Node;
import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NodeTest {

    @Test
    @DisplayName("오른쪽 방향 위치 이동 확인")
    public void rightDirectionMove() throws Exception {
        //given
        Node node = Node.from(Direction.RIGHT);
        //when
        Position position = Position.from(1);
        Position movedPosition = node.move(position);
        //then
        assertThat(movedPosition.getValue()).isEqualTo(2);
     }

    @Test
    @DisplayName("NONE 방향 위치 이동 확인")
    public void noneDirectionMove() throws Exception {
        //given
        Node node = Node.from(Direction.NONE);
        //when
        Position position = Position.from(0);
        Position movedPosition = node.move(position);
        //then
        assertThat(movedPosition.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("왼쪽 방향 위치 이동 확인")
    public void leftDirectionMove() throws Exception {
        //given
        Node node = Node.from(Direction.LEFT);
        //when
        Position position = Position.from(1);
        Position movedPosition = node.move(position);
        //then
        assertThat(movedPosition.getValue()).isEqualTo(0);
    }

}