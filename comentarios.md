# Comentários - Projeto 4 (30/05)

## Nota base: 10

### Comentários

- Intruções de uso preenchido
- Backlog preenchido
- Fizeram o video de apresentação
- Diagrama desatualizado, não contempla a avaliação, por exemplo
- Comentários inexistente
- Como possuem herança entre Conteúdo e os elementos Filme e Serie, crie apenas uma lista de Conteúdo, evitando assim criar elementos duplicados e garantindo os benefícios do polimorfismo
- Operações com o Filme não funcionam em virtude do uso de Serie, exemplo assistir filme
- Utilizem enumeradores quando necessário
- Uma possível solução ao implementar a classe Avaliacao seria definir uma interface de Avaliadores para diferenciar os Clientes
- Se nos metodos de registrarAudiencia vocês utilizam apenas o id do parâmetro, então porque não recebem o parâmetro id?
- Removam trechos de código comentado
- Na classe Main revejam aninhamento de chamadas, ex:

        streaming.getClienteAtual().adicionarNaLista(streaming.series.get(input.nextInt()));

- Não permite dar nota para a serie

        Resposta: 3
        Series para ver: 
        Id da serie que deseja assistir: 3540
        Deseja dar nota para a série?(S/N) s
        738598
        738508
        Dia atual 23/6/2023

        1 - Mostrar series para ver 
        2 - Mostrar series ja vistas 
        3 - Assistir serie
        4 - Adicionar serie a lista
        5 - Filtrar suas series
        6 - Filtrar todas as series 

        0 - Voltar


----
	
- Aderência às classes do diagrama: 1/2 pontos
- Requisitos de corretamente implementados: 7,5/14 pontos
    - só pode avaliar o que tiver visto		1/2 pontos
    - avaliar, calcular e exibir media 		1/2 pontos
    - cliente não pode avaliar 2x			1/3 pontos
    - especialistas podem comentar			3/4 pontos
    - verificação de especialistas			1,5/3 pontos
	
- Documentação de código: 0/2 pontos

- Implementação na aula inicial: 1,5/2 pontos (02/05)
    - arquivos JavaDoc  
    - diagrama atualizado 
    - backlog de pendências

----