package mundo.dao;

import mundo.contenedora.Nodo;
import mundo.db.Conexion;
import mundo.dto.SongDTO;

import java.sql.ResultSet;

import mundo.contenedora.Contenedora;
import mundo.contenedora.Mensaje;

public class SongDAO implements IDAO
{

	@Override
	public void insert(Conexion con, Mensaje message) 
	{
	
		int idsong = message.getidSong();
		String namesong = message.getnamesong();
		String nameinterpreter = message.getnameinterpreter();
		double duration = message.getduration();
		String genre = message.getgenre();
		
		SongDTO nva = new SongDTO(idsong, namesong, nameinterpreter, duration, genre);
		
		con.ejecutaActualizacion(nva.insert());
	}

	@Override
	public void delete(Conexion con, Mensaje message) 
	{
		SongDTO cancion = new SongDTO();
		cancion.setIdSong(message.getidSong());
		
		con.ejecutaActualizacion(cancion.delete());
	}

	@Override
	public void update(Conexion con, Mensaje message) 
	{
		int idsong = message.getidSong();
		String namesong = message.getnamesong();
		String nameinterpreter = message.getnameinterpreter();
		double duration = message.getduration();
		String genre = message.getgenre();
		
		SongDTO nva = new SongDTO(idsong, namesong, nameinterpreter, duration, genre);
		
		con.ejecutaActualizacion(nva.update());
		
	}

	@Override
	public Nodo consultAll(Conexion con, Mensaje message) 
	{
		SongDTO song = new SongDTO();
		
		ResultSet rs = con.ejecutaConsulta(song.consultAll());
		
		Nodo consult = new Contenedora<>().dato(rs, SongDTO.class.getName());
		
		return consult;
	}

	@Override
	public Nodo consult(Conexion con, Mensaje message) 
	{
		SongDTO song = new SongDTO();
		song.setIdSong(message.getidSong());
		
		ResultSet rs = con.ejecutaConsulta(song.consult());
		
		Nodo consult = new Contenedora<>().dato(rs, SongDTO.class.getName());
		
		return consult;
	}

}
