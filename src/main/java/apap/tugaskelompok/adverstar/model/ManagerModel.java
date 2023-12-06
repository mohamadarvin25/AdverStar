package apap.tugaskelompok.adverstar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "manager")
public class ManagerModel extends UserModel {
    @NotNull
    @Column(name = "nip", nullable = false, unique = true)
    private String nip;

    // Relasi ke sub label
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_sublabel", nullable = false)
    private SublabelModel sublabel;

    // Relasi ke Idol
    @OneToOne
    @NotNull
    @JsonIgnore
    @JoinColumn(name = "id_Idol", nullable = false)
    private IdolModel idol;


}
