package teste.unidade.dominio.servico;


import com.sistema.dominio.modelo.Conta;
import com.sistema.dominio.modelo.NegocioException;
import com.sistema.dominio.servico.Transferencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("regra de transferencia")
public class TesteTransferencia {

    BigDecimal cem = new BigDecimal(100);
    BigDecimal vinte = new BigDecimal(20);
    Transferencia trans;
    Conta contaDebito;
    Conta contaCredito;

    @BeforeEach
    void preparar() {
        contaDebito = new Conta(1, cem, "Fernando");
        contaCredito = new Conta(2, cem, "Rebeca");
        trans = new Transferencia();
    }

    @Test
    @DisplayName("valor  nulo como obrigarorio")
    void teste1() {
        try {
            trans.transferencia(null, contaDebito, contaCredito);
            fail("valor transferencia como obrigatorio");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "valor da transferencia é obrigatorio");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("conta de debito como obrigarorio")
    void teste2() {
        try {
            trans.transferencia(vinte, null, contaCredito);
            fail("conta debito obrigatorio");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "conta debito é obrigatorio");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("conta de credito como obrigarorio")
    void teste3() {
        try {
            trans.transferencia(vinte, contaDebito, null);
            fail("conta credito obrigatorio");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "conta credito é obrigatorio");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("transferir 20 reais")
    void teste4() {
        try {
            trans.transferencia(vinte, contaDebito, contaCredito);
            assertEquals(contaDebito.getSaldo(), cem.subtract(vinte), "saldo conta debito deve bater");
            assertEquals(contaCredito.getSaldo(), cem.add(vinte), "saldo conta credito deve bater");
        } catch (NegocioException e) {
            fail("deve transferir c sucesso");
        }
    }
}
