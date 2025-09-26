/*
 * 매직넘버: 코드 중간에 나오는 숫자
 * - 코드의 가독성을 해침
 * - 정책이 바뀌었을 경우 수정이 어려움
 * => 배척해야만.....
 *
 * position -> node 객체
 * 방향을 알려달랴, 다음은 어디냐 메세지 보내서 알아낼 수 있음
 * 책임을 분산!
 *
 * 객체지향은 하나의 하청이었던 것이었어요...
 *
 * 에러 메세지가 그냥 string 값으로 하드코딩 되어 있음
 * -> 에러 메세지 오타가 생길 수 ㅇ
 * -> 에러 메세지가 변경되었을 경우 리팩토링이 쉽지 않음
 * => 에러 클래스를 따로 선언하자
 * */


public class Row {

    private final Node[] nodes;

    public Row(GreaterThanOne numberOfPerson){
        nodes = new Node[numberOfPerson.getNumber()];
        for(int i = 0; i < numberOfPerson.getNumber(); i++){
            nodes[i] = Node.from(Direction.NONE);
        }
    }

    // position이 무언가를 하는 게 아니라 ladder가 그 일을 대신하고 있음
    // 객체는 해당 객체 내에서는 왕이 되어야 한다
    // 스스로 유효성을 검증하고 움직이는 주체적인 객체를 만드는 것이 목표
    public void nextPosition(Position position){
        validatePosition(position);
        nodes[position.getValue()].move(position);
    }

    public void printRow(Position position){
        for(int i = 0; i < nodes.length; i++){
            System.out.print(nodes[i].getDirection().getValue());
            if(i==position.getValue()) System.out.print("*");
            System.out.print(" ");
        }
        System.out.println();
    }

    public void printRow(){
        for(int i = 0; i < nodes.length; i++){
            System.out.print(nodes[i].getDirection().getValue()+" ");
        }
        System.out.println();
    }

    private void validatePosition(Position position) {
        if(isInvalidPosition(position)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(nodes.length -1);
    }

    public void drawLine(Position startPosition){
        validateDrawLinePosition(startPosition);
        setDirectionBetweenNextPosition(startPosition);
    }

    private void setDirectionBetweenNextPosition(Position position) {
        nodes[position.getValue()].setRightNode();
        position.next();
        nodes[position.getValue()].setLeftNode();
    }

    private void validateDrawLinePosition(Position startPosition) {
        validatePosition(startPosition);
        if (isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isLineAtNextPosition(Position position) {
        position.next();
        boolean lineAtPosition = isLineAtPosition(position);
        position.prev();
        return lineAtPosition;
    }

    private boolean isLineAtPosition(Position position) {
        return nodes[position.getValue()].isAlreadySetDirection();
    }


}
