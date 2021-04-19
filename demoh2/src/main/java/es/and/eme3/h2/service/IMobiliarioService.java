package es.and.eme3.h2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.and.eme3.h2.entity.Mobiliario;

@Service
public interface IMobiliarioService {


    List<Mobiliario> getAll();

    Mobiliario getById(int id);

    Mobiliario saveAndFlush(Mobiliario mobiliario);
    
    void deleteById(int idMobiliario);
}
