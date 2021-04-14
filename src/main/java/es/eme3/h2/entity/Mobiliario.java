package es.eme3.h2.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Entity
@Table(name = "Mobiliario")
public class Mobiliario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String alias;
	private String direccion;
	private String municipio;
	private int codigoPostal;
	private String provincia;
	private int contadorLuz;
	private int contadorAgua;

	@OneToMany(mappedBy = "mobiliario")
	private Set<Alquiler> alquilerMobiliario = new HashSet<Alquiler>();

	public Mobiliario() {
		super();
	}

	public Mobiliario(int id, String alias, String direccion, String municipio, int codigoPostal, String provincia,
			int contadorLuz, int contadorAgua) {
		super();
		this.id = id;
		this.alias = alias;
		this.direccion = direccion;
		this.municipio = municipio;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.contadorLuz = contadorLuz;
		this.contadorAgua = contadorAgua;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mobiliario other = (Mobiliario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	

}
