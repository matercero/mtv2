package es.and.eme3.h2.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.and.eme3.h2.entity.Mobiliario;
import es.and.eme3.h2.service.IMobiliarioService;

@Controller
@RequestMapping("/mobiliario")
public class MobiliarioController {
	

    public static final String raiz = "mobiliario";

    @Autowired
    private IMobiliarioService service;

    @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public String crear(Map<String, Mobiliario> model) {
	Mobiliario mobiliario = new Mobiliario();
	model.put("mobiliario", mobiliario);
	return raiz + "/form";
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
    public String eliminar(@PathVariable("id") int idMobiliario, Model model) {
    	service.deleteById(idMobiliario);
    	List<Mobiliario> lista = service.getAll();
    	model.addAttribute("message", "Mobiliario eliminado con éxito !");
    	model.addAttribute("listaMobiliario", lista);
    	return raiz + "/lista";
    }

    @PostMapping("/guardar")
    public String guardar(Mobiliario mobiliario, Model model) {
	service.saveAndFlush(mobiliario);
	List<Mobiliario> lista = service.getAll();
	model.addAttribute("message", "Operación realizada con éxito!");
	model.addAttribute("listaMobiliario", lista);
	return raiz + "/lista";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String inicioMobiliario(Model model) {
	List<Mobiliario> lista = service.getAll();
	model.addAttribute("listaMobiliario", lista);
	return raiz + "/lista";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable("id") int idMobiliario, Model model) {
	Mobiliario mobiliario = service.getById(idMobiliario);
	model.addAttribute("mobiliario", mobiliario);
	return raiz + "/form";
    }

}
