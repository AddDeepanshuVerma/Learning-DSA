package Random;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class arrays05 {

    public static void main(String[] args) {

        /*Build Array from Permutation
        bAFP();
        Concatenation of Array
        System.out.println("Enter an array");
        int[] nums = Arrays.stream(new Scanner(System.in).nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] ans = getConcatenation(nums);
        System.out.println(Arrays.toString(ans));*/

        /*Running Sum of 1d Array
        System.out.println("Enter an array");
        int[] nums = Arrays.stream(new Scanner(System.in).nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] ans = runningSum(nums);
        System.out.println(Arrays.toString(ans));*/

       /* Richest Customer Wealth
        System.out.println("Enter an array");
        int[] nums = Arrays.stream(new Scanner(System.in).nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[][] nums = {{1, 2, 3}, {2, 3, 4}};
        int ans = maximumWealth(nums);
        System.out.println(ans);*/

//        Richest Customer Wealth
        /*System.out.println("Enter two arrays");
        int[] array = Arrays.stream(new Scanner(System.in).nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] array2 = Arrays.stream(new Scanner(System.in).nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[][] ints = new int[2][];
        ints[0] = array;
        ints[1] = array2;
        System.out.println(maximumWealthnow(ints));*/

       /* Shuffle the Array
        System.out.println("Enter an array");
        int[] nums = new int[]{1,2,3,4,4,3,2,12,3,4,5};
        int[] ans = shuffle(nums , 4);
        System.out.println(Arrays.toString(ans));*/

        /*Kids With the Greatest Number of Candies
        System.out.println("Enter an array");
        int[] nums = Arrays.stream(new Scanner(System.in).nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        List<Boolean> ans = kidsWithCandies(nums, 1);
        System.out.println(ans);*/

//        Number of Good Pairs
        /*System.out.println("Enter an array");
        int[] arr = new int[]{1,2,3};
        int ans = numIdenticalPairs3(arr);
        System.out.println(ans);*/

        /*How Many Numbers Are Smaller Than the Current Number
        System.out.println("Enter an array");
        int[] arr = new int[]{8,1,2,2,3};
        int[] ans = smallerNumbersThanCurrent(arr);
        System.out.println(Arrays.toString(ans));*/

        /*int[] res = createTargetArray(new int[]{1,2,3,4,0},new int[]{0,1,2,3,0});
        System.out.println(Arrays.toString(res));*/


//        char a = 'a';
//        a++;
//        System.out.println(a);
//        System.out.println(checkIfPangram2("thequickbrownfoxjumpsoverthelazydog"));

//        Count Items Matching a Rule
       /* List<List<String>> x = new ArrayList<>();
        x.add(new ArrayList<>(Arrays.asList("phone", "blue", "pixel")));
        x.add(new ArrayList<>(Arrays.asList("computer", "silver", "lenovo")));
        x.add(new ArrayList<>(Arrays.asList("phone", "gold", "iphone")));
        int i = countMatches(x, "color", "silver");
        System.out.println(i);*/

//        Find the Highest Altitude
        /*System.out.println("Enter an Array : ");
        int[] array = Arrays.stream(new Scanner(System.in).next().split("\\,+")).mapToInt(Integer::parseInt).toArray();
        int i = largestAltitude(array);
        System.out.println(i);*/

//        Flipping an Image
        /*int[][] arr = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] result= flipAndInvertImage(arr);
        for (int[] A : result) {
            System.out.println(Arrays.toString(A));
        }*/
//        Transpose Matrix
       /* int[][] arr1 = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] arr =  transpose(arr1);
        for (int[] A : arr) {
            System.out.println(Arrays.toString(A));
        }*/

//        System.out.println(addToArrayForm2(new int[]{1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 0, 6, 3}, 516));

//        int[][] arr1 = new int[][]{{1993,1999},{2000,2010}};
//        System.out.println(maximumPopulation(arr1));


        /*int[][] mat90 = roatate90clockwise(mat);
        for (int b[] :
                mat) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println("============");
        for (int a[] :
                mat90) {
            System.out.println(Arrays.toString(a));
        }*/

//        rotateMatrix(mat);
//        int[][] mat = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
//        int[][] target = new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 0, 0}};
//        int[][] target = new int[][]{{1,1,1},{0,1,0},{0,0,0}};
//        System.out.println(findRotation(mat, target));

//        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
//        System.out.println(Arrays.toString(sumZero(11)));
//        System.out.println(luckyNumbers(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}));

//        Kadane  Algorithm
//        System.out.println(maxSubArraySum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(maxSubArraySum(new int[]{-100,-90,-10}));
//        System.out.println(maxSubArraySum(new int[]{-100,-90,-10,1}));
//        System.out.println(maxSubArraySum(new int[]{-10,-20,-30}));
//        System.out.println(maxSubArraySum(new int[]{-100,-90,-10,1,2,4,5,-10}));

//        maxSubArraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
//        maxSubArraySum(new int[]{-100, -90, -10});
//        maxSubArraySum(new int[]{-100, -90, -10, 1, 2, 4, 5, -10});

        /*int[][] mat = matrixReshape(new int[][]{{1,2},{3,4}}, 4, 1);
        for (int[] a :
                mat) {
            System.out.print(Arrays.toString(a));
        }*/
//        System.out.println(Arrays.toString(plusOne(new int[]{8, 9, 9, 9})));

//        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

//        System.out.println(minCostToMoveChips(new int[]{6, 4, 7, 8, 2, 10, 2, 7, 9, 7}));
//        System.out.println(maxOccurredValue(new int[]{2,2,2,2,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4}));

//        int[][] arr = {{1, 2, 4, 2}, {9, 3, 8, 7}, {3,6,7,2}};
//        for (int a[] :arr) {
//            System.out.println(Arrays.toString(a));
//        }
//        System.out.println(spiralOrder(arr));

//        int[][] result = generateMatrix(3);
//        for (int a[] : result) {
//            System.out.println(Arrays.toString(a));
//        }
//        int[][] arr = {{1, 2, 4, 2}, {9, 3, 0, 7}, {3,6,7,2}};
//        int[][] result = setZeroes(arr);
//        for (int[] a : result) {
//            System.out.println(Arrays.toString(a));
//        }
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {-1, 1, 0, -3, 3};
//        System.out.println(Arrays.toString(productExceptSelf(arr1)));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(productExceptSelf2(arr1)));
//        System.out.println(reorganizeString("aaab"));

        /*System.out.println("Enter an array");
        int[] array = Arrays.stream(new Scanner(System.in).nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(sortColors(array)));*/

//        System.out.println(rob(new int[]{2,7,9,3,1}));

//        System.out.println("String".indexOf("r"));
//        int a = 'r';
//        System.out.println(a);
    }
    public int minCostToMoveChips2(int[] chips) {
        int even = 0;
        for (int i : chips)
            if (i % 2 == 0) even++;
        return Math.min(even, chips.length - even);
    }
    public static int rob(int[] nums) {
        int maxEven = 0;
        int maxOdd = 0;
        for (int i = 0; i < nums.length; i++) {
            if((i & 1) == 0){
                maxEven+=nums[i];
            }
            else{
                maxOdd+=nums[i];
            }
        }
        return Math.max(maxEven,maxOdd);
    }
    public static int[] sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int n : nums) {
            switch (n) {
                case 0 -> count0++;
                case 1 -> count1++;
                case 2 -> count2++;
            }
        }
        int i =0;
        while(count0-->0)   nums[i++] = 0;
        while(count1-->0)   nums[i++] = 1;
        while(count2-->0)   nums[i++] = 2;
        return nums;
    }

    // 97 - 122
    public static String reorganizeString(String str) {
        int[] hash = new int[26];
        for (int i = 0; i < str.length(); i++)
            hash[str.charAt(i) - 'a']++;

        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++)
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }

        if (max > (str.length() + 1) / 2) return "";

        char[] res = new char[str.length()];

        // Fill all even places with majority character
        int idx = 0;
        while (hash[letter]-- > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
        }

        // Fill the remaining characters
        for (int i = 0; i < hash.length; i++)
            while (hash[i]-- > 0) {
                if (idx >= res.length) idx = 1;

                res[idx] = (char) (i + 'a');
                idx += 2;
            }

        return String.valueOf(res);
    }

    public static int[] searchRange(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        return new int[]{list.indexOf(target), list.lastIndexOf(target)};
    }

    public int[] searchRange2(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        return new int[]{list.indexOf(target),list.lastIndexOf(target)};
    }


    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        Arrays.fill(output, 1);
        int product = 1;
        System.out.println(Arrays.toString(output));
        for (int i = 0; i < n; i++) {
            output[i] = output[i] * product;
            product = product * nums[i];
        }
        System.out.println(Arrays.toString(output));
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * product;
            product = product * nums[i];
        }
        return output;
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length - 1;
        int[] output = new int[nums.length];
        int product = 1;
        for (int i = 0; i <= n; i++) {
            product = product * nums[i];
            output[i] = product;
        }
        product = 1;
        for (int i = n; i > 0; i--) {
            output[i] = output[i - 1] * product;
            product = product * nums[i];
        }
        output[0] = product;
        return output;
    }

    public static int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int product = 1;
        for (int i = 0; i < n; i++) {
            product = product * nums[i];
            left[i] = product;
        }
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            product = product * nums[i];
            right[i] = product;
        }
        System.out.println("left Sum: " + Arrays.toString(left));
        System.out.println("right Sum: " + Arrays.toString(right));

        int[] result = new int[nums.length];
        result[0] = right[1];
        result[n - 1] = left[n - 2];
        for (int i = 1; i < n - 1; i++) {
            result[i] = left[i - 1] * right[i + 1];
        }

        return result;
    }

    public static int[][] setZeroes(int[][] matrix) {
        List<Integer> ith = new ArrayList<>();
        List<Integer> jth = new ArrayList<>();
        int a = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    ith.add(i);
                    jth.add(j);
                }
            }
        }
        for (int i = 0; i < ith.size(); i++) {
            setZero(ith.get(i), jth.get(i), matrix);
        }
        return matrix;
    }

    private static void setZero(int i, int j, int[][] matrix) {
        for (int k = 0; k < matrix[i].length; k++) {
            matrix[i][k] = 0;
        }

        for (int k = 0; k < matrix.length; k++) {
            matrix[k][j] = 0;
        }
    }


    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int element = 1;

        while (true) {
            for (int i = left; i <= right; i++) matrix[top][i] = element++;
            top++;
            if (left > right || top > bottom) break;
            for (int i = top; i <= bottom; i++) matrix[i][right] = element++;
            right--;
            if (left > right || top > bottom) break;
            for (int i = right; i >= left; i--) matrix[bottom][i] = element++;
            bottom--;
            if (left > right || top > bottom) break;
            for (int i = bottom; i >= top; i--) matrix[i][left] = element++;
            left++;
            if (left > right || top > bottom) break;
        }
        return matrix;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if (left > right || top > bottom) break;
        }

        return res;
    }

    public static int minCostToMoveChips(int[] position) {
        int n = position.length;
        int finalMinimumCost = Integer.MAX_VALUE;
        int currentCost = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if ((Math.abs(position[j] - position[i]) & 1) != 0) {
                    currentCost += 1;
                }
            }
            System.out.println(currentCost + " & " + finalMinimumCost);
            if (finalMinimumCost > currentCost) {
                finalMinimumCost = currentCost;
            }
            currentCost = 0;
        }
        return finalMinimumCost;
    }

    private static int maxOccurredValue(int[] arr) {
        //most occurred element
        Arrays.sort(arr);
        int n = arr.length;
        int currentCount = 1;
        int maxCount = 1;
        int maxOccuredValue = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                currentCount++;
            } else {
                currentCount = 1;
            }
            if (currentCount >= maxCount) {
                maxCount = currentCount;
                maxOccuredValue = arr[i];
            }

        }
        System.out.println(maxOccuredValue + " occurred " + maxCount + " times");
        return maxOccuredValue;
    }

    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            nums[count] = nums[i];
            count++;
        }
        return count;
        /*Set<Integer> set = new HashSet<>();
        for (int a : nums) {
            set.add(a);
        }
        int[] newNums = set.stream().mapToInt(Integer::valueOf).toArray();
        nums = newNums;
        return set.size();*/
//        return set.stream().mapToInt(Integer::valueOf).toArray().length;
//        return  Arrays.stream(nums).boxed().collect(Collectors.toSet()).size();
    }

    public static int removeDuplicates2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int a : nums)  set.add(a);
        return set.size();
//        return set.stream().mapToInt(Integer::valueOf).toArray().length;
//        return  Arrays.stream(nums).boxed().collect(Collectors.toSet()).size();
    }


    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        int carry = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            int n = i;
            carry = (digits[n] + carry) % 9;
            if (i == 0 && digits[i] > 8) {
                list.add(0, (digits[n] + carry) % 10);
                carry = (digits[n] + carry) / 10;
                list.add(0, carry);
                break;
            }
            list.add(0, (digits[n] + carry) % 10);
        }
        System.out.println("Print String :" + list.toString());
        int[] res = list.stream().mapToInt(Integer::valueOf).toArray();
        return res;

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        } else {
            int[] res = new int[mat.length * mat[0].length];
            int[][] result = new int[r][c];
            int a = 0;
            for (int[] ints : mat) {
                for (int anInt : ints) {
                    res[a] = anInt;
                    a++;
                }
            }
            System.out.println("our array : " + Arrays.toString(res));
            a = 0;
            for (int[] ints : result) {
                for (int anInt : ints) {
                    anInt = res[a];
                    a++;
                }
            }
            return result;

        }

    }


    public static int maxSubArraySum(int[] nums) {

        /*int n = nums.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = nums[0];
        int max = dp[0];
        System.out.println("=====================");
        System.out.println(Arrays.toString(nums));
        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        System.out.println(Arrays.toString(dp));

        return max;*/

        int global_Max = Integer.MIN_VALUE;
        int n = nums.length;
        int local_Max = 0;
        for (int i = 0; i < n; i++) {
            local_Max = nums[i] + Math.max(local_Max, 0);
            global_Max = Math.max(global_Max, local_Max);
//            local_Max = Math.max(local_Max, 0);
        }
        System.out.println(global_Max);
        return global_Max;

        /*int global_Max = Integer.MIN_VALUE;
        int n = nums.length;
        int local_Max = 0;
        System.out.println("===================================================");
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            System.out.print("||  Arr[i]= " + nums[i]);
            local_Max = nums[i] + local_Max;
            System.out.print(", local_Max = " + local_Max);
            global_Max = Math.max(global_Max, local_Max);
            System.out.print(", global_Max = " + global_Max);
            local_Max = Math.max(local_Max, 0);
            System.out.print(",local_Max = " + local_Max);
            System.out.println();
        }
        System.out.println("sum : " + Arrays.stream(nums).sum());
        return global_Max;*/
    }

    public static int[] maxSubArray(int[] nums) {
        int global_Max = Integer.MIN_VALUE;
        int n = nums.length;
        int local_Max = 0, start = 0, end = 0, s = 0;
        System.out.println("===================================================");
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            local_Max = nums[i] + local_Max;
            if (global_Max < local_Max) {
                global_Max = local_Max;
                start = s;
                end = i;
            }
            if (local_Max < 0) {
                local_Max = 0;
                s = i + 1;
            }
        }
        System.out.print("[ ");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");
        System.out.println("sum of max array = " + global_Max);
        return nums;
    }


    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (min > matrix[i][j]) min = matrix[i][j];
            }
            list.add(min);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                if (max < matrix[j][i]) max = matrix[j][i];
            }
            if (list.contains(max)) {
                res.add(max);
                return res;
            }
        }
        return res;

    }

    public static int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i - n / 2 == 0 && (n & 1) == 0) {
                res[i] = n / 2;
                continue;
            }
            res[i] = i - n / 2;
        }
        return res;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        outer:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break outer;
                }
            }
        }
        return res;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean flag = true;
        int[][] result = mat;
        int m = 3;
        do {
            result = roatate90clockwise(result);
            flag = true;
            outer:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (result[i][j] != target[i][j]) {
                        flag = false;
                        break outer;
                    }
                }
            }
            m--;
        } while (flag == false && m > 0);
        return flag;
    }

    private static void rotateMatrix(int[][] mat) {
        int m = 1;
        int[][] result = mat;
        System.out.println("Our matrix");
        for (int a[] : mat)
            System.out.println(Arrays.toString(a));

        while (m <= 4) {
            result = roatate90clockwise(result);
            System.out.println("====" + m + "=====");
            for (int a[] : result)
                System.out.println(Arrays.toString(a));
            m++;
        }
    }

    private static int[][] roatate90clockwise(int[][] mat) {
        int n = mat.length;
        int[][] transposedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[j][n - i - 1] = mat[i][j];
            }
        }
        return transposedMatrix;
    }
//    int[][] arr1 = new int[][]{{2008,2026},{2004,2008},{2034,2035},{1999,2050},{2049,2050},{2011,2035},{1966,2033},{2044,2049}};

    public static int maximumPopulation(int[][] logs) {
        int[] year = new int[101];
        for (int[] arr : logs) {
            while (arr[0] < arr[1]) {
                year[arr[0] - 1950]++;
                arr[0]++;
            }
        }
//        for (int i = 0; i < year.length; i++) {
//            System.out.print(i + 1950 + " = " + year[i] + " || ");
//        }
        int max = 0;
        int yearno = 0;
        for (int i = 0; i < year.length; i++) {
            if (max < year[i]) {
                max = year[i];
                yearno = i + 1950;
            }
        }
        System.out.println(max);
        return yearno;

    }

    //[1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,5,7,9]
    public static List<Integer> addToArrayForm2(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int len = num.length - 1;
        while (len >= 0 || k != 0) {
            if (len >= 0) {
                k += num[len--];
            }
            result.add(k % 10);
            k /= 10;
        }
        Collections.reverse(result);
        return result;
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        long sum = 0L;
        for (int i = 0; i < num.length; i++) {
            sum = sum * 10L + num[i];
            System.out.println(sum);
        }
        System.out.println(Long.MAX_VALUE);
        sum += k;
        String res = sum + "";
        for (int i = 0; i < res.length(); i++) {
            result.add(Character.getNumericValue(res.charAt(i)));
        }

        return result;
    }

    public static int[][] transpose(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] transposedMatrix = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                transposedMatrix[i][j] = matrix[j][i];

        return transposedMatrix;
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            List<Integer> list = Arrays.stream(image[i]).boxed().toList();
            Collections.reverse(list); // First reversed each row
            image[i] = list.stream().map(value -> value > 0 ? 0 : 1)
                                    .mapToInt(Integer::valueOf).toArray(); //Then, inverted the image
        }
        return image;
    }

    public List<Integer> addToArrayForm22(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum = sum * 10 + num[i];
        }
        for(int i : num){
            sum += i;
        }
        sum+=k;
        System.out.println(sum);
        while (sum > 0) {
            list.add(0, sum % 10);
            sum /= 10;
        }
        return list;
    }

    public static int largestAltitude(int[] gain) {
        int altitude = 0;
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];
            if (max < altitude) max = altitude;
        }
        return max;
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        long count = 0;
        switch (ruleKey) {
            case "type" -> count = items.stream().filter(list -> list.get(0).equals(ruleValue)).count();
            case "color" -> count = items.stream().filter(list -> list.get(1).equals(ruleValue)).count();
            case "name" -> count = items.stream().filter(list -> list.get(2).equals(ruleValue)).count();
        }
        return (int) count;
    }

    public static boolean checkIfPangram(String sentence) {
        /*Method 1:
        int[] arr = new int[123];
        for (int i = 0; i < sentence.length(); i++) {
            int value = sentence.charAt(i);
            arr[value]++;
        }
        for (int i = 97; i < 123; i++) {
            if(arr[i]==0){
                return false;
            }
        }
        return true;*/

        /*Method 2:
        if(sentence.length()<26) return false;
        for(int i=1;i<=26;i++)
            if(sentence.indexOf((char)i+96)<0)
                return false;
        return true;*/

        for (char c = 'a'; c <= 'z'; c++)
            if (sentence.indexOf(c) < 0) return false;
        return true;

    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cloneArr = nums.clone();
        System.out.println(Arrays.toString(cloneArr));
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i] & i != j) res[i]++;
            }
        }
        return res;
    }

    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i < j & nums[i] == nums[j]) count++;
            }
        }
        return count;
    }

    public int numIdenticalPairs2(int[] guestList) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for (int friends : guestList) {
            int friendCount = hm.getOrDefault(friends, 0);
            ans += friendCount;
            hm.put(friends, friendCount + 1);
        }
        return ans;
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
//        List<Boolean> res = new ArrayList<>(candies.length);
//        int max = 0;
//        for (int a :
//                candies) {
//            max = Math.max(max, a);
//        }
//        for (int i = 0; i < candies.length; i++) {
//            res.add(candies[i] + extraCandies >= max);
//        }
//        return res;

        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= max).collect(Collectors.toList());
    }

    public static int[] shuffle(int[] numbs, int n) {
        int[] result = new int[numbs.length];
        for (int i = 0; i < n; i++) {
            result[2 * i] = numbs[i];
            result[2 * i + 1] = numbs[n + i];
        }
        return result;
    }

    public static int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            maxWealth = Math.max(maxWealth, Arrays.stream(account).sum());
        }
        return maxWealth;
    }

    public static int[] runningSum(int[] nums) {
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            nums[i] = sum;
//        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = ans[i + nums.length] = nums[i];
        }
        return ans;
    }

    private static void bAFP() {
        System.out.println("Enter an array");
        Scanner in = new Scanner(System.in);
        int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ans = buildArray(array);
        System.out.println(Arrays.toString(ans));

    }

    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static int maximumWealthnow(int[][] accounts) {
        int max = 0, temp = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                temp += accounts[i][j];
            }
            max = Math.max(temp, max);
            temp = 0;
        }
        return max;
    }
    public static int numIdenticalPairs3(int[] A) {
        int ans = 0, cnt[] = new int[101];
        for (int a: A) {
            ans = ans + cnt[a];
            cnt[a]++;
//            ans += cnt[a]++;
        }
        return ans;
    }

    public static boolean checkIfPangram2(String sentence) {
        int[] count = new int[26];
        for (int i = 0; i < sentence.length(); i++)
            count[sentence.charAt(i) - 'a']++;
        System.out.println(Arrays.toString(count));
        for (int i : count)
            if (i < 1)
                return false;

        return true;
    }

}
