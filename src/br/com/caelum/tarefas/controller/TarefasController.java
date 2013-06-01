package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.jdbc.bean.Tarefa;
import br.com.caelum.tarefas.jdbc.dao.TarefaDAO;

@Controller
@Transactional
public class TarefasController {
	
	@Autowired
	private TarefaDAO dao;

	

	@RequestMapping("novaTarefa")
	// http://localhost:8080/fj21-tarefas/novaTarefa
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	// action do form
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {

		if (result.hasErrors()) {
			return "tarefa/formulario";
		}

		dao.adiciona(tarefa);

		return "redirect:listaTarefas";
	}

	@RequestMapping("listaTarefas")
	public String lista(Model model) {

		model.addAttribute("tarefas", dao.lista());

		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {

		dao.remove(tarefa);

		return "redirect:listaTarefas";
	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {

		model.addAttribute("tarefa", dao.pesquisar(id));

		return "tarefa/mostra";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {

		dao.altera(tarefa);

		return "redirect:listaTarefas";
	}

	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id, HttpServletResponse response) {
		dao.finaliza(id);
		response.setStatus(200);
	}

}
