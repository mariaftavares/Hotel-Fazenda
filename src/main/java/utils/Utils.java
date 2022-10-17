package utils;

import java.io.PrintStream;
import java.util.Scanner;

public class Utils {
	
	private Scanner input;
	private PrintStream output;
	
	public Utils(Scanner input, PrintStream output) {
		this.input = input;
		this.output = output;
	}
	
	public Utils() {}
	
	public void write(String content) {
		this.output.println(content);
	}
	
	public String read() {	
		String content = this.input.nextLine();
		return content;
	}
}
