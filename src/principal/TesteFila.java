package principal;

import model.Aluno;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lorenzo
 */
public class TesteFila {
    public static void main(String[] args) {
        Queue<Aluno> fila = new LinkedList<>();

        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                "------ MENU FILA ------\n" +
                "1 - Adicionar aluno\n" +
                "2 - Remover primeiro\n" +
                "3 - Mostrar primeiro\n" +
                "4 - Listar Fila\n" +
                "5 - Verificar se fila está vazia\n" +
                "6 - Mostrar tamanho da fila\n" +
                "0 - Sair\n" +
                "Escolha uma opção:"
            ));

            switch (opcao) {
                case 1:
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do aluno:"));
                    String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
                    int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno:"));
                    String curso = JOptionPane.showInputDialog("Digite o curso do aluno:");
                    int fase = Integer.parseInt(JOptionPane.showInputDialog("Digite a fase do aluno:"));

                    Aluno novoAluno = new Aluno(id, nome, idade, curso, fase);
                    fila.offer(novoAluno);
                    JOptionPane.showMessageDialog(null, "Aluno adicionado na fila.");
                    break;

                case 2:
                    if (!fila.isEmpty()) {
                        Aluno removido = fila.poll();
                        JOptionPane.showMessageDialog(null, "Removido: " + removido.getNome());
                    } else {
                        JOptionPane.showMessageDialog(null, "A fila está vazia.");
                    }
                    break;

                case 3:
                    if (!fila.isEmpty()) {
                        Aluno primeiro = fila.peek();
                        JOptionPane.showMessageDialog(null, "Primeiro da fila: " + primeiro.getNome());
                    } else {
                        JOptionPane.showMessageDialog(null, "A fila está vazia.");
                    }
                    break;

                case 4:
                    if (!fila.isEmpty()) {
                        StringBuilder lista = new StringBuilder();
                        for (Aluno a : fila) {
                            lista.append(a.getId()).append(" - ").append(a.getNome()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, "Conteúdo da Fila:\n" + lista.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "A fila está vazia.");
                    }
                    break;

                case 5:
                    if (fila.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "A fila está vazia.");
                    } else {
                        JOptionPane.showMessageDialog(null, "A fila NÃO está vazia.");
                    }
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Tamanho da fila: " + fila.size());
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (opcao != 0);
    }
}
