import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument 
{
	private int limit;
	
	JTextFieldLimit(int limit) // �ndrar limiten f�r hur m�nga bokst�ver man ska kunna skriva i textf�ltet
	{
		super();
		this.limit = limit;
	}
	
	// Kollar s� att man inte skriver fler bokst�ver �n limiten
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
