package mundo.contenedora;

import java.io.Serializable;

public class Mensaje implements Serializable
{
	public final static long serialVersionUID = 518405140372484957L;
	private Funcion funcion;
	private Tabla tabla;
	
	
	private int idsong;
	private String namesong;
	private String nameinterpreter;
	private double duration;
	private String genre;
	
	public Mensaje()
	{
		
	}
	
	public void funcionCanciones(Funcion pFuncion, int pidSong, String pnamesong, String pnameinterpreter, double pduration, String pgenre)
	{
		tabla = Tabla.SONGS;
		funcion = pFuncion;
		idsong = pidSong;
		namesong = pnamesong;
		nameinterpreter = pnameinterpreter;
		duration = pduration;
		genre = pgenre;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Tabla getTabla() {
		return tabla;
	}

	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}

	public int getidSong() {
		return idsong;
	}

	public void setidSong(int idSong) {
		this.idsong = idSong;
	}

	public String getnamesong() {
		return namesong;
	}

	public void setnamesong(String namesong) {
		this.namesong = namesong;
	}

	public String getnameinterpreter() {
		return nameinterpreter;
	}

	public void setnameinterpreter(String nameinterpreter) {
		this.nameinterpreter = nameinterpreter;
	}

	public double getduration() {
		return duration;
	}

	public void setduration(double duration) {
		this.duration = duration;
	}

	public String getgenre() {
		return genre;
	}

	public void setgenre(String genre) {
		this.genre = genre;
	}

}
