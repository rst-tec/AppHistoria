# App Histórias Bíblicas

## Projeto de desenvolviento pessoal, para aplicar os conteudos aprendido em um projeto real.
Tudo começou quando procurei um aplicativo do genero para ler histórias para minha filha, como não encontrei, decidi iniciar um curso de desenvolvimento de aplicativos Android em Java e cria o meu próprio aplicativo.

Projeto independente sem fins lucrativos, com o objetivo de levar a palavra de Deus a diversos lares, onde os pais possam ler para seus filhos,
as principais histórias bíblicas.

- **Tela Splash:** 
- Foi utilizado a função **randomica** para exibir de forma aleatório um versiculo diferente a cada acesso.
![alt text](https://github.com/rst-tec/AppHistoria/blob/AndroidNovaVersao/ImagensTelas/App-Tela-01.jpeg)

- **MainActivity:** 
- Foi adicionado um **banner** de anuncio. 
- Contém 3 botões de acesso.
![alt text](https://github.com/rst-tec/AppHistoria/blob/AndroidNovaVersao/ImagensTelas/App-Tela-02.jpeg)


- **Lista de histórias:** 
- Foi desenvolvida utilizando **Fragmetos**, para alterar de uma para outra de forma mais suave.
- Contém um **ScrollView** e um banner de anuncio no rodapé.
- Cada história esta dentro de um botão que ao acionado estancia uma **Intent** e envia uma (chave e valor) via **putExtra** para a tela de história selecionada, a tela de história recebe esse valor atraves de um **Bundle** **getExtras** e start a história.
![alt text](https://github.com/rst-tec/AppHistoria/blob/AndroidNovaVersao/ImagensTelas/App-Tela-03.jpeg)


- **Tela de histórias:** 
- Contém um Banner de anuncio no topo.
- Contém um botão para alianhamento do texto (Esqueda, Centro ou Direita), e um botão para alteração da cor de fundo, essas escolhas são salvas no **Shared Preferences.**
- Contém um botão para iniciar a leitura da história, e um botão para iniciar uma música de fundo, essas funções foram desenvolvidas utilizando o **MediaPlayer** nativo do Android que inicia os arquivos que estão embarcados dentro do aplicativo.
- Contém um botão para chamar um pergunta relacionada aquela história.
- Contém um botão para avançar para a proxima historia e ou tro botão para voltar a tela de lista de histórias.
![alt text](https://github.com/rst-tec/AppHistoria/blob/AndroidNovaVersao/ImagensTelas/App-Tela-04.jpeg).


- **Tela jogo de perguntas:** 
- Jogo de perguntas.
![alt text](https://github.com/rst-tec/AppHistoria/blob/AndroidNovaVersao/ImagensTelas/App-Tela-05.jpeg).


