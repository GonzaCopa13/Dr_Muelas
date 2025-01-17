package proyecto;

import java.sql.*;

public class Paciente extends Persona{

	private boolean emergencia;
	

	public Paciente(String nombre, String apellido, int dni, int edad, String domicilio, String telefono,
			String genero, String email, String usuario, String clave, boolean emergencia) {
		super(nombre, apellido, dni, edad, domicilio, telefono, genero, email, usuario, clave);
		this.emergencia = emergencia;
	}

	public boolean isEmergencia() {
		return emergencia;
	}

	public void setEmergencia(boolean emergencia) {
		this.emergencia = emergencia;
	}
	
	public Historia_Clinica generar_HC() {
		Historia_Clinica HC = new Historia_Clinica(getNombre(),getApellido(),getDni(),
				getEdad(),getDomicilio(),getTelefono(),getGenero(),getEmail(),getUsuario(),
	            getClave(),isEmergencia(),"Extracc�n");
		return HC;
	}
	
	public boolean sector_Edad() {
		if(super.getEdad()>14) {
			return true;
		}else {
			return false;
		}
	}
	
	public void panel_Paciente(){
		System.out.println("********************************************"+"\n"+
				"** \t ELEGIR TIPO DE ATENCION    \t  **"+"\n"+
				"** \t DIGITE UN NUMERO     \t\t  **"+"\n"+
				"** --> Opcion 1 : Mostrar mis datos   \t\t  **"+"\n"+
				"** --> Opcion 2 : Obtener Turno Normal \t  **"+"\n"+
				"** --> Opcion 3 : obtener Turno Emergencia \t  **"+"\n"+
				"** --> Opcion 4 : Generar Historia Clinica "+"\n"+
				"** --> Opcion 5 : Cancelar un Turno "+"\n"+
				"** --> Opcion 6 : Cerrar Sesion \t  **"+"\n"+
				"********************************************");
		int opcion = super.open_Scanner().nextInt();
		if(opcion>0 & opcion<=5) {
			switch(opcion) {
				case 1: System.out.println(mostrar_Datos());
						panel_Paciente();
						break;
						
				case 2: setEmergencia(false);
						Turno.estado_Turno();
						elegir_Turno();
						break;
						
				case 3: setEmergencia(true);
						Turno.estado_Turno();
						elegir_Turno();
						break;
						
				case 4: generar_HC().generar_pacienteHC();
						break;
					
				case 5: cancelar_Turno();
						break;
				
				case 6: super.panel_Persona();
						break;
					
			}
		}else {
			System.out.println("INGRESO UNA OPCION NO VALIDA");
		}
	}
	
	public void elegir_Turno() {
		System.out.println("Seleccione el turno: ");
		int turno = super.open_Scanner().nextInt();
		System.out.println("�Confirma el turno seleccionado? [SI = 1 - NO = 2]");
		int opcion = super.open_Scanner().nextInt();
		if(opcion == 1 || opcion == 2) {
			switch(opcion) {
											//INSERT INTO `muelas_kd`.`paciente` (`id_persona`, `emergencia`) VALUES ('18224411', '1');
				case 1: String ELEGIR_TURNO = "UPDATE `dr_muelas`.`turno` SET `disponibilidad` = '1' WHERE (`id` = '"+turno+"');";
				
						try{
								
							Statement sql = super.open_Connection().createStatement();
							sql.executeUpdate(ELEGIR_TURNO);
							System.out.println("El turno n�"+turno+ " ha sido registrado con �xito.");
						}catch (Exception e){
					        System.out.println("ERROR AL CARGAR EL TURNO"+e);
					        }	
						super.close_Connection();	
						break;
						
				case 2: System.out.println("A DECIDIDO CANCELAR LA SELECCION DE TURNO");
						break;
			}
		}else {
			System.out.println("NO INGRESO NINGUNA OPCION O INGRESO UNA OPCION NO VALIDA");
		}
	}
	
	public void cancelar_Turno() {
		
	}
	
	@Override
	public void insertarDB() {
		String INSERT_PACIENTE = "INSERT INTO `dr_muelas`.`paciente` (`emergencia`) VALUES ('?');";
		try{
            PreparedStatement sql = super.open_Connection().prepareStatement(INSERT_PACIENTE);
        
            //Setea los valores oara subirse a la base de datos
            //sql.setInt(1,getDni());
            sql.setBoolean(1, isEmergencia());
            
            //Executa los comandos
            sql.executeUpdate();
            System.out.println("EXITO SE A REGISTRADO DATOS DE PACIENTE");
        //Retiene los errores y lo muestra
        }catch (Exception e){
        	System.out.println("ERROR AL REGISTRAR: "+e);
        }

	}
	
}
	