package es.eme3.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("mensaje", "Bienvenido gestión de MTV");
		model.addAttribute("fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

		return "inicio";
	}



}
