package goorm;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Q43224 {

    private static BufferedReader br;
    private static int N, K;
    private static int[] use;
    private static int[] turn;

    public static void main(String[] args) throws Exception {
        setup();
        int answer = getAnswer();
        System.out.println(answer);
    }


    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");

        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);
        use = new int[K];
        turn = new int[K];

        input = br.readLine();
        inputs = input.split(" ");
        for (int idx = 0; idx < K; idx++) {
            turn[idx] = Integer.parseInt(inputs[idx]) - 1;
        }
    }


    private static int getAnswer() {
        int answer = 0;
        int numOfUsing = 0;
        int idxRemoved;

        for (int idx = 0; idx < K; idx++) {
            if ( isAlreadyUsed(turn[idx]) ) {
                continue;
            } else if ( numOfUsing < N ) {
                use[turn[idx]] = 1;
                numOfUsing++;
            } else {
                idxRemoved = getRemovedIdx(idx + 1);
                use[idxRemoved] = 0;
                use[turn[idx]] = 1;
                answer++;
            }
        }

        return answer;
    }


    private static boolean isAlreadyUsed(int idxItem) {
        return use[idxItem] == 1;
    }


    private static int getRemovedIdx(int idxStart) {
        Set<Integer> setUseItemIdx = new HashSet<>();

        for (int idx = 0; idx < K; idx++) {
            if (use[idx] == 1) {
                setUseItemIdx.add(idx);
            }
        }

        if (setUseItemIdx.size() == 1) {
            return setUseItemIdx.stream().collect(Collectors.toList()).get(0);
        }

        for (int idx = idxStart; idx < K; idx++) {
            if (setUseItemIdx.contains(turn[idx])) {
                setUseItemIdx.remove(turn[idx]);
            }
            if (setUseItemIdx.size() == 1) {
                break;
            }
        }

        return setUseItemIdx.stream().collect(Collectors.toList()).get(0);
    }
}
