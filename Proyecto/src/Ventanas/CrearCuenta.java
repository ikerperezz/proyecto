package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearCuenta extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public CrearCuenta(InicioDeSesion inicioDeSesion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioDeSesion v = new InicioDeSesion(CrearCuenta.this, null, null);
				v.setVisible(true);
				CrearCuenta.this.setVisible(false);
			}
		});
		btnVolver.setBounds(10, 11, 89, 23);
		contentPane.add(btnVolver);
	}

}
