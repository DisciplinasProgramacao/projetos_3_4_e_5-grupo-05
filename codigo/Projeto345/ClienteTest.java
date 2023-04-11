package Projeto1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

	public class ClienteTest {
	  Cliente c;
	  Serie s;
	  Lista<Serie> listaParaVer;
	  Lista<Serie> listaJaVista;

	  @BeforeEach
	  void setUp() {
	    c = new Cliente("Roberto", "123", listaParaVer, listaJaVista);
	    s = new Serie("Batman", "Drama", "ingles", 20, 0);
	    listaParaVer = new Lista();
	    listaJaVista = new Lista();
	  }

	  @Test
	  @DisplayName("Adicionando uma nova serie para a lista para ver")
	  void adicionarNaListaParaVer() {
	    assertEquals(0, c.getListaParaVer().size());
	    c.adicionarNaLista(s);
	    assertEquals(1, c.getListaParaVer().size());
	  }

	  @Test
	  @DisplayName("Retirando uma serie da lista de para ver")
	  void retirarDaLista() {
	    assertEquals(0, c.getListaParaVer().size());
	    c.adicionarNaLista(s);
	    assertEquals(1, c.getListaParaVer().size());
	    c.retirarDaLista(s);
	    assertEquals(0, c.getListaParaVer().size());
	  }


	  @Test
	  @DisplayName("Filtrando as series por idioma")
	  void filtrarPorIdioma() {
	    c.adicionarNaLista(s);
	    listaParaVer.add(s);
	    assertEquals(listaParaVer, c.filtrarPorIdioma("ingles"));
	  }

	  @Test
	  @DisplayName("Filtrando as series por genero")
	  void filtrarPorGenero() {
	    c.adicionarNaLista(s);
	    listaParaVer.add(s);
	    assertEquals(listaParaVer, c.filtrarPorGenero("Drama"));
	  }

	  @Test
	  @DisplayName("Filtrando as series por quantidade de episodios")
	  void filtrarPorQuantidadeDeEP() {
	    c.adicionarNaLista(s);
	    listaParaVer.add(s);
	    assertEquals(listaParaVer, c.filtrarPorQtdEpisodios(20));
	  }

	  
	  @Test
	  void registrarPorAudiencia() {
	    c.registrarAudiencia(s);
	    c.registrarAudiencia(s);
	    c.registrarAudiencia(s);
	    assertEquals(3, s.getAudiencia());
	  }


	  @Test
	  @DisplayName("Adicionando uma nova serie para a lista de ja vista")
	  void adicionarNaListaJaVista() {
	    c.adicionarNaLista(s);
	    c.registrarAudiencia(s);
	    assertEquals(0, c.getListaParaVer().size());
	    assertEquals(1, c.getListaJaVista().size());
	  }

	}

