package vie.pi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vie.pi.model.Enregistrement;
import vie.pi.service.IServiceEnregistrement;

@RestController
@RequestMapping("/api")
public class Controleurs {

	@Autowired
	private IServiceEnregistrement serviceEnregistrement;

	@GetMapping("/enregistrements")
	public List<Enregistrement> findall() {
		return serviceEnregistrement.findAll();
	}

	@PostMapping("/enregisrements")
	public ResponseEntity<String> add(@RequestBody Enregistrement enreg) {
		serviceEnregistrement.add(enreg);
		return new ResponseEntity("Enregsitrement " + enreg.getLabel() + " added.", HttpStatus.CREATED);

	}

	@PutMapping("/enregisrements")
	public void updateLigne(@RequestBody Enregistrement enreg) {
		serviceEnregistrement.update(enreg);

	}

	@DeleteMapping("/enregisrements/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if (serviceEnregistrement.remove(id))
			return new ResponseEntity("Enregsitrement deleted succefully.", HttpStatus.OK);
		else
			return new ResponseEntity("Problem with deleting data.", HttpStatus.NOT_MODIFIED);

	}

}
