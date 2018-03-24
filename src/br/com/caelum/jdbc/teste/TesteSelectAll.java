package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.DAO.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteSelectAll {
	
	public static void main(String[] args) {
		
		ContatoDAO dao = new ContatoDAO();
		
		List<Contato> contatos = dao.showAll();
				
		contatos.forEach(x -> x.imprimirDados());
		
	}

}
