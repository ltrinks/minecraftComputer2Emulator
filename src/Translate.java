public class Translate {
    private static int truthCounter;

    public static void isTruth(boolean truth) {
        if (truth == true) {
            truthCounter ++;
        }
    }

    // converts a decimal value to a string of binary that is 16 bits
    public static String toBinary(int result, int bits) { // takes in an integer and returns a String
        String binaryResult = "";
        int binaryTest = 1;
        int workingResult = result;

        if (result < 0) {
            return "error";
        }

        for (int i = 1; i < bits; i++) {
            binaryTest = binaryTest * 2; // sets the value of the first test bit to the value of the last bit

        }

        if (result > 65535 || result > binaryTest) {    // if too big to be displayed properly return as carry
            return "error";
        }

        while (binaryTest >= 1) {

            if (workingResult - binaryTest >= 0) {
                binaryResult = binaryResult + "1";
                workingResult = workingResult - binaryTest; // if the bit should turn on, its puts 1 and subtracts the bit from the workingResult
            }
            else {
                binaryResult = binaryResult + "0";
            }

            binaryTest = binaryTest / 2;      // moves to next bit
        }

        return binaryResult;                   // returns the binary result as a string
    }


    // converts a binary string that is 16 bits into a decimal integer
    public static int toDecimal(String result) { // takes in a String and returns an integer
        int decimalResult = 0;
        int binaryValue = 1; // value to begin multiplying by
        String workingResult = result;

       for (int i = 1; i < result.length(); i++) { //makes it so that it can translate it no matter how many bits are given
           binaryValue = binaryValue * 2;
       }

        while (binaryValue >= 1) { //while the bit is above or at 1

            if (workingResult.charAt(0) == '1') { // if the bit is 1, add its value to the sum
                decimalResult += binaryValue;
            }
            else if (workingResult.charAt(0) == '0') { //if it is 0, do nothing
                decimalResult += 0;
            }
            else { // if it is not 0 or 1, return -1
                return -1;
            }

            workingResult = workingResult.substring(1, workingResult.length()); //remove the last bit
            binaryValue = binaryValue / 2; //change the working bit to the next smallest one
        }

        return decimalResult;
    }


    // takes a binary result and returns a string that has the decimal value in a certain number of digits
    public static String toDecimal(String result, int digits) {
        String decimalResult = Integer.toString(toDecimal(result));  // brings in the integer value and converts it to a string

        if (decimalResult.equals("-1")) {  //if the main toDecimal method encounters an error, return a string that says error
            return "error";
        }

        if (decimalResult.length() > digits) { //if the original number of digits exceeds the desired number of digits, return a string that says error
            return "error";
        }


        for (int i = 0; i < (digits - decimalResult.length()); i++) { // for every digit the original is off, add a zero in the front
            decimalResult = "0" + decimalResult;
        }

        return decimalResult;
    }

    public static String toAssembly(String machine) { //translates a line of machine code into assembly language
        truthCounter = 0; // keeps track of what was able to translate and what wasn't, after the method if the counter is not the proper value, the system will know the line was not properly translated

        String assembly = "";
        String workingMachine = machine;

        //for testing purposes
        while (workingMachine.length() < 48) {
                workingMachine = workingMachine + "0";
        }
        System.out.println(workingMachine.length());

        if (Check.MachineLineIsProperLength(workingMachine) == false) {
            return "Invalid number of bits";
        }

        //check goto
        assembly += Check.GoTo(workingMachine.substring(0, 7));
        workingMachine = workingMachine.substring(7);

        //check force
        assembly += Check.Force(workingMachine.substring(0, 13));
        workingMachine = workingMachine.substring(13);

        //check load 1 and load 2

        //check op

        //check save

        //check booleans

        // check output

        // check if the number of truths is correct





        return assembly;
    }

}



