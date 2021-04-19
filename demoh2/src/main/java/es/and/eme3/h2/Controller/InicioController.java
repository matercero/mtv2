package es.and.eme3.h2.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/")
    public String inicio(Model model) {
	model.addAttribute("mensaje", "Bienvenido: Gestión de alquiler MTV");
	model.addAttribute("fecha", "Hoy es " + new SimpleDateFormat("EEEE, dd/MM/yyyy").format(new Date()));

	return "inicio";
    }
    
    @GetMapping("/login")
    public String login(Model model) {
	model.addAttribute("mensaje", "Bienvenido: Gestión de alquiler MTV");
	model.addAttribute("fecha", "Hoy es " + new SimpleDateFormat("EEEE, dd/MM/yyyy").format(new Date()));

	return "inicio";
    }
    
    

}
