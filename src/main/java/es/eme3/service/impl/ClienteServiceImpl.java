package es.eme3.service.impl;

import java.util.List;

import es.eme3.model.Cliente;
import es.eme3.service.IClienteService;


public class ClienteServiceImpl implements IClienteService {
	
	private List<Cliente> lista = null; 
	
	@Override
	public List<Cliente> buscarTodas() {	
		return lista;
	}

}
