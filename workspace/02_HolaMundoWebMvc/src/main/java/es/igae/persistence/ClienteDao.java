package es.igae.persistence;

import java.util.List;

import es.igae.entities.Cliente;

public interface ClienteDao {

	//Funcionalidad que persiste un Cliente, retornando el Id
	int insertar(Cliente cliente);
	
	//Funcionalidad que actualiza un cliente, retornando el numero de 
	//Clientes Actualizados
	int actualizar(Cliente cliente);
	
	//Retorna el numero de registros borrados
	int borrar(int idCliente);
	
	Cliente consultar(int idCliente);
	
	List<Cliente> consultar();
	
}
