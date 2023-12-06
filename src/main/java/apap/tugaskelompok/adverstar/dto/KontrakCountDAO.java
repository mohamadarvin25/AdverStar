package apap.tugaskelompok.adverstar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class KontrakCountDAO {
    private String nama;
    private String jenis;
    private Long count;
}

