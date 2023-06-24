package business;
import java.util.Random;

import excecoes.ExecaoValorInvalido;
public class Serie extends Conteudo {

    // Declaração de variáveis 
    private final static Random gerador = new Random();
    private int quantidadeEpisodio;
    
    //  Construtores
    public Serie(int id, String nome, String dataDeLancamento)throws ExecaoValorInvalido  {
        super(id, nome, dataDeLancamento);
        int quantidadeEpisodio = gerador.nextInt(100);
        setQuantidadeEpisodios(quantidadeEpisodio);
    }

    public Serie() {
    }
     
    
    //Getters e Setters

    public int getQuantidadeEpisodios() {
      return this.quantidadeEpisodio;
    }

    public void setQuantidadeEpisodios(int quantidadeEpisodio)throws ExecaoValorInvalido {
		    Main.ExecaoValorInvalido(quantidadeEpisodio); 
      if (quantidadeEpisodio < 0) {
        System.out.println("AVISO: a quantidade de episodios deve ser maior que 0");
        return;
      }
        this.quantidadeEpisodio = quantidadeEpisodio;
    }

  
}