package Projeto1;

public class Serie {
	
	public Serie(String nome, String genero, String idioma, int quantidadeEpisodios, int audiencia) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.quantidadeEpisodios = quantidadeEpisodios;
		this.audiencia = audiencia;
	}


	private final String[] GENEROS = {"Ação","Terror","Comédia","Suspense","Drama"};
	private String nome;
	private String genero;
	private String idioma;
	private int quantidadeEpisodios;
	private int audiencia=0;
	
	public String getNome() {return nome;}
  
	public void setNome(String nome) {this.nome = nome;}
  
	public String getGenero() {return genero;}
  
	public void setGenero(String genero) {this.genero = genero;}
  
	public String getIdioma() {return idioma;}
  
	public void setIdioma(String idioma) {this.idioma = idioma;}
  
	public int getQuantidadeEpisodios() {return quantidadeEpisodios;}
  
	public void setQuantidadeEpisodios(int quantidadeEpisodios) {this.quantidadeEpisodios = quantidadeEpisodios;}
  
	public int getAudiencia() {return audiencia;}
  
	public void setAudiencia(int audiencia) {this.audiencia = audiencia;}
  
	public String[] getGENEROS() {return GENEROS;}


	public void registrarAudiencia() {
		this.audiencia++;
	}
}