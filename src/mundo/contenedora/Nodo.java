package mundo.contenedora;

import java.io.Serializable;

public class Nodo<T> implements Serializable 
{
	private final static long serialVersionUID = -7310107063289711815L;
	
	private Nodo<T> next;
	
	private T information;

	
	public Nodo() 
	{
		next = null;
	}

	public T getInformation() {
		return information;
	}

	public void setInformation(T information) {
		this.information = information;
	}

	public Nodo<T> getNext() {
		return next;
	}

	public void setNext(Nodo<T> next) {
		this.next = next;
	}
	
}
