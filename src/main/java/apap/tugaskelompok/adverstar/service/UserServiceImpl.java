package apap.tugaskelompok.adverstar.service;

import apap.tugaskelompok.adverstar.model.*;
import apap.tugaskelompok.adverstar.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;
    @Autowired
    private ManagerDb managerDb;

    @Autowired
    private SalesDb salesDb;

    @Autowired
    private SponsorDb sponsorDb;

    @Autowired
    private SublabelDb sublabelDb;

    @Autowired
    private IdolDb idolDb;

    @Autowired
    private AdminDb adminDb;

    @Override
    public String getUsername() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @Override
    public UserModel getUserByUsername(String username) {
        return userDb.findByUsername(username);
    }
    @Override
    public UserModel getUserById(String id) {
        Optional<UserModel> user = userDb.findUserById(id);
        return user.orElse(null);
    }

    @Override
    public Boolean checkEmailRegistered(String email) {
        for(UserModel user:getListUser()){
            if(user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean checkUsernameRegistered(String username) {
        for(UserModel user:getListUser()){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String encrypt(String password) {
        var passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    @Override
    public AdminModel addAdmin(AdminModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return adminDb.save(user);
    }

    @Override
    public SalesModel addSales(SalesModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return salesDb.save(user);
    }

    @Override
    public SponsorModel addSponsor(SponsorModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return sponsorDb.save( user);
    }

    @Override
    public ManagerModel addManager(ManagerModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return managerDb.save(user);
    }

    @Override
    public List<UserModel> getListUser() {
        return userDb.findAll();
    }

    @Override
    public List<ManagerModel> getListManager() {
        return managerDb.findAll();
    }

    @Override
    public List<SalesModel> getListSales() {
        return salesDb.findAll();
    }

    @Override
    public List<SponsorModel> getListSponsor() {
        return sponsorDb.findAll();
    }
    @Override
    public List<SublabelModel> getListSublabel() {
        return sublabelDb.findAll();
    }

    @Override
    public List<IdolModel> getListIdol() {
        return idolDb.findAll();
    }

    @Override
    public List<IdolModel> getListFreeIdol() {
        List<IdolModel> listIdol = getListIdol();
        listIdol.removeIf(idol -> idol.getManager() != null);


        return listIdol;
    }

    @Override
    public List<SublabelModel> getListFreeSublabelForSales() {
        List<SublabelModel> listSublabel = getListSublabel();
        listSublabel.removeIf(sublabel -> sublabel.getSales() != null);
        return listSublabel;
    }

    @Override
    public boolean isHaveFreeIdol() {
        return !getListFreeIdol().isEmpty();
    }

    @Override
    public void deleteUser(UserModel user) {
        userDb.delete(user);
    }

}
