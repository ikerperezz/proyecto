package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
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
	public InicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblUsuario.setBounds(48, 92, 132, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContraseina = new JLabel("Contraseña:");
		lblContraseina.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblContraseina.setBounds(48, 144, 132, 14);
		contentPane.add(lblContraseina);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazDeUsuarioPublico v = new InterfazDeUsuarioPublico();
				v.setVisible(true);
				InicioSesion.this.setVisible(false);
			}
		});
		btnIniciarSesion.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnIniciarSesion.setBounds(76, 207, 194, 32);
		contentPane.add(btnIniciarSesion);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 144, 142, 20);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(190, 89, 142, 20);
		contentPane.add(textField);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCuenta v = new CrearCuenta();
				v.setVisible(true);
				InicioSesion.this.setVisible(false);
			}
		});
		btnCrearCuenta.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCrearCuenta.setBounds(269, 21, 121, 23);
		contentPane.add(btnCrearCuenta);
	}
}
