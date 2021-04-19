package es.and.eme3.h2.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClienteMobiliarioPK implements Serializable {

	private static final long serialVersionUID = 4086504573649277038L;

	@Column(name = "id_cliente")
	private int idCliente;

	@Column(name = "id_mobiliario")
	private int idMobiliario;
	

}
