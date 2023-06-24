package business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//importar date
public class Cliente{ 

	
//  Declaração de variáveis


  // Variáveis do cliente

    private String nome;
    private String senha;
    private String login;

    
  // Relações do cliente

    private List<Conteudo> listaParaVer = new ArrayList<Conteudo>();
    private List<Conteudo> listaJaVista = new ArrayList<Conteudo>();
	  private List<Date>  listaDatasAssistidas = new ArrayList<Date>();

  
//    Getters e Setters


  //  Informações do usuário

    public String getNomeDeUsuario() {return nome;} //exceptions
    public void setNomeDeUsuario(String nome) {this.nome = nome;}
    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}
    public String getLogin(){return login;}
    public void setLogin(String login){this.login=login;}

    public List<Conteudo> getListaParaVer() {return listaParaVer;}
    public List<Conteudo> getListaJaVista() {return listaJaVista;}
    public List<Date> getListaDatasAssistidasSeries() {return listaDatasAssistidas;}
  
//     Construtores

  public Cliente(String nome, String senha, String login) {
        this.nome = nome; //set informações
        this.senha = senha;
        this.login = login;

    } 

	public Cliente(String nome, String senha, String login, List<Conteudo> listaParaVer, List<Conteudo> listaJaVista, List<Date>  listaDatasAssistidas) {
        this.nome = nome; //set informações
        this.senha = senha;
        this.login = login;
        this.listaParaVer = listaParaVer;
        this.listaJaVista = listaJaVista;
        this.listaDatasAssistidas = listaDatasAssistidas;
    } 
	

  
  /**Função de adicionar um conteúdo na lista de "Para assistir" do cliente
  *
  * @param conteudo Conteudo - Conteudo a ser adicionado 
  */
  public void adicionarNaLista(Conteudo conteudo) {listaParaVer.add(conteudo);}

  /**Função de remover um conteúdo na lista de "Para assistir" do cliente
  *
  * @param conteudo Conteudo - Conteudo a ser removido 
  */
  public void retirarDaLista(Conteudo conteudo) {listaParaVer.remove(conteudo);}

  /**Função de adicionar um conteúdo na lista de "Assistidos" do cliente
  *
  * @param conteudo Conteudo - Conteudo a ser adicionado 
  */
  public void adicionarNaListaJaVista(Serie serie) {listaJaVista.add(serie);} 

  /**Função de adicionar a data de um conteúdo assistido
  *
  * @param data Date - Data a ser inserida
  */
	public void adicionarNaListaDatasAssistidasSeries(Date data) {listaDatasAssistidas.add(data);} 
	

  // Variáveis responsável pelo gerenciamento de Datas
	
    // Declaração de variável 

	private Date hoje = new Date(); // revisar
  public Date getHoje() {return hoje;}
	public void setHoje(Date hoje) {this.hoje = hoje;}	  
	public void adicionaDia(Date hoje) {this.listaDatasAssistidas.add(hoje);}	
	
//	private Calendar ca = new GregorianCalendar();
//	public Calendar hoje = Calendar.getInstance();;
//	public Calendar getCa() {return ca;}
//	public void setCa(Calendar ca) {this.ca = ca;}  

  /** Função para assistir um conteúdo e transferir da lista de "Para assistir" para a lista de "Assistidos"
  * @param conteudo Conteudo - Conteúdo que será assistido
  *
  */
  
    public void registrarAudiencia(Conteudo conteudo) { 
    	conteudo.registrarAudiencia();
        this.listaParaVer.remove(conteudo);
        this.listaJaVista.add(conteudo);
    }

  /** Função para assistir um conteúdo e transferir da lista de "Para assistir" para a lista de "Assistidos"4
  *   e dar uma nota ao conteúdo
  * @param conteudo Conteudo - Conteúdo que será assistido
  * @param nota Int - Nota dada pelo cliente
  */
  
    public void registrarAudiencia(Conteudo conteudo, int nota){
    	conteudo.registrarAudiencia();
    	conteudo.avaliacoes.put(this.getNomeDeUsuario(), new Avaliacao(conteudo.getId(), this, nota));
        this.listaParaVer.remove(conteudo);
        this.listaJaVista.add(conteudo);
    }

    /** Função para assistir um conteúdo e transferir da lista de "Para assistir" para a lista de "Assistidos"4
  *   e dar uma nota com comentário ao conteúdo
  * @param conteudo Conteudo - Conteúdo que será assistido
  * @param nota Int - Nota dada pelo cliente
  * @param comentario String - Comentário da avaliação
  */
    public void registrarAudiencia(Conteudo conteudo, int nota, String comentario){
    	conteudo.registrarAudiencia();
    	
    	conteudo.avaliacoes.put(this.getNomeDeUsuario(), new Avaliacao(conteudo.getId(), this, nota, comentario));
        this.listaParaVer.remove(conteudo);
        this.listaJaVista.add(conteudo);
    }
    

  /** Função de registrar uma audiência e armazenar a data da audiência
  *
  */
  
    public void assisteConteudo(Conteudo c) {
      conferirCliente();
  	  //-----------salva a data vista---------------
  	  Date hoje = new Date();
  	  hoje.getTime();
  	  adicionaDia(hoje);
  	  
  	  registrarAudiencia(c);
    }

  /** Função de gerar uma nova avaliação
  * @param conteudo Int - ID do conteúdo
  * @param nota Int - Nota da avaliação
  *
  */
  
    public Avaliacao avaliar(int conteudo, int nota) {
		return new Avaliacao(conteudo, this, nota);
    }

  /** Função de gerar uma nova avaliação com comentário
  * @param conteudo Int - ID do conteúdo
  * @param nota Int - Notado da avaliação
  * @param comentario String - Comentário da avaliação
  *
  */
	
	public Avaliacao avaliar(int conteudo, int nota, String comentario) {
		return new Avaliacao(conteudo, this, nota, comentario);
	}
    
    // Funções responsáveis por verificar o estado do Cliente


  /** Função de verificar a quantidade de conteúdos assistidos nos últimos dias
  *
  * @return TRUE se o cliente tiver assistido mais de 5 midias recentemente, e FALSE em casos contrários 
  */
    public boolean conferirCliente() {
    	boolean cincoMidiasAssistidas = listaDatasAssistidas.stream()
                .filter(date -> {
                    long differenceInMillis = new Date().getTime() - date.getTime();
                    long daysDifference = differenceInMillis / (24 * 60 * 60 * 1000);
                    return daysDifference <= 30;
                })
                .count() >= 5;
    	return cincoMidiasAssistidas;
    }
    
  /** Função de verificar se o cliente já avaliou o conteudo
  * @param id Int - ID do conteúdo
  * @param conteudos Map<Integer, Conteudo> - Conteudos a serem verificados
  * @return TRUE se o cliente tiver avaliado, e FALSE em casos contrários 
  */
  
	public boolean clienteSemAvaliacao(Map<Integer, Conteudo> conteudos, int id) {
		
		Conteudo conteudo = conteudos.get(id);
		
		boolean clienteEsp = conteudo.avaliacoes.keySet()
        .stream()
        .anyMatch(elemento -> elemento.equals(getNomeDeUsuario()));

		return clienteEsp;
	}

  /** Função de verificar se o cliente já avaliou o conteudo
  * @param id Int - ID do conteúdo
  * @return TRUE se o cliente tiver avaliado, e FALSE em casos contrários 
  */
  
	public boolean clienteSemAvaliacao(Conteudo conteudo) {
		
		boolean clienteEsp = conteudo.avaliacoes.keySet()
        .stream()
        .anyMatch(elemento -> elemento.equals(getNomeDeUsuario()));

		return clienteEsp;
	}
 			
    

    
  // Metódos para auxiliar na filtragem de conteúdos da plataforma


  /** Função para filtrar um conteúdo por Gênero
  * @param genero String - Gênero a ser filtrado
  * 
  * @return List<Conteudo> - Lista de conteúdos que possuem esse gênero
  */
  
    public List<Conteudo> filtrarPorGenero(String genero){

        List<Conteudo> listas = new ArrayList<>();
        listas.addAll(this.listaParaVer);
        listas.addAll(this.listaJaVista);

        return listas.stream()
                .filter((conteudo) -> conteudo.getGenero().equals(genero))
                .collect(Collectors.toList());
    }
  
  /** Função para filtrar um conteúdo por Gênero
  * @param idioma String - Idioma a ser filtrado
  * 
  * @return List<Conteudo> - Lista de conteúdos que possuem esse idioma
  */
  
    public List<Conteudo> filtrarPorIdioma(String idioma){
        List<Conteudo> listas = new ArrayList<>();
        listas.addAll(this.listaParaVer);
        listas.addAll(this.listaJaVista);

        return listas.stream()
                .filter((conteudo) -> conteudo.getIdioma().equals(idioma))
                .collect(Collectors.toList());
    }

  /** Função para filtrar um conteúdo por Nome
  * @param nome String - Nome do conteúdo a ser filtrado
  * 
  * @return List<Conteudo> - Lista de conteúdos que possuem esse nome
  */
  
    public List<Conteudo> filtrarPorNome(String nome){

        List<Conteudo> listas = new ArrayList<>();
        listas.addAll(this.listaParaVer);
        listas.addAll(this.listaJaVista);

        return listas.stream()
                .filter((conteudo) -> conteudo.getNome().equals(nome))
                .collect(Collectors.toList());
    }

  /** Função para filtrar um conteúdo por quantidade de episodios
  * @param qtd Int - Quantidade de episodios
  * @param atual Cliente - Referência ao próprio cliente (this. estava dando errado)
  * 
  * @return List<Conteudo> - Lista de conteúdos que possuem essa quantidade de episódios
  */
  
    public List<Serie> filtrarPorQtdEpisodios(int qtd) {

        List<Conteudo> listaConteudo = new ArrayList<>();
        listaConteudo.addAll(this.listaJaVista);
        listaConteudo.addAll(this.listaParaVer);

        return listaConteudo.stream()
                .filter(conteudo -> conteudo instanceof Serie)
                .map(conteudo -> (Serie) conteudo)
                .filter(serie -> serie.getQuantidadeEpisodios() == qtd)
                .collect(Collectors.toList());
    }

  /** Função para filtrar um conteúdo por duração
  * @param qtd Int - Duração de filme
  * @param atual Cliente - Referência ao próprio cliente (this. estava dando errado)
  * 
  * @return List<Filme> - Lista de conteúdos que possuem essa duração
  */
  
    public List<Filme> filtrarFilmePorDuracao(int duracao){

        List<Conteudo> listaConteudo = new ArrayList<>();
        listaConteudo.addAll(this.listaJaVista);
        listaConteudo.addAll(this.listaParaVer);

        return listaConteudo.stream()
                .filter(conteudo -> conteudo instanceof Filme)
                .map(conteudo -> (Filme) conteudo)
                .filter(filme -> filme.getDuracao() == duracao)
                .collect(Collectors.toList());
    }


}