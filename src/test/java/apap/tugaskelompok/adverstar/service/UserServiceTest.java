package apap.tugaskelompok.adverstar.service;

import apap.tugaskelompok.adverstar.model.AdminModel;
import apap.tugaskelompok.adverstar.model.UserModel;
import apap.tugaskelompok.adverstar.repository.AdminDb;
import apap.tugaskelompok.adverstar.repository.UserDb;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserServiceTest {

    @Autowired
    UserDb userDb;
    @Autowired
    AdminDb adminDb;
    @Test
    public void adminDb_SaveAll_ReturnsSavedUser() {
        UserModel user =AdminModel.builder()
                .role("Admin")
                .password("arvin")
                .nama("Arvin")
                .username("mohamadarvin")
                .email("mohamadarvin@gmail.com")
                .build();

        userDb.save(user);

        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getId()).isNotNull();
    }
}
