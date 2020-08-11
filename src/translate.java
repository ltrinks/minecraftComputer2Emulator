public class translate {

    // converts a decimal value to a string of binary that is 16 bits
    public static String toBinary(int result) { // takes in an integer and returns a String
        String binaryResult = "";
        int binaryTest = 32768; // the value at 16 bits
        int workingResult = result;

        if (result > 65535) {    // if too big to be displayed properly return as carry
            return "carry";
        }

        while (binaryTest >= 1) {
            if (workingResult - binaryTest >= 0) {
                binaryResult = binaryResult + "1";
                workingResult = workingResult - binaryTest; // if the bit should turn on, its puts 1 and subtracts the bit from the workingResult
            } else {
                binaryResult = binaryResult + "0";
            }
            binaryTest = binaryTest / 2;      // moves to next bit
        }

        return binaryResult;                   // returns the binary result as a string
    }


    // converts a binary string that is 16 bits into a decimal integer
    public static int toDecimal(String result) { // takes in a String and returns an integer
        int decimalResult = 0;
        int binaryValue = 32768; // value at 16 bits
        String workingResult = result;

        if (workingResult.length() != 16) { // if the string isnt 16 bits then return -1
            return -1;
        }

        while (binaryValue >= 1) { //while the bit is above or at 1
            if (workingResult.charAt(0) == '1') { // if the bit is 1, add its value to the sum
                decimalResult += binaryValue;
            } else if (workingResult.charAt(0) == '0') { //if it is 0, do nothing
                decimalResult += 0;
            } else { // if it is not 0 or 1, return -1
                return -1;
            }
            workingResult = workingResult.substring(1, workingResult.length()); //remove the last bit
            binaryValue = binaryValue / 2; //change the working bit to the next smallest one
        }

        return decimalResult;
    }


}

