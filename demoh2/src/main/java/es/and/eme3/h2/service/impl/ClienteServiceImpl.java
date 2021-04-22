package es.and.eme3.h2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import es.and.eme3.h2.entity.Cliente;
import es.and.eme3.h2.repository.ClienteRepository;
import es.and.eme3.h2.service.IClienteService;


@Service
public class ClienteServiceImpl implements IClienteService {

   @Autowired
   ClienteRepository clienteRepository;

   @Override
   public void deleteById(int idCliente) {
      clienteRepository.deleteById(idCliente);
   }

   @Override
   public List<Cliente> getAll() {
      return clienteRepository.findAll();
   }

   @Override
   public List<Cliente> getAllDesc() {
      return clienteRepository.findAll(Sort.by(Direction.DESC, "id"));
   }

   @Override
   public Page<Cliente> getAllPage(PageRequest page) {

      return clienteRepository.findAll(page);
   }

   @Override
   public Cliente getById(int id) {
      Optional<Cliente> c = clienteRepository.findById(id);
      if (c.isPresent()) {
         return c.get();
      }

      return null;
   }

   @Override
   public Cliente saveAndFlush(Cliente cliente) {
      Cliente resultado = clienteRepository.saveAndFlush(cliente);
      return resultado;
   }

}
