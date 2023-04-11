package Projeto1;

public class Cliente {

	  private String nomeDeUsuario;
	  private String senha;
	  private Lista<Serie> listaParaVer;
	  private Lista<Serie> listaJaVista;

	  public String getNomeDeUsuario() {
	    return nomeDeUsuario;
	  }

	  public void setNomeDeUsuario(String nomeDeUsuario) {
	    this.nomeDeUsuario = nomeDeUsuario;
	  }

	  public String getSenha() {
	    return senha;
	  }

	  public void setSenha(String senha) {
	    this.senha = senha;
	  }

	  public Lista<Serie> getListaParaVer() {
	    return listaParaVer;
	  }

	  public void setListaParaVer(Lista<Serie> listaParaVer) {
	    this.listaParaVer = listaParaVer;
	  }

	  public Lista<Serie> getListaJaVista() {
	    return listaJaVista;
	  }

	  public void setListaJaVista(Lista<Serie> listaJaVista) {
	    this.listaJaVista = listaJaVista;
	  }

	  public Cliente(String nomeDeUsuario, String senha) {
	    this.nomeDeUsuario = nomeDeUsuario;
	    this.senha = senha;
		this.listaParaVer=new Lista();
		this.listaJaVista=new Lista();
	  }

	  public void adicionarNaLista(Serie serie) {
	    listaParaVer.add(serie);
	  }

	  public void retirarDaLista(Serie serie) {
	    listaParaVer.remove(serie);
	  }

	  	public Lista<Serie> filtrarPorGenero(String genero){
		    Lista<Serie> filtrado= new Lista<Serie>();
		    Serie[] seriesJa = new Serie[this.listaJaVista.size()];
		    Serie[] seriesParaVer = new Serie[this.listaParaVer.size()];
		    seriesJa= this.listaJaVista.allElements(seriesJa);
		    seriesParaVer= this.listaJaVista.allElements(seriesParaVer);
		    
		    for(int i=0;i<listaJaVista.size();i++){
		      if(seriesJa[i].getGenero()==genero) {
		    	  filtrado.add(seriesJa[i]);
		      }
		    }
		    
		    for(int i=0;i<listaParaVer.size();i++){
			      if(seriesParaVer[i].getGenero()==genero) {
			    	  filtrado.add(seriesParaVer[i]);
			      }
			    }
		    
			return filtrado;
		   
		  }
		
		 public Lista<Serie> filtrarPorIdioma(String idioma){
			    Lista<Serie> novaLista = new Lista<Serie>();
			    Serie[] seriesVistas = new Serie[this.listaJaVista.size()];
			    Serie[] seriesParaVer = new Serie[this.listaParaVer.size()];
			    seriesVistas = this.listaJaVista.allElements(seriesVistas);
			    for(int i = 0; i < seriesVistas.length ; i++){
			      if(seriesVistas[i].getIdioma() == idioma){
			        novaLista.add(seriesVistas[i]);
			      } 
			    }
			    seriesParaVer=this.listaParaVer.allElements(seriesParaVer);
			        for(int i = 0; i < seriesParaVer.length ; i++){
			      if(seriesParaVer[i].getIdioma() == idioma){
			        novaLista.add(seriesParaVer[i]);
			      } 
			    }
			    
			  return novaLista;
			  }

	   public Lista<Serie> filtrarPorQtdEpisodios(int Qtd) {
	    Lista<Serie> novaLista = new Lista<Serie>();
	    Serie[] seriesVistas = new Serie[this.listaJaVista.size()];
	    Serie[] seriesParaVer = new Serie[this.listaParaVer.size()];
	    this.listaJaVista.allElements(seriesVistas);
	    for (int i = 0; i < seriesVistas.length; i++) {
	      if (seriesVistas[i].getQuantidadeEpisodios() == Qtd) {
	        novaLista.add(seriesVistas[i]);
	      }
	    }
	    this.listaParaVer.allElements(seriesParaVer);
	    for (int i = 0; i < seriesParaVer.length; i++) {
	      if (seriesParaVer[i].getQuantidadeEpisodios() == Qtd) {
	        novaLista.add(seriesParaVer[i]);
	      }
	    }

	    return novaLista;
	  }


	  public void registrarAudiencia(Serie serie) {
	    serie.registrarAudiencia();
	    this.listaParaVer.remove(serie);
	    this.listaJaVista.add(serie);
	  }

	}
