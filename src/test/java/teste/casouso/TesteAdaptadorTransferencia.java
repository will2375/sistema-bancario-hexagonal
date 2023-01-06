package teste.casouso;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisplayName("caso de uso - Serviço de transferencia")
@ContextConfiguration(classes = Build1.class)
@ExtendWith(SpringExtension.class)
public class TesteAdaptadorTransferencia {

    @Test
    @DisplayName("pesquisa conta com numero nulo")
    void teste1() {
        System.out.println("ola");
    }
}
