export class ClienteService {
    // Método para crear un cliente
    async createCliente(cliente) {
        try {
            const response = await fetch('http://localhost:3000/api/v1/cliente', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(cliente),
            });

            if (!response.ok) {
                throw new Error('Error al crear cliente');
            }

            const data = await response.json();
            return data;
        } catch (error) {
            console.error('Error al crear cliente:', error);
            throw error;
        }
    }


}
