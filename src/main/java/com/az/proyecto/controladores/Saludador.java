package com.az.proyecto.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class Saludador {

    final static Logger LOGGER = LoggerFactory.getLogger(Saludador.class);
    @RequestMapping("saludo")
    public ModelAndView saludar() {
        LOGGER.debug("saludar()");
        ModelAndView mav = new ModelAndView("bienvenida");
        mav.addObject("mensaje", "Hola mundo desde Spring");
        mav.addObject("fecha", LocalDate.now());
        return mav;
    }
}
