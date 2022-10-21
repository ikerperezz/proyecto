package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Clases.UsuarioPublico;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;


public class InicioDeSesion extends JFrame{

	private JFrame frame;
	private JTextField textFieldUs;
	private JLabel lblContraseina;
	private JPasswordField passwordFieldPas;
	private ArrayList<UsuarioPublico> listaUsuarioPublicos= new ArrayList<UsuarioPublico>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioDeSesion window = new InicioDeSesion(null, null, null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*

	/**
	 * Initialize the contents of the frame.
	 */
	public InicioDeSesion(CrearCuenta crearCuenta, InterfazUsuarioPublico interfazUsuarioPublico, ErrorInicioDeSesion errorInicioDeSesion) {
		crearLista();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldUs = new JTextField();
		textFieldUs.setFont(new Font("Verdana", Font.PLAIN, 14));
		textFieldUs.setBounds(226, 79, 142, 20);
		frame.getContentPane().add(textFieldUs);
		textFieldUs.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblUsuario.setBounds(84, 82, 132, 14);
		frame.getContentPane().add(lblUsuario);
		
		lblContraseina = new JLabel("Contrase\u00F1a:");
		lblContraseina.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblContraseina.setBounds(84, 134, 132, 14);
		frame.getContentPane().add(lblContraseina);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String us= textFieldUs.getText();
			String pas=passwordFieldPas.getText();
			boolean inicioCorrecto= false;
			for (int i = 0; i < listaUsuarioPublicos.size(); i++) {
				if (us.equals(listaUsuarioPublicos.get(i).getUsuario()) && pas.equals(listaUsuarioPublicos.get(i).getContraseina())) {
					inicioCorrecto=true;
					break;
					
				
				
			}
				if (inicioCorrecto==true) {
					InterfazUsuarioPublico v = new InterfazUsuarioPublico(InicioDeSesion.this);
					v.setVisible(true);
					InicioDeSesion.this.setVisible(false);
				} else {
					ErrorInicioDeSesion v = new ErrorInicioDeSesion(InicioDeSesion.this);
					v.setVisible(true);
					InicioDeSesion.this.setVisible(false);
				}
				
			}
			}
		});
		btnIniciarSesion.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnIniciarSesion.setBounds(112, 197, 194, 32);
		frame.getContentPane().add(btnIniciarSesion);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				CrearCuenta v = new CrearCuenta(InicioDeSesion.this);
				v.setVisible(true);
				InicioDeSesion.this.setVisible(false);
			}
		});
		btnCrearCuenta.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCrearCuenta.setBounds(305, 11, 121, 23);
		frame.getContentPane().add(btnCrearCuenta);
		
		passwordFieldPas = new JPasswordField();
		passwordFieldPas.setBounds(226, 134, 142, 20);
		frame.getContentPane().add(passwordFieldPas);
	}
	


	public void  crearLista() {
		try (Scanner s = new Scanner(new File("./src/UsuariosPublicos.txt")).useDelimiter(";")) {
			while (s.hasNextLine()) {
				UsuarioPublico usuario = new UsuarioPublico(null, null, null, 0);
				
				usuario.setUsuario(s.next());
				System.out.println();
				usuario.setContraseina(s.next());
				usuario.setIdLiga(s.next());
				usuario.setDineroDisponible(s.nextInt());
				s.nextLine();

				listaUsuarioPublicos.add(usuario);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		
		
		
	
}

