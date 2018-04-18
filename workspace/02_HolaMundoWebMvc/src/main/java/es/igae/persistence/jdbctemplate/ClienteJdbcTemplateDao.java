package es.igae.persistence.jdbctemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import es.igae.entities.Cliente;
import es.igae.persistence.ClienteDao;

@Repository
public class ClienteJdbcTemplateDao extends JdbcDaoSupport implements ClienteDao{

	private static final String sqlConsutarPorId = "SELECT * FROM CLIENTE WHERE id = ?";
	private static final String sqlConsultarTodo = "SELECT * FROM CLIENTE";
	private static final String sqlInsertar = "INSERT INTO CLIENTE (id, nombre, apellido, telefono) VALUES (?,?,?,?)";
	private static final String sqlActualizar = "UPDATE ....";

	private ClienteRowMapper rowMapper;
	
	@Autowired
	public ClienteJdbcTemplateDao(JdbcTemplate jdbcTemplate, ClienteRowMapper rowMapper) {
		super();
		setJdbcTemplate(jdbcTemplate);
		this.rowMapper = rowMapper;
	}

	@Override
	public int insertar(Cliente cliente) {
		try {
			getJdbcTemplate().update(sqlInsertar, 
				cliente.getId(), cliente.getNombre(), cliente.getApellido(), cliente.getTelefono());
		} catch(DataAccessException ex) {
			System.out.println(ex);
			throw ex;
		}
		return cliente.getId();
	}

	@Override
	public int actualizar(Cliente cliente) {
		return getJdbcTemplate().update(sqlActualizar, cliente.getNombre(), cliente.getApellido(), cliente.getTelefono());
	}

	@Override
	public int borrar(int idCliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cliente consultar(int idCliente) {
		
		return getJdbcTemplate()
				.queryForObject(sqlConsutarPorId, new Object[] {idCliente}, rowMapper);
	}

	@Override
	public List<Cliente> consultar() {
		List<Cliente> clientes = getJdbcTemplate().query(sqlConsultarTodo, rowMapper);
		return clientes;
	}

}
