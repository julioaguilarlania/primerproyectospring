package com.az.proyecto.servicios;

import com.az.proyecto.entidades.BaseVehiculos;
import com.az.proyecto.entidades.Vehiculo;
import org.springframework.stereotype.Service;

@Service
public class ServicioVehiculos {

    BaseVehiculos base;

    public ServicioVehiculos(BaseVehiculos base) {
        this.base = base;
    }

    public void guardar(Vehiculo v) {
        this.base.agregarVehiculo(v);
    }
}
