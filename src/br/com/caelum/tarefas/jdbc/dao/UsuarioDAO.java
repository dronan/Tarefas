package br.com.caelum.tarefas.jdbc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.caelum.tarefas.jdbc.bean.Usuario;

@Component
public class UsuarioDAO {
	private SessionFactory factory;

	@Autowired
	public UsuarioDAO(SessionFactory factory) {
		this.factory = factory;
	}

	public boolean existeUsuario(Usuario usuario) {

		Query query = factory
				.getCurrentSession()
				.createQuery(
						"FROM Usuario where usuario = :paramUsuario and senha = :paramSenha");
		query.setString("paramUsuario", usuario.getUsuario());
		query.setString("paramSenha", usuario.getSenha());

		List resultado = query.list();

		if (resultado.size() > 0) {
			return true;
		}

		return false;

		/*
		 * String sql =
		 * "select * from usuarios where usuario = ? and senha = ?"; try {
		 * PreparedStatement stmt = conn.prepareStatement(sql);
		 * stmt.setString(1, usuario.getUsuario());
		 * System.out.println(usuario.getUsuario()); stmt.setString(2,
		 * usuario.getSenha()); System.out.println(usuario.getSenha());
		 * ResultSet rs = stmt.executeQuery();
		 * 
		 * while (rs.next()) { existe = true; } rs.close(); stmt.close(); }
		 * catch (Exception e) { throw new RuntimeException(e); } return existe;
		 */
	}
}
