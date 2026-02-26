package com.example.demo.Controller;

import com.example.demo.entity.Demo;
import com.example.demo.Service.IDemoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/home")
public class homeController {

    private final IDemoService demoService;

    public homeController(IDemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("demos", demoService.getAll());
        model.addAttribute("demo", new Demo());
        return "home";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Demo demo) {
        if (demo.getId() == null) {
            demoService.save(demo);
        } else {
            demoService.update(demo);
        }
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("demo", demoService.getById(id));
        model.addAttribute("demos", demoService.getAll());
        return "home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        demoService.delete(id);
        return "redirect:/home";   // ✅ sửa đúng
    }
}