package leetcode;

import java.util.List;
import java.util.ArrayList;

public class Q446_Arithmetic_Slices_II_Subsequence {
    int answer = 0;

    public int numberOfArithmeticSlices(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        List<Integer> subseq = new ArrayList<>();
        dp(subseq, list);

        return answer;
    }


    private void dp(List<Integer> subseq, List<Integer> list) {
        if ( list.isEmpty() ) {
            return;
        }


        List<Integer> newList = new ArrayList<>(list);
        Integer num = newList.remove(0);

        // 1. num 안 붙이고
        dp(new ArrayList<>(subseq), new ArrayList<>(newList));

        // 2. num 붙이고
        List<Integer> newSubseq = new ArrayList<>(subseq);
        newSubseq.add(num);
        if ( newSubseq.size() < 3) {
            dp(new ArrayList<>(newSubseq), new ArrayList<>(newList));
        }
        else if ( isOk(newSubseq) ) {
            answer++;
            dp(new ArrayList<>(newSubseq), new ArrayList<>(newList));
        } else {
            return;
        }
    }


    private boolean isOk(List<Integer> subseq) {
        long diff = (long) subseq.get(1) - (long) subseq.get(0);

        for (int idx = 0; idx < subseq.size() - 1; idx++) {
            if ( (long) subseq.get(idx + 1) - (long) subseq.get(idx)  != diff) {
                return false;
            }
        }

        return true;
    }
}
