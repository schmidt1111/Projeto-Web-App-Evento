package com.qintess.webapp.dao;

import java.util.List;

//import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableTransactionManagement
public class Dao {
	
		//injeção de dependencia, quando precisa ele abre uma sessionfactory
		@Autowired   
		SessionFactory sessionFactory;
		
		@Transactional
		public <T> void salva(T entidade) {
			org.hibernate.Session session = this.sessionFactory.getCurrentSession();
			session.save(entidade);
		}
		
		@Transactional
		public <T> void deleta(T entidade) {
			org.hibernate.Session session = this.sessionFactory.getCurrentSession();
			session.remove(entidade);
		}
		
		@Transactional
		public <T> void altera(T entidade) {
			org.hibernate.Session session = this.sessionFactory.getCurrentSession();
			session.merge(entidade);
		}
		
		@Transactional
		public <T> T buscaPorId(Class<T> nomeClasse, int id) {
			org.hibernate.Session session = this.sessionFactory.getCurrentSession();
			
			//o get realiza um select com where no id da entidade
			return session.get(nomeClasse, id);
		}
		@Transactional
		public <T> List<T> buscaTodos(Class<T> nomeClasse) {
			org.hibernate.Session session = this.sessionFactory.getCurrentSession();
			
			//a createQuery utiliza JPQL para realizar o select no BD
			//a notação "from nomeClasse" representa um select sem where na Base de Dados
			// a variável nomeClasse.getName() irá retornar o nome da entidade que queremos selecionar (ex. Compra ou Cliente
			//return session.createQuery("select c from " + nomeClasse.getSimpleName() + " c", nomeClasse).getResultList();

			 return session.createQuery("FROM " + nomeClasse.getName()).getResultList();
			//String jpql = "from " + nomeClasse.getName();
			//TypedQuery<T> query = session.createQuery(jpql, nomeClasse);
			//return query.getResultList();
		}
	}


