/*
* enum class란?
* 클래스처럼 보이게 하는 상수
* 서로 관련 있는 상수들끼리 모아 상수를 정의하는 것
*
* 1. 열거형으로 선언된 순서에 따라 0부터 index 값을 가진다.(순차적으로 증가)
* 2. enum 열거형으로 지정된 상수들은 모두 대문자로 선언한다.
* 3. 열거형 변수들을 선언한 후 마지막에 세미콜론(;)을 찍지 않는다.
* 4. 상수와 특정 값을 연결시킬경우 마지막에 세미콜론(;)을 붙여줘야한다.
* */

public enum Direction {
    // 요소에 특정 값(필드값)을 매핑 -> 필드값 추가 필요
    // LEFT: name, -1: value 가 됨
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    // 필드값 추가
    private final int value;

    // 필두값 추가시 생성자 추가 필수
    // 생성자는 언제 쓰이나? -> enum 상수가 단순 이름 이상으로 추가 정보(값)을 가질 때 초기화 용으로 사용
    // LEFT(-1) 부분이 사실상 생성자를 호출하는 부분
    // 생성자는 자동적으로 private이 되므로 따로 접근할 수 없음
    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
