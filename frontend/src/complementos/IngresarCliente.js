import React, { useState } from 'react';

const CrearCliente = () => {
    const [cliente, setCliente] = useState({
        nombre: '',
        apellido: '',
        correo: '',
        fechaRegistro: '',
    });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setCliente({ ...cliente, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch('http://localhost:8080/api/v1/cliente', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(cliente),
            });

            if (response.ok) {

                alert("Cliente creado con éxito");
            } else {
                const errorDetails = await response.text();
                console.error("Error details:", errorDetails); ola
                alert("Error al crear el cliente")
            }
        } catch (error) {
            console.error("Error:", error);
            alert("Ocurrió un error al crear el cliente");
        }
    };

    return (
        <div>
            <h2>Ingresar Cliente</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Nombre:
                    <input
                        type="text"
                        name="nombre"
                        value={cliente.nombre}
                        onChange={handleInputChange}
                        required
                    />
                </label>
                <br />
                <label>
                    Apellido:
                    <input
                        type="text"
                        name="apellido"
                        value={cliente.apellido}
                        onChange={handleInputChange}
                        required
                    />
                </label>
                <br />
                <label>
                    Correo:
                    <input
                        type="email"
                        name="correo"
                        value={cliente.correo}
                        onChange={handleInputChange}
                        required
                    />
                </label>
                <br />
                <label>
                    Fecha de Registro:
                    <input
                        type="date"
                        name="fechaRegistro"
                        value={cliente.fechaRegistro}
                        onChange={handleInputChange}
                        required
                    />
                </label>
                <br />
                <button type="submit">Crear Cliente</button>
            </form>
        </div>
    );
};

export default CrearCliente;
