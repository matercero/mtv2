package es.eme3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eme3.h2.entity.Mobiliario;

public interface MobiliarioRepository  extends JpaRepository<Mobiliario, Integer> {

}
