// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
// import java.util.Random;

// public class AvaliacaoTest {
//     private final Random gerador = new Random();
//     Avaliacao a;

//     Integer id = gerador.nextInt(100);
//     Integer nota = gerador.nextInt(5);
//     String comentario = "Comentario";

//     Cliente c;
//     String userLogin = "robertoCaraMau";
//     String userPassword = "123";
//     String userName = "Roberto";
//     List<Conteudo> listaParaVer;
//     List<Conteudo> listaJaVista;
//     List<Date> listDatasAssistidas;


//     @BeforeEach
//     void setUp() {
//         listaParaVer = new ArrayList<>();
//         listaJaVista = new ArrayList<>();
//         listDatasAssistidas = new ArrayList<>();

//         c = new Cliente(userName, userPassword, userLogin, listaParaVer, listaJaVista, listDatasAssistidas);
//         a = new Avaliacao(id, c, nota, comentario);
//     }


//     @Test
//     @DisplayName("Criando a instancia Cliente")
//     void createAvaliacao() {
//         assertEquals(id, a.getIdConteudo());
//         assertInstanceOf(Cliente.class, a.getAutor());
//         assertEquals(c.getNomeDeUsuario(), a.getAutor().getNomeDeUsuario());
//         assertEquals(nota, a.getNota());
//         assertEquals(comentario, a.getComentario());
//     }

//     @Test
//     @DisplayName("Pegando a media")
//     void testMedia() {
//         assertEquals(0, a.getMedia());
//         a.setMedia(1);
//         assertEquals(1, a.getMedia());
//     }

// }
