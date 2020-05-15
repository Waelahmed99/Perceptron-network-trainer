package Perceptron;
import java.util.ArrayList; 
import java.util.Collections;

public class Input {
    ArrayList<Integer> values = new ArrayList<Integer>();
    int target;

    public Input(Integer[] vals, int tar) {
        Collections.addAll(values, vals);
        target = tar;
    }

    public int multiply(ArrayList<Integer> weight) {
        int result = 0;
        for (int i = 0; i < values.size(); i++) {
            result += (values.get(i) * weight.get(i));
        }
        return result;
    }
}
