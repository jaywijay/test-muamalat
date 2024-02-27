package test.muamalat.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class TiketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_penumpang", nullable = false)
    private PenumpangEntity penumpang;

    @ManyToOne
    @JoinColumn(name = "id_travel", nullable = false)
    private TravelEntity travel;

    @Temporal(TemporalType.TIMESTAMP)
    private Date jadwal;

    public TiketEntity(Long id, PenumpangEntity penumpang, TravelEntity travel, Date jadwal) {
        this.id = id;
        this.penumpang = penumpang;
        this.travel = travel;
        this.jadwal = jadwal;
    }

    public TiketEntity() {
        //TODO Auto-generated constructor stub
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PenumpangEntity getPenumpang() {
        return penumpang;
    }

    public void setPenumpang(PenumpangEntity penumpang) {
        this.penumpang = penumpang;
    }

    public TravelEntity getTravel() {
        return travel;
    }

    public void setTravel(TravelEntity travel) {
        this.travel = travel;
    }

    public Date getJadwal() {
        return jadwal;
    }

    public void setJadwal(Date jadwal) {
        this.jadwal = jadwal;
    }

    // Constructors, getters, and setters
}
