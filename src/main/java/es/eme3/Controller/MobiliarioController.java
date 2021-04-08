package es.eme3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mobiliario")
public class MobiliarioController {
	
	public static final String raiz = "mobiliario";
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String inicioMobiliario() {		
		return raiz+"/lista";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String crear() {		
		return raiz+"/form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar() {		
		return raiz+"/lista";
	}
	
	@RequestMapping(value = "/ver/{id}", method = RequestMethod.GET)
	public String ver(@RequestParam("id")int idMobiliario) {		
		return raiz+"/ver";
	}
	
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") int idMobiliario) {		
		return raiz+"/lista";
	}


}
