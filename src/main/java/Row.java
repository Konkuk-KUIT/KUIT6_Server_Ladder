public class Row {

    private  final int[] row;

    public Row(NaturalNum row) {
        this.row = new int[row.getNaturalNum()];
    }
    public int[] line() {
        return row; // 읽을 때 씀
    }
    public int length(){
        return row.length;
    }
}
