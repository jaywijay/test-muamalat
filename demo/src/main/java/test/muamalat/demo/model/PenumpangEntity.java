package test.muamalat.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PenumpangEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPenumpang;

    private String nama;
    private String noTelp;
    private String alamat;
    public PenumpangEntity(Long idPenumpang, String nama, String noTelp, String alamat) {
        this.idPenumpang = idPenumpang;
        this.nama = nama;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }
    public PenumpangEntity() {
        //TODO Auto-generated constructor stub
    }
    public Long getIdPenumpang() {
        return idPenumpang;
    }
    public void setIdPenumpang(Long idPenumpang) {
        this.idPenumpang = idPenumpang;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
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

    // Constructors, getters, and setters
}