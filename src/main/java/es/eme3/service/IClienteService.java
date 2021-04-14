package es.eme3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.eme3.h2.entity.Cliente;

@Service
public interface IClienteService {
	
	List<Cliente> buscarTodas();
	
	Cliente buscarPorId(int id);

}
