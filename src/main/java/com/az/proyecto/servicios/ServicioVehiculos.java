package com.az.proyecto.servicios;

import com.az.proyecto.entidades.BaseVehiculos;
import com.az.proyecto.entidades.Vehiculo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class ServicioVehiculos {

    BaseVehiculos base;

    public ServicioVehiculos(BaseVehiculos base) {
        this.base = base;
    }

    public void guardar(Vehiculo v) {
        if (!StringUtils.hasText(v.getPlacas())) {
            throw new IllegalArgumentException("No hay placas");
        }
        if (v.getPlacas().length() != 7 ||
                !v.getPlacas().substring(0,3).matches("^[A-Za-z]*$") ||
                !v.getPlacas().substring(3).matches("^\\d*$")
        ) {
            throw new IllegalArgumentException("Placas no cumplen formato");
        }
        Optional<Vehiculo> ov = base.getVehiculoPorPlacas(v.getPlacas());
        if (ov.isPresent()) {
            throw new IllegalArgumentException("Placas ya registradas");
        }
        if (!StringUtils.hasText(v.getMarca())) {
            throw new IllegalArgumentException("No hay marca");
        }
        if (!StringUtils.hasText(v.getModelo())) {
            throw new IllegalArgumentException("No hay modelo");
        }
        if (!StringUtils.hasText(v.getColor())) {
            throw new IllegalArgumentException("No hay color");
        }
        if (v.getKilometraje() < 0) {
            throw new IllegalArgumentException("Kilometros negativos");
        }
        this.base.agregarVehiculo(v);
    }
}
