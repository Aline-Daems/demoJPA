package repositories;

import Entities.Movies;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CRUD {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
    private final EntityManager em;

    public  CRUD(){
        em = emf.createEntityManager();
    }

    public Movies add (Movies movies){
        em.getTransaction().begin();
        em.persist(movies);
        em.getTransaction().commit();
        em.detach(movies);

        return movies;
    }

    public Movies getOne(Long id){
        return em.find(Movies.class, id);
    }

    public List<Movies> getAll(){
        TypedQuery<Movies> query = em.createQuery("select  m from Movies  m", Movies.class);
        return query.getResultList();

    }

    public void update(Movies movies){
        em.getTransaction().begin();
        em.merge(movies);
        em.getTransaction().commit();
    }

    public void delete(Movies movies){

        em.getTransaction().begin();
        Movies m =  em.merge(movies);
        em.remove(m);

    }

    public List<Movies> search(String titre){
        return em.createQuery("select m from Movies m WHERE m.titre = :titre", Movies.class)
                .setParameter("titre", titre)
                .getResultList();
    }
}
