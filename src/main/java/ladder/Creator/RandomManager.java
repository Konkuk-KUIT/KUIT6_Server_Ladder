package ladder.Creator;

import ladder.Row;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomManager {

    public static List<int[]> generatePlan(Row[] rows, Random rand){
        if(rows == null || rows.length == 0) return List.of();

        double ratio = 0.3; //비율값 설정
        int cols = rows[0].size();
        if (cols == 0) return List.of();

        int[] row_rand = getRandomPerRow(rows,ratio,rand); //행별 랜덤분배 설정

        List<int[]> plan = new ArrayList<>();

        for (int i = 0; i < row_rand.length; i++){
            int need =  row_rand[i];
            if (need <= 0) continue;

            List<Integer> cand = new ArrayList<>(cols-1);
            for (int j = 0; j < cols-1; j++) cand.add(j);
            Collections.shuffle(cand,rand);

            boolean[] taken = new boolean[cols-1];
            for (int c : cand) {
                if (need == 0) break;
                if ((c>0 && taken[c-1]) || taken[c] || (c + 1 < taken.length && taken[c+1])) continue; // |-|-| 방지
                taken[c] = true;
                plan.add(new int[]{i,c});
                need--;
            }
        }
        return plan;
    }

    private static int[] getRandomPerRow(Row[] rows, double ratio, Random rand){
        int rowCount = rows.length;
        int cols = rows[0].size();

        int total = (int)Math.round(rowCount * cols * ratio);

        int[] temp = new int[rowCount];

        for (int i = 0; i < total; i++) {
            int r = rand.nextInt(rowCount);
            if (temp[r] < cols-1) temp[r]++;
            else i--;
        }
        return temp;
    }
}
