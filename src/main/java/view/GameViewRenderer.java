package view;

import domain.Row;

public class GameViewRenderer {
    public static void ladderRender(Row[] rows){
        StringBuilder stringBuilder = new StringBuilder();
        for (Row row : rows) {
            stringBuilder.append(row.toString());
        }
        LadderGameView.print(stringBuilder.toString());
    }

    public static void gameRender(String state, Row[] rows, int col, int height){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(state).append("\n");
        for (int i = 0; i < rows.length; i++) {
            stringBuilder.append(i != height ? rows[i].toString() : rows[i].getStringPoint(col));
        }
       LadderGameView.print(stringBuilder.toString());
    }
}
