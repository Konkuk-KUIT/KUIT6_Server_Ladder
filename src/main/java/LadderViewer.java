public class LadderViewer {
    private final Row[] rows;

    public LadderViewer(Row[] rows) {
        this.rows = rows;
    }

    public void drawLadder(Position beforePosition, Position afterPosition) {
        int depth = beforePosition.getY();
        System.out.println("\n---- depth = " + depth + " ----");
        System.out.println("Before");
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[0].getLength(); j++) {
                System.out.print(rows[i].getValue(j));
                if (i == beforePosition.getY() && j == beforePosition.getX()) {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("After");
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[0].getLength(); j++) {
                System.out.print(rows[i].getValue(j));
                if (i == afterPosition.getY() && j == afterPosition.getX()) {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
