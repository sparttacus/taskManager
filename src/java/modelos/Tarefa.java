package modelos;

import java.io.Serializable;
import javax.persistence.Id;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Tarefa implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    private String descricao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date deadline;
   
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idResponsavel", referencedColumnName = "id")
    private Pessoa responsavel;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSituacao", referencedColumnName = "id")
    private Situacao situacao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPrioridade", referencedColumnName = "id")
    private Prioridade prioridade;
    

    public Tarefa() {
        this.responsavel = new Pessoa() {};
        this.situacao = new Situacao();
        this.prioridade = new Prioridade();
    }

    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
    
    
    
}
