package apap.tugaskelompok.adverstar.restcontroller;

import apap.tugaskelompok.adverstar.model.KontrakModel;
import apap.tugaskelompok.adverstar.service.KontrakService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/sponsor")
public class SponsorRestController {

    @Autowired
    private KontrakService kontrakService;


    @PostMapping(value = "/kontrak/create")
    public ResponseEntity createKontrak(@RequestBody KontrakModel newKontrak) {
        log.info("API create a kontrak");
        ResponseEntity responseEntity;
        try {
            KontrakModel createdKontrak = kontrakService.addKontrak(newKontrak);
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(createdKontrak);
        } catch (Exception e) {
            log.error("Error in creating a kontrak");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


}
