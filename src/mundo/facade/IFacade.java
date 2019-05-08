package mundo.facade;

import mundo.contenedora.Nodo;
import mundo.db.Conexion;
import mundo.contenedora.Mensaje;

public interface IFacade 
{
	public void insert(Conexion con, Mensaje messa);
	public void delete(Conexion con, Mensaje messa);
	public void update(Conexion con, Mensaje messa);
	public Nodo consultAll(Conexion con, Mensaje messa);
	public Nodo consult(Conexion con, Mensaje messa);
}
