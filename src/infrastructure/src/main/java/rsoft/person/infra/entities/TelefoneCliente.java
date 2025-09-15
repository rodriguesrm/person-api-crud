package rsoft.person.infra.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TelefonesCliente")
@IdClass(TelefoneClienteId.class)
public class TelefoneCliente {

    @Id
    @Column(name = "TipoTelefoneId")
    private Integer tipoTelefoneId;

    @Id
    @Column(name = "ClienteId")
    private Integer clienteId;

    @ManyToOne
    @JoinColumn(name = "TipoTelefoneId", insertable = false, updatable = false)
    private TipoTelefone tipoTelefone;

    @ManyToOne
    @JoinColumn(name = "ClienteId", insertable = false, updatable = false)
    private Cliente cliente;

    @Column(nullable = false)
    private Short codigoPais;

    @Column(nullable = false)
    private Short codigoArea;

    @Column(nullable = false)
    private Integer numeroTelefone;

    @Column(nullable = false)
    private Boolean whatsApp = false;

    @Column(nullable = false)
    private Boolean telegram = false;

    public Integer getTipoTelefoneId() {
        return tipoTelefoneId;
    }

    public void setTipoTelefoneId(Integer tipoTelefoneId) {
        this.tipoTelefoneId = tipoTelefoneId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Short getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(Short codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Short getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(Short codigoArea) {
        this.codigoArea = codigoArea;
    }

    public Integer getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(Integer numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Boolean getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(Boolean whatsApp) {
        this.whatsApp = whatsApp;
    }

    public Boolean getTelegram() {
        return telegram;
    }

    public void setTelegram(Boolean telegram) {
        this.telegram = telegram;
    }
}