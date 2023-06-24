package business;
import java.util.Random;

public enum Genero {
    ACAO("Ação"),
    AVENTURA("Aventura"),
    ANIME("Anime"),
    COMEDIA("Comédia"),
    DOCUMENTARIO("Documentario"),
    DRAMA("Drama"),
    POLICIAL("Policial"),
    ROMANCE("Romance"),
    SUSPENSE("Suspense");


  //     Declaração de variáveis 
  
    private final String genero;

  //      Construtores
  
    Genero(String g){
        this.genero = g;
    }

  //      Getters e Setters
  
    public String getGenero(){
        return this.genero;
    }

  /** Função para gerar um gênero aleatório
  * 
  * @return String - Gênero aleatoriamente gerado
  */
  public static String getGeneroAleatorio() {
    Random random = new Random();
    Genero[] generos = Genero.values();
    int randomIndex = random.nextInt(generos.length);

    String generoAleatorio = generos[randomIndex].getGenero();
    while (generoAleatorio == null) {
        randomIndex = random.nextInt(generos.length);
        generoAleatorio = generos[randomIndex].getGenero();
    }

    return generoAleatorio;
  }


  /** Função reponsável por converter o enum em um vetor de String
  * 
  * @return String[] - Vetor de valores dos gêneros
  */
  
    public static String[] toArray(){
        Genero[] generos = Genero.values();
        String[] generosString = new String[generos.length];

        for(int i = 0; i < generos.length ; i++){
            generosString[i] = generos[i].getGenero();
        }

        return generosString;
    }
}


