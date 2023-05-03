 // import static org.junit.jupiter.api.Assertions.*;

 // import org.junit.jupiter.api.BeforeEach;
 // import org.junit.jupiter.api.DisplayName;

 // import org.junit.jupiter.api.Test;

 // class PlataformaStreamingTest {

 //    PlataformaStreaming p;
 //    Serie s;

 //    Filme f;

 //    Cliente c;

 //    // Variaveis do Cliente
 //    String userLogin = "robertoCaraMau";
 //    String userPassword = "123";
 //    String userName = "Roberto";

 //    // Variaveis das Series e Filmes
 //    String nome = "Batman";
 //    String genero = "Drama";
 //    String idioma = "Inglês";
 //    String dataDeLancamento = "12/0/2023";
 //    int duracao = 120;
 //    int quantidadeEpisodios = 20;

 //   @BeforeEach
 //   void setUp() {
 //       c = new Cliente(userName, userPassword, userLogin);
 //       s = new Serie(nome,genero, idioma, dataDeLancamento,quantidadeEpisodios );
 //       f = new Filme(nome,genero, idioma, dataDeLancamento,duracao);
 //       p = new PlataformaStreaming("CebolaFlix");
 //   }

 //   @Test
 //   @DisplayName("Fazendo login na plataforma")
 //   void testLogin() {
 //     p.adicionarCliente(c);
 //     p.logar(userLogin, userPassword);
 //     assertEquals(userName, p.getClienteAtual().getNomeDeUsuario());
 //     assertEquals(userPassword, p.getClienteAtual().getSenha());
 //   }

 //   @Test
 //   @DisplayName("Adicionando uma serie nova")
 //   void testAdicionarSerie() {
 //     p.adicionarSerie(s);

 //     assertEquals(nome, p.getSerie(s.getId()).getNome());
 //   }

 //     @Test
 //     @DisplayName("Adicionando um filme novo")
 //     void testAdicionarFilme() {
 //         p.adicionarFilme(f);

 //         assertEquals(nome, p.getFilme(f.getId()).getNome());
 //     }

 //   @Test
 //   @DisplayName("Adicionando um novo cliente")
 //   void testAdicionarCliente() {
 //     p.adicionarCliente(c);

 //     assertEquals(userName, p.getCliente(c.getLogin()).getNomeDeUsuario());
 //   }

 //   @Test
 //   @DisplayName("Filtrando as series por idioma")
 //   void testFiltrarPorIdioma() {
 //     p.adicionarSerie(s);
 //     assertEquals(1, p.filtrarPorIdioma(idioma).size());
 //   }

 //   @Test
 //   @DisplayName("Filtrando as series por genero")
 //   void testFiltrarPorGenero() {
 //     p.adicionarSerie(s);
 //     assertEquals(1, p.filtrarPorGenero(genero).size());
 //   }

 //   @Test
 //   @DisplayName("Filtrando as series por quantidade de episodios")
 //   void testFiltrarPorQuantidadeDeEP() {
 //     p.adicionarSerie(s);
 //     assertEquals(1, p.filtrarPorQtdEpisodios(quantidadeEpisodios).size());
 //   }

 //     @Test
 //     @DisplayName("Filtrando as series por idioma")
 //     void testFiltrarFilmePorIdioma() {
 //         p.adicionarFilme(f);
 //         assertEquals(1, p.filtrarFilmePorIdioma(idioma).size());
 //     }

 //     @Test
 //     @DisplayName("Filtrando as series por genero")
 //     void testFiltrarFilmePorGenero() {
 //         p.adicionarFilme(f);
 //         assertEquals(1, p.filtrarFilmePorGenero(genero).size());
 //     }

 //     @Test
 //     @DisplayName("Filtrando as series por quantidade de episodios")
 //     void testFiltrarFilmePorDuracao() {
 //         p.adicionarFilme(f);
 //         assertEquals(1, p.filtrarFilmePorDuracao(duracao).size());
 //     }

 //   @Test
 //   @DisplayName("Adicionando audiencias a uma serie")
 //   void registrarAudienciaParaSerie() {
 //     p.adicionarSerie(s);

 //     p.registrarAudiencia(s);
 //     p.registrarAudiencia(s);
 //     p.registrarAudiencia(s);
 //     assertEquals(3, s.getAudiencia());
 //   }

 //     @Test
 //     @DisplayName("Adicionando audiencia a um filme")
 //     void registrarAudienciaParaFilme() {
 //         p.adicionarFilme(f);

 //         p.registrarAudienciaParaFilme(f);
 //         p.registrarAudienciaParaFilme(f);
 //         p.registrarAudienciaParaFilme(f);
 //         assertEquals(3, f.getAudiencia());
 //     }

 // }
