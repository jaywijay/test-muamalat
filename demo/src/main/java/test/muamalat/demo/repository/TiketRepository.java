package test.muamalat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.muamalat.demo.model.TiketEntity;

public interface TiketRepository extends JpaRepository<TiketEntity, Long> {
    // Jika diperlukan, tambahkan metode kustom di sini
}
