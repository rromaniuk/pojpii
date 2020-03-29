package Presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// main window
public class FrameFirst {
	public static void main(String[] args) {
		JFrame newFrame = new JFrame();
		newFrame.setVisible(true);
		newFrame.setSize(600, 300);

		JPanel panel = new JPanel();
		newFrame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnSingUp = new JButton("Sign Up");
		btnSingUp.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSingUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.main(args);
			}
		});
		btnSingUp.setBounds(94, 135, 182, 42);
		panel.add(btnSingUp);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame5.main(args);
			}
		});
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnLogin.setBounds(347, 135, 182, 42);
		panel.add(btnLogin);

		JLabel lblNewLabel = new JLabel("Welcome to the club, buddy");
		lblNewLabel.setFont(new Font("Kohinoor Gujarati", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(111, 46, 405, 30);
		panel.add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		newFrame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke('X'));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
	}
}
