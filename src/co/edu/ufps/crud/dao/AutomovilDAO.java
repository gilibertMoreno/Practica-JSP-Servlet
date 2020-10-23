package co.edu.ufps.crud.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.edu.ufps.crud.model.Automovil;
import co.edu.ufps.crud.model.Conexion;


public class AutomovilDAO {
	private Conexion con;
	private Connection connection;
	public AutomovilDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws   SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	//insertar articulo
	
	public boolean insertar(Automovil automovil)throws SQLException{
		String sql = "INSERT INTO automovil (idautomovil, placa, color, modelo, propietario, valor) VALUES (?, ?, ?,?,?,?)";
		System.out.println(automovil.getPropietario());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, automovil.getPlaca());
		statement.setString(3, automovil.getColor());
		statement.setString(4, automovil.getModelo());
		statement.setString(5, automovil.getPropietario());
		statement.setDouble(6, automovil.getValor());
 
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
	
	// listar todos los vehiculos
		public List<Automovil> listarAutomovil() throws SQLException {
	 
			List<Automovil> listaAutomovil = new ArrayList<Automovil>();
			String sql = "SELECT * FROM automovil";
			con.conectar();
			connection = con.getJdbcConnection();
			Statement statement = connection.createStatement();
			ResultSet resulSet = statement.executeQuery(sql);
	 
			while (resulSet.next()) {
				int id = resulSet.getInt("idautomovil");
				String placa = resulSet.getString("placa");
				String color = resulSet.getString("color");
				String modelo = resulSet.getString("modelo");
				String propietario = resulSet.getString("propietario");
				Double valor = resulSet.getDouble("valor");
				Automovil auto= new Automovil(id,placa, color, modelo, propietario, valor);
				listaAutomovil.add(auto);
			}
			con.desconectar();
			return listaAutomovil;
		}
	 
		// obtener por id
		public Automovil obtenerPorId(int id) throws SQLException {
			Automovil automovil = null;
	 
			String sql = "SELECT * FROM automovil WHERE idautomovil= ? ";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
	 
			ResultSet res = statement.executeQuery();
			if (res.next()) {
				automovil = new Automovil(res.getInt("id"),res.getString("placa"), res.getString("color"),res.getString("modelo"),
						res.getString("propietario") ,res.getDouble("valor"));
				
			}
			res.close();
			con.desconectar();
	 
			return automovil;
		}
		
		
		// actualizar
		public boolean actualizar(Automovil automovil) throws SQLException {
			boolean rowActualizar = false;
			String sql = "UPDATE automovil SET placa=?,color=?,modelo=?, propietario=?, valor=? WHERE idautomovil=?";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, automovil.getPlaca());
			statement.setString(2, automovil.getColor());
			statement.setString(3, automovil.getModelo());
			statement.setString(4, automovil.getPropietario());
			System.out.println(automovil.getValor());
			statement.setDouble(5, automovil.getValor());
			statement.setInt(6, automovil.getIdautomovil());
	 
			rowActualizar = statement.executeUpdate() > 0;
			statement.close();
			con.desconectar();
			return rowActualizar;
		}
	
		//eliminar
		public boolean eliminar(Automovil automovil) throws SQLException {
			boolean rowEliminar = false;
			String sql = "DELETE FROM automovil WHERE idautomovil=?";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, automovil.getIdautomovil());
	 
			rowEliminar = statement.executeUpdate() > 0;
			statement.close();
			con.desconectar();
	 
			return rowEliminar;
		}
		

}
