package DailyCodeChallenge.Greedy;

class MaximumSwap_670 {
    public static void main(String[] args) {
        MaximumSwap_670 obj = new MaximumSwap_670();
        System.out.println(obj.maximumSwap(98368));
    }

    public int maximumSwap(int num) {
        if (num < 10) return num;

        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            // find maximum element which is greater than arr[i] and farthest
            int index = find(i, arr);
            if (index != -1) {
                swap(arr, i, index);
                break;
            }
        }
        return Integer.parseInt(String.valueOf(arr));
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int find(int i, char[] arr) {
        int index = -1;
        char max = arr[i];

        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] > arr[i] && arr[j] >= max) {
                max = arr[j];
                index = j;
            }
        }
        return index;
    }
}