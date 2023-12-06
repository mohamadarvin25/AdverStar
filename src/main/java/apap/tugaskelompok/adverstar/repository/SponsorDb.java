package apap.tugaskelompok.adverstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tugaskelompok.adverstar.model.SponsorModel;

@Repository
public interface SponsorDb extends JpaRepository<SponsorModel, String> {
}
