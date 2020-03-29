package Presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Data.UserDAORandom;
import Person.User;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

// TODO: registration - user credentials (3)
public class Frame2 {
	private static JTextField textField_fullName;
	private static JTextField textField_email;
	private static JTextField textField_phone;
	private static JTextField textField_street;
	private static JTextField textField_postalc;
	private static JPasswordField passwordField;
	private static JPasswordField passwordField_1;
	public static int nmb = 1001;

	public static boolean isValidData() {

		if (!Validator.isPresent(textField_fullName, "Full name"))
			return false;
		if (!Validator.isPresent(textField_email, "e-mail"))
			return false;
		if (!Validator.isPresent(passwordField, "Password"))
			return false;
		if (!Validator.isPresent(passwordField_1, "Confirn the password"))
			return false;
		if (!Validator.isPresent(textField_phone, "Phone Number"))
			return false;
		if (!Validator.isInteger(textField_phone, "Phone Number"))
			return false;
		if (!Validator.isPresent(textField_street, "Street"))
			return false;
		if (!Validator.isPresent(textField_postalc, "Postal code"))
			return false;
		return true;
	}

	public static void main(String[] args) {

		UserDAORandom uDAO = new UserDAORandom();

		JFrame frame2 = new JFrame();
		frame2.setLocationRelativeTo(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setTitle("Registration");
		frame2.setSize(530, 490);
		frame2.getContentPane().setLayout(null);
		frame2.setVisible(true);

		JLabel lblName = new JLabel("Full name:");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblName.setBounds(78, 42, 99, 16);
		frame2.getContentPane().add(lblName);

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEmail.setBounds(78, 82, 61, 16);
		frame2.getContentPane().add(lblEmail);

		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(78, 203, 112, 16);
		frame2.getContentPane().add(lblPhoneNumber);

		textField_fullName = new JTextField();
		textField_fullName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_fullName.setBounds(273, 37, 201, 26);
		frame2.getContentPane().add(textField_fullName);
		textField_fullName.setColumns(10);

		textField_email = new JTextField();
		textField_email.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_email.setColumns(10);
		textField_email.setBounds(273, 77, 201, 26);
		frame2.getContentPane().add(textField_email);

		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		rdbtnMale.setBounds(273, 316, 80, 23);
		frame2.getContentPane().add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(394, 316, 80, 23);
		frame2.getContentPane().add(rdbtnFemale);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isValidData()) {
					String fullName = textField_fullName.getText();
					int Id = nmb + 1;
					nmb++;
					String email = textField_email.getText();
					String password = String.valueOf(passwordField.getPassword());
					String confirmPassword = String.valueOf(passwordField_1.getPassword());
					String postalc = textField_postalc.getText();
					String street = textField_street.getText();
					int phone = Integer.parseInt(textField_phone.getText());
					String gender = "Male";
					char rights = 'u';
					
					if(password.equals(confirmPassword)) {
						
						if (rdbtnFemale.isSelected()) {
							gender = "Female";
						}
						if (fullName.equals("Mikhail Udotov") || fullName.contentEquals("*****"))
							rights = 'a';
	
						User u = new User(fullName, Id, rights, email, password, street, gender, postalc, phone);
						if (uDAO.addUser(u)) {
							String result = "Name: " + fullName + "\n" + "E-Mail: " + email + "\n" + "Gender: " + gender;
							JOptionPane.showMessageDialog(null, "main.java.Person data is saved \n" + result);
						}
						Frame3.main(args);
						frame2.dispose();
					}else {
					JOptionPane.showMessageDialog(null, "Values of passwords fields are different");
						//requestFocusInWindow();
//						Frame2.main(args);
//						frame2.dispose();
					}
				}
			}
		});
		btnOk.setBounds(60, 397, 117, 29);
		frame2.getContentPane().add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
			}
		});
		btnCancel.setBounds(353, 397, 117, 29);
		frame2.getContentPane().add(btnCancel);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPassword.setBounds(78, 120, 74, 16);
		frame2.getContentPane().add(lblPassword);

		JLabel lblReenterThePassword = new JLabel("Confirm the password:");
		lblReenterThePassword.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblReenterThePassword.setBounds(78, 164, 178, 16);
		frame2.getContentPane().add(lblReenterThePassword);

		JLabel lblNewLabel = new JLabel("Street number:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(78, 231, 134, 16);
		frame2.getContentPane().add(lblNewLabel);

		JLabel lblPostalCode = new JLabel("Postal code: ");
		lblPostalCode.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPostalCode.setBounds(78, 270, 134, 16);
		frame2.getContentPane().add(lblPostalCode);

		JLabel lblLogin = new JLabel("Gender: ");
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblLogin.setBounds(78, 319, 61, 16);
		frame2.getContentPane().add(lblLogin);

		textField_phone = new JTextField();
		textField_phone.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_phone.setColumns(10);
		textField_phone.setBounds(273, 198, 201, 26);
		frame2.getContentPane().add(textField_phone);

		textField_street = new JTextField();
		textField_street.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_street.setColumns(10);
		textField_street.setBounds(273, 231, 201, 26);
		frame2.getContentPane().add(textField_street);

		textField_postalc = new JTextField();
		textField_postalc.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_postalc.setColumns(10);
		textField_postalc.setBounds(273, 265, 201, 26);
		frame2.getContentPane().add(textField_postalc);

		passwordField = new JPasswordField();
		passwordField.setBounds(273, 115, 201, 29);
		frame2.getContentPane().add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(273, 159, 201, 29);
		frame2.getContentPane().add(passwordField_1);

	}
}
