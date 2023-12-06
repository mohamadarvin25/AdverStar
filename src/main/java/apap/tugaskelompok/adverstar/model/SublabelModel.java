package apap.tugaskelompok.adverstar.model;

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
@Table(name = "sublabel")
public class SublabelModel {
    @Id
    @Column(name = "id_sublabel",nullable = true)
    private Integer idSublabel;

    @NotNull
    @Column(name = "nama", nullable = false)
    private String nama;

    // Relasi ke Sales
    @OneToOne(mappedBy = "sublabel")

    @PrimaryKeyJoinColumn
    private SalesModel sales;

    // Relasi ke Manager
    @OneToMany(mappedBy = "sublabel")
    @PrimaryKeyJoinColumn
    private List<ManagerModel> listManager;

    // Relasi ke Kontrak
    @ManyToMany(mappedBy = "listSublabel")
    @PrimaryKeyJoinColumn
    private List<KontrakModel> listKontrak;

    // Relasi ke Idol
    @OneToMany(mappedBy = "sublabel")
    @PrimaryKeyJoinColumn
    private List<IdolModel> listIdol;

}
