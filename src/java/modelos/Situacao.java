
package modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Situacao implements Serializable {
    
    public static final Integer EM_ANDAMENTO = 1;
    public static final Integer CONCLUIDA = 2;
    public static final Integer REMOVIDA = 3;
    
    @Id
    @GeneratedValue
    private int id;
    private String descricao;

    public Situacao(int i) {
        this.id = i;
    }

    Situacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
