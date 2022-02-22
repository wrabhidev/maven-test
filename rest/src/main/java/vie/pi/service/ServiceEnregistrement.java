package vie.pi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vie.pi.model.Enregistrement;
@Service

public class ServiceEnregistrement implements IServiceEnregistrement {

	public static List<Enregistrement> lesEnregsitrements = new ArrayList<Enregistrement>();

	static {

		lesEnregsitrements.add(new Enregistrement(1, "label 1", new Date()));
		lesEnregsitrements.add(new Enregistrement(2, "label 2", new Date()));
		lesEnregsitrements.add(new Enregistrement(3, "label 3", new Date()));
		lesEnregsitrements.add(new Enregistrement(4, "label 4", new Date()));
		lesEnregsitrements.add(new Enregistrement(5, "label 5", new Date()));

	}

	/*
	 * 
	 * 
	 * @see vie.pi.service.IServiceEnregistrement#findAll()
	 */
	@Override
	public List<Enregistrement> findAll() {

		return lesEnregsitrements;
	}

	/*
	 * 
	 * 
	 * @see
	 * vie.pi.service.IServiceEnregistrement#add(vie.pi.model.Enregistrement)
	 */
	@Override
	public void add(Enregistrement enreg) {
		lesEnregsitrements.add(enreg);
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
			lesEnregsitrements.remove(optEnreg.get());

		}
		lesEnregsitrements.add(enreg);
	}

	/*
	 * 
	 * 
	 * @see
	 * vie.pi.service.IServiceEnregistrement#remove(vie.pi.model.Enregistrement)
	 */
	@Override
	public boolean remove(int id) {
		Optional<Enregistrement> optEnreg = findById(id);
		if (optEnreg.isPresent()) {
			return lesEnregsitrements.remove(optEnreg.get());

		}
		return false;
	}

	/*
	 * 
	 * 
	 * @see vie.pi.service.IServiceEnregistrement#findById(int)
	 */
	@Override
	public Optional<Enregistrement> findById(int id) {
		Optional<Enregistrement> optEnreg = lesEnregsitrements.stream().filter(p -> p.getId() == id).findFirst();
		return optEnreg;
	}

}
