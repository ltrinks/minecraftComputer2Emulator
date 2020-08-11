import java.util.Scanner;

public class emulator {
    public static void main(String[] args) {
       Scanner scanner= new Scanner(System.in);
       boolean quit = false;
       String command = scanner.nextLine();

       while (quit = false) {   // this is not working

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
        int inDecimal = translate.toDecimal(input1);
        System.out.println(inDecimal);
    }

}
