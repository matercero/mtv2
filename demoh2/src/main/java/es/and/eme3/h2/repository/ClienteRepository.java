package es.and.eme3.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.and.eme3.h2.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}