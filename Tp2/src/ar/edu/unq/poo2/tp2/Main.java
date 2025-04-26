package ar.edu.unq.poo2.tp2;

import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
	
		// Empresa
		Empresa empresa = new Empresa("Kramerica industries" , "1234");

		
		EmpleadoPlantaTemporaria ivan = new EmpleadoPlantaTemporaria(LocalDateTime.of(2000, 10, 5, 0, 0), 10,
																	 "Ivan", "123", "Casado", 
																	 LocalDateTime.of(1991, 5, 5, 0, 0),
																	 100);
		
		EmpleadoPlantaPermanente jose = new EmpleadoPlantaPermanente( 2, 5,
																	 "jose", "1234", "Soltero", 
																	 LocalDateTime.of(1999, 5, 5, 0, 0), 1000);
		
		EmpleadoPlantaPermanente luis = new EmpleadoPlantaPermanente( 2, 5,
				 													 "luis", "1235", "Casado", 
				 													 LocalDateTime.of(1998, 5, 5, 0, 0), 1000);
		
		Contratado maria 			  = new Contratado("maria", "15", "Soltero", 
				 										LocalDateTime.of(2008, 5, 5, 0, 0), 5000,
				 										126, "Deposito en Cuenta Bancaria");
		
		//Añadimos los empleados a la empresa
		empresa.addEmpleado(ivan);
		empresa.addEmpleado(jose);
		empresa.addEmpleado(luis);
		empresa.addEmpleado(maria);
		
		
		//////////////////////////////////////// Resultados ////////////////////////////////////////
		///
		//I) el cálculo del total de sueldos neto (SE ESPERA : 7570$)
		System.out.println("Total Sueldos Netos: " + empresa.totalSueldosNetos() + " $");
		
		//II) la liquidación de sueldo.
		empresa.liquidacionDeSueldos();
		System.out.println("//////////////// Resumen Liquidacion de Sueldos ////////////////");
		empresa.resumenLiquidacionDeSueldos();
		
		
		
		
	}

}
