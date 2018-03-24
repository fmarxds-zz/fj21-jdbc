package br.com.caelum.jdbc.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {
	
	//a conexao com o banco de dados
	private Connection connection;
	
	public ContatoDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public List<Contato> showAll(){
		
		// Query de busca no Banco de Dados
		String sql = "SELECT * FROM contatos;";
		
		List<Contato> contatos = new ArrayList<>();
		
		try {
			
			// Executa a consulta e obtem um ResultSet com os dados
			Statement st = this.connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			// Cria um objeto com os dados do ResultSet e passa para a lista
			while (rs.next()){
				Contato contato = new Contato();
				contato.setId(rs.getLong(1));
				contato.setNome(rs.getString(2));
				contato.setEmail(rs.getString(3));
				contato.setEndereco(rs.getString(4));
					Calendar dataNascimento = Calendar.getInstance();
					dataNascimento.setTime(rs.getDate(5));
				contato.setDataNascimento(dataNascimento);
				contatos.add(contato);
			}
			
			// Encerra os recursos
			rs.close();
			st.close();
			
			// Retorna os contatos
			return contatos;
			
		} catch (SQLException e) {
			
			throw new RuntimeException();
			
		}
		
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
