import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="E3" width=400 height=425>
</applet>
*/
public class E3 extends Applet implements ActionListener {
	Button redButton, blueButton, yellowButton, blackButton;


	public void init() {
		redButton = new Button("Red");
		blueButton = new Button("Blue");
		yellowButton = new Button("Yellow");
		blackButton = new Button("Green");


		redButton.addActionListener(this);
		blueButton.addActionListener(this);
		yellowButton.addActionListener(this);
		blackButton.addActionListener(this);


		add(redButton);
		add(blueButton);
		add(yellowButton);
		add(blackButton);
	}


	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		Color bgColor = Color.WHITE;


		if (command.equals("Red")) {
			bgColor = Color.RED;
		} else if (command.equals("Blue")) {
			bgColor = Color.BLUE;
		} else if (command.equals("Yellow")) {
			bgColor = Color.YELLOW;
		} else if (command.equals("Green")) {
			bgColor = Color.GREEN;
		}


		setBackground(bgColor);
	}
}