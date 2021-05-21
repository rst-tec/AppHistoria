# App Histórias Bíblicas

## Projeto de desenvolviento pessoal, para aplicar os conteudos aprendido em um projeto real.
Tudo começou quando procurei um aplicativo do genero para ler histórias para minha filha, como não encontrei, decidi iniciar um curso de desenvolvimento de aplicativos Android em Java e cria o meu próprio aplicativo.

Projeto independente sem fins lucrativos, com o objetivo de levar a palavra de Deus a diversos lares, onde os pais possam ler para seus filhos,
as principais histórias bíblicas.

- **Tela Splash:** 
- Foi desenvlvida uma função **randomica** para exibir de forma aleatório um versiculo diferente a cada acesso.
![mao_01](https://user-images.githubusercontent.com/61321277/119015505-55fbb600-b96f-11eb-8f9c-166c4a94bf7d.jpg)

- **MainActivity:** 
- Foi desenvlvida com 3 botões de acesso e contém um **banner** de anuncio no rodapé.                                                                                
![mao_02](https://user-images.githubusercontent.com/61321277/119015869-b559c600-b96f-11eb-9a8c-91b4af3c8d73.jpg)

- **Lista de histórias:** 
- Foi desenvolvida utilizando **Fragmetos**, para alterar de uma para outra de forma mais suave.
- Contém um **ScrollView** e um banner de anuncio no rodapé.
- Cada história esta dentro de um botão que ao acionado estancia uma **Intent** e envia uma (chave e valor) via **putExtra** para a tela de história selecionada, a tela de história recebe esse valor atraves de um **Bundle** **getExtras** e start a história.
![mao_03](https://user-images.githubusercontent.com/61321277/119192660-e103ab80-ba56-11eb-9ef7-99d2658f5859.jpg)
![mao_03-B](https://user-images.githubusercontent.com/61321277/119192483-9da93d00-ba56-11eb-8a7e-74eae2411e73.jpg)

- **Tela de histórias:** 
- Foi desenvlvida com um Banner de anuncio no topo.
- Contém um botão para alianhamento do texto (Esqueda, Centro ou Direita), e um botão para alteração da cor de fundo, essas escolhas são salvas no **Shared Preferences.**
- Contém um botão para iniciar a leitura da história, e um botão para iniciar uma música de fundo, essas funções foram desenvolvidas utilizando o **MediaPlayer** nativo do Android que inicia os arquivos que estão embarcados dentro do aplicativo.
- Contém um botão para chamar um pergunta relacionada aquela história.
- Contém um botão para avançar para a proxima história e outro botão para voltar a tela de lista de histórias.
![mao_04](https://user-images.githubusercontent.com/61321277/119016400-43ce4780-b970-11eb-8f85-4014e7e22ce6.jpg)

- **Tela jogo de perguntas:** 
- Foi desenvolvida uma função utilizando o **TextToSpeech** que sintetiza a fala do texto para reprodução imediata, essa função faz a leitura da pergunta.
- Contém 3 alternatvas onde apenas uma é a correta, ao clicar é exibido um **alert** e toca um som para erro ou acerto.
- Caso acerte passa para a proxima pergunta, caso erre tente novamente.
- O jogo foi dividido em fase de 10 perguntas cada.
- Os erros e acertos são computados e exibidos ao final de cada fase.                                                           
![mao_05](https://user-images.githubusercontent.com/61321277/119016468-5d6f8f00-b970-11eb-8ad1-24860f5ba11f.jpg)

- **Tela final do jogo:** 
- A pontuação é salvas no **Shared Preferences.** e exibida ao final do jogo
- Inicia uma música de fundo, essa função foi desenvolvidas utilizando o **MediaPlayer** nativo do Android                                   
![mao_06](https://user-images.githubusercontent.com/61321277/119018830-e7205c00-b972-11eb-9770-8ab8e03d6818.jpg)
