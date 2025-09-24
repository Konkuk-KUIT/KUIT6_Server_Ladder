public class Row {
    private final Node[] nodes;
    private final int numberOfPerson;

    public Row(int numberOfPerson){
        validateNumberOfPerson(numberOfPerson);
        this.numberOfPerson = numberOfPerson;
        nodes = new Node[numberOfPerson];
        for(int i = 0; i < numberOfPerson; i++){
            nodes[i] = Node.from(Direction.NONE);
        }
    }

    public void nextPosition(Position position){
        validatePosition(position.getValue());
        nodes[position.getValue()].move(position);
    }

    public void drawLine(int startPosition){
        validateDrawLinePosition(startPosition);
        nodes[startPosition].setRightDirection();
        nodes[startPosition+1].setLeftDirection();
    }

    private void validateDrawLinePosition(int startPosition) {
        if(startPosition < 0 || startPosition >= nodes.length-1){
            throw new IllegalArgumentException();
        }
        if(!nodes[startPosition].isNoneDirection() || ! nodes[startPosition+1].isNoneDirection()){
            throw new IllegalArgumentException();
        }
    }

    private void validatePosition(int position) {
        if (position < 0 || position >= nodes.length) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if (numberOfPerson<=0) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }


    public String generateRow(Position position) {
        int pos = position==null? -1 : position.getValue();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.length; i++) {
            sb.append(nodes[i].getIntegerDirection());
            if(i==pos){
                sb.append("*");
            }
            if (i < nodes.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }


}
