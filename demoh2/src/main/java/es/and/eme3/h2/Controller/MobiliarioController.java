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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

   @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
   public String editar(@PathVariable("id") int idMobiliario, Model model) {
      Mobiliario mobiliario = service.getById(idMobiliario);
      model.addAttribute("mobiliario", mobiliario);
      return raiz + "/form";
   }

   @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
   public String eliminar(@PathVariable("id") int idMobiliario, Model model, RedirectAttributes redirectAttributes) {
      service.deleteById(idMobiliario);
      List<Mobiliario> lista = service.getAll();
      redirectAttributes.addFlashAttribute("message", "Operación realizada con éxito!");
      model.addAttribute("listaMobiliario", lista);
      return "redirect:/mobiliario/index";
   }

   @PostMapping("/guardar")
   public String guardar(Mobiliario mobiliario, Model model, RedirectAttributes redirectAttributes) {
      try {
         service.saveAndFlush(mobiliario);
         redirectAttributes.addFlashAttribute("message", "Operación realizada con éxito!");
      }
      catch (Exception e) {
         redirectAttributes.addFlashAttribute("error", "Error: No se ha dado de alta el cliente." + e.getMessage());
      }

      List<Mobiliario> lista = service.getAll();
      model.addAttribute("listaMobiliario", lista);
      return "redirect:/mobiliario/index";
   }

   @RequestMapping(value = "/index", method = RequestMethod.GET)
   public String inicioMobiliario(Model model) {
      List<Mobiliario> lista = service.getAll();
      model.addAttribute("listaMobiliario", lista);
      return raiz + "/lista";
   }

}
