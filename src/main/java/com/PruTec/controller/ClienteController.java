package com.PruTec.controller;

import com.PruTec.model.entity.dao.Dto.clienteDto;
import com.PruTec.model.entity.dao.cliente.cliente;
import com.PruTec.model.entity.dao.payload.MensajeResponse;
import com.PruTec.servicio.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    private ICliente clienteService;

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public clienteDto create(@RequestBody clienteDto ClienteDto){
        cliente clienteSave = null;

        try {
            clienteSave = clienteService.save(ClienteDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("guardado")
                    .objeto(clienteDto.builder()
                            .idCliente(clienteSave.getIdCliente())
                            .nombre(clienteSave.getNombre())
                            .apellido(clienteSave.getApellido())
                            .correo(clienteSave.getCorreo())
                            .fechaRegistro(clienteSave.getFechaRegistro())
                            .build())
                    .build(),
                     HttpStatus.CREATED
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .objeto(null)
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR


        }
    }

    @PutMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public clienteDto update(@RequestBody clienteDto ClienteDto){
        clienteDto clienteUpdate = clienteService.save(ClienteDto);
        return clienteDto.builder()
                .idCliente(clienteUpdate.getIdCliente())
                .nombre(clienteUpdate.getNombre())
                .apellido(clienteUpdate.getApellido())
                .correo(clienteUpdate.getCorreo())
                .fechaRegistro(clienteUpdate.getFechaRegistro())
                .build();
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            clienteDto clienteoDelete = clienteService.findById(id);
            clienteService.delete(clienteoDelete);
            return new ResponseEntity<>(clienteoDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .objeto(null)
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public clienteDto showById(@PathVariable Integer id){
        clienteDto Cliente = clienteService.findById(id);
        return clienteDto.builder()
                .idCliente(Cliente.getIdCliente())
                .nombre(Cliente.getNombre())
                .apellido(Cliente.getApellido())
                .correo(Cliente.getCorreo())
                .fechaRegistro(Cliente.getFechaRegistro())
                .build();
    }
}
