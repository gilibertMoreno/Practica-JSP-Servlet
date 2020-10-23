package co.edu.ufps.crud.model;
import java.io.Serializable;

import lombok.Data;

@Data
public class Automovil implements Serializable{
	
private Integer idautomovil;

private String placa;

private String color;

private String modelo;

private String propietario;

private Double valor;

public Automovil(int id, String placa, String color, String modelo, String propietario, Double valor) {
	this.idautomovil=id;
	this.placa = placa;
	this.color = color;
	this.modelo = modelo;
	this.propietario = propietario;
	this.valor = valor;
}



}
