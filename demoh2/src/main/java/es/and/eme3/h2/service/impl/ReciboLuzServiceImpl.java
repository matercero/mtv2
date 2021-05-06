package es.and.eme3.h2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.and.eme3.h2.entity.ReciboLuz;
import es.and.eme3.h2.repository.ReciboLuzRepository;
import es.and.eme3.h2.service.IReciboLuzService;


@Service
public class ReciboLuzServiceImpl implements IReciboLuzService {

   @Autowired
   ReciboLuzRepository repository;

   @Override
   public List<ReciboLuz> getAll() {
      return repository.findAll();
   }

   @Override
   public Optional<ReciboLuz> getByAlquiler(int alquiler) {
      return repository.findByAlquiler(alquiler);
   }

   @Override
   public ReciboLuz saveAndFlush(ReciboLuz recibo) {
      return repository.saveAndFlush(recibo);
   }
}
