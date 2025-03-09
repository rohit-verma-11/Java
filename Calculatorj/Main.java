import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Calculator cal = new Calculator();
    public static void main(String[] args) {
        System.out.print("Enter your expression to solve : ");
        String expression = sc.nextLine();
        if (!expression.equals("x")){
            cal.solve(expression);
            System.out.println("The output for the expression is : ");
            System.out.println(cal.answer);
            main(args);
        } else {
            System.out.println("Have a nice day!!!");
        }
    }
}
