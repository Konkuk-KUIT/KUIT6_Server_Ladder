package view;

import domain.Row;

public class GameViewRenderer {
    public static void ladderRender(Row[] rows){
        StringBuilder stringBuilder = new StringBuilder();
        for (Row row : rows) {
            stringBuilder.append(row.toString());
        }
        System.out.println(stringBuilder);
    }

    public static void gameRender(String state, Row[] rows, int col, int height){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(state).append("\n");
        for (int i = 0; i < rows.length; i++) {
            stringBuilder.append(i != height ? rows[i].toString() : rows[i].getStringPoint(col));
        }
        System.out.println(stringBuilder);
    }
}
