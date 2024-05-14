import java.awt.*;
import java.awt.event.*;
/*
<applet code="E4" width=300 height=225>
</applet>
*/
public class E4 extends java.applet.Applet implements ActionListener {
	Button button1, button2, button3, button4;
	int count1, count2, count3, count4;
	public void init() {
		button1 = new Button("Button 1");
		button2 = new Button("Button 2");
		button3 = new Button("Button 3");
		button4 = new Button("Button 4");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			count1++;
			showStatus("Button 1 clicked " + count1 + " times.");
		} else if (e.getSource() == button2) {
			count2++;
			showStatus("Button 2 clicked " + count2 + " times.");
		} else if (e.getSource() == button3) {
			count3++;
			showStatus("Button 3 clicked " + count3 + " times.");
		} else if (e.getSource() == button4) {
			count4++;
			showStatus("Button 4 clicked " + count4 + " times.");
		}
	}
	public static void main(String[] args) {
		Frame frame = new Frame("Button Click Counter Applet");
		E4 applet = new E4();
		applet.init();
		applet.start();
		frame.add(applet);
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}