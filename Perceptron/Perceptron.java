package Perceptron;

import java.util.ArrayList;

class Network {
    ArrayList<Input> _input;
    ArrayList<Integer> _weight;
    int bias;

    public Network(ArrayList<Input> in, ArrayList<Integer> weight, int b) {
        _input = in;
        _weight = weight;
        bias = b;
    }

    /*
    Main logic here
    Try to train each input alone, if the target is satisfied, then increase the counter by one.
    if the target fails, then assign the counter by one to check it again in the next cycle.
    Do the previous step until the succeed inputs counter is equal to the number of inputs. 
    i.e. all the inputs succeed.
    */
    public void evaluate() {
        int counter = 1;
        int index = 0;
        System.out.println("initial weight: " + _weight + ", initial bias: " + bias);
        while (counter != _input.size()) {
            Input p = _input.get(index);
            int n = p.multiply(_weight) + bias;
            System.out.println("input " + (index + 1) + " : " + p.values);
            System.out.println("a = " + hardlim(n));
            // Target is not satisfied by the output.
            if (hardlim(n) != p.target) {
                counter = 1;
                System.out.println("Values will be updated from weight = " + _weight + " and bias = " + bias);
                updateValues(p.target - hardlim(n), index);
                System.out.println("To weight = " + _weight + " and bias = " + bias);
            } else {
                // Target is satisfied.
                System.out.println("Good, nothing to be updated");
                counter++;
            }
            System.out.println("index = " + (index + 1) + ", Counter = " + counter);
            index = (index == _input.size() - 1 ? 0 : ++index);
        }
        System.out.println("Final weight: " + _weight + ", and final bias: " + bias);
        System.out.println("Implemented by Wael Ahmed, Thank you ^_^");
        System.out.println("If you are interested in my work, feel free to visit waelahmed.me");
    }

    // Update values using the formula e = t - a.
    private void updateValues(int e, int idx) {
        bias = bias + e;
        _weight = addLists(_weight, _input.get(idx), e);
    }

    private ArrayList<Integer> addLists(ArrayList<Integer> a1, Input in, int e) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < a1.size(); i++)
            res.add(a1.get(i) + (in.values.get(i) * e));
        return res;
    }

    // Just basic hardlim function.
    private int hardlim(int n) {
        return (n >= 0 ? 1 : 0);
    }
}