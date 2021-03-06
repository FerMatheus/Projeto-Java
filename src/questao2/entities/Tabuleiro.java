package questao2.entities;

import questao1.entities.Comida;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Comida comida = null;

    public Tabuleiro(int linhas, int colunas, Comida comida) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.comida = comida;
    }

    public void mostrarTabuleiro(Robo r1, Robo r2) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (r1.getLinha() == i && r1.getColuna() == j) {
                    System.out.print(" R" + r1.getCor().toLowerCase().charAt(0));
                    if (r2.getLinha() == i && r2.getColuna() == j) {
                        System.out.print("/" + r2.getCor().toLowerCase().charAt(0));
                    }
                } else if (r2.getLinha() == i && r2.getColuna() == j) {
                    System.out.print(" R" + r2.getCor().toLowerCase().charAt(0));
                } else if (comida.getLinha() == i && comida.getColuna() == j) {
                    System.out.print(" C ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }

    public boolean ganhar(Robo r1, Robo r2) {
        if (!r1.ganhar(comida)) {
            jogadas(r1, r2);
            return false;
        }

        else if (!r2.ganhar(comida)) {
            mostrarTabuleiro(r1, r2);
            jogadas(r1, r2);
            return false;
        }
        return true;
    }

    public void jogadas(Robo r1, Robo r2) {
        System.out.println(" O robo " + r1.getCor() + " jogou " + r1.getJogadas() + " vezes.");
        System.out.println(" O robo " + r2.getCor() + " jogou " + r2.getJogadas() + " vezes.");
    }

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }
}
