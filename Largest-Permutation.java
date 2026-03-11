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

    public static List<Integer> largestPermutation(int k, List<Integer> arr)
    {
        int n = arr.size();
        Map<Integer,Integer> pos = new HashMap<>();

        for (int i = 0; i < n; i++)
            pos.put(arr.get(i), i);

        for (int i = 0; i < n && k > 0; i++)
        {
            int target = n - i;

            if (arr.get(i) == target) continue;

            int j = pos.get(target);

            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);

            pos.put(temp, j);
            pos.put(target, i);

            k--;
        }

        return arr;
    }
    
    
    public static List<Integer> largestPermutation2(int k, List<Integer> arr) {
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


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.largestPermutation(k, arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
