public class LadderViewer {

    public static void viewLadder(Row[] rows, int height, Position position, boolean isAfter) {
        System.out.println(isAfter ? "After!" : "Before!");
        for (int i = 0; i < rows.length; i++) {
            String s = rows[i].generateRow(i==height? position:null);
            System.out.println(s);
        }
    }
}
