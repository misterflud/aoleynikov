package schildt.org;

public class LambdaDemo {
    public static void main(String[] args) {
        RandomNumber randomNumber;
        randomNumber = () -> (int) (Math.random() * 100);

        for (int i = 0; i < 10; i++) {
            System.out.println(randomNumber.getNumber());
        }

    }

    interface RandomNumber {
        int getNumber();
    }
}
