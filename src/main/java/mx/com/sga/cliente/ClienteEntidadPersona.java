package mx.com.sga.cliente;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mx.com.sga.domain.Persona;

public class ClienteEntidadPersona {
	public static void main(String[] args) {
		Logger log = Logger.getLogger("PruebaClienteEntidadPersona");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//No se debe especificar el ID, ya que se genera en automático
		Persona persona1 = new Persona("Ana", "Gomez", "Paz", "anamariaGP@live.com.mx", "8111152");
		log.debug("Objeto a persistir:" + persona1);
		em.persist(persona1);
		tx.commit();
		log.debug("Objeto persistido:" + persona1);
		em.close();
		}
}
