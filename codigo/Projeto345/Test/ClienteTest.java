// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// public class ClienteTest {
//   Cliente c;
//   Serie s;
//   Filme f;

//   // Variaveis do Cliente
//   String userLogin = "robertoCaraMau";
//   String userPassword = "123";
//   String userName = "Roberto";


//   // Variaveis das Series e Filmes
//   String nome = "Batman";
//   String genero = "Drama";
//   String idioma = "Inglês";
//   String dataDeLancamento = "12/0/2023";
//   int duracao = 120;
//   int quantidadeEpisodios = 20;

//   @BeforeEach
//   void setUp() {
//     c = new Cliente(userName, userPassword, userLogin);
//     s = new Serie(nome,genero, idioma, dataDeLancamento,quantidadeEpisodios );
//     f = new Filme(nome,genero, idioma, dataDeLancamento,duracao);
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
//   @DisplayName("Filtrando as series por idioma")
//   void filtrarSeriesPorIdioma() {
//     c.adicionarNaLista(s);
//     assertEquals(1, c.filtrarPorIdioma(idioma).size());
//   }

//   @Test
//   @DisplayName("Filtrando as series por genero")
//   void filtrarSeriesPorGenero() {
//     c.adicionarNaLista(s);
//     assertEquals(1, c.filtrarPorGenero(genero).size());
//   }

//   @Test
//   @DisplayName("Filtrando as series por quantidade de episodios")
//   void filtrarSeriesPorQuantidadeDeEP() {
//     c.adicionarNaLista(s);
//     assertEquals(1, c.filtrarPorQtdEpisodios(quantidadeEpisodios).size());
//   }

//   @Test
//   @DisplayName("Filtrando os filmes por idioma")
//   void filtrarFilmesPorIdioma() {
//     c.adicionarFilmeNaLista(f);
//     assertEquals(1, c.filtrarFilmePorIdioma(idioma).size());
//   }

//   @Test
//   @DisplayName("Filtrando os filmes por genero")
//   void filtrarFilmesPorGenero() {
//     c.adicionarFilmeNaLista(f);
//     assertEquals(1, c.filtrarFilmePorGenero(genero).size());
//   }

//   @Test
//   @DisplayName("Filtrando os filmes por duração")
//   void filtrarFilmesPorDuracao() {
//     c.adicionarFilmeNaLista(f);
//     assertEquals(1, c.filtrarFilmePorDuracao(duracao).size());
//   }


//   @Test
//   @DisplayName("Adicionando uma serie para a lista de ja vista")
//   void assistirSerie() {
//     c.adicionarNaLista(s);
//     c.registrarAudiencia(s);
//     assertEquals(0, c.getListaParaVer().size());
//     assertEquals(1, c.getListaJaVista().size());
//   }

//   @Test
//   @DisplayName("Adicionando um filme para a lista de ja vista")
//   void assistirFilme() {
//     c.adicionarFilmeNaLista(f);
//     c.assitirFilme(f);
//     assertEquals(0, c.getListaDeFilmesParaVer().size());
//     assertEquals(1, c.getListaDeFilmesJaVista().size());
//   }

// }

