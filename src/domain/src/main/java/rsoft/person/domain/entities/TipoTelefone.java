package rsoft.person.domain.entities;

public enum TipoTelefone {

    RESIDENCIAL(1, "RESIDENCIAL"),
    COMERCIAL(2, "COMERCIAL"),
    CELULAR(3, "CELULAR"),
    OUTRO(4, "OUTRO");

    private final Integer id;
    private final String descricao;

    TipoTelefone(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

}
