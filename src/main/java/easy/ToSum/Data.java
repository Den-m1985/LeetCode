package easy.ToSum;

public class Data {
    public int[] nums;
    public int target;
    public int[] output;

    public Data(int[] nums, int target, int[] output) {
        this.nums = nums;
        this.target = target;
        this.output = output;
    }

    public int[] getNums() {
        return nums;
    }

    public int getTarget() {
        return target;
    }

    public int[] getOutput() {
        return output;
    }
}
