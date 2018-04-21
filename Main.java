import controller.Controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  /**
	 * Main program. 
	 * It parses the assembly code to machine language and runs the MIPS simulator
	 * @param args
	 * @throws Exception if required files are not found or program has bad instructions
	 */
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		
		Controller controller = new Controller();
		
		while(true)
		{	
			System.out.print("Enter the path to the program to run: ");
			String fileName = sc.nextLine();
			System.out.println("Compiling...");
			
			try{
				controller.getParser().parse(fileName, controller.getSimulator());
				controller.getParser().setRegistersNames(controller.getSimulator());
			}
			catch(Exception e)
			{
				System.out.println("Error: " + e.getMessage());
				continue;
			}
			
			System.out.println("Initial data memory values.");
			System.out.println("===========================");
			System.out.println("Enter the memory address and the value separated by a space on a single line.\nWhen you finish, write \'finished\' on a single line");
			controller.initializeDataMemory(sc);
			
			System.out.println("Initial register file values.");
			System.out.println("===========================");
			System.out.println("Enter the register name and the value separated by a space on a single line.\nWhen you finish, write \'finished\' on a single line");
			controller.initializeRegisterFile(sc);
			
			
			System.out.print("Choose one of the following options => R (run), E (exit): ");
			if(sc.next().toUpperCase().charAt(0) == 'R')
				controller.getSimulator().run();
			break;
		}		
		
		sc.close();
	}
}