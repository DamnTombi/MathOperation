package app;

import java.net.SocketOption;
import java.util.function.Function;

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




    public static void main(String[] args) {

        MathOperation mathOperation = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        int result = mathOperation.operate(1, 2);


        StringManipulator toUppercase = s->s.toUpperCase();
        System.out.println(toUppercase.input("hello world, it must be uppercase"));

        
    }
}

