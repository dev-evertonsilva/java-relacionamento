package br.com.fiap.smartcities.teste;

import br.com.fiap.smartcities.entity.Aluno;
import br.com.fiap.smartcities.entity.Disciplina;
import br.com.fiap.smartcities.entity.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CasdastraCascade {
    public static void main(String[] args) {

        EntityManager em = Persistence.createEntityManagerFactory("smartcities").createEntityManager();

        //Cadastro em cascade

        //Cadastra disciplina
        Disciplina disciplinas1 = new Disciplina(0, "Matemática", new GregorianCalendar(2015, Calendar.JANUARY, 5), null, null);
        Disciplina disciplinas2 = new Disciplina(0, "Português", new GregorianCalendar(2018,Calendar.FEBRUARY,7), null, null);

        //Lista disciplina
        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinas.add(disciplinas1);
        disciplinas.add(disciplinas2);

        //Cadastra Professor com disciplina
        Professor prof1 = new Professor(0, "Fernanda", new GregorianCalendar(2017, Calendar.APRIL, 9),null, disciplinas1);
        Professor prof2 = new Professor(0, "Natalia", new GregorianCalendar(2018, Calendar.AUGUST, 3),null, disciplinas2);

        //Lista professor
        List<Professor> professores = new ArrayList<>();
        professores.add(prof1);
        professores.add(prof2);

        //Cadastra Aluno com Professor e disciplina
        Aluno aluno1 = new Aluno(0, "Everton", new GregorianCalendar(2022, Calendar.JANUARY, 10), disciplinas, professores );
        Aluno aluno2 = new Aluno(0, "Jessica", new GregorianCalendar(2021, Calendar.FEBRUARY, 1), disciplinas, professores );

        em.persist(aluno1);
        em.persist(aluno2);

        em.getTransaction().begin();
        em.getTransaction().commit();


        em.close();

    }
}
