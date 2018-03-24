package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.DAO.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteInsert {
	
	public static void main(String[] args) {
		
		// instancia um contato para gravacao
		Contato contato = new Contato();
		
		// insere os atributos no contato
		contato.setNome("Felipe Marques");
		contato.setEmail("fmarques.ds@gmail.com");
		contato.setEndereco("Rua No Name Street, 13");
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.set(1996, Calendar.APRIL, 12);
		contato.setDataNascimento(dataNascimento);
		
		// instancia um objeto da classe DAO para gravar o contato no banco
		ContatoDAO dao = new ContatoDAO();
		
		// salva o contato no banco
		dao.adiciona(contato);
		
		// fecha a conexao com o banco de dados
		dao.closeResources();
	
	}

}
