package ar.edu.unq.poo2.tp2;

import java.time.LocalDateTime;
import java.time.Period;

public abstract class Empleado {
	
	//Atributos
	private String nombre;
	private String direccion;
	private String estadoCivil;
	private LocalDateTime fechaDeNacimiento;
	private double sueldoBasico;
	
	//Constructor
	public Empleado(String nombre, String direccion, String estadoCivil, LocalDateTime fechaDeNacimiento, double sueldoBasico) {
		
		this.nombre 			= nombre;
		this.direccion 			= direccion;
		this.estadoCivil 		= estadoCivil;
		this.fechaDeNacimiento  = fechaDeNacimiento;
		this.sueldoBasico 		= sueldoBasico;
	}
	
	
	//Metodos
	
	public int calcularEdad() {
		
		// Obtenemos la cantidad de años entre la fecha de nacimiento
		// y el dia de hoy. Retornamos ese valor.
		Period periodo = Period.between(getFechaDeNacimiento().toLocalDate(), LocalDateTime.now().toLocalDate());
        int años = periodo.getYears();
		
		
		return años;
		
	}
	
	public double sueldoNeto() {
		
		return this.sueldoBruto() - this.retenciones();
		
	}
	
	public abstract double sueldoBruto();
	public abstract double retenciones();
	public abstract double aportesJubilatorios();
	public abstract double obraSocial();
	public abstract String infoRetenciones();
	public abstract String infoSueldoBruto();
	
	
	
	//Getters and Setters
	
	public LocalDateTime getFechaDeNacimiento() {
		return this.fechaDeNacimiento;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public String getEstadoCivil() {
		return this.estadoCivil;
	}
	
	public double getSueldoBasico() {
		return this.sueldoBasico;
	}


	public String getNombre() {
		
		return this.nombre;
	}


	
	

}
