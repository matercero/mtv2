package es.eme3.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.eme3.model.Cliente;
import es.eme3.service.IClienteService;

@Controller
public class InicioController {
	
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("mensaje", "Bienvenido gestión de MTV");
		model.addAttribute("fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		
		return "inicio"; 
	}
	

}
 