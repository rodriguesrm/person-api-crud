package rsoft.person.entities;

import java.io.Serializable;
import java.util.Objects;

public class TelefoneClienteId implements Serializable {

    private Integer tipoTelefoneId;
    private Integer clienteId;

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TelefoneClienteId)) return false;
        TelefoneClienteId that = (TelefoneClienteId) o;
        return Objects.equals(tipoTelefoneId, that.tipoTelefoneId) &&
                Objects.equals(clienteId, that.clienteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoTelefoneId, clienteId);
    }

}