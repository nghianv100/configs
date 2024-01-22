package medium;

import java.math.BigInteger;
import java.util.*;

public class MediumTasks {

    public  int IntegerReductionCount(String S) {
        int result = 0;
        int end = S.length() - 1;
        StringBuilder sb = new StringBuilder(S);
        int start = 0;
        while (start < S.length()) {
            if (sb.charAt(start) == '1') {
                break;
            }
            start++;
        }
        while (end >= start) {
            if (sb.charAt(end) == '1') {
                sb.setCharAt(end, '0');
                result++;
                if (end == start) {
                    break;
                }
            } else {
                result++;
                end--;
            }
        }
        return result;
    }
    //>>>IntegerReductionCount

    public int WordMachineEmulator(String S) {
        Stack<Integer> stack = new Stack<>();
        String[] ops = S.split("\\s+");
        for(String op : ops) {
            if ("".equals(op)) {
                continue;
            }
            if ("POP".equals(op)) {
                if (stack.isEmpty()) {
                    return -1;
                } else {
                    stack.pop();
                }
            } else if ("DUP".equals(op)) {
                if (stack.isEmpty()) {
                    return -1;
                } else {
                    int val = stack.peek();
                    stack.push(val);
                }
            } else if ("+".equals(op)) {
                if (stack.size() < 2) {
                    return -1;
                }
                int val1 = stack.pop();
                int val2 = stack.pop();
                if (val1 + val2 > 1048575) {
                    return -1;
                }
                stack.push(val1 + val2);
            } else if ("-".equals(op)) {
                if (stack.size() < 2) {
                    return -1;
                }
                int val1 = stack.pop();
                int val2 = stack.pop();
                if (val1 - val2 < 0) {
                    return -1;
                }
                stack.push(val1 - val2);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        return stack.isEmpty() ? -1 : stack.pop();
    }
    //>>>WordMachineEmulator

    public int AngryFrogs(int[] blocks) {
        int result = 2;
        int pos = 0;
        while (pos < blocks.length) {
            int i = pos;
            int j = pos;
            int dist = 1;
            while (++i < blocks.length) {
                if (blocks[i] >= blocks[i - 1]) {
                    dist++;
                } else {
                    break;
                }
            }
            while (--j >= 0) {
                if (blocks[j] >= blocks[j + 1]) {
                    dist++;
                } else {
                    break;
                }
            }
            if (dist > result) {
                result = dist;
            }
            pos = i;
        }
        return result;
        // 79%
    }
    //>>>AngryFrogs

    public int PlaneSeatingFourPerson(int N, String S) {
        Map<String, Integer> symbols = new HashMap<>();
        symbols.put("A", 0);
        symbols.put("B", 1);
        symbols.put("C", 2);
        symbols.put("D", 3);
        symbols.put("E", 4);
        symbols.put("F", 5);
        symbols.put("G", 6);
        symbols.put("H", 7);
        symbols.put("J", 8);
        symbols.put("K", 9);

        boolean[][] seats = new boolean[N][10];

        for (String s : S.split("\\s+")) {
            if (!s.isEmpty()) {
                int x = Integer.parseInt(s.substring(0, s.length() - 1)) - 1;
                int y = symbols.get(s.substring(s.length() - 1));
                seats[x][y] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 7;) {
                if (j == 1 || j == 3 || j == 5) {
                    if (!seats[i][j] && !seats[i][j+1] && !seats[i][j+2] && !seats[i][j+3]) {
                        seats[i][j] = true;
                        seats[i][j+1] = true;
                        seats[i][j+2] = true;
                        seats[i][j+3] = true;
                        result++;
                    }
                }
                j++;
            }
        }

        return result;
    }
    //>>>PlaneSeatingFourPerson

    public int FairSplits(int[] A, int[] B) {
        long sumA = 0;
        long sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
            sumB += B[i];
        }
        int result = 0;
        int j = 1;
        long sum1 = 0;
        long sum2 = sumA;
        long sum3 = 0;
        long sum4 = sumB;
        do {
            sum1 += A[j - 1];
            sum2 -= A[j - 1];
            sum3 += B[j - 1];
            sum4 -= B[j - 1];
            if (sum1 == sum2 && sum2 == sum3 && sum3 == sum4) {
                result++;
            }
            j++;
        } while (j < A.length);
        return result;
    }
    //>>>FairSplits

    public int ArraySlicing(int[] A) {
        int[] rmin = new int[A.length + 1];
        int val = Integer.MAX_VALUE;
        rmin[A.length] = val;
        for (int i = A.length - 1; i >= 0; i--) {
            val = Math.min(val, A[i]);
            rmin[i] = val;
        }
        int lmax = A[0];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            lmax = Math.max(lmax, A[i]);

            if(lmax <= rmin[i + 1]) {
                count++;
            }
        }
        return count;
    }
    //>>>ArraySlicing

    public static void main(String[] args) {
        System.out.println(Arrays.toString("14:13:12".split(":")));
    }

}
