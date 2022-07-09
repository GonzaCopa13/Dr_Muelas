package proyecto;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Hacer panel para ingresar como usuario o admin
		Scanner teclado = new Scanner(System.in);
		System.out.println("****************************************************"+"\n"+
						"**   BIENVENIDO AL CONSULTORIO Dr. Muelas \t  **"+"\n"+
						"**           DIGITE UN NUMERO             \t  **"+"\n"+
						"** --> Opcion 1 : Generar turnos          \t  **"+"\n"+
						"** --> Opcion 2 : Iniciar registro        \t  **"+"\n"+
						"** --> Opcion 3 : Informaci�n             \t  **"+"\n"+
						"****************************************************");
		int opcion = teclado.nextInt();
		switch(opcion) {
		
		case 1: Administracion admin = new Administracion("Secretaria");
				admin.generar_Turno();
				break;
				
		case 2:	Persona persona = new Persona();
				persona.panel_Persona();
				break;
				
		case 3:	System.out.print("Proyecto Dr.Muelas"+"\n"+
								"1000 Programadores Salte�os - JAVA 2022"+"\n"+
								"Universidad Nacional de Salta(UnSa)"+"\n");
				break;
		}
		teclado.close();		
	}

}
