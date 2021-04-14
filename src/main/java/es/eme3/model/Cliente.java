package es.eme3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

 @Builder
 @ToString
 @Data
 @Entity
 @Table(name="Cliente")
public  class Cliente implements Serializable { 
	
	private static final long serialVersionUID = 3799683323716751105L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String municipio;	
	private String provincia;
	private int codigoPostal;
	private int telefono;
	private String email;
	private String observaciones;
	
	

}
