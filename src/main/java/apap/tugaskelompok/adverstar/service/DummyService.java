package apap.tugaskelompok.adverstar.service;

import org.springframework.beans.factory.annotation.Autowired;

import apap.tugaskelompok.adverstar.model.IdolModel;
import apap.tugaskelompok.adverstar.model.SublabelModel;
import apap.tugaskelompok.adverstar.repository.IdolDb;
import apap.tugaskelompok.adverstar.repository.SublabelDb;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DummyService {
    @Autowired
    IdolDb idolDb;

    @Autowired
    SublabelDb sublabelDb;

    public void createDummySublabelAndIdol() {
        var sublabel0 = new SublabelModel();
        sublabel0.setIdSublabel(0);
        sublabel0.setNama("Perusahaan Induk");
        sublabelDb.save(sublabel0);

        var sublabel = new SublabelModel();
        sublabel.setIdSublabel(1);
        sublabel.setNama("Cabang Hayam Wuruk");
        sublabelDb.save(sublabel);

        var sublabel2 = new SublabelModel();
        sublabel2.setIdSublabel(2);
        sublabel2.setNama("Cabang Harmoni");
        sublabelDb.save(sublabel2);

        var sublabel3 = new SublabelModel();
        sublabel3.setIdSublabel(3);
        sublabel3.setNama("Cabang Tanah Abang");
        sublabelDb.save(sublabel3);

        var sublabel4 = new SublabelModel();
        sublabel4.setIdSublabel(4);
        sublabel4.setNama("Cabang Tajur");
        sublabelDb.save(sublabel4);

        var idol = new IdolModel();
        idol.setIdIdol(1);
        idol.setNama("One Direction");
        idol.setKategori('1');
        idol.setSublabel(sublabel0);
        idolDb.save(idol);

        var idol1 = new IdolModel();
        idol1.setIdIdol(2);
        idol1.setNama("Avicii");
        idol1.setKategori('2');
        idol1.setSublabel(sublabel0);
        idolDb.save(idol1);

        var idol2 = new IdolModel();
        idol2.setIdIdol(3);
        idol2.setNama("Adelle");
        idol2.setKategori('2');
        idol2.setSublabel(sublabel2);
        idolDb.save(idol2);

        var idol3 = new IdolModel();
        idol3.setIdIdol(4);
        idol3.setNama("Bruno Mars");
        idol3.setKategori('2');
        idol3.setSublabel(sublabel3);
        idolDb.save(idol3);

        var idol4 = new IdolModel();
        idol4.setIdIdol(5);
        idol4.setNama("Kana Boon");
        idol4.setKategori('1');
        idol4.setSublabel(sublabel4);
        idolDb.save(idol4);

        var idol5 = new IdolModel();
        idol5.setIdIdol(6);
        idol5.setNama("Olivia Rodrigo");
        idol5.setKategori('2');
        idol5.setSublabel(sublabel);
        idolDb.save(idol5);

    }
}
