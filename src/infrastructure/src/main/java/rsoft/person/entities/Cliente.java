package rsoft.person.entities;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Clientes", indexes = {
        @Index(name = "IX_Clientes_Nome", columnList = "Nome"),
        @Index(name = "AK_Clientes_Email", columnList = "Email", unique = true)
})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @Column(precision = 16, scale = 2)
    private BigDecimal renda;

    @OneToMany(mappedBy = "cliente")
    private Set<TelefoneCliente> telefones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public Set<TelefoneCliente> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<TelefoneCliente> telefones) {
        this.telefones = telefones;
    }
}