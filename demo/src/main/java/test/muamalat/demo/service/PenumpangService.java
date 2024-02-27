package test.muamalat.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import test.muamalat.demo.model.PenumpangEntity;
import test.muamalat.demo.repository.PenumpangRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PenumpangService {

    @Autowired
    private PenumpangRepository penumpangRepository;

    public ResponseEntity<List<PenumpangEntity>> getAllPenumpangs() {
        List<PenumpangEntity> penumpangs = penumpangRepository.findAll();
        return new ResponseEntity<>(penumpangs, HttpStatus.OK);
    }

    public ResponseEntity<PenumpangEntity> getPenumpangById(Long id) {
        Optional<PenumpangEntity> penumpangOptional = penumpangRepository.findById(id);
        return penumpangOptional.map(penumpang -> new ResponseEntity<>(penumpang, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<PenumpangEntity> createPenumpang(String nama, String noTelp, String alamat) {
        // Validasi input (contoh: nama, noTelp, dan alamat tidak boleh kosong)
        if (nama.isEmpty() || noTelp.isEmpty() || alamat.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PenumpangEntity penumpang = new PenumpangEntity();
        penumpang.setNama(nama);
        penumpang.setNoTelp(noTelp);
        penumpang.setAlamat(alamat);

        try {
            PenumpangEntity savedPenumpang = penumpangRepository.save(penumpang);
            return new ResponseEntity<>(savedPenumpang, HttpStatus.CREATED);
        } catch (Exception e) {
            // Penanganan error jika penyimpanan gagal
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Fungsi CRUD lainnya (update, delete) dapat ditambahkan sesuai kebutuhan
}
