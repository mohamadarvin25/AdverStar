package apap.tugaskelompok.adverstar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "idol")
public class IdolModel {
    @Id
    @Column(name = "id_idol", nullable = false, unique = true)
    private Integer idIdol;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "kategori", nullable = false)
    private Character kategori;

    // Relasi dengan sublabel
    @ManyToOne
    @JoinColumn(name = "id_sublabel")
    private SublabelModel sublabel;

    // Relasi dengan kontrak
    @OneToMany(mappedBy = "idol", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<KontrakModel> listKontrak;

    // Relasi dengan Manager
    @OneToOne(mappedBy = "idol")
    @PrimaryKeyJoinColumn
    private ManagerModel manager;

}
