package LinkLista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class LinkList extends JFrame implements ActionListener {
	// NumberFormat longFormat = NumberFormat.getIntegerInstance();

	// NumberFormatter numberFormatter = new NumberFormatter(longFormat);

	// JFormattedTextField field;

	LinkedList<Integer> nummer = new LinkedList<>();
	JPanel pan = new JPanel();
	JPanel butPan = new JPanel();
	JTextField inField = new JTextField(8);
	JTextArea ta = new JTextArea(5, 10);
	JButton sort = new JButton("Sortera");
	JButton shuffle = new JButton("Blanda");
	JButton backwards = new JButton("Bakfram");

	public LinkList() {
		super("hej");
		setBounds(100, 100, 400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		fillDefConst();
		setVisible(true);
	}

	public void fillDefConst() {
		// numberFormatter.setValueClass(Long.class);

		inField.addKeyListener(new KeyBoard());
		ta.setEditable(false);
		pan.add(BorderLayout.SOUTH, inField);
		pan.add(BorderLayout.WEST, ta);
		pan.add(BorderLayout.NORTH, butPan);
		butPan.setLayout(new GridLayout(1, 3));
		sort.addActionListener(this);
		shuffle.addActionListener(this);
		backwards.addActionListener(this);
		butPan.add(sort);
		butPan.add(shuffle);
		butPan.add(backwards);
		add(pan);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob instanceof JButton) {
			String n = ((JButton) ob).getText();
			if (n == "Sortera") {
				Collections.sort(nummer);
			} else if (n == "Blanda") {
				Collections.shuffle(nummer);
			} else if (n == "Bakfram") {
				Collections.reverse(nummer);
			}
		}
		ta.setText(nummer.toString());
	}

	public static void main(String[] args) {
		new LinkList();
	}

	public class KeyBoard extends KeyAdapter {

		@Override
		public void keyTyped(KeyEvent ke) {
			if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
				try {
					int x = Integer.parseInt(inField.getText());

					if (nummer.isEmpty()) {
						nummer.add(x);
					} else {
						if (nummer.contains(x)) {
							JOptionPane.showMessageDialog(null,	"Finns redan det talet");
						} else {
							nummer.add(x);
						}

					}

					ta.setText(nummer.toString());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "BARA SIFFROR, OMG");
					inField.setText("");
				} catch (Exception e) {
					System.out.println("????");
				}
			}
		}

	}

}
