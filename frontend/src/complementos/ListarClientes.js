import React, { useState, useEffect } from "react";
import axios from "axios";

const API_URL = ("http://localhost:8080/api/v1/cliente");



export const eliminarCliente = async (id) => {
    await axios.delete(`${API_URL}/${id}`);
};

const ListarClientes = () => {
    const [clientes, setClientes] = useState([]);


    const fetchClientes = async () => {
        try {
            const response = await axios.get(API_URL);
            setClientes(response.data);
        } catch (error) {
            console.error("Error al obtener clientes", error);
        }
    };


    const handleEliminar = async (id) => {
        try {
            await eliminarCliente(id);
            alert("Cliente eliminado con éxito");
            fetchClientes();
        } catch (error) {
            alert("Error al eliminar cliente");
        }
    };

    useEffect(() => {
        fetchClientes();
    }, []);

    return (
        <div>
            <h2>Lista de Clientes</h2>
            <ul>
                {clientes.map((cliente) => (
                    <li key={cliente.idCliente}>
                        {cliente.nombre} {cliente.apellido} - {cliente.correo}
                        <button onClick={() => handleEliminar(cliente.idCliente)}>
                            Eliminar
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ListarClientes;
