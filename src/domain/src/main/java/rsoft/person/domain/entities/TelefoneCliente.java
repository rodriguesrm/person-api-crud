package rsoft.person.domain.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TelefoneCliente extends EntityValidable<TelefoneCliente> {

    private final TipoTelefone tipoTelefone;

    @NotNull(message = "O código do país é obrigatório")
    @Min(value = 1, message = "O código do país deve ser maior que zero")
    @Max(value = 999, message = "O código do país deve ser menor que 1000")
    private final Short codigoPais;

    @NotNull(message = "O código de área é obrigatório")
    @Min(value = 1, message = "O código de área deve ser maior que zero")
    @Max(value = 99, message = "O código de área deve ser menor que 100")
    private final Short codigoArea;

    @NotNull(message = "O número de telefone é obrigatório")
    @Min(value = 10000000, message = "O número de telefone deve ter no mínimo 8 dígitos")
    @Max(value = 999999999, message = "O número de telefone deve ter no máximo 9 dígitos")
    private final Integer numeroTelefone;

    private Boolean whatsApp = false;

    private Boolean telegram = false;

    public TelefoneCliente(TipoTelefone tipoTelefone,
                           Short codigoPais,
                           Short codigoArea,
                           Integer numeroTelefone,
                           Boolean whatsApp,
                           Boolean telegram) {
        this.tipoTelefone = tipoTelefone;
        this.codigoPais = codigoPais;
        this.codigoArea = codigoArea;
        this.numeroTelefone = numeroTelefone;
        this.whatsApp = whatsApp;
        this.telegram = telegram;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public Short getCodigoPais() {
        return codigoPais;
    }

    public Short getCodigoArea() {
        return codigoArea;
    }

    public Integer getNumeroTelefone() {
        return numeroTelefone;
    }

    public Boolean getWhatsApp() {
        return whatsApp;
    }

    public Boolean getTelegram() {
        return telegram;
    }
}
