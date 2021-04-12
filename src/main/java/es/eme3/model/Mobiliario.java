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
@Table(name="Mobiliario")
public class Mobiliario implements Serializable { 
	
	private static final long serialVersionUID = 8006239739454910177L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String alias;
	private String direccion;
	private String municipio;
	private String provincia;
	private String contadorLuz;
	private String contadorAgua;
}
