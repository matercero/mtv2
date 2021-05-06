package es.and.eme3.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.and.eme3.h2.entity.ReciboLuz;


@Service
public interface IReciboLuzService {

   List<ReciboLuz> getAll();

   Optional<ReciboLuz> getByAlquiler(int idAquiler);

   ReciboLuz saveAndFlush(ReciboLuz recibo);

}
