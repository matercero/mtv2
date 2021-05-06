package es.and.eme3.h2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.and.eme3.h2.entity.ReciboLuz;


public interface ReciboLuzRepository extends JpaRepository<ReciboLuz, Integer> {

   Optional<ReciboLuz> findByAlquiler(int alquiler);
}
