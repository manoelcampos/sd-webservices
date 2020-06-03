package com.manoelcampos.server.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Representa uma Cidade.
 *
 * <p>Observe que todos os atributos são públicos,
 * indo totalmente contra tudo o que é ensinado sobre encapsulamento
 * em POO.
 * No entanto, como estamos usando a biblioteca
 * <a href="https://quarkus.io/guides/hibernate-orm-panache">Quarkus Panache</a>,
 * ele "automagicamente" inclui getters e setters para todos os atributos.
 * </p>
 *
 * <p>
 * É feita uma bruxaria (usando recursos avançados da linguagem) toda vez que
 * tentarmos: (i) obter o valor de um atributo, o getter é chamado automaticamente,
 * ou (ii) alterar o valor de um atributo, o setter é chamado automaticamente.
 * Se precisarmos programar qualquer lógica em algum getter e setter,
 * basta incluí-los manualmente como fazemos convencionalmente.
 * Assim, os atributos são públicos, parecem não estarem encapsulados,
 * mas por conta da magia negra realizada pelo Panache, eles estão :D
 * </p>
 *
 * <p>Adicionalmente, também não precisamos incluir um atributo id
 * para a classe, pois ao extender {@link PanacheEntity},
 * um id é fornecido, juntamente comm todas as funcionalidades
 * necessárias para manipular o cadastro dos clientes no banco de dados.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
@Entity
public class Cidade  extends PanacheEntity implements Serializable {
    public String nome;
    public String uf;

    public static boolean update(Cidade cidade) {
        Cidade existente = Cidade.findById(cidade.id);
        if(existente != null){
            existente.nome = cidade.nome;
            existente.uf = cidade.uf;
            existente.persist();
            return true;
        }

        return false;
    }

}
