package test.muamalat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.muamalat.demo.model.Penumpang;

@Repository
public interface PenumpangRepository extends JpaRepository<Penumpang, Long> {
    // Add custom queries if needed
}
