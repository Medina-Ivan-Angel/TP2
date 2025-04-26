package ar.edu.unq.poo2.tp2;

import java.time.LocalDateTime;

public class EmpleadoPlantaPermanente extends Empleado{

	//Atributos
	private int cantidadDeHijos;
	private int antiguedad;
	
	//Constructor
	public EmpleadoPlantaPermanente(int cantidadDeHijos, int antiguedad, String nombre,
									String direccion, String estadoCivil, LocalDateTime fechaDeNacimiento, 
									double sueldoBasico) {

		super(nombre, direccion, estadoCivil, fechaDeNacimiento, sueldoBasico); // Inicializamos las variables de empleado
		
		this.cantidadDeHijos = cantidadDeHijos;
		this.antiguedad 	 = antiguedad;
	
	}
	
	//Metodos
	
	@Override
	public double sueldoBruto() {
		
		return this.getSueldoBasico() + this.salarioFamiliar();
	}

	@Override
	public double retenciones() {
		
		return this.obraSocial() + this.retencionPorHijo() + this.aportesJubilatorios();
	}
	
	@Override
	public double aportesJubilatorios() {
		// 15% de su sueldo bruto
		return this.sueldoBruto() * 0.15;
	}
	
	@Override
	public double obraSocial() {
		// 10% de su sueldo bruto
		return this.sueldoBruto() * 0.10;
	}
	
	@Override
	public String infoRetenciones() {
		
		return "Obra social : " + this.obraSocial() + "\n" +
			   "Retencion Por Hijo : " + this.retencionPorHijo() + "\n" +
			   "Aportes Jubilatorios : " + this.aportesJubilatorios() + "\n" +
			   "TOTAL RETENCIONES : "  + this.retenciones();
			
			   
	}
	
	@Override
	public String infoSueldoBruto() {
		return "Sueldo Basico : " + this.getSueldoBasico() + "\n" +
			   "Salario Familiar : " + "\n" +
			   "++ Asignacion Por Hijo : " + this.asignacionPorHijo() + "\n" +
			   "++ Asignacion Por Conyuge : " + this.asignacionPorConyuge() + "\n" +
			   "++ Antiguedad : " + this.bonoPorAntiguedad() + "\n" +
			   "TOTAL SUELDO BRUTO : " + this.sueldoBruto(); 
				   
	}
	
	
	
	public double salarioFamiliar() {
		return this.asignacionPorHijo() + this.asignacionPorConyuge() + this.bonoPorAntiguedad();
	}
	
	public double asignacionPorHijo() {
		// + 150 por cada hijo
		return this.getCantidadDeHijos() * 150;
	}
	
	public double asignacionPorConyuge() {
		// + 100 si es casado
		if(this.getEstadoCivil() == "Casado") {
			return 100;
		}else {
			return 0;
		}
		
	}
	
	public double bonoPorAntiguedad() {
		// +50 por cada año de antiguedad
		return this.getAntiguedad() * 50;
	}
	

	public double retencionPorHijo() {
		return this.getCantidadDeHijos() * 20;
	}
	
	//Getters and Setters
	
	public int getCantidadDeHijos() {
		return this.cantidadDeHijos;
	}
	
	public int getAntiguedad() {
		return this.antiguedad;
	}
	
}
