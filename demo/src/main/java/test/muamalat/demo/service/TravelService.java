package test.muamalat.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import test.muamalat.demo.model.TravelEntity;
import test.muamalat.demo.repository.TravelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TravelService {

    @Autowired
    private TravelRepository travelRepository;

    public ResponseEntity<List<TravelEntity>> getAllTravels() {
        List<TravelEntity> travels = travelRepository.findAll();
        return new ResponseEntity<>(travels, HttpStatus.OK);
    }

    public ResponseEntity<TravelEntity> getTravelById(Long id) {
        Optional<TravelEntity> travelOptional = travelRepository.findById(id);
        return travelOptional.map(travel -> new ResponseEntity<>(travel, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<TravelEntity> createTravel(String namaSupir, String noTelp, String alamat, String noPolisi) {
        // Validasi input (contoh: tidak boleh ada field yang kosong)
        if (namaSupir.isEmpty() || noTelp.isEmpty() || alamat.isEmpty() || noPolisi.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        TravelEntity travel = new TravelEntity();
        travel.setNamaSupir(namaSupir);
        travel.setNoTelp(noTelp);
        travel.setAlamat(alamat);
        travel.setNoPolisi(noPolisi);

        try {
            TravelEntity savedTravel = travelRepository.save(travel);
            return new ResponseEntity<>(savedTravel, HttpStatus.CREATED);
        } catch (Exception e) {
            // Penanganan error jika penyimpanan gagal
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<TravelEntity> updateTravel(Long id, String namaSupir, String noTelp, String alamat, String noPolisi) {
        Optional<TravelEntity> travelOptional = travelRepository.findById(id);

        if (travelOptional.isPresent()) {
            TravelEntity travel = travelOptional.get();

            // Validasi input (contoh: tidak boleh ada field yang kosong)
            if (namaSupir.isEmpty() || noTelp.isEmpty() || alamat.isEmpty() || noPolisi.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            travel.setNamaSupir(namaSupir);
            travel.setNoTelp(noTelp);
            travel.setAlamat(alamat);
            travel.setNoPolisi(noPolisi);

            try {
                TravelEntity updatedTravel = travelRepository.save(travel);
                return new ResponseEntity<>(updatedTravel, HttpStatus.OK);
            } catch (Exception e) {
                // Penanganan error jika penyimpanan gagal
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> deleteTravel(Long id) {
        try {
            travelRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // Penanganan error jika penghapusan gagal
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
