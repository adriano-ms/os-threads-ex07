package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PlayController implements ActionListener {

	private JButton playButton;
	private JTextField firstNumber;
	private JTextField secondNumber;
	private JTextField thirdNumber;

	public PlayController() {
		super();
	}

	public PlayController(JButton playButton, JTextField firstNumber, JTextField secondNumber, JTextField thirdNumber) {
		this.playButton = playButton;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.thirdNumber = thirdNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		playButton.setEnabled(false);
		RowController firstController = new RowController(firstNumber);
		RowController secondController = new RowController(secondNumber);
		RowController thirdController = new RowController(thirdNumber);

		firstController.start();
		secondController.start();
		thirdController.start();

		Thread aux = new Thread() {
			@Override
			public void run() {
				while (firstController.isAlive() || secondController.isAlive() || thirdController.isAlive())
					;

				if (firstNumber.getText().equals(secondNumber.getText())
						&& secondNumber.getText().equals(thirdNumber.getText())) {

					JOptionPane.showMessageDialog(null, "Congratulations, You Win!", "Victory",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Sorry, You Lose", "Fail", JOptionPane.ERROR_MESSAGE);

				}
				playButton.setEnabled(true);
				playButton.requestFocus();
			}
		};
		aux.start();

	}

}
