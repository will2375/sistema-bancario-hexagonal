module conta.sistema {

    requires javax.inject;
    requires spring.tx;
    requires spring.boot.autoconfigure;
    requires spring.boot;


    // expondo porta de entrada (driver)

    exports conta.sistema.casouso.imp;

    // expondo sistema negocio

    exports conta.sistema.dominio.servico;

    // expondo adaptadores de saídas (driven)

    exports conta.adaptador;
}