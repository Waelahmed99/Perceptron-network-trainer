package Perceptron;
import java.util.ArrayList;
import Perceptron.Input;
import Perceptron.Network;

class Main {
    public static void main(String[] args) {
        // Initialize as many number of input you want.
        Integer[] in1 = new Integer[]{2, 2};
        Integer[] in2 = new Integer[]{1, -2};
        Integer[] in3 = new Integer[]{-2, 2};
        Integer[] in4 = new Integer[]{-1, 1};

        // Add all inputs in one List.
        ArrayList<Input> inputs = new ArrayList<Input>();
        inputs.add(new Input(in1, 0));
        inputs.add(new Input(in2, 1));
        inputs.add(new Input(in3, 0));
        inputs.add(new Input(in4, 1));

        // Initial weight and bias.
        int bias = 0;
        ArrayList<Integer> weight = new ArrayList<Integer>();
        weight.add(0);
        weight.add(0);

        // Begin training with evaluate function.
        System.out.println("Welcome!");
        for (int i = 0; i < inputs.size(); i++)
            System.out.println(inputs.get(i).values);
        Network network = new Network(inputs, weight, bias);
        network.evaluate();
    }
}
