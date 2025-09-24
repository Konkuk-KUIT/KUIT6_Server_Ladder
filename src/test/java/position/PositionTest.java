package position;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void Position_at_정상_생성_테스트() {
        Position position = Position.at(3, 5);
        
        assertEquals(3, position.getY());
        assertEquals(5, position.getX());
    }

    @Test
    void 음수_좌표_생성_테스트() {
        Position position = Position.at(-1, -2);
        
        assertEquals(-1, position.getY());
        assertEquals(-2, position.getX());
    }

    @Test
    void 경계값_영_좌표_생성_테스트() {
        Position position = Position.at(0, 0);
        
        assertEquals(0, position.getY());
        assertEquals(0, position.getX());
    }

    @Test
    void moveLeft_동작_및_반환값_테스트() {
        Position original = Position.at(3, 5);
        
        Coordinate moved = original.moveLeft();
        
        assertEquals(3, moved.getY());
        assertEquals(4, moved.getX());
        assertTrue(moved instanceof Position);
    }

    @Test
    void moveRight_동작_및_반환값_테스트() {
        Position original = Position.at(3, 5);
        
        Coordinate moved = original.moveRight();
        
        assertEquals(3, moved.getY());
        assertEquals(6, moved.getX());
        assertTrue(moved instanceof Position);
    }

    @Test
    void moveUp_동작_및_반환값_테스트() {
        Position original = Position.at(3, 5);
        
        Coordinate moved = original.moveUp();
        
        assertEquals(2, moved.getY());
        assertEquals(5, moved.getX());
        assertTrue(moved instanceof Position);
    }

    @Test
    void 이동_후_원본_객체_불변성_테스트() {
        Position original = Position.at(3, 5);
        
        original.moveLeft();
        original.moveRight();
        original.moveUp();
        
        assertEquals(3, original.getY());
        assertEquals(5, original.getX());
    }

    @Test
    void equals_동일_좌표_객체_비교_테스트() {
        Position position1 = Position.at(3, 4);
        Position position2 = Position.at(3, 4);
        
        assertEquals(position1, position2);
    }

    @Test
    void equals_다른_좌표_객체_비교_테스트() {
        Position position1 = Position.at(3, 4);
        Position position2 = Position.at(3, 5);
        Position position3 = Position.at(4, 4);
        
        assertNotEquals(position1, position2);
        assertNotEquals(position1, position3);
    }

    @Test
    void equals_null_객체_비교_테스트() {
        Position position = Position.at(3, 4);
        
        assertNotEquals(position, null);
    }

    @Test
    void hashCode_일관성_테스트() {
        Position position = Position.at(3, 4);
        int hash1 = position.hashCode();
        int hash2 = position.hashCode();
        
        assertEquals(hash1, hash2);
    }

    @Test
    void hashCode_equals_객체_동일_해시_테스트() {
        Position position1 = Position.at(3, 4);
        Position position2 = Position.at(3, 4);
        
        assertEquals(position1.hashCode(), position2.hashCode());
    }

    @Test
    void toString_형식_검증_테스트() {
        Position position = Position.at(3, 4);
        
        String result = position.toString();
        
        assertEquals("Position{y=3, x=4}", result);
    }

    @Test
    void Coordinate_인터페이스_구현_확인() {
        Position position = Position.at(1, 1);
        
        assertTrue(position instanceof Coordinate);
    }

    @Test
    void Movable_인터페이스_구현_확인() {
        Position position = Position.at(1, 1);
        
        assertTrue(position instanceof Movable);
    }
}