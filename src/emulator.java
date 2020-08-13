import java.util.Scanner;

public class emulator {
    public static void main(String[] args) {
       Scanner scanner= new Scanner(System.in);
       boolean quit = false;


       while (quit == false) {   // this is not working

           String command = scanner.nextLine();

           if (command.equals("stop")) {
               quit = true;
           }

           if (command.equals("binary")) {
               emulator.binaryTranslator();
           }

           if (command.equals("decimal")) {
               emulator.decimalTranslator();
           }

       }
    }

    public static void binaryTranslator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What value");
        int input1 = Integer.parseInt(scanner.nextLine());
        System.out.println("How many bits");
        int input2 = Integer.parseInt(scanner.nextLine());
        String inBinary = translate.toBinary(input1, input2);
        System.out.println(inBinary);
    }

    public static void decimalTranslator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What binary value");
        String input1 = scanner.nextLine();
        System.out.println("How you want a certain amount of digits");
        int input2 = 0;
        if (scanner.nextLine().equals("yes")) {
            System.out.println("How many");
            input2 = Integer.parseInt(scanner.nextLine());
            System.out.println(translate.toDecimal(input1, input2));
            return;
        }
        int inDecimal = translate.toDecimal(input1);
        System.out.println(inDecimal);
    }

}
