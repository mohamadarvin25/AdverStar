package apap.tugaskelompok.adverstar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sponsor")
public class SponsorModel extends UserModel {
    @NotNull
    @Column(name = "tahun_berdiri", nullable = false)
    private String tahunBerdiri;

    @NotNull
    @Column(name = "kategori", nullable = false)
    private String kategori;

    // Relasi ke Kontrak
     @OneToMany(mappedBy = "sponsor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     @PrimaryKeyJoinColumn
     @JsonIgnore
     private List<KontrakModel> listKontrak;

}
