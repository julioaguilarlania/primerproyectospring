package com.az.proyecto.controladores;

import com.az.proyecto.entidades.BaseVehiculos;
import com.az.proyecto.entidades.Vehiculo;
import com.az.proyecto.servicios.ServicioVehiculos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ControladorVehiculos {

    //@Autowired
    BaseVehiculos base;
    //@Autowired
    ServicioVehiculos servVehiculos;

    ControladorVehiculos(BaseVehiculos base, ServicioVehiculos sv) {
        this.base = base;
        this.servVehiculos = sv;
    }
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
        Optional<Vehiculo> v = base.getVehiculoPorPlacas(p);
        if (v.isPresent())
            mav.addObject("vehiculo", v.get());
        return mav;
    }

    @RequestMapping("forma_nuevo")
    public String mostrarFormularioCaptura() {
        LOGGER.debug("forma Captura()");
        return "capturaNuevo";
    }

    @RequestMapping(value="guardar")
    public ModelAndView guardarNuevo(
            @RequestParam("placas") String placas,
            @RequestParam("color") String color,
            @RequestParam("marca") String marca,
            @RequestParam("modelo") String modelo,
            @RequestParam("kilometraje") Double kms)
    {
        LOGGER.debug("guardar Vehiculo()");
        Vehiculo v = new Vehiculo(placas, color, marca, modelo, kms, null, null);
        ModelAndView mav = new ModelAndView("busqueda");
        try {
            servVehiculos.guardar(v);
            mav.addObject("mensaje", "Se guardo el vehiculo");
            LOGGER.trace("Se guardo el vehiculo");
        } catch(IllegalArgumentException iae) {
            mav.setViewName("capturaNuevo");
            mav.addObject("error", iae.getMessage());
            mav.addObject("vehiculo", v);
            LOGGER.warn("Error al guardar Vehiculo:", iae);
        }
        /*
        LOGGER.error();
        LOGGER.warn()
        LOGGER.info();
        LOGGER.debug();
        LOGGER.trace();
         */
        return mav;
    }
}
