 // import static org.junit.jupiter.api.Assertions.*;

 // import org.junit.jupiter.api.BeforeEach;
 // import org.junit.jupiter.api.DisplayName;

 // import org.junit.jupiter.api.Test;

 // import java.util.ArrayList;
 // import java.util.List;
 // import java.util.Random;

 // class PlataformaStreamingTest {
 //     private final Random gerador = new Random();

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
 //    String dataDeLancamento = "12/1/2023";
 //    int duracao = 120;

 //   @BeforeEach
 //   void setUp() {
 //       c = new Cliente(userName, userPassword, userLogin);
 //       try {
	// 	s = new Serie(gerador.nextInt(100), nome, dataDeLancamento );
	// } catch (ExecaoValorInvalido e) {
	// 	// TODO Auto-generated catch block
	// 	e.printStackTrace();
	// }
 //       try {
	// 	f = new Filme(gerador.nextInt(101, 200), nome, dataDeLancamento,duracao);
	// } catch (ExecaoValorInvalido e) {
	// 	// TODO Auto-generated catch block
	// 	e.printStackTrace();
	// }
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
 //     try {
	// 	p.adicionarSerie(s);
	// } catch (ExecaoValorInvalido e) {
	// 	// TODO Auto-generated catch block
	// 	e.printStackTrace();
	// }

 //     assertEquals(nome, p.getSerie(s.getId()).getNome());
 //   }

 //     @Test
 //     @DisplayName("Adicionando um filme novo")
 //     void testAdicionarFilme() {
 //         try {
	// 		PlataformaStreaming.adicionarFilme(f);
	// 	} catch (ExecaoValorInvalido e) {
	// 		// TODO Auto-generated catch block
	// 		e.printStackTrace();
	// 	}

 //         assertEquals(nome, p.getFilme(f.getId()).getNome());
 //     }

 //   @Test
 //   @DisplayName("Adicionando um novo cliente")
 //   void testAdicionarCliente() {
 //     p.adicionarCliente(c);

 //     assertEquals(userName, p.getCliente(c.getLogin()).getNomeDeUsuario());
 //   }

 //   @Test
 //   @DisplayName("Filtrando os conteudos por idioma")
 //   void testFiltrarPorIdioma() {
 //     try {
	// 	p.adicionarSerie(s);
	// } catch (ExecaoValorInvalido e) {
	// 	// TODO Auto-generated catch block
	// 	e.printStackTrace();
	// }
 //     assertEquals(1, p.filtrarPorIdioma(s.getIdioma()).size());
 //   }

 //   @Test
 //   @DisplayName("Filtrando os conteudos por genero")
 //   void testFiltrarPorGenero() {
 //     try {
	// 	p.adicionarSerie(s);
	// } catch (ExecaoValorInvalido e) {
	// 	// TODO Auto-generated catch block
	// 	e.printStackTrace();
	// }
 //     assertEquals(1, p.filtrarPorGenero(s.getGenero()).size());
 //   }

 //   @Test
 //   @DisplayName("Filtrando as series por quantidade de episodios")
 //   void testFiltrarPorQtdEpisodios() {
 //     try {
	// 	p.adicionarSerie(s);
	// } catch (ExecaoValorInvalido e) {
	// 	// TODO Auto-generated catch block
	// 	e.printStackTrace();
	// }
 //     assertEquals(1, p.filtrarPorQtdEpisodios(s.getQuantidadeEpisodios()).size());
 //   }

 //     @Test
 //     @DisplayName("Filtrando os filmes por duração")
 //     void testFiltrarPorDuracao() {
 //         try {
	// 		PlataformaStreaming.adicionarFilme(f);
	// 	} catch (ExecaoValorInvalido e) {
	// 		// TODO Auto-generated catch block
	// 		e.printStackTrace();
	// 	}
 //         assertEquals(1, p.filtrarPorDuracao(f.getDuracao()).size());
 //     }

 //     @Test
 //     @DisplayName("Filtrando os conteudos por nome")
 //     void testFiltrarPorNome() {
 //       try {
	// 	p.adicionarSerie(s);
	// } catch (ExecaoValorInvalido e) {
	// 	// TODO Auto-generated catch block
	// 	e.printStackTrace();
	// }
 //       assertEquals(1, p.filtrarPorNome(s.getNome()).size());
 //     }

 //   @Test
 //   @DisplayName("Adicionando audiencias a uma serie")
 //   void registrarAudienciaParaSerie() {
 //     try {
	// 	p.adicionarSerie(s);
	// } catch (ExecaoValorInvalido e) {
	// 	// TODO Auto-generated catch block
	// 	e.printStackTrace();
	// }

 //     p.registrarAudiencia(s);
 //     p.registrarAudiencia(s);
 //     p.registrarAudiencia(s);
 //     assertEquals(3, s.getAudiencia());
 //   }


 // }
