//Desktop computer: adds GPU type

public final class Desktop 
{
    private final String GPUType;
    private final Computer computer;

    //Constructor
    public Desktop(String CPU, String RAM, String disk, String GPUType) 
    {
        //Composition from Computer
        this.computer = new Computer(CPU, RAM, disk);

        //Only in Desktop subclass
        this.GPUType=GPUType;
    }

    //Getters
    public String getGPUType() 
    {
        return this.GPUType;
    }

    public String getCPU()
    {
        return computer.getCPU();
    }

    public String getRAM()
    {
        return computer.getRAM();
    }

    public String getDisk()
    {
        return computer.getDisk();
    }

    //Return formatted version of data
    public String toString() 
    {
        return "Type:Desktop" + computer.toString() + "\tGPU:" + this.GPUType;
    }
}
