package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class ErrorInicioDeSesion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param inicioDeSesion 
	 */
	public ErrorInicioDeSesion(InicioDeSesion inicioDeSesion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioDeSesion v = new InicioDeSesion(null, null, ErrorInicioDeSesion.this);
				v.setVisible(true);
				ErrorInicioDeSesion.this.setVisible(false);
			}
		});
		btnVolver.setBounds(133, 91, 111, 37);
		contentPane.add(btnVolver);
		
		JLabel lblInfoError = new JLabel("El Usuario o la contrase\u00F1a son incorrectas");
		lblInfoError.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblInfoError.setBounds(33, 35, 326, 45);
		contentPane.add(lblInfoError);
	}
}
