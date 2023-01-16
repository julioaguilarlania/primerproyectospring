package com.az.proyecto.controladores;

import com.az.proyecto.entidades.BaseVehiculos;
import com.az.proyecto.entidades.Vehiculo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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
        BaseVehiculos base = new BaseVehiculos();
        base.agregarVehiculo(v);
        ModelAndView mav = new ModelAndView("busqueda");
        mav.addObject("mensaje", "Se guardo el vehiculo");
        LOGGER.trace("Se guardo el vehiculo");
        return mav;
    }
}
