package rsoft.person.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Cliente {

    private Integer id;
    private String nome;
    private String email;
    private java.util.Date nascimento;
    private java.math.BigDecimal renda;
    private List<TelefoneCliente> telefones = new ArrayList<>();

    public Cliente(Integer id, String nome, String email, Date nascimento, BigDecimal renda) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.renda = renda;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public List<TelefoneCliente> getTelefones() {
        return unmodifiableList(telefones);
    }
}
