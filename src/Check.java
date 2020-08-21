public class Check {

    // checks if the the length of the machine line is the proper length to attempt to be translated
    public static boolean MachineLineIsProperLength(String machineLine) {
        if (machineLine.length() == 48) {
            Translate.isTruth(true);
            return true;
        }
        return false;
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

    // checks if there is a force value and if it is valid it will return the assembly
    public static String Force(String force) {
        if (force.charAt(12) == '1') {
            if (Check.IsProperInput(force.substring(0,8)) == true && Check.IsRAMAddress(force.substring(9,12)) == true) {
                Translate.isTruth(true);
                    return " FORCE " + Translate.toDecimal(force.substring(0,8), 3) + " IN RAM " + Translate.toDecimal(force.substring(8,12), 1) + ";";
                } else {
                return "Invalid FORCE";
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
