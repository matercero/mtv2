package es.eme3.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.eme3.model.Cliente;
import es.eme3.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	private List<Cliente> lista = null; 
	
	public ClienteServiceImpl() {
		Cliente cli1 = Cliente.builder().id(0).nombre("pepe").apellidos("lopez gomez").direccion("calle sierpes, 1")
				.build();
		Cliente cli2 = Cliente.builder().id(1).nombre("Luis").apellidos("garcia pavon")
				.direccion("Avda de la constitucion, 10").build();
		
		lista = new ArrayList<Cliente>();
		lista.add(cli1);
		lista.add(cli2);
	}
	
	@Override
	public List<Cliente> buscarTodas() {
		return lista;
	}

	@Override
	public Cliente buscarPorId(int id) {
		for (Cliente c : lista) {
			if (c.getId()==id) 
					return c;
		}
		return null;
	}

}
