package controller;

import java.util.Scanner;
import java.io.FileNotFoundException;

public class Controller {
	
	private Simulator simulator;
	private Parser parser;
	
	/**
	 * Constructs a new controller
	 * @throws FileNotFoundException if parser can't find program file or instruction set
	 */
	public Controller() throws FileNotFoundException
	{
		simulator = new Simulator();
		parser = new Parser();
	}
	
	/**
	 * Gets the simulator instance associated with the controller
	 * @return the simulator
	 */
	public Simulator getSimulator() { return simulator; }
	
	/**
	 * Gets the parser instance associated with the controller
	 * @return the parser
	 */
	public Parser getParser() { return parser; }
	
	/**
	 * Initializes the data memory with inital values taken from the input
	 * @param sc the scanner from which the input is taken
	 */
	public void initializeDataMemory(Scanner sc)
	{
		while(true)
		{
			String s = sc.next();
			if(s.equals("finished"))
				return;
			this.getSimulator().getDataMemory().write(Integer.parseInt(s), sc.nextInt());
		}
	}
	
	/**
	 * Initializes the register file with inital values taken from the input
	 * @param sc the scanner from which the input is taken
	 */
	public void initializeRegisterFile(Scanner sc)
	{
		while(true)
		{
			String s = sc.next();
			if(s.equals("finished"))
				return;
			this.getSimulator().getRegisterFile().writeRegister(this.getParser().getRegisterNumber(s), sc.nextInt());
		}
	}
}
