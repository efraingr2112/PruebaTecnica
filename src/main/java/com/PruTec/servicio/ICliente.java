package com.PruTec.servicio;
import com.PruTec.model.entity.dao.Dto.clienteDto;
import com.PruTec.model.entity.dao.cliente;
public interface ICliente {

    clienteDto save(clienteDto Cliente);

    clienteDto findById(Integer id);

    void delete(cliente Cliente);

}
