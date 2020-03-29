package Presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// TODO: enter verification code (4)
public class Frame4 {
	private static JTextField textField;

	public static void main(String[] args) {

		JFrame frame4 = new JFrame();
		frame4.setLocationRelativeTo(null);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.setTitle("Registration");
		frame4.setSize(530, 200);
		frame4.getContentPane().setLayout(null);

		JLabel lblTheVarificationCode = new JLabel("The varification code has been sent to your email address");
		lblTheVarificationCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblTheVarificationCode.setBounds(70, 24, 368, 31);
		frame4.getContentPane().add(lblTheVarificationCode);

		JLabel lblPleaseEnterThe = new JLabel("Please enter the code in the box below");
		lblPleaseEnterThe.setBounds(129, 52, 255, 16);
		frame4.getContentPane().add(lblPleaseEnterThe);

		textField = new JTextField();
		textField.setBounds(176, 88, 165, 26);
		frame4.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code;
				if (textField.getText().equalsIgnoreCase("0")) { // "0" for now...
					frame4.dispose();
					JOptionPane.showMessageDialog(frame4, "Congratulations! You are now official member of the club",
							"Congratulations!", JOptionPane.INFORMATION_MESSAGE);
					frame4.dispose();
				} else {
					JOptionPane.showMessageDialog(frame4,
							"The code you entered is invalid. Please, check the code and try again time",
							"Congratulations!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDone.setBounds(200, 126, 117, 29);
		frame4.getContentPane().add(btnDone);
		frame4.setVisible(true);

	}
}
