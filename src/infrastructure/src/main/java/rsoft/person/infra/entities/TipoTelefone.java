package rsoft.person.infra.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TiposTelefone", uniqueConstraints = {
        @UniqueConstraint(name = "AK_TiposTelefone_Descricao", columnNames = "Descricao")
})
public class TipoTelefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30, nullable = false, unique = true)
    private String descricao;

    @OneToMany(mappedBy = "tipoTelefone")
    private Set<TelefoneCliente> telefones;

    // getters e setters
}