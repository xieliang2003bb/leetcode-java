package first_missing_positive;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive f =new FirstMissingPositive();
        int[] a = {3,4,-1,1};
        System.out.println(f.firstMissingPositive(a));


    }
}
