package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import mundo.contenedora.Funcion;
import mundo.contenedora.Mensaje;
import mundo.contenedora.Nodo;
import mundo.contenedora.Tabla;
import mundo.servidor.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelInformationSong extends JFrame  implements ActionListener
{
	

	public final static String INSERT = "Insert";
	
	public final static String DELETE = "Delete";
	
	public final static String MODIFY = "Modify";
	
	public final static String CONSULT = "Consult";
	
	public final static String CONSULT_ID = "Consult por ID";
	
	public final static String START = "Start";
	
	public final static String CLEAR = "Clear";
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNameSong;
	private JTextField txtNameInterpreter;
	private JTextField txtGenre;
	private JTextField txtDuration;
	private JTextArea txtResults;
	private JScrollPane scroll;
	private Funcion funcion;
	private Tabla tabla = Tabla.SONGS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelInformationSong frame = new PanelInformationSong();
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
	public PanelInformationSong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1167, 848);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 1139, 791);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(169, 41, 809, 153);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton butAdd = new JButton("INSERT");
		butAdd.setActionCommand(INSERT);
		butAdd.addActionListener(this);
		butAdd.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 13));
		butAdd.setForeground(Color.WHITE);
		butAdd.setBackground(Color.GRAY);
		butAdd.setBounds(53, 28, 97, 37);
		panel_3.add(butAdd);
		
		
		JButton butModify = new JButton("MODYFY");
		
		butModify.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 13));
		butModify.setForeground(Color.WHITE);
		butModify.setBackground(Color.GRAY);
		butModify.setBounds(218, 28, 102, 37);
		butModify.setActionCommand(MODIFY);
		butModify.addActionListener(this);
		panel_3.add(butModify);
		
		JButton butConsult = new JButton("CONSULT");
		butConsult.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 13));
		butConsult.setForeground(Color.WHITE);
		butConsult.setBackground(Color.GRAY);
		butConsult.setBounds(380, 28, 102, 37);
		butConsult.setActionCommand(CONSULT);
		butConsult.addActionListener(this);
		panel_3.add(butConsult);
		
		JButton butConsultID = new JButton("CONSULT BY ID");
		butConsultID.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 13));
		butConsultID.setForeground(Color.WHITE);
		butConsultID.setBackground(Color.GRAY);
		butConsultID.setBounds(530, 28, 126, 37);
		butConsultID.setActionCommand(CONSULT_ID);
		butConsultID.addActionListener(this);
		panel_3.add(butConsultID);
		
		JButton butDelete = new JButton("DELETE");
		butDelete.setForeground(Color.WHITE);
		butDelete.setBackground(Color.GRAY);
		butDelete.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 13));
		butDelete.setBounds(700, 28, 97, 37);
		butDelete.setActionCommand(DELETE);
		butDelete.addActionListener(this);
		panel_3.add(butDelete);
		
		JButton butClear = new JButton("CLEAR");
		butClear.setBackground(Color.GRAY);
		butClear.setBounds(423, 460, 97, 25);
		butClear.setActionCommand(CLEAR);
		butClear.addActionListener(this);
		panel_1.add(butClear);
		
		JButton butStart = new JButton("Start");
		butStart.setBackground(Color.GRAY);
		butStart.setBounds(585, 460, 97, 25);
		butStart.setActionCommand(START);
		butStart.addActionListener(this);
		panel_1.add(butStart);
		
		
		// Panel resultados
		JPanel panelResults = new JPanel();
		TitledBorder edge1 = BorderFactory.createTitledBorder("Results");
		panelResults.setBounds(169, 498, 809, 280);

		txtResults = new JTextArea();
		txtResults.setEditable(false);
		scroll = new JScrollPane(txtResults);
		
		
		panel_1.add(panelResults);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(158, 196, 809, 224);
		panel_1.add(panel_2);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setLayout(null);
		
		JLabel labID = new JLabel("ID:");
		labID.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		labID.setForeground(Color.WHITE);
		labID.setBounds(202, 26, 90, 23);
		panel_2.add(labID);
		
		JLabel labNameSong = new JLabel("NameSong:");
		labNameSong.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		labNameSong.setForeground(Color.WHITE);
		labNameSong.setBounds(202, 62, 90, 16);
		panel_2.add(labNameSong);
		
		JLabel labNameInterpreter = new JLabel("NameInterpreter:");
		labNameInterpreter.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		labNameInterpreter.setForeground(Color.WHITE);
		labNameInterpreter.setBounds(202, 102, 145, 16);
		panel_2.add(labNameInterpreter);
		
		JLabel labGenre = new JLabel("Genre:");
		labGenre.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		labGenre.setForeground(Color.WHITE);
		labGenre.setBounds(202, 131, 56, 16);
		panel_2.add(labGenre);
		
		JLabel labDuration = new JLabel("Duration");
		labDuration.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		labDuration.setForeground(Color.WHITE);
		labDuration.setBounds(202, 178, 70, 16);
		panel_2.add(labDuration);
		
		txtID = new JTextField();
		txtID.setBounds(373, 26, 145, 22);
		panel_2.add(txtID);
		txtID.setColumns(10);
		
		txtNameSong = new JTextField();
		txtNameSong.setBounds(373, 61, 145, 22);
		panel_2.add(txtNameSong);
		txtNameSong.setColumns(10);
		
		txtNameInterpreter = new JTextField();
		txtNameInterpreter.setBounds(373, 99, 145, 22);
		panel_2.add(txtNameInterpreter);
		txtNameInterpreter.setColumns(10);
		
		txtGenre = new JTextField();
		txtGenre.setBounds(373, 134, 145, 22);
		panel_2.add(txtGenre);
		txtGenre.setColumns(10);
		
		txtDuration = new JTextField();
		txtDuration.setBounds(373, 175, 145, 22);
		panel_2.add(txtDuration);
		txtDuration.setColumns(10);
	}
	
	public void actionPerformed(ActionEvent event) 
	{
		String execution = event.getActionCommand();
		User user = new User();
		
		if(INSERT.equals(execution))
		{
			int menssage = JOptionPane.showConfirmDialog(null, "¿It wants to add a register?", "ADD", JOptionPane.YES_NO_OPTION);
			if(menssage == JOptionPane.YES_OPTION)
			{
				JOptionPane.showMessageDialog(null, "Please enter the data of the song you want to add");
				funcion = Funcion.INSERT;
			}		
		}
		else if(DELETE.equals(execution))
		{

			int menssage = JOptionPane.showConfirmDialog(null, "¿It wants to delete a register?", "DELETE", JOptionPane.YES_NO_OPTION);
			if(menssage == JOptionPane.YES_OPTION)
			{
				JOptionPane.showMessageDialog(null, "Please enter the ID of the song you want to delete");

				funcion = Funcion.DELETE;
			}		
		}
		
		else if(MODIFY.equals(execution))
		{
			int menssage = JOptionPane.showConfirmDialog(null, "¿It wants to modify a register?", "MODIFY", JOptionPane.YES_NO_OPTION);
			if(menssage == JOptionPane.YES_OPTION)
			{
				JOptionPane.showMessageDialog(null, "Please enter the data of the song you want to modify");

				funcion = Funcion.UPDATE;
			}
		}	
		
		else if(CONSULT.equals(execution))
		{
			int menssage = JOptionPane.showConfirmDialog(null, "¿You want to consult for all elements?", "CONSULT?",  JOptionPane.YES_NO_OPTION);
			if(menssage == JOptionPane.YES_OPTION)
			{
				

				funcion = Funcion.SELECT;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "All existing elements will be consulted");

				funcion = Funcion.SELECT;
			}
		}
		
		else if(CONSULT_ID.equals(execution))
		{
			int menssage = JOptionPane.showConfirmDialog(null, "¿You want to check your ID for a song?", "CONSULT ID?",  JOptionPane.YES_NO_OPTION);
			if(menssage == JOptionPane.YES_OPTION)
			{
				JOptionPane.showMessageDialog(null, "Please enter the ID of the song you want to consult");

				funcion = Funcion.SELECT_ID;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "All existing id elements will be consulted");

				funcion = Funcion.SELECT_ID;
			}
		}
		
		
		else if(START.equals(execution)) 
		{
			try {
				Mensaje menssage = nuevoMensaje();
				
				if(funcion.equals(Funcion.SELECT) || funcion.equals(Funcion.SELECT_ID))
				{
					Nodo nodo = user.envioMensaje(menssage);
					
					if(nodo != null)
					{
						String resultado = "";
						
						while(nodo != null)
						{
							resultado +=  nodo.getInformation().toString() + "\n";
							nodo = nodo.getNext();
						}
						
						txtResults.setText(resultado);							
					}
				}
				else
				{
					user.envioMensaje(menssage);
					JOptionPane.showMessageDialog(null, "Operation has been performed correctly.");
				}
				
				
			} 
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "There was an error: "+ "\n" + e.getMessage());
			}
		}
		else if (CLEAR.equals(execution))
		{
			txtID.setText("");
			txtNameSong.setText("");
			txtNameInterpreter.setText("");
			txtGenre.setText("");
			txtDuration.setText("");
			txtResults.setText("");	
		}
	}
	public Mensaje nuevoMensaje()
	{
		Mensaje menssage = new Mensaje();
		
		if(funcion.equals(Funcion.SELECT))
			{
				
				menssage.funcionCanciones(funcion, 1, " ", " ", 1, "");
			}
			else
			{
				int id = Integer.parseInt(txtID.getText());
				String nameSong = txtNameSong.getText();
				String nameInterpreter = txtNameInterpreter.getText();
				double duration = txtDuration.getText().isEmpty() ? 0 : Double.parseDouble(txtDuration.getText());
				String genre = txtGenre.getText();
			
				
				menssage.funcionCanciones(funcion, id, nameSong, nameInterpreter, duration, genre);
			}
			
		
		return menssage;
		
	}
}
