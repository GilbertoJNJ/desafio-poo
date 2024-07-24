package org.gilberto;

import org.gilberto.dominio.Bootcamp;
import org.gilberto.dominio.conteudo.Curso;
import org.gilberto.dominio.conteudo.Mentoria;
import org.gilberto.dominio.dev.Dev;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso(
                "Curso 1",
                "Descrição do curso 1",
                8
        );

        Curso curso2 = new Curso(
                "Curso 2",
                "Descrição do curso 2",
                4
        );

        Mentoria mentoria = new Mentoria(
                "Mentoria 1",
                "Descrição da mentoria 1",
                LocalDate.now()
        );

        Bootcamp bootcamp = new Bootcamp(
                "Bootcamp Java Developer",
                "Descrição Bootcamp Java Developer"
        );
        bootcamp.getConteudos().addAll(
                Arrays.asList(curso1, curso2, mentoria)
        );

        System.out.println("--- Dev 1 ---");
        Dev dev1 = new Dev("Dev 1");
        dev1.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos:" + dev1.getConteudosInscritos());
        dev1.progredir();
        dev1.progredir();
        dev1.exibirProgresso();

        System.out.println("\n--- Dev 2 ---");
        Dev dev2 = new Dev("Dev 2");
        dev2.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos:" + dev2.getConteudosInscritos());
        dev2.progredir();
        dev2.progredir();
        dev2.progredir();
        dev2.exibirProgresso();
    }
}