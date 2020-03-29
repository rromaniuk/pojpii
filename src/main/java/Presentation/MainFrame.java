package Presentation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// TODO: Reference code window (2)
public class MainFrame {
	private static JTextField textField;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Registration");
		frame.setSize(560, 260);
		frame.getContentPane().setLayout(null);

		JLabel lblEnterYourReference = new JLabel("Enter your reference code:");
		lblEnterYourReference.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEnterYourReference.setBounds(188, 29, 216, 31);
		frame.getContentPane().add(lblEnterYourReference);

		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField.setBounds(144, 80, 284, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equalsIgnoreCase("0")) { // "0" for now...
					Frame2.main(args);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "Entered code doesn't exist", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnOk.setBounds(88, 175, 117, 29);
		frame.getContentPane().add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(369, 175, 117, 29);
		frame.getContentPane().add(btnCancel);
		frame.setVisible(true);
	}
}
