package vie.pi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vie.pi.service.IServiceEnregistrement;

@RestController
public class DeleteEnregsitrement {

	@Autowired
	private IServiceEnregistrement serviceEnregistrement;

	@DeleteMapping("/enregisrements/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if(serviceEnregistrement.remove(id))
			return new ResponseEntity<>("Enregsitrement deleted succefully.",HttpStatus.OK);
		else 
			return new ResponseEntity<>("Problem with deleting data.",HttpStatus.NOT_MODIFIED);


	}

}
