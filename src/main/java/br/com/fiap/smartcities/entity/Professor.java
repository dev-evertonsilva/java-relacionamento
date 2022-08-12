package br.com.fiap.smartcities.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="tb_professores")
public class Professor {

    @Id
    @Column(name="cd_professor")
    @SequenceGenerator(name="professor", sequenceName="sq_tb_professor", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "professor")
    private int id_professor;

    @Column(name="nm_professor", nullable = false)
    private String nome;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name="dt_cadastro_professor")
    private Calendar dataCadastroProfessor;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name="dt_modificacao")
    private Calendar dataModificacao;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(joinColumns=@JoinColumn(name="id_aluno"), inverseJoinColumns= @JoinColumn(name="id_professor"), name="tb_aluno_professor")
    private List<Aluno> alunos;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_disciplina")
    private Disciplina disciplina;

    public Professor () { super();}

    public Professor(int id_professor, String nome, Calendar dataCadastroProfessor, List<Aluno> alunos, Disciplina disciplina) {
        this.id_professor = id_professor;
        this.nome = nome;
        this.dataCadastroProfessor = dataCadastroProfessor;
        this.alunos = alunos;
        this.disciplina = disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor){
        this.id_professor = id_professor;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Calendar getDataCadastroProfessor() {
        return dataCadastroProfessor;
    }

    public void setDataCadastroProfessor(Calendar dataCadastroProfessor) {
        this.dataCadastroProfessor = dataCadastroProfessor;
    }

    public Calendar getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Calendar dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
}
