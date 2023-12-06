package apap.tugaskelompok.adverstar.controller;

import apap.tugaskelompok.adverstar.model.IdolModel;
import apap.tugaskelompok.adverstar.model.KontrakModel;
import apap.tugaskelompok.adverstar.model.SalesModel;
import apap.tugaskelompok.adverstar.service.KontrakService;
import apap.tugaskelompok.adverstar.service.UserService;
import apap.tugaskelompok.adverstar.dto.KontrakCountDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    UserService userService;

    @Autowired
    KontrakService kontrakService;

    @GetMapping(value = "/kontrak/viewall")
    public String listKontrak(Model model) {
        String username = userService.getUsername();
        SalesModel sales = (SalesModel) userService.getUserByUsername(username);
        List<KontrakModel> listKontrak;
        var role = "Sales";
        int idSublabel = sales.getSublabel().getIdSublabel();
        if(idSublabel== 0){
            listKontrak = kontrakService.getListKontrak();
        }
        else{
        listKontrak = kontrakService.getListKontrakForASublabel(idSublabel);
        }
        model.addAttribute("sales", sales);
        model.addAttribute("role",role);
        model.addAttribute("listKontrak", listKontrak);
        return "viewall-kontrak";
    }

    @GetMapping("/kontrak/view")
    public String viewDetailCoursePage(@RequestParam(value = "id") int idKontrak, Model model) {
        KontrakModel kontrak = kontrakService.getKontrak(idKontrak);
        var role = "Sales";
        model.addAttribute("role",role);
        model.addAttribute("kontrak", kontrak);
        return "view-kontrak";
    }
    @PostMapping("kontrak/update-status")
    public ResponseEntity<String> updateStatusKontrak(@RequestParam Integer idKontrak, @RequestParam String action) {
        var newStatus = "";
        if (action.equals("Terima Kontrak")) {
            newStatus = "diterima";
        } else if (action.equals("Tolak Kontrak")) {
            newStatus = "ditolak";
        } else {
            return ResponseEntity.badRequest().body("Invalid action.");
        }

        KontrakModel updatedKontrak = kontrakService.updateStatus(idKontrak, newStatus);

        if (updatedKontrak != null) {
            return ResponseEntity.ok(newStatus);
        } else {
            return ResponseEntity.badRequest().body("ditolak");
        }
    }

    @GetMapping("/kontrak/dashboard")
    public String viewDashboard(@RequestParam(value = "idolName") String idolName, Model model) {
        List<KontrakCountDAO> results = kontrakService.countByJenisAndIdolNameEquals(idolName);
        Map<String, Long> chartData = new HashMap<>();
        results.forEach(item -> chartData.put(item.getJenis(), item.getCount()));
        model.addAttribute("chartData", chartData);
        if (results.size() != 0) {
            model.addAttribute("idolName", results.get(0).getNama());
        }else {
            model.addAttribute("idolName", "Tidak ditemukan");
        }

        return "dashboard-sales";
    }

    @GetMapping("/kontrak/viewDashboard")
    public String viewAllDashboard(Model model) {
        KontrakModel kontrak = new KontrakModel();
        List<IdolModel> listIdol = userService.getListIdol();
        model.addAttribute("kontrak", kontrak);
        model.addAttribute("listIdol", listIdol);
        return "view-dashboard-sales";
    }

}
