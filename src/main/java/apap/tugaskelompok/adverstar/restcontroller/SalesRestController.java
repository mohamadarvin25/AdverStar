package apap.tugaskelompok.adverstar.restcontroller;

import apap.tugaskelompok.adverstar.model.KontrakModel;
import apap.tugaskelompok.adverstar.service.KontrakService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/sales")
public class SalesRestController {
    @Autowired
    private KontrakService kontrakService;

    @GetMapping(value = "/kontrak/viewall")
    public ResponseEntity getAllKontrak(){
        log.info("api get all kontrak");
        ResponseEntity responseEntity = null;
        try {
            List<KontrakModel> listKontrak = kontrakService.getListKontrak();
            responseEntity = ResponseEntity.ok(listKontrak);
        } catch (Exception e){
            log.error("Error in get all kontrak");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  responseEntity;
    }

    @GetMapping(value = "/kontrak/view")
    public ResponseEntity getKontrak(@RequestParam(value = "id") int idKontrak){
        log.info("api get a kontrak");
        ResponseEntity responseEntity = null;
        try {
            KontrakModel kontrak = kontrakService.getKontrak(idKontrak);
            responseEntity = ResponseEntity.ok(kontrak);
        } catch (Exception e){
            log.error("Error in get a kontrak");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
