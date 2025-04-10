package com.PruTec.model.entity.dao;

import com.PruTec.model.entity.dao.Dto.clienteDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="clientes")
public class cliente extends clienteDto implements Serializable {

    @Id
    @Column(name="id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="correo")
    private String correo;
    @Column(name="fecha_registro")
    private Date fechaRegistro;
}
