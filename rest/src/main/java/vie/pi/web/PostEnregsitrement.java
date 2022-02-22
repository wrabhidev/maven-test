package vie.pi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vie.pi.model.Enregistrement;
import vie.pi.service.IServiceEnregistrement;

@RestController
public class PostEnregsitrement {

	@Autowired
	private IServiceEnregistrement serviceEnregistrement;

	@PostMapping("/enregisrements")
	public ResponseEntity<String> add(@RequestBody Enregistrement enreg) {
		serviceEnregistrement.add(enreg);
		return new ResponseEntity<>("Enregsitrement "+enreg.getLabel()+" added.",HttpStatus.CREATED);

	}
	
/*	
	@PostMapping("/enregisrements/add")
	public ResponseEntity<String> add(@RequestBody Enregistrement enreg) {
		serviceEnregistrement.add(enreg);
		return new ResponseEntity<>("Enregsitrement "+enreg.getLabel()+" added.",HttpStatus.CREATED);

	}

*/

}
