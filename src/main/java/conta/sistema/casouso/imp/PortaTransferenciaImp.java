package conta.sistema.casouso.imp;

import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.servico.Transferencia;
import conta.sistema.casouso.porta.PortaTransferencia;
import conta.sistema.porta.ContaRepositorio;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.math.BigDecimal;

import static conta.sistema.dominio.modelo.Erro.*;
import static java.util.Objects.isNull;

@Named
public class PortaTransferenciaImp implements PortaTransferencia {

    private ContaRepositorio repositorio;
    private Transferencia transferencia;

    public PortaTransferenciaImp(ContaRepositorio repositorio, Transferencia transferencia) {
        this.repositorio = repositorio;
        this.transferencia = transferencia;
    }

    @Override
    public Conta getConta(Integer numero) {
        return repositorio.get(numero);
    }

    @Override
    @Transactional
    public void transferir(Integer contaDebito, Integer contaCredito, BigDecimal valor) {
        // 1. validação de parametros
        if (isNull(contaDebito)) {
            obrigatorio("conta debito");
        }
        if (isNull(contaCredito)) {
            obrigatorio("conta credito");
        }
        if (isNull(valor)) {
            obrigatorio("valor");
        }
        //2. validação das contas
        var debito = repositorio.get(contaDebito);
        if (isNull(debito)) {
            inexistente("conta debito");
        }
        var credito = repositorio.get(contaCredito);
        if (isNull(credito)) {
            inexistente("conta credito");
        }

        //3. validação da mesma conta
        if (debito.getNumero().equals(credito.getNumero())) {
            mesmaConta();
        }

        //4. operação
        transferencia.transferencia(valor, debito, credito);
        repositorio.alterar(debito);
        repositorio.alterar(credito);
    }
}
