package vie.pi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vie.pi.model.Enregistrement;
import vie.pi.service.IServiceEnregistrement;

@RestController

public class GetEnregistrement {

	@Autowired
	private IServiceEnregistrement serviceEnregistrement;

	@GetMapping("/enregistrements")
	public List<Enregistrement> findall() {
		return serviceEnregistrement.findAll();
	}

}
