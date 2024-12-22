package com.axsosacademy.dojoandninja.controllers;

import com.axsosacademy.dojoandninja.models.Dojo;
import com.axsosacademy.dojoandninja.models.Ninja;
import com.axsosacademy.dojoandninja.services.DojoService;
import com.axsosacademy.dojoandninja.services.NinjaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public MainController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage() {
        return "index";
    }

    @GetMapping("/dojos/new")
    public String newDojoPage(@ModelAttribute("dojo") Dojo dojo) {
        return "newDojoPage";
    }

    @GetMapping("ninjas/new")
    public String newNinjaPage(Model model, @ModelAttribute("ninja") Ninja ninja) {
        model.addAttribute("dojos", dojoService.getAllDojos());
        return "newNinjaPage";
    }

    @GetMapping("/dojos/{id}")
    public String showDojoPage(@PathVariable Long id, Model model) {
        Dojo dojo = dojoService.getDojoById(id);
        model.addAttribute("dojo", dojo);
        return "showDojoPage";
    }

    // Add new Dojo controller (POST)
    @PostMapping("/dojos/addDojo")
    public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newDojoPage";
        }
        else {
            dojoService.addDojo(dojo);
            return "redirect:/dojos/" + dojo.getId();
        }
    }

    // Add new Ninja Controller (Post)
    @PostMapping("/ninjas/addNinja")
    public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newNinjaPage";
        }
        else {
            ninjaService.addNewNinja(ninja);
            return "redirect:/dojos/" + ninja.getDojo().getId();
        }
    }

}
