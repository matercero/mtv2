package es.and.eme3.h2.entity.composite;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CompositeAlquilerId  implements Serializable {

	
	private static final long serialVersionUID = -422928737418211130L;
	
	private Integer idCliente;
	private Integer idMobiliario;
	
	public CompositeAlquilerId(Integer idCliente, Integer idMobiliario) {
		super();
		this.idCliente = idCliente;
		this.idMobiliario = idMobiliario;
	}
	
	public CompositeAlquilerId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
