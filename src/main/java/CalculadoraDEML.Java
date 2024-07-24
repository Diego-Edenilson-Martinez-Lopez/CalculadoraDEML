package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculadora")
public class CalculadoraDEML {

    @GetMapping("/resta")
    public String mostrarRestaForm(Model model) {
        // Inicializamos los atributos para evitar errores de null
        model.addAttribute("numero1", "");
        model.addAttribute("numero2", "");
        model.addAttribute("resultado", "");
        return "resta";  // Asumiendo que el nombre de tu vista es "resta.html"
    }

    @PostMapping("/resta")
    public String calcularResta(@RequestParam(required = false) Integer numero1,
                                @RequestParam(required = false) Integer numero2,
                                Model model) {
        // Validamos que ambos números no sean null
        if (numero1 != null && numero2 != null) {
            int resultado = numero1 - numero2;
            model.addAttribute("numero1", numero1);
            model.addAttribute("numero2", numero2);
            model.addAttribute("resultado", resultado);
        } else {
            // Si alguno es null, enviamos un mensaje de error
            model.addAttribute("error", "Por favor, ingrese números válidos");
        }
        return "resta";
    }
}