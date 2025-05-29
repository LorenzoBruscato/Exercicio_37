package model;

import dao.AlunoDAO;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Aluno extends Pessoa {

    private String curso;
    private int fase;

    public Aluno() {
        this(0, "", 0, "", 0);
    }

    public Aluno(int id, String nome, int idade, String curso, int fase) {
        super(id, nome, idade);
        this.curso = curso;
        this.fase = fase;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    @Override
    public String getNomeFormatado() {
        return getNome().toUpperCase();
    }

    @Override
    public String toString() {
        return super.paraString() + "\n"
                + "Curso: " + getCurso() + "\n"
                + "Fase: " + getFase() + "\n"
                + "--------------------------";
    }

    // CRUD
    public boolean insertAlunoBD(Aluno aluno) {
        AlunoDAO.getMinhaLista().add(aluno);
        return true;
    }

    public boolean deleteAlunoBD(int id) {
        int index = procuraIndice(id);
        if (index != -1) {
            AlunoDAO.getMinhaLista().remove(index);
            return true;
        }
        return false;
    }

    public boolean updateAlunoBD(int id, Aluno novoAluno) {
        int index = procuraIndice(id);
        if (index != -1) {
            AlunoDAO.getMinhaLista().set(index, novoAluno);
            return true;
        }
        return false;
    }

    public ArrayList<Aluno> getMinhaLista() {
        return AlunoDAO.getMinhaLista();
    }

    private int procuraIndice(int id) {
        for (int i = 0; i < AlunoDAO.getMinhaLista().size(); i++) {
            if (AlunoDAO.getMinhaLista().get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
