package br.com.fiap.smartcities.teste;

import br.com.fiap.smartcities.entity.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ListaAlteraRemoveProfessor {

    public static void main(String[] args) {

        EntityManager em = Persistence.createEntityManagerFactory("smartcities").createEntityManager();

        //Lista Professor
        Professor professor = em.find(Professor.class, 1);
        System.out.println(professor.getId_professor() + " " + professor.getNome());

        //Altera Professor
        professor.setNome("Maria");
        System.out.println(professor.getId_professor() + " " + professor.getNome());

        em.remove(professor);

        em.getTransaction().begin();
        em.getTransaction().commit();

        em.close();
    }
}
