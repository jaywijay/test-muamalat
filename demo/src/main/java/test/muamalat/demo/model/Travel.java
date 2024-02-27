package test.muamalat.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_travel")
    private Long idTravel;

    @NotBlank
    private String namaSupir;

    @NotBlank
    @Pattern(regexp = "\\d{12,13}", message = "Phone number must be 12 or 13 digits")
    private String noTelp;

    @NotBlank
    private String alamat;

    @NotBlank
    private String noPolisi;

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

}