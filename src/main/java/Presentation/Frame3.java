package Presentation;

import javax.swing.*;

import java.awt.event.*;

// TODO: terms and conditions (4)
public class Frame3 extends JFrame{
	public static void main(String[] args) {
		new Frame3().setVisible(true);
	}

	public Frame3() {

		this.setTitle("Registration");
		this.setSize(600, 420);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		JCheckBox chckbxAgree = new JCheckBox("Agree");
		chckbxAgree.setBounds(248, 325, 128, 23);
		getContentPane().add(chckbxAgree);
		this.setVisible(true);
		JButton btnAgree = new JButton("Continue");
		btnAgree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxAgree.isSelected() == false) {
					JOptionPane.showMessageDialog(new JFrame(),
							"You have to agree with terms and conditions to continue", "Warning!",
							JOptionPane.WARNING_MESSAGE);
				}else {Frame4.main(null);
				dispose();}
				
			}
		});
		btnAgree.setBounds(88, 351, 117, 29);
		getContentPane().add(btnAgree);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(419, 351, 117, 29);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnCancel);

		JTextPane txtpnAttainingAimsAnd = new JTextPane();
		txtpnAttainingAimsAnd.setEditable(false);
		txtpnAttainingAimsAnd.setText("                      Terms and Conditions(to be completed...)");
		txtpnAttainingAimsAnd.setBounds(76, 21, 460, 292);
		getContentPane().add(txtpnAttainingAimsAnd);

	}
}
