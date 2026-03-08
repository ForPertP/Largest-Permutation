using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Result
{

    /*
     * Complete the 'largestPermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static List<int> largestPermutation(int k, List<int> arr)
    {
        int n = arr.Count;
        int[] pos = new int[n + 1];

        for (int i = 0; i < n; i++)
            pos[arr[i]] = i;

        for (int i = 0; i < n && k > 0; i++)
        {
            int target = n - i;

            if (arr[i] == target)
                continue;

            int j = pos[target];

            pos[arr[i]] = j;
            pos[target] = i;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            k--;
        }

        return arr;
    }
}

