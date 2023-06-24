// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

// public class FilmeTest {

//     Cliente c;
//     Avaliacao a;
//     PlataformaStreaming plataforma = new PlataformaStreaming("Plataforma");

//     Filme f;
//     Integer id = 1;
//     String nome = "Batman";
//     String dataDeLancamento = "12/1/2023";
//     int duracao = 120;

//     @BeforeEach
//     void setUp() {
//         c = new Cliente("Arhtur", "senha", "login");
//         try {
// 			f = new Filme(id, nome, dataDeLancamento, duracao);
// 		} catch (ExecaoValorInvalido e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
//         try {
// 			plataforma.adicionarFilme(f);
// 		} catch (ExecaoValorInvalido e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
//         plataforma.adicionarCliente(c);
//         plataforma.logar("login", "senha");
//         a = new Avaliacao(f.getId(), c, 5);
//     }


//     @Test
//     @DisplayName("Criando um filme e verificando os seus valores")
//     void CreateSerie() {
//         assertEquals(nome, f.getNome());
//         assertEquals(duracao*60, f.getDuracao());
//         assertEquals(dataDeLancamento, f.getDataDeLancamento());
//         assertEquals(0, f.getAudiencia());
//     }


//     @Test
//     @DisplayName("Registrando uma nova audiencia")
//     void testRegistrarAudiencia() {
//         assertEquals(0, f.getAudiencia());
//         f.registrarAudiencia();
//         assertEquals(1, f.getAudiencia());
//     }


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
//         assertEquals(f.mediaNotas(), 0.0);

//         plataforma.salvaAvalicao(a);
//         assertEquals(f.mediaNotas(), 5);
//     }


// }
