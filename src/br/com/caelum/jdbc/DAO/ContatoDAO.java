package br.com.caelum.jdbc.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {
	
	//a conexao com o banco de dados
	private Connection connection;
	
	public ContatoDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato){
		String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento) values (?,?,?,?);";
		try {
			
			// prepara o statement para insercao
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			// seta os valores
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getEndereco());
			ps.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			// executa o update
			ps.executeUpdate();
			
			// fecha o statement
			ps.close();
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
		
	}
	
	public void closeResources(){
		if (!this.connection.equals(null)){
			try {
				this.connection.close();
			} catch (SQLException e) {}
		}
	}

}
