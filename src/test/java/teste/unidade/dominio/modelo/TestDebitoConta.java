package teste.unidade.dominio.modelo;

import conta.sistema.modelo.Conta;
import conta.sistema.modelo.NegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("regra de debito da conta")
public class TestDebitoConta {

    BigDecimal cem = new BigDecimal(100);
    Conta contaValida;

    @BeforeEach
    void preparar() {
        contaValida = new Conta(1, cem, "Rebeca");
    }

    @Test
    @DisplayName("valor debito nulo como obrigarorio")
    void teste1() {
        try {
            contaValida.debitar(null);
            fail("valor debito obrigatorio");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "valor debito é obrigatorio");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("valor debito  negativo como obrigarorio")
    void teste2() {
        try {
            contaValida.debitar(new BigDecimal(-10));
            fail("valor debito obrigatorio");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "valor debito é obrigatorio");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("valor debito zero como obrigarorio")
    void teste3() {
        try {
            contaValida.debitar(new BigDecimal(0));
            fail("valor debito obrigatorio");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "valor debito é obrigatorio");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("valor debito acima do saldo")
    void teste4() {
        try {
            contaValida.debitar(cem.add(BigDecimal.ONE));
            fail("valor debito acima do saldo");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "saldo insuficiente");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("valor debito igual do saldo")
    void teste5() {
        try {
            contaValida.debitar(cem);
            assertEquals(contaValida.getSaldo(), BigDecimal.ZERO, "saldo deve zerar");
        } catch (NegocioException e) {
            fail("deve debitar com sucesso" + e.getMessage());
        }
    }

    @Test
    @DisplayName("valor debito menor do saldo")
    void teste6() {
        try {
            contaValida.debitar(BigDecimal.TEN);
            var saldoFinal = cem.subtract(BigDecimal.TEN);
            assertEquals(contaValida.getSaldo(), saldoFinal, "saldo deve zerar");
        } catch (NegocioException e) {
            fail("deve debitar com sucesso" + e.getMessage());
        }
    }
}
