
package apoio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelos.Pessoa;
import modelos.Prioridade;
import modelos.Situacao;
import modelos.Tarefa;

@ManagedBean
@SessionScoped
public class TarefaBean {

    private Tarefa tarefa = new Tarefa();
    private List<Tarefa> tarefas;
    
    private List<Prioridade> prioridades = new ArrayList<>();
    private List<Situacao> situacoes = new ArrayList<>();
    private List<Pessoa> pessoas = new ArrayList<>();
    
    private List<SelectItem> allPrioridades = new ArrayList<>();
    private List<SelectItem> allSituacoes = new ArrayList<>();
    private List<SelectItem> allPessoas = new ArrayList<>();
    
    private boolean novaTarefa = false;

    private Date dataMin;
    
    /* Filtros para busca */
    private Integer filtroNumero = 0;
    private String filtroTituloDescricao = "";
    private Integer filtroSituacao = 0;
    private Integer filtroResponsavel = 0;
    
    
    public TarefaBean() {
        tarefa.setId(null);
        clear();
    }
    
    public void clear(){
        this.prioridades.clear();
        this.situacoes.clear();
        this.pessoas.clear();
        this.allPrioridades.clear();
        this.allSituacoes.clear();
        this.allPessoas.clear();
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public String salva() {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            em.getTransaction().begin();
            // Verifica se a tarefa ainda não está salva no banco de dados.
            if (tarefa.getId() == null) {
                //Salva os dados da tarefa.
                em.persist(tarefa);
            } else {
                //Atualiza os dados da tarefa.
                tarefa = em.merge(tarefa);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        this.tarefas = null;
        return "ListarTarefas";
    }

    public List<Tarefa> getTarefas() {

        if (this.tarefas == null) {
            EntityManager em = JPAUtil.getEntityManager();
            Query q = em.createQuery("select a from Tarefa a where a.situacao.id != 3 ",
                    Tarefa.class);
            this.tarefas = q.getResultList();
            em.close();
        }
        return tarefas;
    }
    
    public List<Tarefa> buscaTarefas() {
       
            EntityManager em = JPAUtil.getEntityManager();
            String query = " select t from Tarefa t where 1=1 ";
            if(filtroNumero != 0){
                query = query.concat(" and t.id = ").concat(filtroNumero.toString());
            }
            if(!filtroTituloDescricao.isEmpty()){
                query = query.concat(" and upper(t.titulo) like upper('%").concat(filtroTituloDescricao).concat("%') or upper(t.descricao) like upper('%").concat(filtroTituloDescricao).concat("%') ");
            }
            if(filtroResponsavel != 0){
                query = query.concat(" and t.responsavel.id = ").concat(filtroResponsavel.toString());
            }
            if(filtroSituacao != 0){
                query = query.concat(" and t.situacao.id = ").concat(filtroSituacao.toString());
            }
            query = query.concat(" order by t.id asc");
            Query q = em.createQuery(query,
                    Tarefa.class);
            this.tarefas = q.getResultList();
            em.close();
            clear();
    
        return tarefas;
    }

    public void excluir(Tarefa tarefa) {

        if (tarefa.getId() != null) {
            EntityManager em = JPAUtil.getEntityManager();

            System.out.println(tarefa.getId() + ", " + tarefa.getTitulo());
            em.getTransaction().begin();
            tarefa.setSituacao(new Situacao(Situacao.REMOVIDA));
            tarefa = em.merge(tarefa);
            //em.remove(tarefa);
            em.getTransaction().commit();
            em.close();
        }

        this.tarefas = null;

    }
    
     public void concluir(Tarefa tarefa) {

        if (tarefa.getId() != null) {
            EntityManager em = JPAUtil.getEntityManager();

            System.out.println(tarefa.getId() + ", " + tarefa.getTitulo());
            em.getTransaction().begin();
            tarefa.setSituacao(new Situacao(Situacao.CONCLUIDA));
            tarefa = em.merge(tarefa);
            em.getTransaction().commit();
            em.close();
        }

        this.tarefas = null;

    }

    public String alterar(Tarefa t) {
        clear();
        this.tarefa = t;
        return "CadastrarTarefa";
    }

    public String cadastrarNovo(String complemento) {
        novaTarefa = true;
        clear();
        tarefa = new Tarefa();
        tarefa.setSituacao(new Situacao(Situacao.EM_ANDAMENTO));
        return complemento + "CadastrarTarefa";
    }
    
    public List<SelectItem> getAllPrioridades(){
        EntityManager em = JPAUtil.getEntityManager();
            Query q = em.createQuery("select p from Prioridade p",
                    Prioridade.class);
            prioridades = q.getResultList();
            em.close();
            
            if(!prioridades.isEmpty()){
                for(Prioridade p : prioridades){
                   allPrioridades.add(new SelectItem(p.getId(), p.getDescricao()));                }
            }
       
        return allPrioridades;
    }  
    
    public List<SelectItem> getAllSituacoes(){
        EntityManager em = JPAUtil.getEntityManager();
            Query q = em.createQuery("select s from Situacao s",
                    Situacao.class);
            situacoes = q.getResultList();
            em.close();
            
            if(!situacoes.isEmpty()){
                for(Situacao s : situacoes){
                   allSituacoes.add(new SelectItem(s.getId(), s.getDescricao()));                }
            }
        return allSituacoes;
    }
    
    public List<SelectItem> getAllPessoas(){
        EntityManager em = JPAUtil.getEntityManager();
            Query q = em.createQuery("select p from Pessoa p",
                    Pessoa.class);
            pessoas = q.getResultList();
            em.close();
            
            if(!pessoas.isEmpty()){
                for(Pessoa p : pessoas){
                   allPessoas.add(new SelectItem(p.getId(), p.getNome()));                }
            }
        return allPessoas;
    } 

    public boolean isNovaTarefa() {
        return novaTarefa;
    }

    public void setNovaTarefa(boolean novaTarefa) {
        this.novaTarefa = novaTarefa;
    }  
    
    public Date getDataMin(){
        return new java.util.Date(System.currentTimeMillis()); 
    } 

    public int getFiltroNumero() {
        return filtroNumero;
    }

    public void setFiltroNumero(int filtroNumero) {
        this.filtroNumero = filtroNumero;
    }

    public String getFiltroTituloDescricao() {
        return filtroTituloDescricao;
    }

    public void setFiltroTituloDescricao(String filtroTituloDescricao) {
        this.filtroTituloDescricao = filtroTituloDescricao;
    }

    public int getFiltroSituacao() {
        return filtroSituacao;
    }

    public void setFiltroSituacao(int filtroSituacao) {
        this.filtroSituacao = filtroSituacao;
    }

    public int getFiltroResponsavel() {
        return filtroResponsavel;
    }

    public void setFiltroResponsavel(int filtroResponsavel) {
        this.filtroResponsavel = filtroResponsavel;
    }
    
}
