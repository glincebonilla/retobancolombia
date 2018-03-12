package com.gestor.excel;

public class DataRequest {
	private String nombres;
	private String apellidos;
	private String tipoducumento;
	private String numerodocumento;
	private String fechanacimiento;
	private String ingresos;
	private String ciudaddepartamento;

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTipoDcocumento() {
		return tipoducumento;
	}

	public void setTipoDocumento(String tipodocumento) {
		this.tipoducumento = tipodocumento;
	}

	public String getNumeroDocumento() {
		return numerodocumento;
	}

	public void setNumeroDocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public String getFechaNacimiento() {
		return fechanacimiento;
	}

	public void setFechaNacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getIngresos() {
		return ingresos;
	}

	public void setIngresos(String ingresos) {
		this.ingresos = ingresos;
	}

	public String getCiudadDepartamento() {
		return ciudaddepartamento;
	}

	public void setCiudadDepartamento(String ciudaddepartamento) {
		this.ciudaddepartamento = ciudaddepartamento;
	}

}
