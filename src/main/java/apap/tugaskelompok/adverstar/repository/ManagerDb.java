package apap.tugaskelompok.adverstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import apap.tugaskelompok.adverstar.model.ManagerModel;

public interface ManagerDb extends JpaRepository<ManagerModel, String>{
}
