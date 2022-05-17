package crud.carros.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ModelsCarros.Carros;
import RepositorioCarros.CarrosRepositorios;

@RestController
public class CarroController {
	@Autowired
	private CarrosRepositorios _carrosRepositorios;

	@GetMapping("/carro")
	public String Get() {
		return "teste";
	}

	@RequestMapping(value = "/carro/{id}", method = RequestMethod.GET)
	public ResponseEntity<Carros> GetById(@PathVariable(value = "id") Long id) {
		Optional<Carros> carros = _carrosRepositorios.findById(id);
		if (carros.isPresent())
			return new ResponseEntity<Carros>(carros.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/carro", method = RequestMethod.POST)
	public Carros Post(@RequestBody Carros carros) {
		return _carrosRepositorios.save(carros);
	}

	@RequestMapping(value = "/carro/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Carros> Put(@PathVariable(value = "id") long id, @RequestBody Carros newCarro) {
		Optional<Carros> oldCarro = _carrosRepositorios.findById(id);
		if (oldCarro.isPresent()) {
			Carros carros = oldCarro.get();
			carros.setNome(newCarro.getNome());
			_carrosRepositorios.save(carros);
			return new ResponseEntity<Carros>(carros, HttpStatus.OK);
		} else
			return new ResponseEntity<Carros>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/carro/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
		Optional<Carros> carros = _carrosRepositorios.findById(id);
		if (carros.isPresent()) {
			_carrosRepositorios.delete(carros.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
