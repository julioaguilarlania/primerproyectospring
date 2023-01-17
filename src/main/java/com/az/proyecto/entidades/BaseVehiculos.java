package com.az.proyecto.entidades;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class BaseVehiculos {
    Map<String, Vehiculo> vehiculos;

    public BaseVehiculos() {
        this.vehiculos = new HashMap<>();
        Vehiculo v1 = new Vehiculo("ABCD1234","Azul","Audi","2023 XYZ", 12345.0,
                LocalDateTime.of(2023,01,10,9,0),
                LocalDateTime.of(2023,01,10,10,30));
        this.vehiculos.put(v1.getPlacas(),v1);
        Vehiculo v2 = new Vehiculo("BCDE9876","Bermellón","BMW","2021", 1234.0,
                LocalDateTime.of(2023,01,10,9,15),
                null);
        this.vehiculos.put(v2.getPlacas(), v2);
    }

    public Collection<Vehiculo> getVehiculos(){
        return vehiculos.values();
    }

    public Optional<Vehiculo> getVehiculoPorPlacas(String p) {
        Vehiculo v = this.vehiculos.get(p);
        if (v != null) { return Optional.of(v); }
        else { return Optional.empty(); }
    }

    public void agregarVehiculo(Vehiculo v) {
        this.vehiculos.put(v.getPlacas(), v);
    }
}
