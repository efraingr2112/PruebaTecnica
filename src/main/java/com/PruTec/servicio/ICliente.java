package com.PruTec.servicio;
import com.PruTec.model.entity.dao.cliente;
public interface ICliente {

    cliente save(cliente Cliente);

    cliente findById(Integer id);

    void delete(cliente Cliente);

}
