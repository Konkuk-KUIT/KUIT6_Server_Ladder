public class Row {
    private final int[] row;

    public Row(GreaterThanOne numberOfPerson){
        validateNumberPerson(numberOfPerson.getNumber());
        row = new int[numberOfPerson.getNumber()];
    }

    /*
    StringBuilder sb=new StringBuilder();
    sb.append("*");
    sb.append("*");
    String result=sb.toString();
    System.out.println(result);
    */
    public void clearRow(){
        for(int j=0;j< row.length;j++){
            row[j]=0;
        }
    }
    public int[] getRowState(){
        return row;
    }

    public int nextPosition(int position){
        validatePosition(position);

        if(isRight(position)){
            return position + 1;
        }

        if(isLeft(position)){
            return position - 1;
        }
        return position;
    }

    public String generateRow(LadderPosition curr, int rowIndex) {
        StringBuilder sb = new StringBuilder();
        int[] state=this.row;
        for (int i = 0; i < state.length; i++) {
            int val=state[i];
            String valstr=String.valueOf(val);
            if (curr.getRow() == rowIndex && curr.getCol() == i) {
                valstr+="*";
            }
            sb.append(valstr);
            if (i < state.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private boolean isLeft(int position) {
        return row[position] == Direction.Left.getValue();
    }

    private boolean isRight(int position) {
        return row[position] == Direction.Right.getValue();
    }

    private void validatePosition(int position) {
        if(position >= row.length || position < 0){
            throw new IllegalArgumentException("유효하지 않은 위치입니다.");
        }
    }

    public void drawLine(int startPosition){
        validateDrawLinePosition(startPosition);
        row[startPosition] = Direction.Right.getValue();
        row[startPosition + 1] = Direction.Left.getValue();
    }

    private void validateDrawLinePosition(int startPosition) {
        if (startPosition >= row.length -1 || startPosition < 0 || row[startPosition] == -1 || row[startPosition + 1] == 1) {
            throw new IllegalArgumentException("사다리를 그릴 수 없는 위치입니다.");
        }
    }

    private void validateNumberPerson(int numberOfPerson) {
        if(numberOfPerson <= 1){
            throw new IllegalArgumentException("참여 인원은 1명 이상이어야 합니다.");
        }
    }
}
