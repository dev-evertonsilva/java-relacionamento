package br.com.fiap.smartcities.teste;

import br.com.fiap.smartcities.entity.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ListaAlteraRemoveAluno {

    public static void main(String[] args) {

        EntityManager em = Persistence.createEntityManagerFactory("smartcities").createEntityManager();

        //Lista Aluno
        Aluno aluno = em.find(Aluno.class, 1);
        System.out.println(aluno.getId_aluno() + " " + aluno.getNome());

        //Altera Aluno
        aluno.setNome("Jordan");
        System.out.println(aluno.getId_aluno() + " " + aluno.getNome());

        //Remove registro
        em.remove(aluno);

        em.getTransaction().begin();
        em.getTransaction().commit();

        em.close();


    }


}
