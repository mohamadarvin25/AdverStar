package apap.tugaskelompok.adverstar.controller;

import apap.tugaskelompok.adverstar.model.KontrakModel;
import apap.tugaskelompok.adverstar.service.KontrakService;
import apap.tugaskelompok.adverstar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private KontrakService kontrakService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/kontrak/viewall")
    public String listKontrak(Model model) {
        String username = userService.getUsername();
        List<KontrakModel> listKontrak = kontrakService.getListKontrakForAManager(username);
        var role = "Manager";
        model.addAttribute("role",role);
        model.addAttribute("listKontrak", listKontrak);
        return "viewall-kontrak";
    }

    @GetMapping("/kontrak/view")
    public String viewDetailKontrakPage(@RequestParam(value = "id") int idKontrak, Model model) {
        KontrakModel kontrak = kontrakService.getKontrak(idKontrak);
        model.addAttribute("kontrak", kontrak);
        return "view-kontrak";
    }

}
