package business;
import java.util.Random;

public enum Idioma {

  //       Declaração de variáveis
  
    INGLES("Ingles"),
    PORTUGUES("Português"),
    ESPANHOL("Espanhol"),
    MANDARIM("Mandarim"),
    TURCO("Turco"),
    FRANCES("Francês"),
    RUSSO("Russo"),
    ALEMAO("Alemão"),
    JAPONES("Japonês"),
    COREANO("Koreano"),
    ITALIANO("Italiano"),
    GREGO("Grego");

    private final String idioma;

  //     Construtores
  
    Idioma(String i){
        this.idioma = i;
    }

    public String getIdioma(){
        return this.idioma;
    }

  /** Função auxiliar para gerar um gênero aleatório
  * 
  * @return String - o valor aleatório de um Idiomar
  */
    public static String getIdiomaAleatorio() {
        Random random = new Random();
        Idioma[] idiomas = Idioma.values();
        int randomIndex = random.nextInt(idiomas.length);
        while(idiomas[randomIndex].getIdioma() == null){
          randomIndex = random.nextInt(idiomas.length);
        }
        return idiomas[randomIndex].getIdioma();
    }
}
