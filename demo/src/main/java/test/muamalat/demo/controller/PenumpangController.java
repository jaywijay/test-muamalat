package test.muamalat.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import test.muamalat.demo.model.Penumpang;
import test.muamalat.demo.service.PenumpangService;

@RestController
@RequestMapping("/api/penumpang")
public class PenumpangController {

    @Autowired
    private PenumpangService penumpangService;

    @GetMapping("/{id}")
    public ResponseEntity<Penumpang> getPenumpangById(@PathVariable Long id) {
        Penumpang penumpang = penumpangService.getPenumpangById(id);

        if (penumpang != null) {
            return new ResponseEntity<>(penumpang, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Penumpang> createPenumpang(@Valid @RequestBody Penumpang penumpang) {
        Penumpang createdPenumpang = penumpangService.createPenumpang(penumpang);
        return new ResponseEntity<>(createdPenumpang, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Penumpang> updatePenumpang(@PathVariable Long id, @Valid @RequestBody Penumpang updatedPenumpang) {
        Penumpang updatedEntity = penumpangService.updatePenumpang(id, updatedPenumpang);

        if (updatedEntity != null) {
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePenumpang(@PathVariable Long id) {
        penumpangService.deletePenumpang(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
