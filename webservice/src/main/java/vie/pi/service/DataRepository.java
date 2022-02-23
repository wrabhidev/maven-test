package vie.pi.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import vie.pi.model.Enregistrement;

@Service
public class DataRepository {
    
    private  List<Enregistrement> lesEnregsitrements ; 
    // initilize data 
    public DataRepository() {
        
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Enregistrement>> typeReference = new TypeReference<List<Enregistrement>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/fichier.json");
            try {
                lesEnregsitrements  = mapper.readValue(inputStream,typeReference) ;
            } catch (IOException e){
                System.out.println("Unable to read data file: " + e.getMessage());
            }

        
        }
    
    
    public List<Enregistrement> findAll() {
        return lesEnregsitrements;
    }
    
    public boolean add(Enregistrement dto) {
        return lesEnregsitrements.add(dto);
    }
    
	public void update(Enregistrement enreg) {

		Optional<Enregistrement> optEnreg = findById(enreg.getId());
		if (optEnreg.isPresent()) {
			lesEnregsitrements.remove(optEnreg.get());

		}
		lesEnregsitrements.add(enreg);
	}

	
	public boolean remove(int id) {
		Optional<Enregistrement> optEnreg = findById(id);
		if (optEnreg.isPresent()) {
			return lesEnregsitrements.remove(optEnreg.get());

		}
		return false;
	}

	
	public Optional<Enregistrement> findById(final int id) {
		Optional<Enregistrement> optEnreg = lesEnregsitrements.stream().filter(p -> p.getId() == id).findFirst();
		return optEnreg;
	}
    


}
