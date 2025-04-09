package com.PruTec.servicio.impl;

import com.PruTec.model.entity.dao.ClienteDao;
import com.PruTec.model.entity.dao.cliente;
import com.PruTec.servicio.ICliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class clienteimpl implements ICliente {
   @Autowired
    private ClienteDao clienteDao;
   @Transactional
    @Override
    public cliente save(cliente Cliente) {
        return clienteDao.save(Cliente);
    }
    @Transactional
    @Override
    public cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(cliente Cliente) {
        clienteDao.delete(Cliente);

    }
}





























