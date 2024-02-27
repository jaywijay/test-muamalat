package test.muamalat.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Penumpang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_penumpang")
    private Long idPenumpang;

    @NotBlank
    private String nama;

    @NotBlank
    @Pattern(regexp = "\\d{12,13}", message = "Phone number must be 12 or 13 digits")
    private String noTelp;

    @NotBlank
    private String alamat;

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
}