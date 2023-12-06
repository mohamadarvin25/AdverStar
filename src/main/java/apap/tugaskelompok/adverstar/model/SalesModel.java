package apap.tugaskelompok.adverstar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesModel extends UserModel {
    
    @NotNull
    @Column(name = "nip", nullable = false, unique = true)
    private String nip;

    @NotNull
    @Column(name = "jabatan", nullable = false)
    private Character jabatan;
    
    // Relasi ke sub label
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "id_sublabel")
    private SublabelModel sublabel;

    
}
