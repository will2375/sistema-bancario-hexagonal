package teste.casouso;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        //objetos de sistema
        "conta.sistema",
        //adptadores falsos
        "conta.adaptador"})
public class Build1 {
    // Build1 - Adaptadora teste -> Sistema <- Adaptadora Mock
}
