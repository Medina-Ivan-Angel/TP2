package ar.edu.unq.poo2.tp2;

import java.time.LocalDateTime;

public class EmpleadoPlantaTemporaria extends Empleado {

	// Atributos
	private LocalDateTime fechaFinDeDesignacion;
	private int cantidadDeHorasExtra;

	// Constructor
	public EmpleadoPlantaTemporaria(LocalDateTime fechaFinDeDesignacion, int cantidadDeHorasExtra, String nombre,
			String direccion, String estadoCivil, LocalDateTime fechaDeNacimiento, double sueldoBasico) {

		super(nombre, direccion, estadoCivil, fechaDeNacimiento, sueldoBasico); // Inicializamos las variables de
																				// empleado
		this.fechaFinDeDesignacion = fechaFinDeDesignacion;
		this.cantidadDeHorasExtra = cantidadDeHorasExtra;

	}

	// Metodos
	@Override
	public double sueldoBruto() {

		return this.getSueldoBasico() + (this.bonoHorasExtras());
	}

	@Override
	public double retenciones() {
		
		return this.obraSocial() + this.retencionMayorCincuentaAños() + this.aportesJubilatorios() + this.retencionPorHorasExtra();
	}
	
	@Override
	public double aportesJubilatorios() {
		// 10% del sueldo bruto + 5 por cada hora extra
		return this.sueldoBruto() * 0.10 + this.retencionPorHorasExtra();
	}
	
	@Override
	public double obraSocial() {
		// 10% del sueldo bruto
		return this.sueldoBruto() * 0.10;
	}
	
	@Override
	public String infoRetenciones() {
		
		return "Obra Social : "          + this.obraSocial() 				  + "\n" +
			   "Mayor a 50 años : "      + this.retencionMayorCincuentaAños() + "\n" +
			   "Aportes Jubilatorios : " + this.aportesJubilatorios() 		  + "\n" +
			   "Horas Extra : " 		 + this.retencionPorHorasExtra() 	  + "\n" +
			   "TOTAL RETENCIONES : " 	 + this.retenciones();
		
	}
	
	@Override
	public String infoSueldoBruto() {
		
		return "Sueldo Basico : "     + this.getSueldoBasico()         + "\n" +
			   "Horas Extras : "      + this.getCantidadDeHorasExtra() + "\n" +
			   "TOTAL SUELDO BRUTO :" + this.sueldoBruto();
		
	}
	
	public double bonoHorasExtras() {
		return this.getCantidadDeHorasExtra() * 40;
	}

	

	public double retencionMayorCincuentaAños() {
		// +25 si supera los 50 años
		if (this.calcularEdad() > 50) {
			return 25;
		} else {
			return 0;
		}
	}

	

	public double retencionPorHorasExtra() {
		// 5 por cada hora extra
		return this.getCantidadDeHorasExtra() * 5;
	}

	// Getters and Setters

	public LocalDateTime getFechaFinDeDesignacion() {
		return this.fechaFinDeDesignacion;
	}

	public int getCantidadDeHorasExtra() {
		return this.cantidadDeHorasExtra;
	}

}
