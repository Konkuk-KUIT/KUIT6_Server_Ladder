public class LadderViewer {
    public void printLadder(Row[] rows, LadderPosition currentPosition) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < rows.length; r++) {
            sb.append(rows[r].generateRow(currentPosition, r)).append('\n');
        }
        // 만약 전체 사다리를 한 번만 그리고 싶다면 위처럼,
        // 진행시마다 행별로 그리고 싶으면 한 줄만 append하도록 사용 가능
        System.out.println(sb.toString());
    }
}

