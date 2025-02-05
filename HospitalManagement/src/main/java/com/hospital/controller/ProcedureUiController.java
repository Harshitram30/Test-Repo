package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.entities.Procedure;
import com.hospital.exceptions.NotFoundException;
import com.hospital.services.ProcedureService;

@Controller
@RequestMapping("/procedures")
public class ProcedureUiController {

    @Autowired
    private ProcedureService procedureService;

    //read
    @GetMapping("/all")
    public String getAllProcedures(Model model) {
        List<Procedure> procedures = procedureService.getAll();
        model.addAttribute("procedures", procedures);
        return "procedure-list"; // Assuming you have a Thymeleaf template named "procedureList.html"
    }

    //create
    @GetMapping("/add")
    public String showAddProcedureForm(Model model) {
        model.addAttribute("procedure", new Procedure());
        return "addprocedure"; // Thymeleaf template name without extension
    }

    @PostMapping("/add") // This method handles the form submission
    public String addProcedure(@ModelAttribute Procedure procedure) {
        procedureService.addTreatment(procedure);
        return "redirect:/procedures/all";
    }

    //update
    @GetMapping("/update")
    public String showupdateProcedureForm() {
        return "updateprocedure";
    }
    @PostMapping("/update")
    public String updateProcedure(@RequestParam("code") Integer code,@RequestParam("cost") Double cost,Model model) {
    	Procedure procedure=procedureService.updateCostBy(code,cost);
    	if(procedure!=null) {
    		model.addAttribute("procedure",procedure);
    	}
    	return "redirect:/procedures/all";
    }

    //delete
    @GetMapping("/delete")
    public String showDeleteProcedureForm() {
        return "deleteprocedure";
    }
    @PostMapping("/delete")
    public String deleteProcedure(@RequestParam("code") Integer code) {
    	String result=procedureService.deleteBy(code);
    	if(!result.equals("Record Deleted Successfully")) {
    		throw new NotFoundException("Procedure not found");
    	}
    	return "redirect:/procedures/all";
    }


}
