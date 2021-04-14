package es.and.eme3.h2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.and.eme3.h2.entity.Cliente;

@Service
public interface IClienteService {
	
	List<Cliente> getAll();
	
	Cliente getById(int id);

}
