package es.and.eme3.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.and.eme3.h2.entity.Alquiler;


@Service
public interface IAlquilerService {

   void deleteById(int id);

   List<Alquiler> getAll();

   List<Alquiler> getAllDesc();

   Alquiler getById(int id);

   Optional<Alquiler> getFile(Integer fileId);

   Alquiler saveAndFlush(Alquiler alquiler);

}
