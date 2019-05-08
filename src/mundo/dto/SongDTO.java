package mundo.dto;

import java.io.Serializable;

public class SongDTO implements IDTO, Serializable {
	
	private final static long serialVersionUID = 5063886785530634323L;

	private int idsong;
	
	private String namesong;
	
	private String nameinterpreter;
	
	private double duration;
		
	private String genre;
	
	
	
	public SongDTO()
	{
		
	}
	
	public SongDTO(int pId, String pNamesong, String pNameInterpreter, double pDuration, String pGenre )
	{
		super();

		idsong = pId;
		namesong = pNamesong;
		nameinterpreter = pNameInterpreter;
		duration = pDuration;
		genre = pGenre;	
	}
	
		
	public int getIdSong() {
		return idsong;
	}

	public void setIdSong(int pIdSong) {
		idsong = pIdSong;
	}

	public String getNamesong() {
		return namesong;
	}

	public void setNamesong(String pNamesong) {
		namesong = pNamesong;
	}

	public String getNameInterpreter() {
		return nameinterpreter;
	}

	public void setNameInterpreter(String pNameInterpreter) {
		nameinterpreter = pNameInterpreter;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double pDuration) {
		duration = pDuration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String pGenre) {
		genre = pGenre;
	}

	@Override
	public String insert() {
		return "INSERT INTO  songs (idsong,namesong,nameinterpreter,duration, genre) VALUES ("+ idsong+ ", '"+namesong.trim()+"', '"+nameinterpreter.trim()+ "', "+ duration+", '"+genre.trim()+"' )";
	}

	@Override
	public String delete() {
		return "DELETE FROM songs WHERE IDSONG = " +idsong;
	}

	@Override
	public String update() {
		return "UPDATE songs SET idsong = "+idsong+",namesong = '"+namesong.trim()+"', nameinterpreter = '"+nameinterpreter.trim()+"', duration = "+duration+", genre = '"+genre.trim()+"' WHERE IDSONG = "+idsong;
	}

	@Override
	public String consult() {
		return "Select IDSONG, NAMESONG, NAMEINTERPRETER, DURATION, GENRE FROM songs WHERE IDSONG = " +idsong;
		
	}
	
	@Override
	public String consultAll() {
		return "select * from songs";
	}

	public String toString() 
	{
		return "songs:" + "\n" + "ID = " + idsong + "\nName = " + namesong +"\nName Interpreter = " + nameinterpreter + "\nDuration = " + duration + "\nGenre = "+genre +"\n " +"/---------------------------------------\\";
	}

}
