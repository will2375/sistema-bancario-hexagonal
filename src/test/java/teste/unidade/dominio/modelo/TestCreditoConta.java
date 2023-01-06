package teste.unidade.dominio.modelo;

import com.sistema.dominio.modelo.Conta;
import com.sistema.dominio.modelo.NegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("regra de credito da conta")
public class TestCreditoConta {

    BigDecimal cem = new BigDecimal(100);
    Conta contaValida;

    @BeforeEach
    void preparar() {
        contaValida = new Conta(1, cem, "Rebeca");
    }

    @Test
    @DisplayName("valor credito nulo como obrigarorio")
    void teste1() {
        try {
            contaValida.creditar(null);
            fail("valor credito obrigatorio");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "valor credito é obrigatorio");
        }
    }

    @Test
    @DisplayName("valor credito  negativo como obrigarorio")
    void teste2() {
        try {
            contaValida.creditar(new BigDecimal(-10));
            fail("valor credito obrigatorio");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "valor credito é obrigatorio");
        }
    }

    @Test
    @DisplayName("valor credito zero como obrigarorio")
    void teste3() {
        try {
            contaValida.creditar(new BigDecimal(0));
            fail("valor credito obrigatorio");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "valor credito é obrigatorio");
        }
    }

    @Test
    @DisplayName("valor credito acima de 0")
    void teste4() {
        try {
            contaValida.creditar(BigDecimal.ONE);
            var saldofinal = cem.add(BigDecimal.ONE);
            assertEquals(contaValida.getSaldo(), saldofinal, "saldo deve bater");
        } catch (NegocioException e) {
            fail("deve creditar com sucesso - " + e.getMessage());
        }
    }
}
