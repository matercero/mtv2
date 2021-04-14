package es.and.eme3.h2.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getContadorLuz() {
		return contadorLuz;
	}

	public void setContadorLuz(int contadorLuz) {
		this.contadorLuz = contadorLuz;
	}

	public int getContadorAgua() {
		return contadorAgua;
	}

	public void setContadorAgua(int contadorAgua) {
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

	@Override
	public String toString() {
		return "Mobiliario [id=" + id + ", alias=" + alias + ", direccion=" + direccion + ", municipio=" + municipio
				+ ", codigoPostal=" + codigoPostal + ", provincia=" + provincia + ", contadorLuz=" + contadorLuz
				+ ", contadorAgua=" + contadorAgua + "]";
	}

}
