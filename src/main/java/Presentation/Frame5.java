package Presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Data.DAOFactory;
import Data.UserDAORandom;

//TODO: login window (5) we're here
public class Frame5 {
	private static JPasswordField passwordField;
	
	private static UserDAORandom pDAO = DAOFactory.getUserDAO();

	public static void main(String[] args) {
		JFrame frame5 = new JFrame();
		frame5.setVisible(true);
		frame5.setSize(503, 205);
		frame5.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Full Name:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(78, 41, 61, 16);
		frame5.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblPassword.setBounds(78, 100, 88, 16);
		frame5.getContentPane().add(lblPassword);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textPane.setBounds(177, 35, 221, 34);
		frame5.getContentPane().add(textPane);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		passwordField.setBounds(174, 90, 224, 41);
		frame5.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textPane.getText().length()<0 || String.valueOf(passwordField.getPassword()).length()<0) {
					JOptionPane.showMessageDialog(new JFrame(),
							"All fields should be filled in", "Warning!",
							JOptionPane.WARNING_MESSAGE);
				}else {
					String name = textPane.getText();
					String pass = String.valueOf(passwordField.getPassword());
					Person.User user = pDAO.getUser(name);
					if(user == null) {
						JOptionPane.showMessageDialog(null, textPane.getText() + "is not exist");
					}else {
						if(String.valueOf(user.getPassword()).equals(pass)) {
							JOptionPane.showMessageDialog(new JFrame(),
									"You are successfully logged in", "Success!",
									JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(new JFrame(),
									"Wrong password", "Warning!",
									JOptionPane.WARNING_MESSAGE);
						}
					}

				}
			}
		});
		btnLogin.setBounds(78, 143, 117, 29);
		frame5.getContentPane().add(btnLogin);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame5.dispose();
			}
		});
		btnClose.setBounds(316, 143, 117, 29);
		frame5.getContentPane().add(btnClose);
	}
}
