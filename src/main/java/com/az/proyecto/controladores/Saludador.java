package com.az.proyecto.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class Saludador {

    final static Logger LOGGER = LoggerFactory.getLogger(Saludador.class);
    @RequestMapping("saludo")
    public String saludar(Model modelo) {
        LOGGER.debug("saludar()");

        ModelAndView mav = new ModelAndView();
        modelo.addAttribute("mensaje", "Hola mundo desde Spring");
        modelo.addAttribute("fecha", LocalDate.now());
        return "bienvenida";
    }
}
