package vie.pi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vie.pi.model.Enregistrement;

@Service
public interface IServiceEnregistrement {

	List<Enregistrement> findAll();

	Optional<Enregistrement> findById(int id);

	boolean remove(int id);

	void update(Enregistrement enreg);

	void add(Enregistrement enreg);

}
