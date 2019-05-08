package mundo.contenedora;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Clase que me crea el objeto
 * @author jfzambrano
 *
 * @param <T>
 */
public class Contenedora<T> 
{
	
	private Nodo<T> head;
	
	public Contenedora() {
		head = null;
	}

	public Nodo dato(ResultSet rs, String clase)
	{
		T data = null;
		ResultSetMetaData metaDatos;
		
		try
		{
			data = (T) Class.forName(clase).newInstance();
			Method method[] = Class.forName(clase).getMethods();
			metaDatos = rs.getMetaData();
			int numeroColumnas = metaDatos.getColumnCount();
			while(rs.next())
			{
				for(int i = 1; i <= numeroColumnas; i++ )
				{
					System.out.println(metaDatos.getColumnName(i));
					Method metodo = buscarMetodo(metaDatos.getColumnName(i), method);
					if(metodo != null)
					{
						darValor(data, metodo, rs.getObject(i));
					}
					
				}
				
				System.out.println(data.toString());
				
				if(head == null)
				{
					Nodo<T> temp = new Nodo<T>();

					temp.setInformation(data);
					head = temp;
					
					data = (T) Class.forName(clase).newInstance();

				}
				else
				{
					Nodo<T> present = head;
					while(present.getNext() != null)
					{
						present = present.getNext();
						
					}
					
					Nodo<T> nuevo = new Nodo<T>();

					nuevo.setInformation(data);
					present.setNext(nuevo);
										
					data= (T) Class.forName(clase).newInstance();
				}
				
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return head;
		
		
	}
	
	public Method buscarMetodo(String name, Method[] methods)
	{
		String variable = "set" + name;
		variable = variable.replace("_", "");
		Method result = null;
		System.out.println("Method search" + variable);
		for(int i = 0; i < methods.length; i++)
		{
			if(variable.compareToIgnoreCase(methods[i].getName())==0)
			{
				result = methods[i];
			}
		}
		
		return result;
		
	}
	
	public void darValor(T data, Method method,Object res) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		method.invoke(data, res);
	}
	

	public Nodo<T> getCabeza() {
		return head;
	}

	public void setCabeza(Nodo<T> cabeza) {
		this.head = cabeza;
	}
	

}
