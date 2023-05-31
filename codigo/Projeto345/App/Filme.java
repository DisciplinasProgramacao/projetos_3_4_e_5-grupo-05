
public class Filme extends Conteudo {

    private int duracao;

    public Filme(int id, String nome, String dataDeLancamento, int duracao) {
        super(id, nome, dataDeLancamento);
        setDuracao(duracao);
    }

    public Filme(int duracao) {
        setDuracao(duracao);
    }

    public Filme() {
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        if (duracao < 0) {
            System.out.println("AVISO: a duração deve ser mais que 0");
            return;
        }

        this.duracao = (duracao * 60);
    }

}