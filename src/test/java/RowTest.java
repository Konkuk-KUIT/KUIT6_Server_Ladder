import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RowTest {
    @Test
    @DisplayName("연결 선 없이 사다리 이동")
    void moveNoLine () throws Exception {
        //when
        Row row = new Row(GreaterThanOne.from(2));

        //given
        Position position = Position.from(0);
        row.goToNext(position);
        
        //then
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("하나의 연결 선이 있는 사다리 이동")
    void moveOneLine () {
        //when
        Row row = new Row(GreaterThanOne.from(2));
        row.drawLine(Position.from(0));

        //given
        Position position = Position.from(0);
        row.goToNext(position);

        //then
        assertThat(position.getPosition()).isEqualTo(1);

        //given
        row.goToNext(position);

        //then
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("사람이 한 명이 넘지 않으면 에러")
    void moreThanOnePeople () {
        assertThatThrownBy(() -> new Row(GreaterThanOne.from(1))).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("시작 위치가 사람의 수보다 많으면 에러")
    void startIsBiggerThanPeople () {
        //given
        Row row = new Row(GreaterThanOne.from(3));
        //when
        Position position = Position.from(3);
        //then
        assertThatThrownBy(() -> row.goToNext(position)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("마지막 줄 이상에서는 사다리의 가로선을 긋지 못함")
    void cantDrawInLastLine () {
        //given
        Row row = new Row(GreaterThanOne.from(2));
        //when
        Position position = Position.from(1);
        //then
        assertThatThrownBy(() -> row.drawLine(Position.from(1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("좌측에 선이 이미 그어진 경우 우측 선 봉쇄")
    void rightLineAlreadyExist () {
        //given
        Row row = new Row(GreaterThanOne.from(3));
        row.drawLine(Position.from(0));

        //when & then
        assertThatThrownBy(() -> row.drawLine(Position.from(1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우측에 선이 이미 그어진 경우 좌측 선 봉쇄")
    void leftLineAlreadyExist () {
        //given
        Row row = new Row(GreaterThanOne.from(3));
        row.drawLine(Position.from(0));

        //when & then
        assertThatThrownBy(() -> row.drawLine(Position.from(0))).isInstanceOf(IllegalArgumentException.class);
    }
}
