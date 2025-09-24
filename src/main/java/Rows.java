public class Rows {
    private final Row[] rows;


    public Rows(NaturalNum row, NaturalNum numberOfPerson) {
        this.rows = new Row[row.getNaturalNum()];
        for (int i = 0; i < row.getNaturalNum(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }
    public void draw(NaturalNum leftColumn,  Height height){
        NaturalNum rightColumn = NaturalNum.of(leftColumn.getNaturalNum() + 1);
        String error = Validation.validate(this.rows,leftColumn.getNaturalNum(), rightColumn.getNaturalNum(), height);
        if(error != null){
            throw new IllegalArgumentException(error);
        }
        int min = Math.min(leftColumn.getNaturalNum(), rightColumn.getNaturalNum()) - 1;
        int max = Math.max(leftColumn.getNaturalNum(), rightColumn.getNaturalNum()) - 1;

        rows[height.current()].line()[min] = Direction.RIGHT.getValue();
        rows[height.current()].line()[max] = Direction.LEFT.getValue();
    }

    public int[][] toMatrix() {
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            matrix[i] = rows[i].line();
        }
        return matrix;
    }

}
