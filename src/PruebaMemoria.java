import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

interface correccion{
	Scanner entrada = new Scanner(System.in);
	public static int validacion() {
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
		return "Folio: " + folio + ", Nombre: " + nombre + ", Edad=" + edad + ", Redes Sociales:" + Arrays.toString(rs) + "]";
	}
	
	
}





public class PruebaMemoria {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		RegistroDeAlumnos regAlu = new RegistroDeAlumnos();
		String nombre;
		String folio = null;
		int edad = 0, opcion=0;
		
		
		do {
			System.out.println("Digite 1 para Agregar alumno ");
			System.out.println("Digite 2 para Eliminar alumno ");
			System.out.println("Digite 3 para Mostrar alumnos ");
					System.out.println("Digite 4 para ***Salir***");
			opcion = correccion.validacion();
			switch (opcion) {
			case 1:
				String redes[]=new String[3];
				System.out.println("Ingresa el nombre: ");
				nombre = entrada.nextLine();
				System.out.println("Ingresa la edad: ");
				edad = correccion.validacion();
				System.out.println("Ingrese su Facebook: ");
				redes[0]=entrada.nextLine();
				System.out.println("Ingrese su Instagram: ");
				redes[1]=entrada.nextLine();
				System.out.println("Ingrese su Whast App: ");
				redes[2]=entrada.nextLine();
				
				if (regAlu.listaA.isEmpty()) {
					regAlu.agregar(new Alumno(1,nombre, (byte)edad, redes));
					System.out.println("...");
				}else {
					regAlu.agregar(new Alumno(regAlu.getnumFol() , nombre, (byte)edad, redes));
				}
				break;
			case 2:
				regAlu.eliminar(folio);break;
			case 3:
				regAlu.mostrar();break;
			case 4:
				System.out.println("A decidido salir del programa, Gracias!");break;
			default:
				System.out.println("Ups! Esra opcion invalida");break;
			}
			
		}while (opcion!=4);
		
		System.out.println("Tamaño del arreglo: " + regAlu.listaA.size());
		


	}

}
