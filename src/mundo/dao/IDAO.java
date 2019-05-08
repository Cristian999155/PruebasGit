package mundo.dao;

import mundo.db.Conexion;
import mundo.contenedora.Mensaje;
import mundo.contenedora.Nodo;

public interface IDAO 
{
	public void insert(Conexion con, Mensaje message);
	public void delete(Conexion con, Mensaje message);
	public void update(Conexion con, Mensaje message);
	public Nodo consultAll(Conexion con, Mensaje message);
	public Nodo consult(Conexion con, Mensaje message);
}
