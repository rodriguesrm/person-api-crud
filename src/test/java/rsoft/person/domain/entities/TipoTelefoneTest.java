package rsoft.person.domain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TipoTelefoneTest {

    @Test
    void deveRetornarIdCorretoParaCadaTipo() {
        assertEquals(1, TipoTelefone.RESIDENCIAL.getId());
        assertEquals(2, TipoTelefone.COMERCIAL.getId());
        assertEquals(3, TipoTelefone.CELULAR.getId());
        assertEquals(4, TipoTelefone.OUTRO.getId());
    }

    @Test
    void deveRetornarDescricaoCorretaParaCadaTipo() {
        assertEquals("RESIDENCIAL", TipoTelefone.RESIDENCIAL.getDescricao());
        assertEquals("COMERCIAL", TipoTelefone.COMERCIAL.getDescricao());
        assertEquals("CELULAR", TipoTelefone.CELULAR.getDescricao());
        assertEquals("OUTRO", TipoTelefone.OUTRO.getDescricao());
    }

    @Test
    void deveConterTodosOsValoresEsperados() {
        TipoTelefone[] valores = TipoTelefone.values();
        assertArrayEquals(
                new TipoTelefone[]{TipoTelefone.RESIDENCIAL, TipoTelefone.COMERCIAL, TipoTelefone.CELULAR, TipoTelefone.OUTRO},
                valores
        );
    }
}
