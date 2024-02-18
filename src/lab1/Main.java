package lab1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GCDFunction gcdFunction = new GCDFunction();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int num1 = scanner.nextInt();
        System.out.println("Введите второе число:");
        int num2 = scanner.nextInt();
        int[] numbers = {num1, num2};
        int gcd = gcdFunction.apply(numbers);
        System.out.println("Наибольший общий делитель: " + gcd);
    }
}