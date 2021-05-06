package es.and.eme3.h2.Controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.and.eme3.h2.entity.ReciboLuz;
import es.and.eme3.h2.service.IReciboLuzService;


@Controller
@RequestMapping("/reciboluz")
public class RecibosLuzController {

   public static final String raiz = "reciboluz";

   @Autowired
   private IReciboLuzService  service;

   /*
    * @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET) public String editar(@PathVariable("id") int idRecibos, Model
    * model) { }
    * @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET) public String eliminar(@PathVariable("id") int idRecibos, Model
    * model, RedirectAttributes redirectAttributes) { }
    */

   @RequestMapping(value = "/crear", method = RequestMethod.GET)
   public String crear(Map<String, ReciboLuz> model) {
      ReciboLuz recibos = new ReciboLuz();
      model.put("ReciboLuz", recibos);
      return raiz + "/form";
   }

   @PostMapping("/guardar")
   public String guardar(ReciboLuz recibos, Model model, RedirectAttributes redirectAttributes) {
      try {
         service.saveAndFlush(recibos);
         redirectAttributes.addFlashAttribute("message", "Operación realizada con éxito!");
      }
      catch (Exception e) {
         redirectAttributes.addFlashAttribute("error", "Error: No se ha dado de alta el cliente." + e.getMessage());
      }

      return "redirect:/reciboluz/index";

   }

   @RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
   public String inicio(@PathVariable("id") int idAlquiler, Model model, RedirectAttributes redirectAttributes) {
      Optional<ReciboLuz> lista = service.getByAlquiler(idAlquiler);
      if (!lista.isPresent()) {
         redirectAttributes.addFlashAttribute("message", "No hay recibos ");
         return "redirect:/reciboluz/form";
      }

      model.addAttribute("lista", lista);

      return raiz + "/lista";
   }

}
