package apap.tugaskelompok.adverstar.service;

import apap.tugaskelompok.adverstar.model.KontrakModel;
import apap.tugaskelompok.adverstar.dto.KontrakCountDAO;

import java.util.List;


public interface KontrakService {
    KontrakModel getKontrak(int idKontrak);

    List<KontrakModel> getListKontrakForAManager(String username);

    List<KontrakModel> getListKontrak();
    List<KontrakModel> getListKontrakForASublabel(int idSublabel);

    KontrakModel addKontrak(KontrakModel kontrak);

    List<KontrakModel> getListKontrak(String username);

    KontrakModel updateStatus(Integer kontrakId, String newStatus);

    List<KontrakCountDAO> countByJenisAndIdolNameEquals(String nama);

}
