package mundo.contenedora;

import java.sql.ResultSet;
import java.sql.SQLException;

import interfaz.Login;
import mundo.db.Conexion;

public class MetodosLogin 
{

	public int ValidateEntry()
	{
	String usario = Login.txtUser.getText();
	String clave = Login.textClave.getText();
	
	int result = 0;
	
	String SQL = "SELECT * FROM usuarios WHERE	 usuario = '" +usario+"' AND clave= ('"+clave+"')";
	
	
	
	Conexion con = new Conexion("jdbc:postgresql://localhost:5432/dbSound", "postgres", "barcelona99");
	ResultSet rs = con.ejecutaConsulta(SQL);
	try {
		if(rs.next())
			
		{
			result = 1;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
   	
	return result;
	}
	
	
	
}

	
	
	

