import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
       Scanner scanner= new Scanner(System.in);
       boolean quit = false;


       while (quit == false) {   // this is not working
           System.out.println("Awaiting command");

           String command = scanner.nextLine();

           if (command.equals("stop")) {
               quit = true;
           }

           if (command.equals("binary")) {
               Emulator.binaryTranslator();
           }

           if (command.equals("decimal")) {
               Emulator.decimalTranslator();
           }

           if (command.equals("assembly")) {
               Emulator.translateMachine();
           }

       }
    }

    public static void binaryTranslator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What value");
        int input1 = Integer.parseInt(scanner.nextLine());

        System.out.println("How many bits");
        int input2 = Integer.parseInt(scanner.nextLine());

        String inBinary = Translate.toBinary(input1, input2);
        System.out.println(inBinary);
    }

    public static void decimalTranslator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What binary value");
        String input1 = scanner.nextLine();

        System.out.println("should the string have a certain length");
        int input2 = 0;

        if (scanner.nextLine().equals("yes")) {

            System.out.println("How many");
            input2 = Integer.parseInt(scanner.nextLine());
            System.out.println(Translate.toDecimal(input1, input2));

            return;
        }

        int inDecimal = Translate.toDecimal(input1);
        System.out.println(inDecimal);
    }

    public static void translateMachine() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What machine code");
        String input1 = scanner.nextLine();

        System.out.println(Translate.toAssembly(input1));
    }

}
