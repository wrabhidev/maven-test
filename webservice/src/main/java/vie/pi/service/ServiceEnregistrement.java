package vie.pi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vie.pi.model.Enregistrement;

@Service
public class ServiceEnregistrement implements IServiceEnregistrement {

	@Autowired
	DataRepository dataRepository;

	/*
	 * 
	 * 
	 * @see vie.pi.service.IServiceEnregistrement#findAll()
	 */
	@Override
	public List<Enregistrement> findAll() {

		return dataRepository.findAll();
	}

	/*
	 * 
	 * 
	 * @see
	 * vie.pi.service.IServiceEnregistrement#add(vie.pi.model.Enregistrement)
	 */
	@Override
	public void add(Enregistrement enreg) {
		dataRepository.add(enreg);
	}

	/*
	 * 
	 * 
	 * @see
	 * vie.pi.service.IServiceEnregistrement#update(vie.pi.model.Enregistrement)
	 */
	@Override
	public void update(Enregistrement enreg) {

		Optional<Enregistrement> optEnreg = findById(enreg.getId());
		if (optEnreg.isPresent()) {
			dataRepository.remove(optEnreg.get().getId());

		}
		dataRepository.add(enreg);
	}

	/*
	 * 
	 * 
	 * @see
	 * vie.pi.service.IServiceEnregistrement#remove(vie.pi.model.Enregistrement)
	 */
	@Override
	public boolean remove(int id) {
		return dataRepository.remove(id);

	}

	/*
	 * 
	 * 
	 * @see vie.pi.service.IServiceEnregistrement#findById(int)
	 */
	@Override
	public Optional<Enregistrement> findById(int id) {
		return dataRepository.findById(id);
	}

}
