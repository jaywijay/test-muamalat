package test.muamalat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.muamalat.demo.model.TravelEntity;

public interface TravelRepository extends JpaRepository<TravelEntity, Long> {
    // Jika diperlukan, tambahkan metode kustom di sini
}
