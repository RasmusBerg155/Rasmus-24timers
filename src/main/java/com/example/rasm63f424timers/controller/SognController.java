package com.example.rasm63f424timers.controller;

import com.example.rasm63f424timers.model.Sogn;
import com.example.rasm63f424timers.repository.SognRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SognController {

    @Autowired
    SognRepo sognRepo;

    @GetMapping("/")
    public String index(Model model) {
        List<Sogn> sogne = new ArrayList<>();
        sognRepo.findAll().forEach(sogne::add);
        model.addAttribute("sogne", sogne);
        return "index";
    }

    @GetMapping("/createSogn")
    public String createSogn(){
        return "createSogn";
    }

    @PostMapping("/createSogn")
    public String createSogn(WebRequest request){
        String name = request.getParameter("name");
        String strsmitteniveau = request.getParameter("smitteniveau");
        String nedlukningStart = request.getParameter("nedlukningStart");

        double smitteniveau = Double.parseDouble(strsmitteniveau);

        Sogn sogn = new Sogn(name, smitteniveau, nedlukningStart);

        sognRepo.save(sogn);
        return "redirect:/";
    }
}