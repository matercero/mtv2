package es.eme3.model;

import lombok.Getter;
import lombok.Setter;

public class Mobiliario {
	
	@Getter	@Setter private int id;
	@Getter @Setter	private String alias;
	@Getter @Setter	private String direccion;
	@Getter @Setter	private String municipio;
	@Getter @Setter	private String provincia;
	@Getter @Setter	private String contadorLuz;
	@Getter @Setter	private String contadorAgua;

}
