package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Chuveiro;
import br.com.fiap.entity.Usuario;
import br.com.fiap.tds.dao.UsuarioDao;
import br.com.fiap.tds.dao.impl.UsuarioDaoImpl;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {

	public static void main(String[] args) {
		
		// Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		// Obter um usuarioDao
		UsuarioDao dao = new UsuarioDaoImpl(em);
		
		// Pesquisar o usuario de código 1
		try {
			Usuario usuario = dao.findById(1);
			
			// Exibir o nome do usuario
			System.out.println("Usuario: " + usuario.getNome());
			
			// Exibir os chuveiros do usuario
			System.out.println("Chuveiros: ");
			for (Chuveiro chuv : usuario.getChuveiros()) {
				System.out.println("Pressão: " + chuv.getPressao() + " Temperatura: " + 
						chuv.getTemperatura() + " Duração: " + chuv.getDuracao() + "minutos");
			}
		}catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
				em.close();
				EntityManagerFactorySingleton.getInstance().createEntityManager();
		
	}

}
