package com.PruTec.servicio.impl;

import com.PruTec.model.entity.dao.ClienteDao;
import com.PruTec.model.entity.dao.Dto.clienteDto;
import com.PruTec.model.entity.dao.cliente;
import com.PruTec.servicio.ICliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clienteimpl implements ICliente {
    @Autowired
    private ClienteDao ClienteDao;
    @Transactional
    @Override
    public cliente save(clienteDto ClienteDto) {
       cliente Cliente = cliente.builder()
               .idCliente(ClienteDto.getIdCliente())
               .nombre(ClienteDto.getNombre())
               .apellido(ClienteDto.getApellido())
               .correo(ClienteDto.getCorreo())
               .fechaRegistro(ClienteDto.getFechaRegistro())
               .build();
        return ClienteDao.save(Cliente);
    }
    @Transactional
    @Override
    public cliente findById(Integer id) {
        return ClienteDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(cliente Cliente) {
        ClienteDao.delete(Cliente);

    }
}





























