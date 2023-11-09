package br.edu.ifpb.pdist.back.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@EqualsAndHashCode(exclude = {"instituicao", "declaracoes"})
@AllArgsConstructor
@Entity
public class Medico implements Serializable {

    // Para garantir que a assinatura de um número seja única , para o uso do @Id
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nome;

    private String crm;

    private String sexo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    @Past(message = "Data deve ser no passado")
    private Date dataNascimento;

    private String especialidade;

    private String telefone;

    public void setName(String name) {
        if(name.isBlank())
            throw new IllegalArgumentException("Nome nao pode ser vazio!");
        this.nome = name;
    }

    public void setCrm(String crm) {
        if(crm.length() != 7)
            throw new IllegalArgumentException("CRM deve conter 7 digitos!");
        if(crm.isBlank())
            throw new IllegalArgumentException("CRM nao pode ser vazio!");    
        this.crm = crm;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Medico(String name, String crm, String sexo, String especialidade, String telefone) {
        this.nome = name;
        this.crm = crm;
        this.sexo = sexo;
        this.especialidade = especialidade;
        this.telefone = telefone;
    }
}
