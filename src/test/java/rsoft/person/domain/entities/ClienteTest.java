// src/test/java/rsoft/person/domain/ClienteTest.java
package rsoft.person.domain.entities;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveCriarClienteComTodosOsCampos() {
        var cliente = new Cliente(1, "João", "joao@email.com", LocalDate.of(1990, 1, 1), BigDecimal.TEN);
        assertEquals(1, cliente.getId());
        assertEquals("João", cliente.getNome());
        assertEquals("joao@email.com", cliente.getEmail());
        assertEquals(LocalDate.of(1990, 1, 1), cliente.getNascimento());
        assertEquals(BigDecimal.TEN, cliente.getRenda());
        assertTrue(cliente.getTelefones().isEmpty());
    }

    @Test
    void deveCriarClienteSemId() {
        var cliente = new Cliente("Maria", "maria@email.com", LocalDate.of(1985, 5, 20), BigDecimal.ONE);
        assertNull(cliente.getId());
        assertEquals("Maria", cliente.getNome());
    }

    @Test
    void deveAdicionarTelefoneValido() {
        var cliente = new Cliente("Ana", "ana@email.com", LocalDate.of(2000, 2, 2), BigDecimal.ZERO);
        var telefone = new TelefoneCliente(TipoTelefone.CELULAR, (short) 55, (short) 11, 99999999, true, false);
        cliente.addTelefone(telefone);
        assertEquals(1, cliente.getTelefones().size());
        assertEquals(telefone, cliente.getTelefones().get(0));
    }

    @Test
    void deveLancarExcecaoAoAdicionarTelefoneInvalido() {
        var cliente = new Cliente("Carlos", "carlos@email.com", LocalDate.of(1995, 3, 3), BigDecimal.TEN);
        var telefoneInvalido = new TelefoneCliente(TipoTelefone.CELULAR, null, (short) 11, 99999999, true, false);
        var ex = assertThrows(IllegalArgumentException.class, () -> cliente.addTelefone(telefoneInvalido));
        assertTrue(ex.getMessage().contains("Telefone inválido"));
    }

    @Test
    void deveRetornarListaImutavelDeTelefones() {
        var cliente = new Cliente("Pedro", "pedro@email.com", LocalDate.of(1992, 4, 4), BigDecimal.ONE);
        var telefone = new TelefoneCliente(TipoTelefone.RESIDENCIAL, (short) 55, (short) 21, 12345678, false, false);
        cliente.addTelefone(telefone);
        var telefones = cliente.getTelefones();
        assertThrows(UnsupportedOperationException.class, () -> telefones.add(telefone));
    }

    @Test
    void deveFalharValidacaoQuandoNomeForNulo() {
        var cliente = new Cliente(null, "teste@email.com", LocalDate.of(1990, 1, 1), BigDecimal.ZERO);
        assertTrue(cliente.getViolationMessages().stream().anyMatch(v -> v.key().equals("nome")));
    }

    @Test
    void deveFalharValidacaoQuandoEmailForInvalido() {
        var cliente = new Cliente("Teste", "email-invalido", LocalDate.of(1990, 1, 1), BigDecimal.ZERO);
        assertTrue(cliente.getViolationMessages().stream().anyMatch(v -> v.key().equals("email")));
    }

    @Test
    void deveFalharValidacaoQuandoNascimentoForFuturo() {
        var cliente = new Cliente("Teste", "teste@email.com", LocalDate.now().plusDays(1), BigDecimal.ZERO);
        assertTrue(cliente.getViolationMessages().stream().anyMatch(v -> v.key().equals("nascimento")));
    }

    @Test
    void deveFalharValidacaoQuandoRendaForNegativa() {
        var cliente = new Cliente("Teste", "teste@email.com", LocalDate.of(1990, 1, 1), BigDecimal.valueOf(-1));
        assertTrue(cliente.getViolationMessages().stream().anyMatch(v -> v.key().equals("renda")));
    }
}
