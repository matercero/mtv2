package es.eme3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.eme3.h2.entity.Mobiliario;


@Service
public interface IMobiliarioService {
	
	List<Mobiliario> buscarTodas();

}
