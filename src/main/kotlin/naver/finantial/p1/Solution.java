package naver.finantial.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Solution {

    public static void main(String[] args) {
        int[] arr11 = {1, 6, 2, 5, 3, 4};
        int[] arr22 = {9, 9, 1, 0, 7, 8};
        System.out.println(new Solution().solution(new int[][]{arr11, arr22}));

        int[] arr1 = {0, 1, 5, 3, 9, 2};
        int[] arr2 = {2, 1, 0, 4, 8, 7};
        int[] arr3 = {6, 3, 4, 7, 6, 5};
        System.out.println(new Solution().solution(new int[][]{arr1, arr2, arr3}));
    }

    public int solution(int[][] dice) {
        final Set<Integer> answers = new TreeSet<>();
        final List<List<Integer>> allNumbers = new ArrayList<>();

        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 6; i++) {
                for (int k = 0; k < 6; k++) {
                    final ArrayList<Integer> numbers = new ArrayList<>();
                    numbers.add(dice[0][j]);
                    for (int dl = 1; dl < dice.length - 1; dl++) {
                        numbers.add(dice[dl][i]);
                    }
                    numbers.add(dice[dice.length - 1][k]);
                    allNumbers.add(numbers);
                }
            }
        }

        for (List<Integer> numbers : allNumbers) {
            for (int i = 1; i < dice.length + 1; i++) {
                final Permutation perm = new Permutation(dice.length, i);
                perm.permutation(numbers, 0);
                final ArrayList<ArrayList<Integer>> result = perm.getResult();
                for (ArrayList<Integer> integers : result) {
                    int n = 0;
                    for (Integer integer : integers) {
                        if (n == 0 && integer == 0) {
                            break;
                        }
                        n = n * 10 + integer;
                    }
                    answers.add(n);
                }
            }
        }
        answers.remove(0);
        int answer = answers.size() + 1;
        final List<Integer> answerList = new ArrayList<>(answers);
        int i = 1;
        for (Integer integer : answerList) {
            if (i != integer) {
                answer = i;
                break;
            }
            i++;
        }

        return answer;
    }
}

class Permutation {
    private int n;
    private int r;
    private int[] now; // 현재 순열
    private ArrayList<ArrayList<Integer>> result; // 모든 순열

    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Integer>>();
    }

    public void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public void permutation(List<Integer> arr, int depth) {
        // 현재 순열의 길이가 r일 때 결과 저장
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(now[i]);
            }
            result.add(temp);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            now[depth] = arr.get(depth);
            permutation(arr, depth + 1);
            swap(arr, i, depth);
        }
    }
}
