package proyecto;

public class Administracion extends Persona {

	public String funcion;
		
	public Administracion(String funcion) {

		this.funcion = funcion;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	
	public void generar_Turno() {
		Turno.generar_Turno(getFuncion());
	}
	
	public void generar_Informe() {
		System.out.println ("***Bienvenido Administrador***");
		System.out.println ("Pronto se generará el informe de atenciones diaria..." + "\n"
				          + "Espere un instante...");
		String CONTAR_ATENCIÓNES = "select*from turno";
				
				/*"select count(*)\r\n"
				+ "from turno\r\n"
				+ "where (disponibilidad ='1');";
				*/
		
		Statement sql = super.open_Connection().createStatement();
		ResultSet rs = sql.executeQuery(CONTAR_ATENCIÓNES);
		int atenciones = 0;
		while (rs.next())
			atenciones+= rs.getInt("disponibilidad");
			System.out.println ("*****RESULTADO DEL INFORME***** " + "\n"
								+ "Pacientes atendidos: " + atenciones );
	}
		
} 
