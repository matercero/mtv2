package es.and.eme3.h2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.and.eme3.h2.entity.Alquiler;
import es.and.eme3.h2.service.impl.AlquilerServiceImpl;
import es.and.eme3.h2.service.impl.ClienteServiceImpl;
import es.and.eme3.h2.service.impl.MobiliarioServiceImpl;


@Controller
@RequestMapping("/alquiler")
public class AlquilerController {

   public static final String raiz = "alquiler";

   @Autowired
   ClienteServiceImpl         clienteService;

   @Autowired
   MobiliarioServiceImpl      mobiliarioService;

   @Autowired
   AlquilerServiceImpl        alquilerService;

   @RequestMapping(value = "/crear", method = RequestMethod.GET)
   public String crear(Model model) {
      Alquiler a = new Alquiler();
      model.addAttribute("alquiler", a);
      model.addAttribute("listaCliente", clienteService.getAllDesc());
      model.addAttribute("listaMobi", mobiliarioService.getAll());
      return raiz + "/guardar";
   }

   /*
    * @GetMapping("/downloadFile/{fileId}") public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId) { Doc doc =
    * docStorageService.getFile(fileId).get(); return
    * ResponseEntity.ok().contentType(MediaType.parseMediaType(doc.getDocType())).header(HttpHeaders.CONTENT_DISPOSITION,
    * "attachment:filename=\"" + doc.getDocName() + "\"").body(new ByteArrayResource(doc.getData())); }
    */

   @RequestMapping(value = "/downloadFile/{fileId}")
   public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId) {
      Alquiler a = alquilerService.getFile(fileId).get();
      return ResponseEntity.ok().contentType(MediaType.parseMediaType(a.getDocType())).header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\""
            + a.getDocName() + "\"").body(new ByteArrayResource(a.getContrato()));
   }

   @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
   public String editar(@PathVariable("id") int idAlquiler, Model model) {
      Alquiler a = alquilerService.getById(idAlquiler);
      model.addAttribute("alquiler", a);
      return raiz + "/form";
   }

   @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
   public String eliminar(@PathVariable("id") int idAlquiler, Model model) {
      alquilerService.deleteById(idAlquiler);
      model.addAttribute("message", "Cliente eliminado con éxito !");
      model.addAttribute("listaAlquiler", alquilerService.getAll());
      return raiz + "/lista";
   }

   @PostMapping("/guardar")
   public String guardar(Alquiler alquiler, Model model) {

      alquilerService.saveAndFlush(alquiler);

      model.addAttribute("listaAlquiler", alquilerService.getAll());

      return raiz + "/index";
   }

   @RequestMapping(value = "/index", method = RequestMethod.GET)
   public String inicio(Model model) {
      model.addAttribute("listaAlquiler", alquilerService.getAllDesc());
      model.addAttribute("listaCliente", clienteService.getAllDesc());
      model.addAttribute("listaMobi", mobiliarioService.getAll());
      return raiz + "/index";
   }

}
