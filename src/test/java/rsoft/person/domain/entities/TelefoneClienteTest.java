package rsoft.person.domain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneClienteTest {

    @Test
    void deveValidarTelefoneClienteValido() {
        var entity = new TelefoneCliente(
                TipoTelefone.CELULAR,
                (short) 55,
                (short) 11,
                99999999,
                true,
                false
        );
        assertTrue(entity.isValid());
    }

    @Test
    void deveValidarTelefoneClienteValidoComNumeroDe9Digitos() {
        var entity = new TelefoneCliente(
                TipoTelefone.CELULAR,
                (short) 55,
                (short) 11,
                999999999,
                true,
                false
        );
        assertTrue(entity.isValid());
    }

    @Test
    void deveObterDadosCorretamente() {
        var entity = new TelefoneCliente(
                TipoTelefone.COMERCIAL,
                (short) 1,
                (short) 21,
                12345678,
                false,
                true
        );
        assertTrue(entity.isValid());
        assertEquals(TipoTelefone.COMERCIAL, entity.getTipoTelefone());
        assertEquals((short) 1, entity.getCodigoPais());
        assertEquals((short) 21, entity.getCodigoArea());
        assertEquals(12345678, entity.getNumeroTelefone());
        assertFalse(entity.getWhatsApp());
        assertTrue(entity.getTelegram());
    }

    @Test
    void deveFalharQuandoCodigoPaisForNulo() {
        var entity = new TelefoneCliente(
                TipoTelefone.RESIDENCIAL,
                null,
                (short) 11,
                99999999,
                false,
                false
        );
        assertTrue(entity.getViolationMessages().stream().anyMatch(v -> v.key().equals("codigoPais")));
    }

    @Test
    void deveFalharQuandoCodigoAreaForMenorQueMinimo() {
        var entity = new TelefoneCliente(
                TipoTelefone.OUTRO,
                (short) 55,
                (short) 0,
                99999999,
                false,
                false
        );
        assertTrue(entity.getViolationMessages().stream().anyMatch(v -> v.key().equals("codigoArea")));
    }

    @Test
    void deveFalharQuandoNumeroTelefoneForMaiorQueMaximo() {
        var entity = new TelefoneCliente(
                TipoTelefone.RESIDENCIAL,
                (short) 55,
                (short) 11,
                1000000000,
                false,
                false
        );
        assertTrue(entity.getViolationMessages().stream().anyMatch(v -> v.key().equals("numeroTelefone")));
    }
}
