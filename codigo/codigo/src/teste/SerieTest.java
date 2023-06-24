 // import static org.junit.jupiter.api.Assertions.*;

 // import org.junit.jupiter.api.BeforeEach;
 // import org.junit.jupiter.api.DisplayName;
 // import org.junit.jupiter.api.Test;

 // public class SerieTest {
 //       Cliente c;
 //       Avaliacao a;
 //       Serie s;
 //       PlataformaStreaming plataforma = new PlataformaStreaming("Plataforma");
 //       Integer id = 1;
 //       String nome = "Batman";
 //       String dataDeLancamento = "12/1/2023";

 //   @BeforeEach
 //   void setUp() {
 //       c = new Cliente("Arhtur", "senha", "login");
 //       a = new Avaliacao(id, c, 5);
 //       try {
	// 	s = new Serie(id, nome, dataDeLancamento);
	// 	} catch (ExecaoValorInvalido e) {
	// 		// TODO Auto-generated catch block
	// 		e.printStackTrace();
	// 	}
 //       try {
	// 		plataforma.adicionarSerie(s);
	// 	} catch (ExecaoValorInvalido e) {
	// 		// TODO Auto-generated catch block
	// 		e.printStackTrace();
	// 	}
 //       plataforma.adicionarCliente(c);
 //       plataforma.logar("login", "senha");
 //   }


 //   @Test
 //   @DisplayName("Criando uma serie e verificando os seus valores")
 //   void CreateSerie() {
 //     assertEquals(nome, s.getNome());
 //     assertNotNull(s.getGenero());
 //     assertNotNull(s.getIdioma());
 //     assertEquals(dataDeLancamento, s.getDataDeLancamento());
 //     assertEquals(0, s.getAudiencia());
 //   }

 //   @Test
 //   @DisplayName("Registrando uma nova audiencia")
 //   void registrarAudiencia() {
 //     assertEquals(0, s.getAudiencia());
 //     s.registrarAudiencia();
 //     assertEquals(1, s.getAudiencia());
 //   }


 //     @Test
 //     @DisplayName("Adicionando avaliacao")
 //     void testAdicionarAvaliacao() {
 //     	int tamanho = plataforma.getConteudo(a.getIdConteudo()).avaliacoes.size();
 //     	plataforma.salvaAvalicao(a);
 //         assertEquals(tamanho + 1, plataforma.getConteudo(a.getIdConteudo()).avaliacoes.size());
 //         plataforma.salvaAvalicao(a); // Adicionar uma avaliação já existente
 //         assertEquals(tamanho + 1, plataforma.getConteudo(a.getIdConteudo()).avaliacoes.size()); // Deve continuar do mesmo tamanho
     
 //     }


 //     @Test
 //     @DisplayName("Adicionando avaliacao")
 //     void testMediaNotas() {
 //         assertEquals(plataforma.getConteudo(a.getIdConteudo()).mediaNotas(), 0.0);

 //      	plataforma.salvaAvalicao(a);
      	
 //         assertEquals(plataforma.getConteudo(a.getIdConteudo()).mediaNotas(), 5);
 //     }

 // }
