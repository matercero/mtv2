package es.eme3.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.eme3.model.Cliente;
import es.eme3.service.IClienteService;
import es.eme3.service.impl.ClienteServiceImpl;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	public static final String raiz = "cliente";
	
	@Autowired
	private IClienteService service; 

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String inicioCliente(Model model) {				
		List<Cliente> lista = service.buscarTodas();		
		model.addAttribute("listaCliente", lista );
		return raiz+"/lista";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String crear() {		
		return raiz+"/form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(@RequestParam("nombre") String nombre) {		
		return raiz+"/lista";
	}
	
	@RequestMapping(value = "/ver/{id}", method = RequestMethod.GET)
	public String ver(@PathVariable("id") int idCliente, Model model) {		
		Cliente cliente = service.buscarPorId(idCliente);
		model.addAttribute("cliente", cliente );
		return raiz+"/ver";
	}
	
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") int idCliente) {		
		return raiz+"/lista";
	}

}
