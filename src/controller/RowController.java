package controller;

import javax.swing.JTextField;

public class RowController extends Thread {

	private JTextField number;

	public RowController() {
		super();
	}

	public RowController(JTextField number) {
		super();
		this.number = number;
	}



	@Override
	public void run() {
		try {
			int currentNumber = number.getText().equals("") ? (int) ((Math.random() * 7) + 1) : Integer.parseInt(number.getText());
			int rowsAmount = (int) ((Math.random() * 150) + 1);
			for (; rowsAmount > 0; rowsAmount--) {
				currentNumber = nextNumber(currentNumber);
				number.setText(String.valueOf(currentNumber));
				RowController.sleep(2);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private int nextNumber(int currentNumber) {
		if (currentNumber == 7)
			return 1;

		return currentNumber + 1;
	}

}
