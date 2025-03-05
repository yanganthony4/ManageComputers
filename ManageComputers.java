//Manage Computers program: maintains an ArrayList of Computer objects, 
//can be either Laptop or Desktop, but never just Computer-type objects themselves

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageComputers {

    public static void main(String args[]) {

        //This ArrayList will hold all the computers in the system. Note that the type of objects expected in this
        //ArrayList are Computer, not Laptop or Desktop, but since those are subclasses of Computer they can be
        //stored in an ArrayLiust<Computer> anyway.
        List<Object> computers = new ArrayList<>(); // Updated from ArrayList<Computer> to List<Object>

        Scanner s = new Scanner(System.in);
        String menuOption="";

        do { //Start of main program loop

            //Show computer data in ArrayList<Object>
            showComputers(computers); 

            //Display menu and return menu option selected by the user
            menuOption = getMenuSelection(s);

            switch(menuOption) {
                //Add new computer
                case "a": 

                    addComputer(computers,s);

                    break;

                //Delete a computer    
                case "d": 

                    deleteComputer(computers,s);

                    break;

                //Edit a computer    
                case "e": 

                    editComputer(computers, s);

                    break;

            }

        } while ( ! menuOption.equals("x") ); //Stop when "x" is entered

        s.close(); //Close keyboard scanner

    } //End of main

    //-----------------------------
    //Display menu and get user selection, return it
    private static String getMenuSelection(Scanner s) {
        String menuOption="";

        //Display menu options on-screen
        System.out.println("----------");
        System.out.println("A) Add Computer");
        System.out.println("D) Delete Computer");
        System.out.println("E) Edit Computer");
        System.out.println("X) eXit");
        System.out.println("----------");

        //Get menu selection from keyboard
        System.out.print("Enter menu selection:");
        menuOption = s.nextLine();

        menuOption = menuOption.toLowerCase(); //Make lower case for comparison purposes

        return menuOption;
    } //End of getMenuSelection

    //-----------------------------
    //Show data for all laptops and desktops stored in List<Object> created in main() method
    private static void showComputers(List<Object> computers) {
        int computerListNumber=0; //This variable is used to hold the "list number" for each computer, starting at 1.

        System.out.println("=========");

        System.out.println("LIST OF COMPUTERS:-");

        if (computers.isEmpty()) {
            System.out.println("No computers available.");
        } else {
            for (Object c: computers) {
                computerListNumber++; //Increment list number for each computer
                System.out.println(computerListNumber + ": " + c.toString());
            }
        }
        System.out.println("=========");
    } //End of showComputers

    //-----------------------------
    //Add a new Laptop or Desktop computer to the List<Object>
    private static void addComputer(List<Object> computers, Scanner s) {
        System.out.println("ADDING COMPUTER:-");
        System.out.print("Enter type of computer to add ('L' for Laptop, 'D' for Desktop): ");
        String computerType = s.nextLine().toLowerCase();

        Computer tempComputer = getComputerData(s);
        
        switch (computerType) {
            case "l":
                System.out.print("Enter screen size: ");
                String screenSize = s.nextLine();
                computers.add(new Laptop(tempComputer.getCPU(), tempComputer.getRAM(), tempComputer.getDisk(), screenSize));
                break;
            case "d":
                System.out.print("Enter GPU type: ");
                String GPUType = s.nextLine();
                computers.add(new Desktop(tempComputer.getCPU(), tempComputer.getRAM(), tempComputer.getDisk(), GPUType));
                break;
            default:
                System.out.println("Invalid computer type entered!");
        }
    } //End of addComputer

    //-----------------------------
    //Delete a specified computer from the List<Object>
    private static void deleteComputer(List<Object> computers, Scanner s) {
        if (computers.isEmpty()) {
            System.out.println("No computers available to delete.");
            return;
        }
        System.out.print("Enter number of computer to delete: ");
        int index = Integer.parseInt(s.nextLine()) - 1;
        if (index >= 0 && index < computers.size()) {
            computers.remove(index);
        } else {
            System.out.println("Invalid computer number entered!");
        }
    } //End of deleteComputer

    //-----------------------------
    // Edit a computer by replacing it with a new object
    private static void editComputer(List<Object> computers, Scanner s) {
        if (computers.isEmpty()) {
            System.out.println("No computers available to edit.");
            return;
        }
        System.out.print("Enter number of computer to edit: ");
        int index = Integer.parseInt(s.nextLine()) - 1;

        if (index >= 0 && index < computers.size()) {
            Object oldComputer = computers.get(index);
            
            Computer newComputer = getComputerData(s);

            if (oldComputer instanceof Laptop) {
                System.out.print("Enter new Screen Size: ");
                String screenSize = s.nextLine();
                computers.set(index, new Laptop(newComputer.getCPU(), newComputer.getRAM(), newComputer.getDisk(), screenSize));
            } else if (oldComputer instanceof Desktop) {
                System.out.print("Enter new GPU Type: ");
                String GPUType = s.nextLine();
                computers.set(index, new Desktop(newComputer.getCPU(), newComputer.getRAM(), newComputer.getDisk(), GPUType));
            }
        } else {
            System.out.println("Invalid computer number entered!");
        }
    } //End of editComputer

    //-----------------------------
    // Helper method to get CPU, RAM, and Disk
    private static Computer getComputerData(Scanner s) {
        System.out.print("Enter CPU: ");
        String CPU = s.nextLine();
        System.out.print("Enter RAM: ");
        String RAM = s.nextLine();
        System.out.print("Enter Disk: ");
        String disk = s.nextLine();
        return new Computer(CPU, RAM, disk);
    } //End of getComputerData
} //End of ManageComputer class
