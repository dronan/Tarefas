package br.com.caelum.tarefas.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.caelum.tarefas.jdbc.bean.Usuario;


	public class GeraTabelas {
		public static void main(String[] args) {
			Configuration cfg = new Configuration();
			cfg.configure();
			cfg.addAnnotatedClass(Usuario.class);
					
			SchemaExport se = new SchemaExport(cfg);
			se.create(true, true);
		}
	}


