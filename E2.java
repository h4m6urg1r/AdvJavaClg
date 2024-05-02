import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="E2" width=400 height=425>
</applet>
*/
public class E2 extends Applet implements ActionListener {
	TextField displayField;
	String operator;
	double operand1, operand2;


	public void init() {
		setLayout(new BorderLayout());
		
		// Text field for display
		displayField = new TextField("0");
		displayField.setEditable(false);
		add(displayField, BorderLayout.NORTH);


		// Panel for buttons
		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new GridLayout(4, 4));


		// Add digit buttons
		for (int i = 0; i <= 9; i++) {
			Button button = new Button(String.valueOf(i));
			button.addActionListener(this);
			buttonPanel.add(button);
		}


		// Add operator buttons
		String[] operators = {"+", "-", "*", "/"};
		for (String op : operators) {
			Button button = new Button(op);
			button.addActionListener(this);
			buttonPanel.add(button);
		}


		// Add equals and clear buttons
		Button equalsButton = new Button("=");
		equalsButton.addActionListener(this);
		buttonPanel.add(equalsButton);


		Button clearButton = new Button("C");
		clearButton.addActionListener(this);
		buttonPanel.add(clearButton);


		add(buttonPanel, BorderLayout.CENTER);
	}


	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("C")) {
			// Clear the display
			displayField.setText("0");
			operator = "";
			operand1 = 0;
			operand2 = 0;
		} else if (Character.isDigit(command.charAt(0))) {
			// Append digits to the display
			if (displayField.getText().equals("0")) {
				displayField.setText(command);
			} else {
				displayField.setText(displayField.getText() + command);
			}
		} else if (command.equals("=")) {
			// Perform the calculation
			operand2 = Double.parseDouble(displayField.getText());
			double result = 0;
			switch (operator) {
				case "+":
					result = operand1 + operand2;
					break;
				case "-":
					result = operand1 - operand2;
					break;
				case "*":
					result = operand1 * operand2;
					break;
				case "/":
					result = operand1 / operand2;
					break;
			}
			displayField.setText(String.valueOf(result));
			operand1 = result;
			operator = "";
		} else {
			// Set operator
			operator = command;
			operand1 = Double.parseDouble(displayField.getText());
			displayField.setText("0");
		}
	}
}