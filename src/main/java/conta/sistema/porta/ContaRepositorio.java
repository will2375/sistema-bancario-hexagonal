package conta.sistema.porta;

import com.sistema.dominio.modelo.Conta;

public interface ContaRepositorio {
    Conta get(Integer numero);
    void alterar(Conta conta);
}
