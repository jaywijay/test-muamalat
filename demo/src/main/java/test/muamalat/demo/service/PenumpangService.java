package test.muamalat.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.muamalat.demo.model.Penumpang;
import test.muamalat.demo.repository.PenumpangRepository;

@Service
public class PenumpangService {
    
    @Autowired
    private PenumpangRepository penumpangRepository;

    public Penumpang getPenumpangById(Long id) {
        return penumpangRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public Penumpang createPenumpang(Penumpang penumpang) {
        return penumpangRepository.save(penumpang);
    }

    public Penumpang updatePenumpang(Long id, Penumpang updatedPenumpang) {
        Penumpang existingPenumpang = penumpangRepository.findById(id).orElse(null);

        if (existingPenumpang != null) {
            existingPenumpang.setNama(updatedPenumpang.getNama());
            existingPenumpang.setNoTelp(updatedPenumpang.getNoTelp());
            existingPenumpang.setAlamat(updatedPenumpang.getAlamat());
            return penumpangRepository.save(existingPenumpang);
        } else {
            return null; // Handle the case where the Penumpang with the given ID is not found
        }
    }

    public void deletePenumpang(Long id) {
        penumpangRepository.deleteById(id);
    }
}
