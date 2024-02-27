// TravelService.java
package test.muamalat.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.muamalat.demo.model.Travel;
import test.muamalat.demo.repository.TravelRepository;

import java.util.List;

@Service
public class TravelService {

    @Autowired
    private TravelRepository travelRepository;

    public List<Travel> getAllTravel() {
        return travelRepository.findAll();
    }

    public Travel getTravelById(Long id) {
        return travelRepository.findById(id).orElse(null);
    }

    public Travel createTravel(Travel travel) {
        return travelRepository.save(travel);
    }

    public Travel updateTravel(Long id, Travel updatedTravel) {
        Travel existingTravel = travelRepository.findById(id).orElse(null);

        if (existingTravel != null) {
            existingTravel.setNamaSupir(updatedTravel.getNamaSupir());
            existingTravel.setNoTelp(updatedTravel.getNoTelp());
            existingTravel.setAlamat(updatedTravel.getAlamat());
            existingTravel.setNoPolisi(updatedTravel.getNoPolisi());

            return travelRepository.save(existingTravel);
        } else {
            return null; // Handle the case where the Travel with the given ID is not found
        }
    }

    public void deleteTravel(Long id) {
        travelRepository.deleteById(id);
    }

    public TravelRepository getTravelRepository() {
        return travelRepository;
    }

    public void setTravelRepository(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }
}
