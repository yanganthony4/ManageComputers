//Laptop computer: adds screen size to other Computer info

public final class Laptop
{
    private final String screenSize;
    private final Computer computer;

    //Constructor
    public Laptop(String CPU, String RAM, String disk, String screenSize) 
    {
        
        //Composition from Computer
        this.computer = new Computer(CPU, RAM, disk);

        //Only in Laptop subclass
        this.screenSize=screenSize;
    }

    //Getters
    public String getScreenSize() 
    {
        return this.screenSize;
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
        return "Type:Laptop" + computer.toString() + "\tScreen:" + this.screenSize;
    }
}
