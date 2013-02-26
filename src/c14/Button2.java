package c14;

//: c14:Button2.java
//Responding to button presses.
//<applet code=Button2 width=200 height=75></applet>
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.bruceeckel.swing.*;

public class Button2 extends JApplet {
	private JButton b1 = new JButton("Button 1"), b2 = new JButton("Button 2");
	private JTextField txt = new JTextField(10);

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String name = ((JButton) e.getSource()).getText();
			txt.setText(name);
		}
	}
	private ActionListener bl1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String name = ((JButton)e.getSource()).getText();
		txt.setText(name);
		}
		};
	//you must notice, bl is not b1 they are different
	private ButtonListener bl = new ButtonListener();

	public void init() {
		b1.addActionListener(bl);
		b2.addActionListener(bl);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b1);
		cp.add(b2);
		cp.add(txt);
	}

	public static void main(String[] args) {
		Console.run(new Button2(), 200, 100);
	}
} // /:~