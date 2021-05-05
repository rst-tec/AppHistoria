# App Histórias Bíblicas

## Projeto de desenvolviento pessoal, para aplicar os conteudos aprendido em um projeto real.
Tudo começou quando procurei um aplicativo do genero para ler histórias para minha filha, como não encontrei, decidi iniciar um curso de desenvolvimento de aplicativos Android em Java e cria o meu próprio aplicativo.

Projeto independente sem fins lucrativos.
Com o objetivo de levar a palavra de Deus a diversos lares, onde os pais possam ler para seus filhos,
as principais histórias bíblicas.

- Tela Splash: Foi utilizado a função **randomica** para exibir de forma aleatório um versiculo diferente a cada acesso.
- MainActivity: Foi adicionado um **banner** de anuncio. 
- As listas de histórias: Foi desenvolvida utilizando **Fragmetos**, para alterar de uma para outra de forma mais suave, ele contém um **ScrollView** e um banner de anuncio no rodapé, cada história esta dentro de um botão que ao acionado estancia uma **Intent** e envia uma (chave e valor) via **putExtra.** para a tela de história selecionada, a tela de história recebe esse valor atraves de um **Bundle** **getExtras** e start a história.

- Tela de história: 
1. Contém um Banner de anuncio no topo.
2. Contém um botão para alianhamento do texto (Esqueda, Centro ou Direita), e um botão para alteração da cor de fundo, essas escolhas são salvas no **Shared Preferences.**
4. Contém um botão para iniciar a leitura da história, e um botão para iniciar uma música de fundo, essas funções foram desenvolvidas utilizando o **MediaPlayer** nativo do Android que inicia os arquivos que estão embarcados dentro do aplicativo.
6. Contém um botão para chamar um pergunta relacionada aquela história.
7. Contém um botão para avançar para a proxima historia e ou tro botão para voltar a tela de lista de histórias.


