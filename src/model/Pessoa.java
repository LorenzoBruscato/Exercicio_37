package model;

import javax.swing.JOptionPane;

/**
 *
 * @author Lorenzo
 */
public abstract class Pessoa {
    private int id;
    private String nome;
    private int idade;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public abstract String getNomeFormatado();

    public void leitura() {
        setNome(JOptionPane.showInputDialog("Digite o seu nome:"));
        setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a sua idade:")));
    }

    public void imprimir() {
        JOptionPane.showMessageDialog(null, paraString());
    }

    public String paraString() {
        return "ID: " + getId() + "\n" +
               "Nome: " + getNome() + "\n" +
               "Idade: " + getIdade();
    }
}
