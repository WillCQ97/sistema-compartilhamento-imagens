package br.ufes.sgi.memento;

import br.ufes.sgi.model.Imagem;
import java.util.Stack;

public class ZeladorImagem {

    private final Stack<Imagem> elementos;
    private static ZeladorImagem instancia;

    private ZeladorImagem() {
        this.elementos = new Stack<>();
    }

    public static ZeladorImagem getInstancia() {
        if (instancia == null) {
            instancia = new ZeladorImagem();
        }
        return instancia;
    }

    public void add(Imagem todo) throws Exception {
        this.elementos.push(todo);

    }

    public Imagem getUltimo() throws Exception {
        if (!elementos.isEmpty()) {
            return elementos.pop();
        }
        throw new Exception("Não há estados salvos");
    }
}
