package easy;

import java.util.*;

public class EasyTasks {
    public boolean abstring(String S) {
        boolean isBEncountered = false;
        for (char i : S.toCharArray()) {
            if (i == 'a') {
                if (isBEncountered) {
                    return false;
                }
            } else {
                isBEncountered = true;
            }
        }
        return true;
    }
    //>>>abstring

    public int longestsentence(String S) {
        String[] sentences = S.split("[.!?]");
        int max = 0;
        for (String sentence : sentences) {
            String[] words = sentence.trim().split("\\s+");
            int count = 0;
            for (String word : words) {
                if (!word.trim().isEmpty()) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
    //>>>longestsentence

    public int signum(int[] A) {
        float signum = Math.signum(A[0]);
        for (int i = 1; i < A.length; i++) {
            if (A[i] == 0) {
                return 0;
            }
            signum *= Math.signum(A[i]);
        }
        return (int) signum;
    }
    //>>>signum

    public int[] distinctarraygenerator(int N) {
        int[] result = new int[N];
        if (N % 2 == 0) {
            int i = 0;
            for (int start = 1; start <= N / 2; start++) {
                result[i++] = start;
                result[i++] = -start;
            }
        } else {
            result[0] = 0;
            int i = 1;
            for (int start = 1; start <= N / 2; start++) {
                result[i++] = start;
                result[i++] = -start;
            }
        }
        return result;
    }//>>>distinctarraygenerator

    public int[] testingcomputemin(int N) {
        // Implement your solution here
        int[] result = new int[N];
        Arrays.fill(result, 10);
        return result;
    }
    //>>>testingcomputemin

    public int ntimesn(int[] A) {
        // Implement your solution here
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (map.containsKey(a)) {
                int count = map.get(a);
                if (a == count + 1) {
                    set.add(a);
                }
                map.put(a, count + 1);
            } else {
                if (a == 1) {
                    set.add(1);
                }
                map.put(a, 1);
            }
        }
        int max = 0;
        for (int x : set) {
            if(x == map.get(x) && x > max) {
                max = x;
            }
        }
        return max;
    }
    //>>>ntimesn

    public String createpalindrome(String S) {
        // Implement your solution here
        int i = 0;
        int j = S.length() - 1;
        StringBuilder sb = new StringBuilder(S);
        while (i <= j) {

            if (i == j) {
                if (S.charAt(i) == '?') {
                    sb.setCharAt(i, 'a');
                }
                return sb.toString();
            }
            char iChar = S.charAt(i);
            char jChar = S.charAt(j);
            if (jChar == '?' && iChar == '?') {
                sb.setCharAt(i, 'a');
                sb.setCharAt(j, 'a');
            } else if (jChar == '?' || iChar == '?') {
                if (iChar == '?') {
                    sb.setCharAt(i, S.charAt(j));
                } else {
                    sb.setCharAt(j, S.charAt(i));
                }
            } else if (jChar != iChar) {
                return "NO";
            }
            i++;
            j--;

        }
        return sb.toString();
    }
    //>>>createpalindrome

    public boolean findclosenumbers(int[] A) {
        ArrayList<Integer> list = new ArrayList<>(A.length);
        for (int a : A) {
            list.add(a);
            if (list.contains(a - 1) || list.contains(a + 1)) {
                return true;
            }
        }

        for (int a : list) {
            if (list.contains(a - 1) || list.contains(a + 1)) {
                return true;
            }
        }
        return false;
    }
    //>>>findclosenumbers

    public int doubledigitssum(int N) {
        int a = doubledigitssum_sumDigit(N);
        int i = N;
        while (true) {
            int b = doubledigitssum_sumDigit(i);
            if (b == a * 2) {
                break;
            }
            i++;
        }
        return i;
    }

    public int doubledigitssum_sumDigit(int N) {
        int sum = 0;
        int n = N;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        // System.out.println(sum);
        return sum;
    }
    //>>>doubledigitssum

    public int optimizingfarthestequal(int[] A) {
        int N = A.length;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N ; i++) {
            if (map.containsKey(A[i])) {
                result = Math.max(result, Math.abs(i - map.get(A[i])));
            } else {
                map.put(A[i], i);
            }
        }
        return result;
    }
    //>>>optimizingfarthestequal

    public int[] dicerolls(int[] A, int F, int M) {
        // Implement your solution here
        int[] result = new int[F];
        int totalTimes = A.length + F;
        int sum = totalTimes * M;
        int sumMissed = sum;
        for (int a : A) {
            sumMissed -= a;
        }

        float med = (float) sumMissed / F;
        if (med > 6.0 || med < 1.0) {
            return new int[]{0};
        }

        int x = (int) Math.floor(med);
        int totalMissed = x * F;
        Arrays.fill(result, x);

        int i = 0;

        while (totalMissed < sumMissed && i < F) {
            if (result[i] < 6) {
                result[i]++;
                totalMissed++;
            } else {
                i++;
            }
        };

        return result;
    }
    //>>> dicerolls

    public int countBananas(String S) {
        int nB = 0;
        int nA = 0;
        int nN = 0;
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'B') {
                nB++;
            } else if (S.charAt(i) == 'A') {
                nA++;
            } else if (S.charAt(i) == 'N') {
                nN++;
            }
        }
        while (nB > 0) {
            if (nA >= 3 && nN >= 2) {
                nA -= 3;
                nN -= 2;
                nB--;
                result++;
            } else {
                break;
            }
        }
        return result;
    }
    //>>>countBananas

    public boolean equalpairs(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (set.contains(a)) {
                set.remove(a);
            } else {
                set.add(a);
            }
        }
        return set.isEmpty();
    }
    //>>>equalpairs

    public int binarypositiveand(int[] A) {
        int N = A.length;
        int step = 0;
        while (step < N) {
            int i = 0;
            int j = N - 1 - step;
            while (j < N) {
                if (binarypositiveand_check(A, i, j)) {
                    return N - step;
                }
                i++;
                j++;
            }
            step++;
        }
        return 1;
    }

    public boolean binarypositiveand_check(int[] A, int from, int to) {
        int result = A[from];
        for (int i = from + 1; i <= to; i++) {
            result = result & A[i];
        }
        return result > 0;

    }
    //>>>binarypositiveand

    public static void main(String[] args) {
        System.out.println("ABCDEF!asdasd!!???");
    }
}
