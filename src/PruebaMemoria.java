import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

interface correccion{
	Scanner entrada = new Scanner(System.in);
	public static int validacionNatural() {
		int r = 0;
		boolean e = false;
		
		do {
			try {
				r = entrada.nextInt();
			} catch (java.util.InputMismatchException x) {
				System.out.println("Ups! el dato que intentas ingresar no es valido");
				entrada.nextLine();
				e=true;
			}
			if (r>0) {
				e=false;
			}else {
				System.out.println("Ingresa porfavor solo numeros mayores a 0");
				e=true;
			}
		}while(e);
		return r;
	}
}

class RegistroDeAlumnos implements correccion{
	int x = 1;
	ArrayList listaA;
	private int numFol=1;
	
	public int getnumFol() {
		return numFol;
	}
	public void setnumFol(int numFol) {
		this.numFol = numFol;
	}
	
	public RegistroDeAlumnos() {
		listaA = new ArrayList();
	}
	public void agregar(Alumno al) {
		this.setnumFol(this.getnumFol()+x);
		listaA.add(al);
	}
	public Object eliminar(String folio) {
		this.setnumFol(this.getnumFol()-x);
		
		
		return listaA.remove(listaA.size()-x);
	}
	public void mostrar() {
		Iterator it = listaA.iterator();
		
		
		
		while(it.hasNext()) {
			Alumno al = (Alumno) it.next();
			
			System.out.println(al);
		}//While
	}	
}


class Alumno{
	private int folio;
	private String nombre;
	private byte edad;
	private String rs[];
	
	public Alumno(int folio, String nombre, byte edad, String[] rs) {
		this.folio = folio;
		this.nombre = nombre;
		this.edad = edad;
		this.rs = rs;
	}
	
	
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte getEdad() {
		return edad;
	}
	public void setEdad(byte edad) {
		this.edad = edad;
	}
	public String[] getRs() {
		return rs;
	}
	public void setRs(String[] rs) {
		this.rs = rs;
	}

	public String toString() {
		return "Alumno [folio=" + folio + ", nombre=" + nombre + ", edad=" + edad + ", rs=" + Arrays.toString(rs) + "]";
	}
	
	
}





public class PruebaMemoria {

	public static void main(String[] args) {
		

	}

}
