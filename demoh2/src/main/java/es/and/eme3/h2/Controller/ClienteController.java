package es.and.eme3.h2.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.and.eme3.h2.entity.Cliente;
import es.and.eme3.h2.service.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    public static final String raiz = "cliente";

    @Autowired
    private IClienteService service;

    @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public String crear(Map<String, Cliente> model) {
	Cliente cliente = new Cliente();
	model.put("cliente", cliente);
	return raiz + "/form";
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
    public String eliminar(@PathVariable("id") int idCliente, Model model) {
    	service.deleteById(idCliente);
    	List<Cliente> lista = service.getAll();
    	model.addAttribute("message", "Cliente eliminado con éxito !");
    	model.addAttribute("listaCliente", lista);
    	return raiz + "/lista";
    }

    @PostMapping("/guardar")
    public String guardar(Cliente cliente, Model model) {
	service.saveAndFlush(cliente);
	List<Cliente> lista = service.getAll();
	model.addAttribute("message", "Operación realizada con éxito!");
	model.addAttribute("listaCliente", lista);
	return raiz + "/lista";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String inicioCliente(Model model) {
	List<Cliente> lista = service.getAll();
	model.addAttribute("listaCliente", lista);
	return raiz + "/lista";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable("id") int idCliente, Model model) {
	Cliente cliente = service.getById(idCliente);
	model.addAttribute("cliente", cliente);
	return raiz + "/form";
    }
    
    @GetMapping(value ="/page")
	public String findAll(@RequestParam Map<String, Object> params, Model model) {
		int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
		
		PageRequest pageRequest = PageRequest.of(page, 5);
		
		Page<Cliente> pagePersona = service.getAllPage(pageRequest);
		
		int totalPage = pagePersona.getTotalPages();
		if(totalPage > 0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}
		
		model.addAttribute("listaCliente", pagePersona.getContent());
		model.addAttribute("current", page + 1);
		model.addAttribute("next", page + 2);
		model.addAttribute("prev", page);
		model.addAttribute("last", totalPage);
		return raiz + "/lista2";
	}

}
