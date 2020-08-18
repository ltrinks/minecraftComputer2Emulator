public class Check {

    // checks if the the length of the machine line is the proper length to attempt to be translated
    public static void MachineLineIsProperLength(String machineLine) {
        if (machineLine.length() == 48) {
            Translate.isTruth(true);
        }
    }

    //takes in a string and checks to see if it is a valid GoTo input and returns the assembly
    public static String GoTo(String goTo) {
        if (goTo.charAt(6) == '1') {
            if (IsROMAddress(goTo.substring(0, 6)) == true) {
                Translate.isTruth(true);
                return "GOTO " + Translate.toDecimal(goTo.substring(0,6), 2) + ";";
            } else {
                return "Invalid GOTO";
            }
        }
        Translate.isTruth(true);
       return " ;";
    }

    // checks to see if a given value is a proper rom address
    public static boolean IsROMAddress(String address) {
        if (Translate.toDecimal(address) >= 0 && Translate.toDecimal(address) < 64) {
            return true;
        }
        return false;
    }

    //checks to see if a given value is a proper ram address
    public static boolean IsRAMAddress(String address) {
        if (Translate.toDecimal(address) >= 0 && Translate.toDecimal(address) <= 8) {
            return true;
        }
        return false;
    }

    // checks to see if a given input is a proper input
    public static boolean IsProperInput(String input) {
        if (Translate.toDecimal(input) >= 0 && Translate.toDecimal(input) < 256) {
            return true;
        }
        return false;
    }
}
