package apap.tugaskelompok.adverstar.service;

import apap.tugaskelompok.adverstar.model.KontrakModel;
import apap.tugaskelompok.adverstar.model.ManagerModel;
import apap.tugaskelompok.adverstar.model.UserModel;
import apap.tugaskelompok.adverstar.repository.KontrakDb;
import apap.tugaskelompok.adverstar.repository.UserDb;
import apap.tugaskelompok.adverstar.dto.KontrakCountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KontrakServiceImpl implements KontrakService{

    @Autowired
    KontrakDb kontrakDb;

    @Autowired
    UserDb userDb;

    @Override
    public KontrakModel getKontrak(int idKontrak) {
        Optional<KontrakModel> kontrak = kontrakDb.findByIdKontrak(idKontrak);
        return kontrak.orElse(null);
    }

    @Override
    public List<KontrakModel> getListKontrakForAManager(String username) {
        List<KontrakModel> listKontrak = kontrakDb.findAll();
        UserModel user = userDb.findByUsername(username);
        ManagerModel manager = (ManagerModel) user;
        listKontrak.removeIf(kontrak -> !(kontrak.getIdol().getNama().equals(manager.getIdol().getNama())));
        listKontrak.removeIf(kontrak -> !kontrak.getStatus().equals("diterima"));
        return listKontrak;
    }
    @Override
    public List<KontrakModel> getListKontrak() {
        return kontrakDb.findAll();
    }

    @Override
    public List<KontrakModel> getListKontrakForASublabel(int idSublabel) {
        List<KontrakModel> listKontrak = getListKontrak();
        listKontrak.removeIf(kontrak -> kontrak.getIdol().getSublabel().getIdSublabel() != idSublabel);
        return listKontrak;
    }

    @Override
    public KontrakModel addKontrak(KontrakModel kontrak) {
        return kontrakDb.save(kontrak);
    }

    @Override
    public List<KontrakModel> getListKontrak(String username) {
        List<KontrakModel> listKontrak = kontrakDb.findAll();
        listKontrak.removeIf(kontrak -> !kontrak.getSponsor().getUsername().equals(username));
        return listKontrak;
    }

    @Override
    public KontrakModel updateStatus(Integer idKontrak, String newStatus) {
        Optional<KontrakModel> kontrak = kontrakDb.findById(idKontrak);
        if (kontrak.isPresent()) {
            KontrakModel newKontrak = kontrak.get();
            newKontrak.setStatus(newStatus);
            return kontrakDb.save(newKontrak);
        } else {
            throw new EntityNotFoundException("Kontrak with ID " + idKontrak + " not found");
        }
    }

    @Override
    public List<KontrakCountDAO> countByJenisAndIdolNameEquals(String nama) {
        List<KontrakCountDAO> kontrakData = kontrakDb.countByJenisAndNameEquals(nama);
        return kontrakData;
    }

}
