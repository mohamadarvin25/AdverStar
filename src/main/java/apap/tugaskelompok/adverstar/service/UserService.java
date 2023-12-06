package apap.tugaskelompok.adverstar.service;

import apap.tugaskelompok.adverstar.model.*;

import java.util.List;

public interface UserService {
    UserModel getUserById(String id);
    String getUsername();
    UserModel getUserByUsername(String username);

    Boolean checkUsernameRegistered(String username);
    Boolean checkEmailRegistered(String email);
    public String encrypt(String password);

    ManagerModel addManager(ManagerModel user);
    SalesModel addSales(SalesModel user);
    SponsorModel addSponsor(SponsorModel user);
    AdminModel addAdmin(AdminModel user);

    void deleteUser(UserModel user);

    List<UserModel> getListUser();
    List<SponsorModel> getListSponsor();
    List<SalesModel> getListSales();
    List<ManagerModel> getListManager();
    List<SublabelModel> getListSublabel();
    List<SublabelModel> getListFreeSublabelForSales();
    List<IdolModel> getListIdol();
    List<IdolModel> getListFreeIdol();

    boolean isHaveFreeIdol();


}
