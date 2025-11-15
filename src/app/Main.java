package app;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }

    @FunctionalInterface
    interface StringManipulator {
        String input(String s);
    }

    public static class StringListProcessor {
        static int countUppercase(String s) {
            char[] arr = s.toCharArray();
            int sumCase = 0;
            for (int i = 0; i < arr.length; i++) {
                if (Character.isUpperCase(arr[i])) {
                    sumCase++;
                }
            }
            return sumCase;
        }
    }

    public static class RandomNumberGenerator {
        static int generateRandomNumber() {
            int min = 1;
            int max = 100;
            int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
            return randomNumber;
        }
    }




    public static void main(String[] args) {

        MathOperation mathOperation = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        int result = mathOperation.operate(1, 2);

        System.out.println("Sum result "+result);


        StringManipulator toUppercase = s->s.toUpperCase();
        System.out.println(toUppercase.input("hello world, it must be uppercase"));

        Function<String,Integer> function = StringListProcessor::countUppercase;
        int uppercaseCount = function.apply("Hello There. Obi Van Kenobi");
        System.out.println("Uppercase laters "+uppercaseCount);

        Supplier<Integer> randomizer = RandomNumberGenerator::generateRandomNumber;
        int randomNumber = randomizer.get();
        System.out.println("Random Number "+randomNumber);
    }
}

