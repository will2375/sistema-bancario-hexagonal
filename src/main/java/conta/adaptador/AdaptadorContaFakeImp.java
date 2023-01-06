package conta.adaptador;

import com.sistema.dominio.modelo.Conta;
import com.sistema.dominio.modelo.NegocioException;
import conta.sistema.porta.ContaRepositorio;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

@Named
public class AdaptadorContaFakeImp implements ContaRepositorio {

    private Map<Integer, Conta> banco = new HashMap<>();

    public AdaptadorContaFakeImp() {
        banco.put(10, new Conta(10, new BigDecimal(100), "Fernando fake"));
        banco.put(20, new Conta(20, new BigDecimal(100), "Rebeca fake"));

    }
    @Override
    public Conta get(Integer numero) {
        System.out.println("fake banco de dados -> conta get(numero)");
        return banco.get(numero);
    }

    @Override
    public void alterar(Conta conta) {
        System.out.println("fake banco de dados -> alterar(conta)");
        var ct = banco.get(conta.getNumero());
        if (!isNull(ct)) {
            banco.put(conta.getNumero(), conta);
        }else {
            throw new NegocioException("conta inexistente: " + conta.getNumero());
        }
    }
}
