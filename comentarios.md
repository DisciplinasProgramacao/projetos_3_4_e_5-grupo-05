## Correção Projeto 3 (branch de 02/05)

### Nota base: 11,75

### Comentários

- Preencheram backlog, sem informar responsável
- Preencheram instruções de uso
- Enviaram video de apresentação
- A carga de arquivos pode ser automática ao executar o sistema
- Não foram implementados todas as opções de filtragens (por nome)
- Diagrama desatualizado
- Todos os testes estão comentados
- Documentação praticamente inexistente
- A carga de dados poderia ser autamatica ao executar a aplicação
- Por questões de polimorfismo, deveria possuir as informações do Conteudo em Cliente e PlataformaStreaming, assim como os mecanismos de filtragem, assistir e registrar audiencia deveriam se beneficar dos mesmos - Muito trecho de código repetido em virtude disso, contando também com a Main
- Não é uma boa prática deixar entrada de dados (scanner) dentro de classes de regra de negócio (PlataformaStreming)
- Não estão salvando dados

1. Aderência às classes do diagrama: 1,25/2 pontos
  - Diagramas

2. Requisitos de corretamente implementados: 8,75/12 pontos
  - Carga de dados					1,75/2 pontos
  - Cadastro + salvar dados			1/2 pontos
  - Robustez básica					1/1 ponto
  - Clientes							1/2 pontos
	Listas, audiência sem repet
  - Séries							1/1 ponto
	 - audiência
  - Filme/Herança de mídia			1/1 ponto
  - Buscas 							2/3 pontos
	 - nome, gênero, idioma

3. Documentação de código: 0,25/4 pontos

4. Implementação na aula inicial: 1,5/2 pontos (cliente e série testados)
- Poderiam exercitar mais a serie
