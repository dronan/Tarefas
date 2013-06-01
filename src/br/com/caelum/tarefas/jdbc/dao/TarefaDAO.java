package br.com.caelum.tarefas.jdbc.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.tarefas.jdbc.bean.Tarefa;

@Component
@Transactional
// informa que a dao Ž injetavel
public class TarefaDAO {

	@Autowired
	private SessionFactory factory;

	

	public void adiciona(Tarefa tarefa) {
		this.factory.getCurrentSession().save(tarefa);
	}

	public void finaliza(Long id) {

		try {

			Query query = factory.getCurrentSession().createQuery(
					"update Tarefa set finalizado = true, "
							+ " datafinalizacao = :paramDataFinalizacao"
							+ " where id = :paramId");
			query.setParameter("paramDataFinalizacao", new Date(Calendar
					.getInstance().getTimeInMillis()));
			query.setParameter("paramId", id);

			query.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Tarefa> lista() {
		return this.factory.getCurrentSession().createCriteria(Tarefa.class)
				.list();
	}

	public Tarefa pesquisar(long id) {
		return (Tarefa) this.factory.getCurrentSession().get(Tarefa.class, id);
	}

	public boolean altera(Tarefa tarefa) {

		try {
			
			Query query = factory
					.getCurrentSession()
					.createQuery(
							"Update Tarefa set dataFinalizacao = :paramDataFinalizacao,"
									+ " descricao = :paramDescricao, finalizado = :paramFinalizado"
									+ " where id = :paramId");
			query.setParameter("paramDataFinalizacao",tarefa.getDataFinalizacao());
			query.setParameter("paramDescricao", tarefa.getDescricao());
			query.setParameter("paramFinalizado", tarefa.isFinalizado());
			query.setParameter("paramId", tarefa.getId());

			if (query.executeUpdate() == 1) {
				return true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return false;

	}

	public void remove(Tarefa tarefa) {
		this.factory.getCurrentSession().delete(tarefa);
	}

}
