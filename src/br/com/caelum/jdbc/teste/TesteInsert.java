package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.DAO.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteInsert {
	
	public static void main(String[] args) {
		
		Contato contato = new Contato();
		contato.setNome("Felipe Marques");
		contato.setEmail("fmarques.ds@gmail.com");
		contato.setEndereco("Rua No Name Street, 13");
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.set(1996, Calendar.APRIL, 12);
		contato.setDataNascimento(dataNascimento);
		
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
		dao.closeResources();
	
	}

}
