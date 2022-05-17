package RepositorioCarros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ModelsCarros.*;

@Repository
public interface CarrosRepositorios extends JpaRepository<Carros, Long> { }




