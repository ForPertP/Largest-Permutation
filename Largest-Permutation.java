import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'largestPermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> largestPermutation(int k, List<Integer> arr) {
        int n = arr.size();
        int[] pos = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pos[arr.get(i)] = i;
        }

        for (int i = 0; i < n && k > 0; i++) {
            int target = n - i;

            if (arr.get(i) == target) continue;

            int j = pos[target];

            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);

            pos[temp] = j;
            pos[target] = i;

            k--;
        }

        return arr;    
    }
}
