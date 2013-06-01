package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.jdbc.bean.Usuario;
import br.com.caelum.tarefas.jdbc.dao.UsuarioDAO;

@Controller
@Transactional
public class LoginController {

	@Autowired
	public UsuarioDAO dao;
	
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "formulario-login";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session){
		
		boolean retornoUsuario = false;
		retornoUsuario = dao.existeUsuario(usuario);
		
		if (retornoUsuario == true){
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:loginForm";
	}
}
