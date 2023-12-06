package apap.tugaskelompok.adverstar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "kontrak")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KontrakModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kontrak", nullable = false, unique = true)
    private Integer idKontrak;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "jangka_waktu", nullable = false)
    private Integer jangkaWaktu;

    @NotNull
    @Size(max = 50)
    @Column(name = "jenis", nullable = false)
    private String jenis;

    @NotNull
    @Size(max = 50)
    @Column(name = "nilai_penawaran", nullable = false)
    private String nilaiPenawaran;

    
    @Column(name = "keterangan", nullable = true)
    private String keterangan;

    @NotNull
    @Column(name= "status", nullable = false)
    private String status;

    // Relasi ke Idol
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_idol", nullable = false)   
    private IdolModel idol;

    // Relasi dengan sublabel
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "kontrak_sublabel", joinColumns = @JoinColumn(name = "id_Kontrak"), inverseJoinColumns = @JoinColumn(name = "`id_sublabel"))
    private List<SublabelModel> listSublabel;

    // Relasi ke Sponsor
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_sponsor", nullable = false)   
    private SponsorModel sponsor;

}
