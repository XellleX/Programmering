import java.io.IOException;

import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args)
	{
		Hangman h = new Hangman();
		JOptionPane.showMessageDialog(h, "Regler: \nDu ska gissa ordet. För att gissa skriv bokstaven längst ner i textrutan och tryck sedan 'Enter'."
				+ "\nOm du gissar fel 8 gånger förlorar du.");
	}

}
