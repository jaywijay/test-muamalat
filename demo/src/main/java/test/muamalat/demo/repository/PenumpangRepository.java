package test.muamalat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.muamalat.demo.model.PenumpangEntity;

public interface PenumpangRepository extends JpaRepository<PenumpangEntity, Long> {
    // Jika diperlukan, tambahkan metode kustom di sini
}
