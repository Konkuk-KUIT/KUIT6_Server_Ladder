public class GreaterThanOne {

    private final int number;

    private GreaterThanOne(int number) {
        validate(number);
        this.number = number;
    }

    // 정적 팩토리 메소드 : new 키원드 대신 클래스 내부의 static 메소드로 객체를 만들어 반환하는 방식
    // 1. 생성자가 이름을 가질 수 있다.
    // new를 사용할 경우 생성자의 이름은 항상 클래스의 이름과 같아야 한다 -> 왜 이 클래스를 만드는지 의도가 불문명함
    // 정적 팩토리 메소드는 이름을 자유롭게 지을 수 있기 때문에 무슨 의도로 이 객체가 만들어졌는지 알 수 있음
    // new Person("홍다리") → 무슨 의미인지 애매
    // Person.of("홍다리") → 의미가 분명 ("홍다리라는 이름을 가진 객체 생성")
    // 2. 생성자를 감추고, 원하는 객체를 재활용할 수도 있다
    // 매번 new 하지 않고, 캐시해둔 객체를 돌려줄 수 있음 → 싱글턴, 풀링에 유용
    // static은 instance가 아닌 class 소속임
    // 변수는 값이 공유되니까 그렇다고 치고 메소드에는 왜 static이 붙을 수 있는 것이었지
    // -> 객체와 상관없이 호출이 가능하기 때문에 (일반 메소드는 객체가 있어야 호출이 가능하지만 static 메소드는 객체 없이 클래스 이름으로 바로 호출 가능)
    // -> 객체의 상태에 의존하지 않을 때, 객체마다 달라질 필요 없는 기능을 정의할 때 유용하다
    public static GreaterThanOne from(int number) {
        return new GreaterThanOne(number);
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number <= 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GREATER_THAN_ONE.getMessage());
        }
    }
}
