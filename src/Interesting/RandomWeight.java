package Interesting;

import jdk.jfr.Description;

import java.util.Random;
import java.util.TreeMap;

@Description("528. Random Pick with Weight")
class RandomWeight {
    private final TreeMap<Integer, Integer> treeMap;
    private final Random random = new Random();
    int totalSum;

    public RandomWeight(int[] w) {
        treeMap = new TreeMap<>();
         /*Sum up the weights (incremental sum)
         We insert the numbers with the current weight sum into the TreeMap, so we get a "weighted distribution" among the keys

         e.g. to visualize "distribution":
         Weights      [1,     4,      2,    3] end up in the TreeMap as
         TreeMap:    | - | - - - - | - - | - - -    [0, sumWeight - 1] (we leave the right side "open")
         Keys:       0   1         5     7
         Values:       0      1       2      3
         Incr. Sum:    0     1-4     5-6    7-9
         The greater/"longer" one range is the higher the probability for that range to be chosen randomly
         here we keep the last position open(do not add final weight) to give each number fair amount of probability
         */
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            treeMap.put(sum, i);
            sum += w[i];
        }

        totalSum = sum;
    }

    public int pickIndex() {
         /*We pick an index within the range of the key values which equals to [0, totalWeight - 1]
         and floor it to the next key

         e.g.
         TreeMap:    | - | - - - - | - - | - - -
                               ^ Random pick
         TreeMap:    | - | - - - - | - - | - - -
                         ^ We floor to this key and get the value*/
        int randomWeight = random.nextInt(totalSum);
        return treeMap.floorEntry(randomWeight).getValue();
    }
}