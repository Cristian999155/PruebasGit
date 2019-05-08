package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mundo.contenedora.MetodosLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	public static  JTextField txtUser;
	public static  JTextField textClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 348, 445);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(348, 0, 360, 445);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Californian FB", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(47, 149, 98, 18);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setBounds(135, 23, 83, 35);
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 29));
		lblNewLabel.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setForeground(Color.WHITE);
		txtUser.setBackground(new Color(47, 79, 79));
		txtUser.setBounds(90, 180, 202, 35);
		panel_1.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Californian FB", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(47, 246, 83, 18);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("SignUP");
		btnNewButton.setFont(new Font("Californian FB", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			
	
			public void actionPerformed(ActionEvent e) 
			{
				MetodosLogin mt = new MetodosLogin();
				if(mt.ValidateEntry() == 1)
				{
					dispose();
					JOptionPane.showMessageDialog(null, "Bienvenido\n Has ingresado al sistema");
					
					PanelInformationSong song = new PanelInformationSong();
					song.setVisible(true);

			}else {
					
					
				JOptionPane.showMessageDialog(null, "Acceso denegado");
				}
				
				
			}
		});
		btnNewButton.setBounds(135, 366, 97, 25);
		panel_1.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(47, 228, 267, 3);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(47, 325, 279, 18);
		panel_1.add(separator_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/data/216498-48.png")));
		lblNewLabel_3.setBounds(29, 180, 56, 35);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/data/3643755-48.png")));
		lblNewLabel_4.setBounds(29, 270, 56, 48);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(Login.class.getResource("/data/2203549-64.png")));
		lblNewLabel_5.setBounds(145, 60, 71, 72);
		panel_1.add(lblNewLabel_5);
		
		textClave = new JTextField();
		textClave.setBounds(90, 277, 202, 35);
		panel_1.add(textClave);
		textClave.setColumns(10);
	}
	
	
}
