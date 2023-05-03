import java.util.Random;
public class Serie extends Conteudo {
    private final static Random gerador = new Random();

    private int quantidadeEpisodio;

    public Serie(int id, String nome, String dataDeLancamento) {
        super(id, nome, dataDeLancamento);
        int quantidadeEpisodio = gerador.nextInt(100);
        setQuantidadeEpisodios(quantidadeEpisodio);
    }

    public Serie(int quantidadeEpisodio) {
        setQuantidadeEpisodios(quantidadeEpisodio);
    }

    public Serie() {
    }
  
    public int getQuantidadeEpisodios() {
      return this.quantidadeEpisodio;
    }

    public void setQuantidadeEpisodios(int quantidadeEpisodio) {
      if (quantidadeEpisodio < 0) {
        System.out.println("AVISO: a quantidade de episodios deve ser maior que 0");
        return;
      }

        this.quantidadeEpisodio = quantidadeEpisodio;
    }

}