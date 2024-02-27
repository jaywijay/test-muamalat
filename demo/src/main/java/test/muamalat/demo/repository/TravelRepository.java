// TravelRepository.java
package test.muamalat.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.muamalat.demo.model.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
    // You can add custom query methods if needed
}
