package apap.tugaskelompok.adverstar.controller;

import apap.tugaskelompok.adverstar.model.*;
import apap.tugaskelompok.adverstar.service.KontrakService;
import apap.tugaskelompok.adverstar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sponsor")
public class SponsorController {

    @Autowired
    private UserService userService;

    @Autowired
    private KontrakService kontrakService;

    @GetMapping(value = "/kontrak/add")
    public String addKontrakFormPage(Model model) {
        var kontrak = new KontrakModel();
        List<IdolModel> listIdol = userService.getListIdol();
        model.addAttribute("listIdol", listIdol);
        model.addAttribute("kontrak", kontrak);
        return "form-add-kontrak";

    }

    @PostMapping(value = "/kontrak/add")
    public String addKontrakSubmit(@ModelAttribute KontrakModel kontrak, Model model) {

        String username = userService.getUsername();
        SponsorModel sponsor = (SponsorModel) userService.getUserByUsername(username);
        kontrak.setSponsor(sponsor);
        kontrak.setStatus("dalam review");

        SublabelModel sublabel = kontrak.getIdol().getSublabel();
        if (kontrak.getListSublabel() == null) {
            kontrak.setListSublabel(new ArrayList<>());
        }
        kontrak.getListSublabel().add(sublabel);
        kontrakService.addKontrak(kontrak);
        model.addAttribute(sponsor);

        return "home";
    }

    @GetMapping(value = "/kontrak/viewall")
    public String listKontrak(Model model) {
        String username = userService.getUsername();
        List<KontrakModel> listKontrak = kontrakService.getListKontrak(username);
        var role = "Sponsor";
        model.addAttribute("role", role);
        model.addAttribute("listKontrak", listKontrak);
        return "viewall-kontrak";
    }

    @GetMapping("/kontrak/view")
    public String viewDetailKontrakPage(@RequestParam(value = "id") int idKontrak, Model model) {
        KontrakModel kontrak = kontrakService.getKontrak(idKontrak);
        model.addAttribute("kontrak", kontrak);
        return "view-kontrak";
    }

    @GetMapping(value = "/dashboard")
    public String viewDashboardString(Model model) {
        String username = userService.getUsername();
        List<KontrakModel> listKontrak = kontrakService.getListKontrak(username);
        String role = "Sponsor";
        model.addAttribute("role", role);
        model.addAttribute("listKontrak", listKontrak);
        return "dashboard-sponsor";
    }

}
