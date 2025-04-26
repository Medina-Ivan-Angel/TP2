package ar.edu.unq.poo2.tp2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	//Atributos
	private List<Empleado> empleados = new ArrayList<Empleado>();
	private List<ReciboDeHaberes> recibos = new ArrayList<ReciboDeHaberes>();
	
	private String nombre;
	private String cuit;
	
	//Constructor
	public Empresa(String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit   = cuit;
	}
	
	//Metodos
	
	public void addEmpleado(Empleado nuevoEmpleado) {
		this.empleados.add(nuevoEmpleado);
	}
	
	public void addRecibo(ReciboDeHaberes nuevoRecibo) {
		this.recibos.add(nuevoRecibo);
	}
	
	public void liquidacionDeSueldos() {
		
		this.getEmpleados().stream().forEach(e -> this.addRecibo(new ReciboDeHaberes(e, LocalDateTime.now())));
		
	}
	
	public void resumenLiquidacionDeSueldos() {
		//Recorre todos los recibos y devuelve sus respectivos desgloces
		this.recibos.stream().forEach(r -> System.out.println(r.getDesgloce()) );
		
	}
	
	public double totalSueldosNetos() {
		return this.empleados.stream().mapToDouble(e -> e.sueldoNeto()).sum();
	}
	
	public double totalSueldosBrutos() {
		return this.empleados.stream().mapToDouble(e -> e.sueldoBruto()).sum();
	}
	
	public double totalRetenciones() {
		return this.empleados.stream().mapToDouble(e -> e.retenciones()).sum();
	}
	
	//Getters and Setters
	public List<Empleado> getEmpleados(){
		return this.empleados;
	}
	
	public List<ReciboDeHaberes> getRecibos(){
		return this.recibos;
	}

}
