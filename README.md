# ProjMundoWumpus

Resumo da lógica do projeto:
O código implementa uma base de conhecimento para um agente de IA que explora um ambiente do jogo "Wumpus World". A base de conhecimento é representada por duas matrizes: "mundo" e "caminho". A matriz "mundo" guarda o conhecimento sobre as casas do ambiente, onde o valor 0 representa uma casa desconhecida, 1 representa uma casa segura e -1 representa uma casa não segura. A matriz "caminho" guarda informações sobre as casas já visitadas pelo agente.

A função "ask" recebe as percepções do ambiente (brisa, fedor, brilho, poço, Wumpus e tesouro) e a posição atual do agente (i, j). Com base nessas informações, a função atualiza o conhecimento na matriz "mundo" e determina a próxima posição do agente.

A função "tell" é chamada para marcar uma casa como caminho percorrido na matriz "caminho".

Esse é apenas um trecho do código que aborda as primeiras posições do agente no ambiente. O restante do código provavelmente segue uma lógica similar, atualizando o conhecimento do
