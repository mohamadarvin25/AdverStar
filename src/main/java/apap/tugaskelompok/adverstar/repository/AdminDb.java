package apap.tugaskelompok.adverstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import apap.tugaskelompok.adverstar.model.AdminModel;

public interface AdminDb extends JpaRepository<AdminModel, String> {
    
}
