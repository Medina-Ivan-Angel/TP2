package ar.edu.unq.poo2.tp2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

	//Empresa 
	Empresa empresa;
	//Empleados
	EmpleadoPlantaTemporaria ivan;
	EmpleadoPlantaPermanente jose;
	EmpleadoPlantaPermanente luis;
	Contratado maria;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		// Empresa
		empresa = new Empresa("Kramerica industries" , "1234");

				
		ivan = new EmpleadoPlantaTemporaria(LocalDateTime.of(2000, 10, 5, 0, 0), 10,
											"Ivan", "123", "Casado", 
											LocalDateTime.of(1991, 5, 5, 0, 0),
											100);
				
		jose = new EmpleadoPlantaPermanente( 2, 5,
											"jose", "1234", "Soltero", 
										    LocalDateTime.of(1999, 5, 5, 0, 0), 1000);
				
		luis = new EmpleadoPlantaPermanente( 2, 5,
						 					"luis", "1235", "Casado", 
						 					LocalDateTime.of(1998, 5, 5, 0, 0), 1000);
				
		maria = new Contratado("maria", "15", "Soltero", 
						 	   LocalDateTime.of(2008, 5, 5, 0, 0), 5000,
						 	   126, "Deposito en Cuenta Bancaria");
				
		//Añadimos los empleados a la empresa
		empresa.addEmpleado(ivan);
		empresa.addEmpleado(jose);
		empresa.addEmpleado(luis);
		empresa.addEmpleado(maria);
		
		
	}

	@Test
	void testCalculoTotalSueldoNetos() {
		
		assertEquals(7570 , empresa.totalSueldosNetos());
		
	}
	

	@Test
	void testDesgloceIvan() {
		empresa.liquidacionDeSueldos();
		String resultado = "EMPLEADO : Ivan\n"
						   + "--------- SUELDO BRUTO --------- \n"
						   + "Sueldo Basico : 100.0\n"
						   + "Horas Extras : 10\n"
						   + "TOTAL SUELDO BRUTO :500.0\n"
						   + "--------- RETENCIONES  --------- \n"
						   + "Obra Social : 50.0\n"
						   + "Mayor a 50 años : 0.0\n"
						   + "Aportes Jubilatorios : 100.0\n"
						   + "Horas Extra : 50.0\n"
						   + "TOTAL RETENCIONES : 200.0";
		
		//Buscamos el recibo de "Ivan" y lo almacenamos en recibo.
		ReciboDeHaberes recibo = empresa.getRecibos().stream().filter(r -> r.getNombre().equals("Ivan")).findFirst().orElse(null);
		
		
		//Utilizamos ".trim()" para ignorar saltos de linea al principio y al final.
		assertEquals(resultado.trim() , recibo.getDesgloce().trim());
		
	}
	
	@Test
	void testDesgloceJose() {
		empresa.liquidacionDeSueldos();
		
		String resultado = "EMPLEADO : jose\n"
							+ "--------- SUELDO BRUTO --------- \n"
							+ "Sueldo Basico : 1000.0\n"
							+ "Salario Familiar : \n"
							+ "++ Asignacion Por Hijo : 300.0\n"
							+ "++ Asignacion Por Conyuge : 0.0\n"
							+ "++ Antiguedad : 250.0\n"
							+ "TOTAL SUELDO BRUTO : 1550.0\n"
							+ "--------- RETENCIONES  --------- \n"
							+ "Obra social : 155.0\n"
							+ "Retencion Por Hijo : 40.0\n"
							+ "Aportes Jubilatorios : 232.5\n"
							+ "TOTAL RETENCIONES : 427.5";
		
		//Buscamos el recibo de "jose" y lo almacenamos en recibo.
		ReciboDeHaberes recibo = empresa.getRecibos().stream().filter(r -> r.getNombre().equals("jose")).findFirst().orElse(null);
		
		
		//Utilizamos ".trim()" para ignorar saltos de linea al principio y al final.
		assertEquals(resultado.trim() , recibo.getDesgloce().trim());
		
	}
	
	@Test
	void testDesgloceMaria() {
		empresa.liquidacionDeSueldos();
		
		String resultado = "EMPLEADO : maria\n"
							+ "--------- SUELDO BRUTO --------- \n"
							+ "TOTAL SUELDO BRUTO : 5000.0\n"
							+ "--------- RETENCIONES  --------- \n"
							+ "Gastos Administrativos Contractuales : 50.0\n"
							+ "TOTAL RETENCIONES : 50.0";
		
		//Buscamos el recibo de "jose" y lo almacenamos en recibo.
		ReciboDeHaberes recibo = empresa.getRecibos().stream().filter(r -> r.getNombre().equals("maria")).findFirst().orElse(null);
		
		
		//Utilizamos ".trim()" para ignorar saltos de linea al principio y al final.
		assertEquals(resultado.trim() , recibo.getDesgloce().trim());
		
	}
	
	
	
}//END_MAINTEST
