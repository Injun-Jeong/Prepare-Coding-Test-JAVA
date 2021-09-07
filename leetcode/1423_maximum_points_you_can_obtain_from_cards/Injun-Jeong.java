package leetcode;

public class Q1423_Maximum_Points_You_Can_Obtain_from_Cards {
    public int maxScore(int[] cardPoints, int k) {
        int answer = 0;
        int temp = 0;
        int len = cardPoints.length;

        /* left side */
        for ( int idx = 0; idx < k; idx++ ) {
            temp += cardPoints[idx];
        }
        answer = temp;

        /* right side */
        for ( int idx = 0; idx < k; idx++ ) {
            temp -= cardPoints[k - 1 - idx];
            temp += cardPoints[len - 1 - idx];

            answer = temp > answer ? temp : answer;
        }

        return answer;
    }
}
