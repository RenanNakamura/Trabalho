package br.unicesumar.restserver.Disciplina;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Disciplina {
    @Id
    private long id;
    private String nome;
    private int cargaHoraria;
    private double peso;

    public Disciplina() {
    }

    public Disciplina(long id, String nome, int cargaHoraria, double peso) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.peso = peso;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public double getPeso() {
        return peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
