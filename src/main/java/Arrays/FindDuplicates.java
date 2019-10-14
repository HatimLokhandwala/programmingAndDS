//given an array of integers where 1<= a[i] <= n  (n = size of array)
//determine all the elements that appear twice

//Use arrays elements to store the counts, to distinguish between count and the actual value, store counts as negative value.
class FindDuplicates{
    public List<Integer> findDuplicates(int[] nums) {
        for(int i=0; i <nums.length; i++){ 
            if(nums[i] > 0) {
                int val = nums[i];
                nums[i] = 0;
                while(val > 0) {
                    int temp = nums[val - 1];
                    if(nums[val - 1] > 0) {
                        nums[val - 1] = -1;
                    } else {
                        nums[val - 1]--;
                    }
                    val = temp;
                }
            }
        }
        List<Integer> output = new ArrayList<>();
        for(int i=0; i <nums.length; i++){ 
            if(nums[i] == -2) {
                output.add(i+1);
            }
        }
        return output;
    }
}
