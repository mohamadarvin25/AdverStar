package apap.tugaskelompok.adverstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tugaskelompok.adverstar.model.UserModel;

import java.util.Optional;

@Repository
public interface UserDb extends JpaRepository<UserModel, String> {
    Optional<UserModel> findUserById(String id);
    UserModel findByUsername(String username);
}


