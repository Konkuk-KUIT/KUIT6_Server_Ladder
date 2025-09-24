public class Ladder {

    private final Rows rows;

    private Ladder(NaturalNum row, NaturalNum numberOfPerson) {
        this.rows = new Rows(row, numberOfPerson);
    }
    public static Ladder of(NaturalNum row, NaturalNum numberOfPerson) {
        return new Ladder(row, numberOfPerson);
    }


    public int run(NaturalNum S){
        Index index = new Index(S);
        for (int[] ints : rows.toMatrix()) {
            int i = index.readValue(ints);
            CheckIndex.checkIndex(i, index);
        }
        return index.getResult();
    }

    //todo 싫어
    public void drawLine(NaturalNum leftColumn,  Height height) {
        rows.draw(leftColumn,height);
    }


}
