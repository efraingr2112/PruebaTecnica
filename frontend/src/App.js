import React from "react";
import "./App.css";
import IngresarCliente from "./complementos/IngresarCliente";
import ListarClientes from "./complementos/ListarClientes";

function App() {
    return (
        <div className="App">
            <h1>Gestión de Clientes</h1>
            <IngresarCliente />
            <ListarClientes />
        </div>
    );
}

export default App;
