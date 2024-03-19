package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.PlayController;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstNumber;
	private JTextField secondNumber;
	private JTextField thirdNumber;
	private JButton playButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		firstNumber = new JTextField("");
		firstNumber.setEditable(false);
		firstNumber.setFont(new Font("Tahoma", Font.PLAIN, 40));
		firstNumber.setHorizontalAlignment(SwingConstants.CENTER);
		firstNumber.setBounds(51, 73, 86, 81);
		contentPane.add(firstNumber);
		firstNumber.setColumns(10);
		firstNumber.setFocusable(false);
		
		secondNumber = new JTextField("");
		secondNumber.setEditable(false);
		secondNumber.setFont(new Font("Tahoma", Font.PLAIN, 40));
		secondNumber.setHorizontalAlignment(SwingConstants.CENTER);
		secondNumber.setColumns(10);
		secondNumber.setBounds(147, 73, 86, 81);
		contentPane.add(secondNumber);
		secondNumber.setFocusable(false);
		
		thirdNumber = new JTextField("");
		thirdNumber.setEditable(false);
		thirdNumber.setFont(new Font("Tahoma", Font.PLAIN, 40));
		thirdNumber.setHorizontalAlignment(SwingConstants.CENTER);
		thirdNumber.setColumns(10);
		thirdNumber.setBounds(243, 73, 86, 81);
		contentPane.add(thirdNumber);
		thirdNumber.setFocusable(false);
	
		playButton = new JButton("Play");
		playButton.setBounds(147, 191, 89, 23);
		playButton.addActionListener(new PlayController(playButton, firstNumber, secondNumber, thirdNumber));
		contentPane.add(playButton);
	}
}
