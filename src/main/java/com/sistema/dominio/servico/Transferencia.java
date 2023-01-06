package com.sistema.dominio.servico;

import com.sistema.dominio.modelo.Conta;

import java.math.BigDecimal;

import static com.sistema.dominio.modelo.Erro.obrigatorio;
import static java.util.Objects.isNull;

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
