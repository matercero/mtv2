package es.eme3.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import es.eme3.h2.entity.Cliente;
import es.eme3.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	private List<Cliente> lista = null; 
	
	public ClienteServiceImpl() {	
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
