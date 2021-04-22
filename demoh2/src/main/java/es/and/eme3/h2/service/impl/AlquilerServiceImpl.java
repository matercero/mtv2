package es.and.eme3.h2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import es.and.eme3.h2.entity.Alquiler;
import es.and.eme3.h2.repository.AlquilerRepository;
import es.and.eme3.h2.service.IAlquilerService;


@Service
public class AlquilerServiceImpl implements IAlquilerService {

   @Autowired
   AlquilerRepository alquilerRepository;

   @Override
   public void deleteById(int id) {
      alquilerRepository.deleteById(id);
   }

   @Override
   public List<Alquiler> getAll() {
      return alquilerRepository.findAll();
   }

   @Override
   public List<Alquiler> getAllDesc() {
      return alquilerRepository.findAll(Sort.by(Direction.DESC, "id"));
   }

   @Override
   public Alquiler getById(int id) {
      Optional<Alquiler> a = alquilerRepository.findById(id);
      if (a.isPresent()) {
         return a.get();
      }

      return null;
   }

   @Override
   public Optional<Alquiler> getFile(Integer fileId) {
      return alquilerRepository.findById(fileId);
   }

   @Override
   public Alquiler saveAndFlush(Alquiler alquiler) {
      return alquilerRepository.saveAndFlush(alquiler);
   }

}
