package es.eme3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MobiliarioController {
	
	@GetMapping("/mobiliario")
	public String inicioCliente() {		
		return "inicioMobiliario";
	}


}
