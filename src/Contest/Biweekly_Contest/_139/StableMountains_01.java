package Contest.Biweekly_Contest._139;

import java.util.ArrayList;
import java.util.List;

class StableMountains_01 {
    public List<Integer> stableMountains(int[] arr, int threshold) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > threshold) {
                list.add(i);
            }
        }
        return list;
    }
}