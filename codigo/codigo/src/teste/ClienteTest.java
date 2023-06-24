// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// public class ClienteTest {
//   Cliente c;
//   Serie s;
//   Filme f;
//   PlataformaStreaming plataforma = new PlataformaStreaming("Plataforma");

//   // Variaveis do Cliente
//   String userLogin = "robertoCaraMau";
//   String userPassword = "123";
//   String userName = "Roberto";
//     List<Conteudo> listaParaVer;
//     List<Conteudo> listaJaVista;
//     List<Date> listDatasAssistidas;


//   // Variaveis das Series e Filmes
//     Integer id = 0;
//   String nome = "Batman";
//   String dataDeLancamento = "12/1/2023";
//   int duracao = 120;

//   @BeforeEach
//   void setUp() {
//     listaParaVer = new ArrayList<>();
//     listaJaVista = new ArrayList<>();
//     listDatasAssistidas = new ArrayList<>();

//     c = new Cliente(userName, userPassword, userLogin, listaParaVer, listaJaVista, listDatasAssistidas);
//     try {
// 		s = new Serie(id, nome, dataDeLancamento );
// 	} catch (ExecaoValorInvalido e) {
// 		// TODO Auto-generated catch block
// 		e.printStackTrace();
// 	}
//     try {
// 		f = new Filme(id, nome, dataDeLancamento,duracao);
// 	} catch (ExecaoValorInvalido e) {
// 		// TODO Auto-generated catch block
// 		e.printStackTrace();
// 	}
//     try {
// 		plataforma.adicionarSerie(s);
// 	} catch (ExecaoValorInvalido e) {
// 		// TODO Auto-generated catch block
// 		e.printStackTrace();
// 	}
//     plataforma.adicionarCliente(c);
//     plataforma.logar("robertoCaraMau", "123");
//   }

//   @Test
//   @DisplayName("Adicionando uma nova serie para a listaParaVer")
//   void assistirSerieMaisTarde() {
//     assertEquals(0, c.getListaParaVer().size());
//     c.adicionarNaLista(s);
//     assertEquals(1, c.getListaParaVer().size());
//   }

//   @Test
//   @DisplayName("Retirando uma serie da listaParaVer")
//   void retirarSerieDoAssistirMaisTarde() {
//     assertEquals(0, c.getListaParaVer().size());
//     c.adicionarNaLista(s);
//     assertEquals(1, c.getListaParaVer().size());
//     c.retirarDaLista(s);
//     assertEquals(0, c.getListaParaVer().size());
//   }

//   @Test
//   @DisplayName("Adicionando um conteudo a lista de ja vistos")
//   void adicionarNaListaJaVista() {
//     c.adicionarNaListaJaVista(s);
//     assertEquals(1, c.getListaJaVista().size());
//   }


//   @Test
//   @DisplayName("Adicionando uma data a lista de datas assistidas")
//   void adicionarNaListaDatasAssistidasSeries() {
//     c.adicionarNaListaDatasAssistidasSeries(new Date());
//     assertEquals(1, c.getListaDatasAssistidasSeries().size());
//   }


//   @Test
//   @DisplayName("Filtrando os conteudos por idioma")
//   void filtrarPorIdioma() {
//     c.adicionarNaLista(s);
//     assertEquals(0, c.filtrarPorIdioma("idioma").size());
//   }

//   @Test
//   @DisplayName("Filtrando os conteudos por genero")
//   void filtrarPorGenero() {
//     c.adicionarNaLista(s);
//     assertEquals(0, c.filtrarPorGenero("genero").size());
//   }

//   @Test
//   @DisplayName("Filtrando as series por quantidade de episodios")
//   void filtrarPorQtdEpisodios() {
//     plataforma.getClienteAtual().adicionarNaLista(s);
//     assertEquals(1, plataforma.getClienteAtual().filtrarPorQtdEpisodios(s.getQuantidadeEpisodios()).size());
//   }

//   @Test
//   @DisplayName("Filtrando os filmes por duração")
//   void filtrarFilmesPorDuracao() {
//     c.adicionarNaLista(f);
//     assertEquals(1, c.filtrarFilmePorDuracao(duracao*60).size());
//   }

//     @Test
//     @DisplayName("Filtrando os conteudos por nome")
//     void filtrarPorNome() {
//         c.adicionarNaLista(s);
//         assertEquals(0, c.filtrarPorNome("nome").size());
//     }

//   @Test
//   @DisplayName("Assistindo um conteudo")
//   void assistirSerie() {
//     c.adicionarNaLista(s);
//     c.registrarAudiencia(s);
//     assertEquals(0, c.getListaParaVer().size());
//     assertEquals(1, c.getListaJaVista().size());
//   }


//   @Test
//   @DisplayName("Adicionando um conteudo e dando nota")
//   void assistirSerieComNota() {
//     c.adicionarNaLista(s);
//     c.registrarAudiencia(s, 5);
//     assertEquals(0, c.getListaParaVer().size());
//     assertEquals(1, c.getListaJaVista().size());

//     Avaliacao a = s.getAvaliacoes().get(c.getNomeDeUsuario());

//     assertNotNull(a);
//     assertEquals(5, a.getNota());
//   }


//   @Test
//   @DisplayName("Adicionando um conteudo e dando nota e comentario")
//   void assistirSerieComNotaComComentario() {
//     c.adicionarNaLista(s);
//     c.registrarAudiencia(s, 5, "muito ruim");
//     assertEquals(0, c.getListaParaVer().size());
//     assertEquals(1, c.getListaJaVista().size());

//     Avaliacao a = s.getAvaliacoes().get(c.getNomeDeUsuario());

//     assertNotNull(a);
//     assertEquals(5, a.getNota());
//     assertEquals("muito ruim", a.getComentario());
//   }


//   @Test
//   @DisplayName("Avaliando um conteudo")
//   void avaliar() {
//     assertInstanceOf(Avaliacao.class, c.avaliar(2, 5));
//   }


//   @Test
//   @DisplayName("Avaliando um conteudo com comentario")
//   void avaliarComComentario() {
//     assertInstanceOf(Avaliacao.class, c.avaliar(2, 5, "ola mundo"));
//   }

//   @Test
//   @DisplayName("Conferindo as datas que o cliente assistiu")
//   void conferirCliente() {
//     assertFalse(c.conferirCliente());

//     c.adicionarNaListaDatasAssistidasSeries(new Date());
//     c.adicionarNaListaDatasAssistidasSeries(new Date());
//     c.adicionarNaListaDatasAssistidasSeries(new Date());
//     c.adicionarNaListaDatasAssistidasSeries(new Date());
//     c.adicionarNaListaDatasAssistidasSeries(new Date());
//     c.adicionarNaListaDatasAssistidasSeries(new Date());

//     assertTrue(c.conferirCliente());
//   }

//   @Test
//   @DisplayName("Conferindo se o cliente tem avaliacoes")
//   void clienteSemAvaliacao() {
//     assertFalse(plataforma.getClienteAtual().clienteSemAvaliacao(s));

//     plataforma.salvaAvalicao(new Avaliacao(s.getId(), c, 5));
//     assertTrue(plataforma.getClienteAtual().clienteSemAvaliacao(s));
//   }

// }