package br.com.fiap.smartcities.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="tb_aluno")
public class Aluno {

    @Id
    @Column(name="cd_aluno")
    @SequenceGenerator(name="aluno", sequenceName="sq_tb_aluno", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="aluno")
    private int id_aluno;

    @Column(name="nm_aluno", nullable = false)
    private String nome;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name="dt_cadastro_aluno")
    private Calendar dataCadastroAluno;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name="dt_modificacao")
    private Calendar dataModificacao;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(joinColumns=@JoinColumn(name="id_aluno"), inverseJoinColumns = @JoinColumn(name="id_disciplina"), name="tb_aluno_disciplina")
    private List<Disciplina> disciplinas;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(joinColumns=@JoinColumn(name="id_aluno"), inverseJoinColumns= @JoinColumn(name="id_professor"), name="tb_aluno_professor")
    private List<Professor> professores;

    public Aluno(){ super(); }

    public Aluno(int id_aluno, String nome, Calendar dataCadastroAluno, List<Disciplina> disciplinas, List<Professor> professores) {
        this.id_aluno = id_aluno;
        this.nome = nome;
        this.dataCadastroAluno = dataCadastroAluno;
        this.disciplinas = disciplinas;
        this.professores = professores;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataCadastroAluno() {
        return dataCadastroAluno;
    }

    public void setDataCadastroAluno(Calendar dataCadastroAluno) {
        this.dataCadastroAluno = dataCadastroAluno;
    }

    public Calendar getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Calendar dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
}

