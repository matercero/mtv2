package es.and.eme3.h2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "alquiler")
public class Alquiler {

	@EmbeddedId
	private ClienteMobiliarioPK id;

	@ManyToOne
	@MapsId("idCliente") // This is the name of attr in ClienteMobiliarioPK class
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@ManyToOne
	@MapsId("idMobiliario")
	@JoinColumn(name = "id_mobiliario")
	private Mobiliario mobiliario;

	@Column(name = "fechaInicio")
	private Date fechaInicio;

	/*
	 * private Date fechaFin; private int luzInicio; private int luzFin; private int
	 * aguaInicio; private int aguaFin; private int precio; private String
	 * observaciones; private Clob contrato;
	 */

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

}
