package org.gilberto.dominio.dev;

import org.gilberto.dominio.Bootcamp;

public interface IDev {
    void inscreverBootcamp(Bootcamp bootcamp);

    void progredir();

    double calcularTotalXp();

    void exibirProgresso();
}
