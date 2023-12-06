package apap.tugaskelompok.adverstar.restcontroller;

import apap.tugaskelompok.adverstar.model.*;
import apap.tugaskelompok.adverstar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserRestController
{
    @Autowired
    private UserService userService;

    @GetMapping(value = "/manager/viewall")
    public ResponseEntity getAllManager(){
        log.info("api get all Manager");
        ResponseEntity responseEntity = null;
        try{
            List<ManagerModel> listManager = userService.getListManager();
            responseEntity = ResponseEntity.ok(listManager);
        }catch (Exception e){
            log.error("Error in get all Manager");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping(value = "/user/view")
    public ResponseEntity getUser(@RequestParam(value = "id") String id){
        log.info("api get a user");
        ResponseEntity responseEntity = null;
        try {
            UserModel user = userService.getUserById(id);
            responseEntity = ResponseEntity.ok(user);
        } catch (Exception e){
            log.error("Error in get a user");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @GetMapping(value = "/sales/viewall")
    public ResponseEntity getAllSales(){
        log.info("api get all Sales");
        ResponseEntity responseEntity = null;
        try{
            List<SalesModel> listSales = userService.getListSales();
            responseEntity = ResponseEntity.ok(listSales);
        }catch (Exception e){
            log.error("Error in get all Sales");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping(value = "/sponsor/viewall")
    public ResponseEntity getAllSponsor(){
        log.info("api get all Sponsor");
        ResponseEntity responseEntity = null;
        try{
            List<SponsorModel> listSponsor = userService.getListSponsor();
            responseEntity = ResponseEntity.ok(listSponsor);
        }catch (Exception e){
            log.error("Error in get all Sponsor");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }




}
