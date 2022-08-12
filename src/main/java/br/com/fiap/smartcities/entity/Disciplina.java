package br.com.fiap.smartcities.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="tb_disciplina")
public class Disciplina {

    @Id
    @Column(name="cd_disciplina")
    @SequenceGenerator(name="disciplina", sequenceName ="sq_tb_disciplina",allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="disciplina")
    private int id_disciplina;

    @Column(name="nm_disciplina", nullable = false)
    private String nome;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name="dt_cadastro")
    private Calendar dataCadastro;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(joinColumns=@JoinColumn(name="id_aluno"), inverseJoinColumns = @JoinColumn(name="id_disciplina"), name="tb_aluno_disciplina")
    private List<Aluno> alunos;

    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_disciplina")
    private List<Professor> professores;

    public Disciplina(){
        super();
    }

    public Disciplina(int id_disciplina, String nome, Calendar dataCadastro, List<Aluno> alunos, List<Professor> professores) {
        this.id_disciplina = id_disciplina;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.alunos = alunos;
        this.professores = professores;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public int getId() {
        return id_disciplina;
    }

    public void setId(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


}
