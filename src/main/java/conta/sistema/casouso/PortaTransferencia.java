package conta.sistema.casouso;

import com.sistema.dominio.modelo.Conta;

import java.math.BigDecimal;

public interface PortaTransferencia {
    Conta getConta(Integer numero);
    void transferir(Integer contaDebito, Integer contaCredito, BigDecimal valor);
}
