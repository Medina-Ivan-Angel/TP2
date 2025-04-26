package ar.edu.unq.poo2.tp2;

import java.time.LocalDateTime;

public class Contratado extends Empleado {

	//Atributos
	private int numeroDeContrato;
	private String medioDePago;
	
	//Constructor
	public Contratado(String nombre, String direccion, String estadoCivil, LocalDateTime fechaDeNacimiento, double sueldoBasico,
			          int numeroDeContrato, String medioDePago) {
		
		super(nombre, direccion, estadoCivil, fechaDeNacimiento, sueldoBasico);
		
		this.numeroDeContrato = numeroDeContrato;
		this.medioDePago 	  = medioDePago;
		
	}
	
	
	
	//Metodos
	
	@Override
	public double sueldoBruto() {
		// sueldo bruto para este empleado es igual a sueldo basico
		return this.getSueldoBasico();
	}

	@Override
	public double retenciones() {
		return this.gastosAdministrativosContractuales();
	}

	@Override
	public double aportesJubilatorios() {
		return 0;
	}

	@Override
	public double obraSocial() {
		return 0;
	}

	@Override
	public String infoRetenciones() {
		
		return "Gastos Administrativos Contractuales : " + this.gastosAdministrativosContractuales() + "\n" +
			   "TOTAL RETENCIONES : " 					 + this.retenciones();
	}

	@Override
	public String infoSueldoBruto() {
		
		return "TOTAL SUELDO BRUTO : " + this.sueldoBruto();
	}
	
	public double gastosAdministrativosContractuales() {
		return 50;
	}
	
	//Getters and Setters

}
