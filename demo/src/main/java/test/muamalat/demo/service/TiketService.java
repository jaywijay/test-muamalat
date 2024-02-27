package test.muamalat.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import test.muamalat.demo.model.PenumpangEntity;
import test.muamalat.demo.model.TiketEntity;
import test.muamalat.demo.model.TravelEntity;
import test.muamalat.demo.repository.PenumpangRepository;
import test.muamalat.demo.repository.TiketRepository;
import test.muamalat.demo.repository.TravelRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TiketService {

    @Autowired
    private TiketRepository tiketRepository;

    @Autowired
    private PenumpangRepository penumpangRepository;

    @Autowired
    private TravelRepository travelRepository;

    public ResponseEntity<List<TiketEntity>> getAllTikets() {
        List<TiketEntity> tikets = tiketRepository.findAll();
        return new ResponseEntity<>(tikets, HttpStatus.OK);
    }

    public ResponseEntity<TiketEntity> getTiketById(Long id) {
        Optional<TiketEntity> tiketOptional = tiketRepository.findById(id);
        return tiketOptional.map(tiket -> new ResponseEntity<>(tiket, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<TiketEntity> createTiket(Long idPenumpang, Long idTravel, Date jadwal) {
        // Validasi input (contoh: idPenumpang dan idTravel harus valid, jadwal tidak boleh null)
        if (idPenumpang == null || idTravel == null || jadwal == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PenumpangEntity penumpang = penumpangRepository.findById(idPenumpang)
                .orElseGet(() -> new PenumpangEntity());  // Anda dapat menyesuaikan tindakan jika idPenumpang tidak valid

        TravelEntity travel = travelRepository.findById(idTravel)
                .orElseGet(() -> new TravelEntity());  // Anda dapat menyesuaikan tindakan jika idTravel tidak valid

        TiketEntity tiket = new TiketEntity();
        tiket.setPenumpang(penumpang);
        tiket.setTravel(travel);
        tiket.setJadwal(jadwal);

        try {
            TiketEntity savedTiket = tiketRepository.save(tiket);
            return new ResponseEntity<>(savedTiket, HttpStatus.CREATED);
        } catch (Exception e) {
            // Penanganan error jika penyimpanan gagal
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Fungsi CRUD lainnya (update, delete) dapat ditambahkan sesuai kebutuhan
}
