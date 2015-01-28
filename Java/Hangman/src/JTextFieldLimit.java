import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument 
{
	private int limit;
	
	JTextFieldLimit(int limit) // Ändrar limiten för hur många bokstäver man ska kunna skriva i textfältet
	{
		super();
		this.limit = limit;
	}
	
	// Kollar så att man inte skriver fler bokstäver än limiten
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException
	{
		if (str == null)
		{
			return;
		}
			
		if ((getLength() + str.length()) <= limit) 
		{
			super.insertString(offset, str, attr);
		}
	}
}
