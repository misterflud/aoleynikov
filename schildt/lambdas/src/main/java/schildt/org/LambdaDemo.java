package schildt.org;

public class LambdaDemo {
    public static void main(String[] args) {
        RandomNumber randomNumber;
        randomNumber = () -> (int) (Math.random() * 100);

        for (int i = 0; i < 10; i++) {
            System.out.println(randomNumber.getNumber());
        }

        RandomNumberWithParameter number = (a) -> {
            return (int) (Math.random() * a);
        };
        System.out.println(number.getNumber(30));

    }

    interface RandomNumber {
        int getNumber();
    }

    interface RandomNumberWithParameter {
        int getNumber(int a);
    }
}
