package es.and.eme3.h2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.and.eme3.h2.entity.Mobiliario;
import es.and.eme3.h2.repository.MobiliarioRepository;
import es.and.eme3.h2.service.IMobiliarioService;

@Service
public class MobiliarioServiceImpl implements IMobiliarioService {
	
	@Autowired
	MobiliarioRepository repository;

	@Override
	public List<Mobiliario> getAll() {
		List<Mobiliario> lista= repository.findAll();
		return lista;
	}

	@Override
	public Mobiliario getById(int id) {
		Optional<Mobiliario>  m= repository.findById(id);
		if (m.isPresent()) {
		    return m.get();
		}

	return null;
	}

	@Override
	public Mobiliario saveAndFlush(Mobiliario mobiliario) {
		Mobiliario resultado = repository.saveAndFlush(mobiliario);
		return resultado;
	}

	@Override
	public void deleteById(int idMobiliario) {
		repository.deleteById(idMobiliario);
	}

}
