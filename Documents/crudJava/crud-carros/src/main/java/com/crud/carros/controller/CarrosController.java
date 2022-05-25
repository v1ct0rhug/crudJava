package com.crud.carros.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.carros.entity.Carros;
import com.crud.carros.repository.CarrosRepository;


@RestController
@CrossOrigin
public class CarrosController {
	
	@Autowired
	private CarrosRepository carrosRepository;

	@RequestMapping(value = "/carro", method = RequestMethod.GET)
	public List<Carros> buscarTodosCarros() {
		return this.carrosRepository.findAll();
	}
	
	@RequestMapping(value = "/carro/{id}", method = RequestMethod.GET)
	public ResponseEntity<Carros> GetById(@PathVariable(value = "id") Long id) {
		Optional<Carros> carros = carrosRepository.findById(id);
		if (carros.isPresent())
			return new ResponseEntity<Carros>(carros.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/carro", method = RequestMethod.POST)
	public Carros Post(@Valid @RequestBody Carros carros) {
		return carrosRepository.save(carros);
	}

	@RequestMapping(value = "/carro/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Carros> put(@PathVariable(value = "id") long id, @Valid @RequestBody Carros newCarro) {
		Optional<Carros> oldCarro = carrosRepository.findById(id);
		if (oldCarro.isPresent()) {
			Carros carros = oldCarro.get();
			carros.setNome(newCarro.getNome());
			carros.setAno_fabricacao(newCarro.getAno_fabricacao());
			carros.setCor(newCarro.getCor());
			carros.setStatus_carro(newCarro.getStatus_carro());
			carros.setMarca(newCarro.getMarca());
			carrosRepository.save(carros);
			return new ResponseEntity<Carros>(carros, HttpStatus.OK);
		} else
			return new ResponseEntity<Carros>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/carro/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable(value = "id") long id) {
		Optional<Carros> carros = carrosRepository.findById(id);
		if (carros.isPresent()) {
			carrosRepository.delete(carros.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
