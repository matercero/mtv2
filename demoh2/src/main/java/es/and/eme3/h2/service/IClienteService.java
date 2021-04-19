package es.and.eme3.h2.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import es.and.eme3.h2.entity.Cliente;

@Service
public interface IClienteService {

    List<Cliente> getAll();

    Cliente getById(int id);

    Cliente saveAndFlush(Cliente cliente);
    
    void deleteById(int idCliente);

    Page<Cliente>  getAllPage(PageRequest page);
}
