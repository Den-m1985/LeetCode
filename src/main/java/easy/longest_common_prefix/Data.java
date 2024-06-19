package easy.longest_common_prefix;

public class Data {
    private final String[] strs;
    private final String output;


    public Data(String[] strs, String output) {
        this.strs = strs;
        this.output = output;
    }

    public String[] getStrs() {
        return strs;
    }

    public String getOutput() {
        return output;
    }
}
