package test.muamalat.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Tiket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_penumpang", nullable = false)
    private Penumpang penumpang;

    @ManyToOne
    @JoinColumn(name = "id_travel", nullable = false)
    private Travel travel;

    @Column(nullable = false)
    private LocalDateTime jadwal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Penumpang getPenumpang() {
        return penumpang;
    }

    public void setPenumpang(Penumpang penumpang) {
        this.penumpang = penumpang;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public LocalDateTime getJadwal() {
        return jadwal;
    }

    public void setJadwal(LocalDateTime jadwal) {
        this.jadwal = jadwal;
    }

    // Constructors, getters, and setters
}

