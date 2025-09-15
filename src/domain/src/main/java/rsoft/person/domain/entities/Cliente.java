package rsoft.person.domain.entities;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Cliente extends EntityValidable<Cliente> {


    private Integer id;

    @NotNull(message = "O nome é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    private String nome;

    @NotNull(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @Past(message = "A data de nascimento deve ser uma data passada")
    private LocalDate nascimento;

    @PositiveOrZero(message = "A renda deve ser um valor maior ou igual a zero")
    private BigDecimal renda;

    private List<TelefoneCliente> telefones = new ArrayList<>();

    public Cliente(String nome,
                   String email,
                   LocalDate nascimento,
                   BigDecimal renda) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.renda = renda;
    }

    public Cliente(Integer id,
                   String nome,
                   String email,
                   LocalDate nascimento,
                   BigDecimal renda) {
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public List<TelefoneCliente> getTelefones() {
        return unmodifiableList(telefones);
    }

    public void addTelefone(@NotNull final TelefoneCliente telefone) {
        if (telefone.isNotValid())
            throw new IllegalArgumentException("Telefone inválido: " + telefone.getViolationMessages());
        this.telefones.add(telefone);
    }
}
