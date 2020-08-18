public class MachineLine {
    String program = null;  //if this line is the start of a program, it will say the title of the program it begins
    boolean isStart = false; //will say if the line is the start of a program
    int line; //what line the code should be placed on in memory
    String machineCode = ""; //the machine language encoded in the line
    String assemblyCode = "";
    String warnings = ""; //things the checker notices are odd but don't break it
    String errors = ""; //things that make the line unable to be read
    boolean isValidLine = false; //if the machine can be properly translated it will be set to true


    //constructs a standard line of code
    public void MachineLine(int line, String machineCode) {
        this.line = line;
        this.program = null;
        this.isStart = false;
        this.machineCode = "machine code will go here"; //use methods to check the machine code input is valid
    }


    //constructs a line of code that is the start of a program
    public void MachineLine(String program, int line, String machineCode) {
        MachineLine(line, machineCode);
        this.program = program;
        this.isStart = true;
    }
}
