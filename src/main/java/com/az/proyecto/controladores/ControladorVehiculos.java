package com.az.proyecto.controladores;

import com.az.proyecto.entidades.BaseVehiculos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorVehiculos {

    final static Logger LOGGER = LoggerFactory.getLogger(ControladorVehiculos.class);

    @RequestMapping("forma_busqueda")
    public String mostrarFormularioBusqueda() {
        LOGGER.debug("forma busqueda()");
        return "busqueda";
    }

    @RequestMapping(value = "buscar", params = "placas")
    public ModelAndView buscarVehiculo(@RequestParam("placas") String p) {
        LOGGER.debug("buscarVehiculo()");
        ModelAndView mav = new ModelAndView("resultados");
        BaseVehiculos base = new BaseVehiculos();
        mav.addObject("vehiculo", base.getVehiculoPorPlacas(p));
        return mav;
    }
}
