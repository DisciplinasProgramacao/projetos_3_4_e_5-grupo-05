package business;
import excecoes.ExecaoValorInvalido;

public class Filme extends Conteudo {

//declaração de variável
//------------------------------------
    private int duracao;
//------------------------------------
    
//construtor
//------------------------------------
    public Filme(int id, String nome, String dataDeLancamento, int duracao) throws ExecaoValorInvalido{
        super(id, nome, dataDeLancamento);
        setDuracao(duracao);
    }

    public Filme() {
    }

    /*public Filme(int duracao) {
        setDuracao(duracao);
    }*/
//------------------------------------
    
//getters e setters
//------------------------------------
    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao)throws ExecaoValorInvalido {
		    Main.ExecaoValorInvalido(duracao); 
        if (duracao < 0) {
            System.out.println("AVISO: a duração deve ser mais que 0");
            return;
        }

        this.duracao = (duracao * 60);
    }
//------------------------------------

}