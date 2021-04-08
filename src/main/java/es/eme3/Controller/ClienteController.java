package es.eme3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	public static final String raiz = "cliente";

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String inicioCliente() {		
		return raiz+"/lista";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String crear() {		
		return raiz+"/form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@RequestParam("nombre") String nombre) {		
		return raiz+"/lista";
	}
	
	@RequestMapping(value = "/ver/{id}", method = RequestMethod.GET)
	public String ver(@RequestParam("id") int idCliente) {		
		return raiz+"/ver";
	}
	
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") int idCliente) {		
		return raiz+"/lista";
	}

}
