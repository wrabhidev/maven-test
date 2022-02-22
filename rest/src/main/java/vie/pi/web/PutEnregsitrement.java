package vie.pi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vie.pi.model.Enregistrement;
import vie.pi.service.IServiceEnregistrement;

@RestController

public class PutEnregsitrement {
	
	@Autowired
	private IServiceEnregistrement serviceEnregistrement;
	

	@PutMapping("/enregisrements")
	public void updateLigne(@RequestBody Enregistrement enreg) {
		serviceEnregistrement.update(enreg);
	
	}
	


}
