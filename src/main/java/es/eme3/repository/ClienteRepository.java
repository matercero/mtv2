package es.eme3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eme3.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
