package apap.tugaskelompok.adverstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import apap.tugaskelompok.adverstar.model.SalesModel;

public interface SalesDb extends JpaRepository<SalesModel, String> {
}
