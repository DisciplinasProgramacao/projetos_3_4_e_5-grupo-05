// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

// public class FilmeTest {

//     Filme f;
//     String nome = "Batman";
//     String genero = "Drama";
//     String idioma = "Inglês";
//     String dataDeLancamento = "12/0/2023";
//     int duracao = 120;

//     @BeforeEach
//     void setUp() {
//         f = new Filme(nome,genero, idioma, dataDeLancamento, duracao );
//     }


//     @Test
//     @DisplayName("Criando um filme e verificando os seus valores")
//     void CreateSerie() {
//         assertEquals(nome, f.getNome());
//         assertEquals(genero, f.getGenero());
//         assertEquals(idioma, f.getIdioma());
//         assertEquals(duracao*60, f.getDuracao());
//         assertEquals(dataDeLancamento, f.getDataDeLancamento());
//         assertEquals(0, f.getAudiencia());
//     }


//     @Test
//     @DisplayName("Registrando uma nova audiencia")
//     void registrarAudiencia() {
//         assertEquals(0, f.getAudiencia());
//         f.registrarAudiencia();
//         assertEquals(1, f.getAudiencia());
//     }
// }
