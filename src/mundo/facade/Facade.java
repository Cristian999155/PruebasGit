package mundo.facade;

import mundo.contenedora.Nodo;
import mundo.contenedora.Tabla;
import mundo.dao.SongDAO;
import mundo.db.Conexion;
import mundo.contenedora.Mensaje;

public class Facade implements IFacade
{
	private SongDAO cancionesDao;
	
	public Facade()
	{
		cancionesDao = new SongDAO();
	}

	@Override
	public void insert(Conexion con, Mensaje message) 
	{
		if(message.getTabla().equals(Tabla.SONGS))
		{
			cancionesDao.insert(con, message);
		}
	}



	@Override
	public void delete(Conexion con, Mensaje message) 
	{
		if(message.getTabla().equals(Tabla.SONGS))
		{
			cancionesDao.delete(con, message);
		}
	}
	
	
	@Override
	public void update(Conexion con, Mensaje message) 
	{	
		if(message.getTabla().equals(Tabla.SONGS))
		{
			cancionesDao.update(con, message);
		}
	}

	
	@Override
	public Nodo consultAll(Conexion con, Mensaje message) {

		Nodo nvo = new Nodo<>();
		{
			if(message.getTabla().equals(Tabla.SONGS))
			{
				nvo = cancionesDao.consultAll(con, message);
			}
		}
		return nvo;
	}

	
	@Override
	public Nodo consult(Conexion con, Mensaje message) 
	{
		Nodo nvo = new Nodo<>();
		{
			if(message.getTabla().equals(Tabla.SONGS))
			{
				nvo = cancionesDao.consult(con, message);
			}
		}
		return nvo;
	}

}
