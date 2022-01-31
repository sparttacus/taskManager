package modelos;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tarefa.class)
public abstract class Tarefa_ {

	public static volatile SingularAttribute<Tarefa, Situacao> situacao;
	public static volatile SingularAttribute<Tarefa, Prioridade> prioridade;
	public static volatile SingularAttribute<Tarefa, String> titulo;
	public static volatile SingularAttribute<Tarefa, Integer> id;
	public static volatile SingularAttribute<Tarefa, Date> deadline;
	public static volatile SingularAttribute<Tarefa, Pessoa> responsavel;
	public static volatile SingularAttribute<Tarefa, String> descricao;

}

