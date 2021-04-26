package es.and.eme3.h2.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import antlr.StringUtils;
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



   @RequestMapping(value = "/downloadFile/{fileId}")
   public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId, HttpServletRequest request) {
      Alquiler a = alquilerService.getFile(fileId).get();
      
      String mimeType = request.getServletContext().getMimeType(a.getDocName());
     
      return ResponseEntity.ok()
    		  .contentType(MediaType.parseMediaType(mimeType))
    		  .header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName=" + a.getDocName())
    		  .body(new ByteArrayResource(a.getContrato()));
   }

   @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
   public String editar(@PathVariable("id") int idAlquiler, Model model) {
      Alquiler a = alquilerService.getById(idAlquiler);
      model.addAttribute("alquiler", a);
      return raiz + "/guardar";
   }

   @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
   public String eliminar(@PathVariable("id") int idAlquiler, Model model) {
      alquilerService.deleteById(idAlquiler);
      model.addAttribute("message", "Cliente eliminado con éxito !");
      model.addAttribute("listaAlquiler", alquilerService.getAll());
      return raiz + "/lista";
   }

   @PostMapping("/guardar")
   @ResponseBody
   public String guardar( Alquiler alquiler , BindingResult bindingResult,
		   @RequestParam("contrato") MultipartFile file, Model model) {
   
	   try {
		   
		      String docname = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename()); 
		
		   		alquiler.setDocName(docname);
		   		alquiler.setDocType(file.getContentType());
		   		alquiler.setContrato(file.getBytes());
		   		
		   		alquilerService.saveAndFlush(alquiler); 
		   		
		   		model.addAttribute("listaAlquiler", alquilerService.getAllDesc());
		   
			
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }


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
