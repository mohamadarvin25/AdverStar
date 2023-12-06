package apap.tugaskelompok.adverstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import apap.tugaskelompok.adverstar.model.IdolModel;

public interface IdolDb extends JpaRepository<IdolModel, Integer> {
}
