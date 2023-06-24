package business;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import excecoes.ExecaoNota;
import excecoes.ExecaoValorInvalido;

import java.util.HashMap;

abstract public class Conteudo {
  
	
	
  // Declaração de váriaveis
  
  private final static Random gerador = new Random();

    public final static String[] GENEROS = { // prioridade baixa, colocar em list
            "Ação", "Terror", "Comédia",
            "Suspense", "Drama", "Anime",
            "Aventura", "Sci-fy", "Superhero",
            "Documentario", "Policial", "Romance", "Suspense"
    };
    public final static String[] IDIOMAS = {
            "Ingles", "Português", "Espanhol",
            "Mandarim", "Turco", "Francês",
            "Russo", "Alemão", "Japonês",
            "Koreano", "Italiano", "Grego"
    };
    
    protected int id; 
    protected String nome;
    protected String idioma;
    protected String genero;
    protected String dataDeLancamento;
    protected boolean eLancamento; // colocar private interface Lançavel recebe null
    
    protected int audiencia; 
    
    protected Map<String, Avaliacao> avaliacoes; // fazer por hash map, puxando inffo do cliente por id
    protected double mNota;  // mudar, variável inutil
    

        //Construtores
    public Conteudo(int id, String nome, String dataDeLancamento) {
        this.id = id;
        setNome(nome);
        setIdioma(Idioma.getIdiomaAleatorio());
        setGenero(Genero.getGeneroAleatorio());
        setDataDeLancamento(dataDeLancamento);
        this.audiencia = 0;
        this.mNota = mediaNotas();
        this.avaliacoes = new HashMap<String, Avaliacao>();
        eLancamento = calculaLancamento();
    }

	 public Conteudo() { //!!!
        this.id = gerador.nextInt(1000); // verificar se não há id igual
        this.nome = "";
        setIdioma(Idioma.getIdiomaAleatorio());
        setGenero(Genero.getGeneroAleatorio());
        this.audiencia = 0;
        this.dataDeLancamento = "";
        this.mNota = mediaNotas();
        this.avaliacoes = new HashMap<String, Avaliacao>();
        eLancamento = calculaLancamento();
    }
	
	public Conteudo(int id, String nome) { //para trailers
        this.id = id;
        setNome(nome);
    }

        //Getters and Setters
  
    public double getNota(){return this.mNota;} // alterar sets, com exceção
  
    public void setNota(int nota) throws ExecaoNota {
		  Main.ExecaoNota(nota);
  		this.mNota = nota;
	  }
  
    public int getId() {return this.id;}
  
    public String getNome() {return this.nome;}
  
    public String getIdioma() {return this.idioma;}
  
    public String getGenero() {return this.genero;}
  
    public int getAudiencia() {return this.audiencia;}
  
    public String getDataDeLancamento() {return this.dataDeLancamento;}
  
    public boolean getELancamento() {return this.eLancamento;}
  
    public void setIdioma(String idioma) {this.idioma = idioma;}
  
    public void setGenero(String genero) {this.genero = genero;}
  
  	public void setId(int id) throws ExecaoValorInvalido{
  		Main.ExecaoValorInvalido(id);
  		this.id = id;
  	}
    public void setDataDeLancamento(String dataDeLancamento) {this.dataDeLancamento = dataDeLancamento;}
    
    public Map<String, Avaliacao> getAvaliacoes(){return this.avaliacoes;}
    public void setAvaliacoes(Map<String, Avaliacao> avaliacoes) {this.avaliacoes = avaliacoes;}
    
    public void setNome( String nome) {
        if (nome.length() < 2) {
            System.out.println("AVISO: o nome deve ter mais de 2 silabas");
            return;
        }
        this.nome = nome;
    }
    public void registrarAudiencia() {
    	this.audiencia++;
    }


  
  /**Função responsável por calcular a nota média das avaliações do conteúdo
  *
  * @return Double - Retorna a média calculada.
  */
  
    public double mediaNotas() throws NullPointerException{
    	double media = 0.0;
    	try {
        if (!avaliacoes.isEmpty()) {
            media = avaliacoes.values()
                    .stream()
                    .mapToDouble(Avaliacao::getNota)
                    .average()
                    .orElse(0.0);
        }
        return media;
    	}
    	catch(NullPointerException e) {
    		return media;
    	}
    }

  /**Função responsável por exibir o nome e id do Conteúdo em String
  *
  * @return String - O Nome e ID do conteúdo.
  */
  
     public String toString() {
        return "ID: " + id +
                " Nome: " + nome;
    }

  
  /**Função de verificar se um conteúdo é lançamento, verificando se foi passado 30 dias corridos desde sua
  * data de lançamento
  *
  * @return Boolean - Devolve TRUE se o conteúdo é um lançamento e FALSE no caso contrário
  */
  
     private boolean calculaLancamento() {
    	 LocalDate hoje = LocalDate.now();
    	 String dataInfo[] = getDataDeLancamento().split("/");
    	 LocalDate dataLancamento = LocalDate.of(Integer.parseInt(dataInfo[2].trim()), Integer.parseInt(dataInfo[1].trim()), Integer.parseInt(dataInfo[0].trim()));
    	 LocalDate dataLimite = hoje.minusDays(30);
    	 return !dataLancamento.isBefore(dataLimite);
 	}
     
  
}