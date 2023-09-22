import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums1 = {0, 0, 0, 0};
        if (nums.length < 3) {
            System.out.println("not possible");
        } else {
            System.out.println(threeSumThreePointer(nums));
        }
    }

    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        int numLength = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < numLength; i++) {
            for (int j = i + 1; j < numLength; j++) {
                for (int k = j + 1; k < numLength; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        Collections.sort(temp);
                        result.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static List<List<Integer>> threeSumHashSet(int[] nums) {
        int numLength = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < numLength; i++) {
            Set<Integer> potentialCandidates = new HashSet<>();
            for (int j = i + 1; j < numLength; j++) {
                int lostValue = -(nums[i] + nums[j]);
                if (potentialCandidates.contains(lostValue)) {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], lostValue));
                    Collections.sort(temp);
                    result.add(temp);
                }
                potentialCandidates.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }

    public static List<List<Integer>> threeSumThreePointer(int[] nums) {
        int numLength = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < numLength; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = numLength - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> newItems = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    result.add(newItems);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
