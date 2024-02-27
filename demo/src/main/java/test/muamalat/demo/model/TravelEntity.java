package test.muamalat.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class TravelEntity {

    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTravel;

    private String namaSupir;
    private String noTelp;
    private String alamat;
    private String noPolisi;
    public TravelEntity() {
        this.idTravel = idTravel;
        this.namaSupir = namaSupir;
        this.noTelp = noTelp;
        this.alamat = alamat;
        this.noPolisi = noPolisi;
    }
    public Long getIdTravel() {
        return idTravel;
    }
    public void setIdTravel(Long idTravel) {
        this.idTravel = idTravel;
    }
    public String getNamaSupir() {
        return namaSupir;
    }
    public void setNamaSupir(String namaSupir) {
        this.namaSupir = namaSupir;
    }
    public String getNoTelp() {
        return noTelp;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getNoPolisi() {
        return noPolisi;
    }
    public void setNoPolisi(String noPolisi) {
        this.noPolisi = noPolisi;
    }

    // Constructors, getters, and setters
}
