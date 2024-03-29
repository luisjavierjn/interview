package Book.RotateArray;

// Space is O(n) and time is O(n).
// You can check out the difference between System.arraycopy() and Arrays.copyOf()
public class IntermediateArray implements Strategy {
    @Override
    public void rotate(int[] nums, int k) {
        if(k > nums.length)
            k=k%nums.length;
        int[] result = new int[nums.length];
        for(int i=0; i < k; i++){
            result[i] = nums[nums.length-k+i];
        }
        int j=0;
        for(int i=k; i<nums.length; i++){
            result[i] = nums[j];
            j++;
        }
        System.arraycopy( result, 0, nums, 0, nums.length );
    }
}
