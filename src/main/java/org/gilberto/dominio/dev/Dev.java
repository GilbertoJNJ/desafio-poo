package org.gilberto.dominio.dev;

import org.gilberto.dominio.Bootcamp;
import org.gilberto.dominio.conteudo.Conteudo;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Dev implements IDev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.nome = nome;
    }

    @Override
    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    @Override
    public void progredir() {
        this.conteudosInscritos.stream()
                .findFirst()
                .ifPresentOrElse(conteudo -> {
                            this.conteudosInscritos.remove(conteudo);
                            this.conteudosConcluidos.add(conteudo);
                        },
                        () -> System.err.println("Você não está matriculado em nenhum conteúdo!")
                );
        System.out.println("Progredindo...");
    }

    @Override
    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    @Override
    public void exibirProgresso() {
        System.out.println("Conteúdos Inscritos:" + conteudosInscritos);
        System.out.println("Conteúdos Concluídos:" + conteudosConcluidos);
        System.out.println("XP:" + this.calcularTotalXp());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
