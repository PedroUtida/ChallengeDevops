package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Chuveiro;
import br.com.fiap.entity.Usuario;
import br.com.fiap.tds.dao.UsuarioDao;
import br.com.fiap.tds.dao.impl.UsuarioDaoImpl;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {

		// Instanciar um usuario
		Usuario usuario = new Usuario("Carlos Alberto", 945452121, "carlosalberto@gmail.com",
			"carlos12345", new GregorianCalendar(1990,Calendar.OCTOBER, 8), "Masculino");
		
		// Instanciar dois chuveiros
		Chuveiro chuv1 = new Chuveiro("forte", 30, 5.30);
		Chuveiro chuv2 = new Chuveiro("fraco", 15, 3.45);
		
		// Adicionar os chuveiros ao Usuario
		usuario.addChuveiro(chuv1);
		usuario.addChuveiro(chuv2);

		// Cadastrar um usuario
		// Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		// Instanciar um usuarioDao
		UsuarioDao dao = new UsuarioDaoImpl(em);
		
		try {
			// Persistir o sistema
			dao.create(usuario);
			
			// Commit 
			dao.commit();
			System.out.println("Tudo ok!");
		}catch(CommitException e) {
			System.out.println("Deu ruim...");
		}
		
		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
