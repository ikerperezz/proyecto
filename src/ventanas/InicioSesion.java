package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.UsuarioPublico;
import interfazes.ICrearLista;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InicioSesion extends JFrame implements ICrearLista {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private ArrayList<UsuarioPublico> up = new ArrayList<UsuarioPublico>();
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
		
		JLabel lblCampoObligatorio = new JLabel("*Este campo es obligatorio");
		lblCampoObligatorio.setForeground(Color.RED);
		lblCampoObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObligatorio.setBounds(190, 109, 142, 14);
		lblCampoObligatorio.setVisible(false);
		contentPane.add(lblCampoObligatorio);
		
		JLabel lblCampoObligatorio1 = new JLabel("*Este campo es obligatorio");
		lblCampoObligatorio1.setForeground(Color.RED);
		lblCampoObligatorio1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCampoObligatorio1.setBounds(190, 167, 142, 14);
		lblCampoObligatorio1.setVisible(false);
		contentPane.add(lblCampoObligatorio1);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {

				crearLista();
				UsuarioPublico us = new UsuarioPublico("iperez", "123i", "A1", 100000000);
				up.add(us);

				boolean acceso = false;
				boolean camposVacios = false;

				for (int i = 0; i < up.size(); i++) {
					if (textField.getText().trim().isEmpty()
							|| String.valueOf(passwordField.getText()).trim().isEmpty()) {

						JOptionPane.showMessageDialog(InicioSesion.this,
								"Hay campos obligatorios vacios, rellene todos");
						lblCampoObligatorio.setVisible(true);
						lblCampoObligatorio1.setVisible(true);
						camposVacios=true;
						break;
					}
					if (textField.getText().equals(up.get(i).getUsuario())
							&& (passwordField.getText().equals(up.get(i).getContraseina()))) {
						InterfazDeUsuarioPublico v = new InterfazDeUsuarioPublico(null, null);
						v.setVisible(true);
						InicioSesion.this.setVisible(false);
						textField.setText("");
						passwordField.setText("");
						acceso = true;
						break;

					}

				}

				if (acceso == false && camposVacios==false) {
					JOptionPane.showMessageDialog(InicioSesion.this,
							"Usuario o contrasena incorrecto, intentelo de nuevo");

					textField.setText("");
					passwordField.setText("");
			
			
		} 
		
			}
		});
		btnIniciarSesion.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnIniciarSesion.setBounds(196, 207, 194, 32);
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
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				passwordField.setText("");
				
			}
		});
		btnBorrar.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnBorrar.setBounds(25, 207, 115, 32);
		contentPane.add(btnBorrar);
		
	
	}
	
	public void crearLista() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha podido cargar el driver de la base de datos");
		}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:baseDatosProyecto.db");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT nombreDeUsuario, contraseña, dineroDisponible, idLiga FROM usuarios");

			while (rs.next()) {
				String usuario = rs.getString("nombreDeUsuario");
				String contraseina = rs.getString("contraseña");
				String idLIga = rs.getString("IdLIga");
				int dineroDisponible =rs.getInt("dineroDisponible");
				UsuarioPublico us= new UsuarioPublico(usuario, contraseina, idLIga, dineroDisponible);
				up.add(us);
			}
			rs.close();
			stmt.close();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido establecer la conexión a la base de datos");
		}
	}
	
	
}
