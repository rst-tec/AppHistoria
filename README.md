# App Histórias Bíblicas

## Projeto de desenvolviento pessoal, para aplicar os conteudos aprendido em um projeto real.
Tudo começou quando procurei um aplicativo do genero para ler histórias para minha filha, como não encontrei, decidi iniciar um curso de desenvolvimento de aplicativos Android em Java e cria o meu próprio aplicativo.

Projeto independente sem fins lucrativos, com o objetivo de levar a palavra de Deus a diversos lares, onde os pais possam ler para seus filhos,
as principais histórias bíblicas.

- **Tela Splash:** 
- Foi utilizado a função **randomica** para exibir de forma aleatório um versiculo diferente a cada acesso.
![mao_01](https://user-images.githubusercontent.com/61321277/119015505-55fbb600-b96f-11eb-8f9c-166c4a94bf7d.jpg)

- **MainActivity:** 
- Foi adicionado um **banner** de anuncio. 
- Contém 3 botões de acesso.
- 
![mao_02](https://user-images.githubusercontent.com/61321277/119015869-b559c600-b96f-11eb-9a8c-91b4af3c8d73.jpg)

- **Lista de histórias:** 
- Foi desenvolvida utilizando **Fragmetos**, para alterar de uma para outra de forma mais suave.
- Contém um **ScrollView** e um banner de anuncio no rodapé.
- Cada história esta dentro de um botão que ao acionado estancia uma **Intent** e envia uma (chave e valor) via **putExtra** para a tela de história selecionada, a tela de história recebe esse valor atraves de um **Bundle** **getExtras** e start a história.
![mao_03](https://user-images.githubusercontent.com/61321277/119016279-213c2e80-b970-11eb-82e7-a16be75ec4d4.jpg)


- **Tela de histórias:** 
- Contém um Banner de anuncio no topo.
- Contém um botão para alianhamento do texto (Esqueda, Centro ou Direita), e um botão para alteração da cor de fundo, essas escolhas são salvas no **Shared Preferences.**
- Contém um botão para iniciar a leitura da história, e um botão para iniciar uma música de fundo, essas funções foram desenvolvidas utilizando o **MediaPlayer** nativo do Android que inicia os arquivos que estão embarcados dentro do aplicativo.
- Contém um botão para chamar um pergunta relacionada aquela história.
- Contém um botão para avançar para a proxima historia e ou tro botão para voltar a tela de lista de histórias.
![mao_04](https://user-images.githubusercontent.com/61321277/119016400-43ce4780-b970-11eb-8f85-4014e7e22ce6.jpg)


- **Tela jogo de perguntas:** 
- Jogo de perguntas.
- 
![alt text](https://drive.google.com/file/d/1Nj3ZuJISDn7eJn7fZDh1H5hnatiP1LdE/view?usp=sharing)
