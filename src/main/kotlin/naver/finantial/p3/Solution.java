package naver.finantial.p3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Hi {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(8, new int[]{1, 4, 6}));
        System.out.println(new Solution().solution(18, new int[]{1, 2, 5}));
    }
}

class Solution {

    private int answer = Integer.MAX_VALUE;

    public int solution(int num, int[] cards) {
        final List<Integer> cardList = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            cardList.add(cards[i]);
        }
        Collections.reverse(cardList);
        dfs(0, num, cardList, 0);
        return answer;
    }

    private void dfs(final int sum, final int num, final List<Integer> cardList, final int depth) {
        if (sum > num) {
            return;
        }

        if (sum == num) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int card : cardList) {
            dfs(sum + card, num, cardList, depth + 1);
        }
    }
}
