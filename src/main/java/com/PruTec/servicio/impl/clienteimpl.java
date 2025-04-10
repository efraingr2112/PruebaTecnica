package com.PruTec.servicio.impl;

import com.PruTec.model.entity.dao.ClienteDao;
import com.PruTec.model.entity.dao.Dto.clienteDto;
import com.PruTec.model.entity.dao.cliente.cliente;
import com.PruTec.servicio.ICliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clienteimpl implements ICliente {
    @Autowired
    private ClienteDao ClienteDao;
    private cliente cliente;

    @Transactional
    @Override
    public clienteDto save(clienteDto ClienteDto) {
       cliente Cliente = cliente.builder()
               .idCliente(ClienteDto.getIdCliente())
               .nombre(ClienteDto.getNombre())
               .apellido(ClienteDto.getApellido())
               .correo(ClienteDto.getCorreo())
               .fechaRegistro(ClienteDto.getFechaRegistro())
               .build();
        return ClienteDao.save(Cliente).getClienteDto();
    }
    @Transactional
    @Override
    public clienteDto findById(Integer id) {
        return ClienteDao.findById(id).orElse(null).getClienteDto();
    }
    @Transactional
    @Override
    public void delete(clienteDto Cliente) {
        ClienteDao.delete(cliente);

    }
}





























