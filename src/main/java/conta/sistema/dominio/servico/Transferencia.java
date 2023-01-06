package conta.sistema.dominio.servico;

import conta.sistema.dominio.modelo.Conta;

import javax.inject.Named;
import java.math.BigDecimal;

import static conta.sistema.dominio.modelo.Erro.obrigatorio;
import static java.util.Objects.isNull;

@Named
public class Transferencia  {
    public void transferencia(BigDecimal valor, Conta debito, Conta credito) {
        if (isNull(valor)) {
            obrigatorio("valor da transferencia");
        }
        if (isNull(debito)) {
            obrigatorio("conta debito");
        }
        if (isNull(credito)) {
            obrigatorio("conta credito");
        }
        debito.debitar(valor);
        credito.creditar(valor);
    }
}
