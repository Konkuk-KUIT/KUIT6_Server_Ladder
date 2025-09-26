// interdface는 상속을 해야하기 때문에 private 미지원
// 필드값은 기본으로 public static final을 가짐, 또한 반드시 초기화 되어 있어야 함. 아닐 시  컴파일 에러
// 내부에서 생성자  선언 불가
// 인터페이스 메소드는 바디를 가질 수 없음

public interface LadderCreator {
    public void drawLine(Position row, Position col);
    public Row[] getRows();
}
