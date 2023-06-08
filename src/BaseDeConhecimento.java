public class BaseDeConhecimento {

    int mundo[][]; // mundo Wumpus conhecido (0: desconhecido; 1: seguro; -1: não seguro)
    boolean caminho[][];

    public BaseDeConhecimento() {
        mundo = new int[4][4];
        caminho = new boolean[4][4];
        // Inicialização do mundo inicial conhecido
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mundo[i][j] = 0;
                caminho[i][j] = false;
            }
        }
        mundo[0][0] = 1;
        caminho[0][0] = true;
    }

    public int[] ask(boolean percep[], int i, int j) {
        int posicao[] = new int[2]; // Posicao do personagem
        boolean brisa = percep[0]; // Se tem brisa nas casas adjacentes tem poço
        boolean fedor = percep[1]; // Se tem fedor, há um Wumpus nas casas adjacentes
        boolean brilho = percep[2]; // Casas adjacentes têm tesouro
        boolean poco = percep[3]; // O personagem morre
        boolean Wumpus = percep[4]; // O personagem morre
        boolean tesouro = percep[5]; // O personagem ganha

        if ((i == 0) && (j == 0)) { // Sala (0,0)
            mundo[0][1] = 1;
            mundo[1][0] = 1;
            if (!caminho[0][1]) { // Se ele já visitou (0,1)
                posicao[0] = 0;
                posicao[1] = 1;
            } else { // Vá para a sala (1,0)
                posicao[0] = 1;
                posicao[1] = 0;
            }
        } else if ((i == 0) && (j == 1)) { // Sala (0,1)
            // Verifica se há brisa e define o estado das casas adjacentes
            if (!brisa) {
                mundo[1][1] = 1; // Seguro
                mundo[0][2] = 1; // Seguro
            } else {
                mundo[1][1] = -1; // Não seguro
                mundo[0][2] = -1; // Não seguro
            }
            // Verifica se há fedor e define o estado das casas adjacentes
            if (!fedor) {
                mundo[1][1] = 1; // Seguro
                mundo[0][2] = 1; // Seguro
            } else {
                mundo[1][1] = -1; // Não seguro
                mundo[0][2] = -1; // Não seguro
            }

            // Define a próxima posição com base no estado das casas adjacentes
            if (mundo[1][1] == 1) {
                posicao[0] = 1;
                posicao[1] = 1;
            } else {
                if (mundo[0][2] == 1) {
                    posicao[0] = 0;
                    posicao[1] = 2;
                } else { // Retorne à posição inicial
                    posicao[0] = 0;
                    posicao[1] = 0;
                }
            }
        } else if ((i == 1) && (j == 0)) {
            // Verifica se há brisa e define o estado das casas adjacentes
            if (!brisa) {
                mundo[1][1] = 1; // Seguro
                mundo[2][0] = 1; // Seguro
            } else {
                mundo[1][1] = -1; // Não seguro
                mundo[2][0] = -1; // Não seguro
            }
            // Verifica se há fedor e define o estado das casas adjacentes
            if (!fedor) {
                mundo[1][1] = 1; // Seguro
                mundo[2][0] = 1; // Seguro
            } else {
                mundo[1][1] = -1; // Não seguro
                mundo[2][0] = -1; // Não seguro
            }

            // Define a próxima posição com base no estado das casas adjacentes
            if (mundo[1][1] == 1) {
                posicao[0] = 1;
                posicao[1] = 1;
            } else {
                if (mundo[2][0] == 1) {
                    posicao[0] = 2;
                    posicao[1] = 0;
                } else {
                    // Verifica se as casas adjacentes a (1,1) foram visitadas e continuam sendo não seguras (-1).
                    // Se for o caso, a casa (1,1) é marcada como segura, pois não pode haver um poço e um Wumpus no mesmo local.
                    if (caminho[0][1] == true && caminho[1][0] == true && mundo[1][1] == -1) {
                        mundo[1][1] = 1; // Seguro

                        // Verifica se há brisa e define o estado das casas adjacentes
                        if (!brisa) {
                            mundo[1][2] = 1; // Seguro
                            mundo[2][1] = 1; // Seguro
                        } else {
                            mundo[1][2] = -1; // Não seguro
                            mundo[2][1] = -1; // Não seguro
                        }
                        // Verifica se há fedor e define o estado das casas adjacentes
                        if (!fedor) {
                            mundo[1][2] = 1; // Seguro
                            mundo[2][1] = 1; // Seguro
                        } else {
                            mundo[1][2] = -1; // Não seguro
                            mundo[2][1] = -1; // Não seguro
                        }

                        // Define a próxima posição com base no estado das casas adjacentes
                        if (mundo[1][2] == 1) {
                            posicao[0] = 1;
                            posicao[1] = 2;
                        } else {
                            if (mundo[2][1] == 1) {
                                posicao[0] = 2;
                                posicao[1] = 1;
                            } else { // Retorne à posição (1,1)
                                posicao[0] = 1;
                                posicao[1] = 1;
                            }
                        }
                    }
                }
            }
        } else if ((i == 1) && (j == 2)) {
            // Verifica se há brisa e define o estado das casas adjacentes
            if (!brisa) {
                mundo[2][2] = 1; // Seguro
                mundo[1][3] = 1; // Seguro
            } else {
                mundo[2][2] = -1; // Não seguro
                mundo[1][3] = -1; // Não seguro
            }
            // Verifica se há fedor e define o estado das casas adjacentes
            if (!fedor) {
                mundo[2][2] = 1; // Seguro
                mundo[1][3] = 1; // Seguro
            } else {
                mundo[2][2] = -1; // Não seguro
                mundo[1][3] = -1; // Não seguro
            }

            // Define a próxima posição com base no estado das casas adjacentes
            if (mundo[2][2] == 1) {
                posicao[0] = 1;
                posicao[1] = 2;
            } else {
                if (mundo[1][3] == 1) {
                    posicao[0] = 2;
                    posicao[1] = 1;
                } else {
                    // Retorne à posição (1,1)
                    posicao[0] = 1;
                    posicao[1] = 1;
                }
            }
        } else if ((i == 2) && (j == 1)) {
            // Verifica se há brisa e define o estado das casas adjacentes
            if (!brisa) {
                mundo[3][1] = 1; // Seguro
                mundo[2][2] = 1; // Seguro
            } else {
                mundo[2][2] = -1; // Não seguro
                mundo[1][3] = -1; // Não seguro
            }
            // Verifica se há fedor e define o estado das casas adjacentes
            if (!fedor) {
                mundo[3][1] = 1; // Seguro
                mundo[2][2] = 1; // Seguro
            } else {
                mundo[3][1] = -1; // Não seguro
                mundo[2][2] = -1; // Não seguro
            }
            // Define a próxima posição com base no estado das casas adjacentes
            if (mundo[3][1] == 1) {
                posicao[0] = 3;
                posicao[1] = 1;
            } else {
                if (mundo[2][2] == 1) {
                    posicao[0] = 2;
                    posicao[1] = 2;
                } else {
                    // Retorne à posição (1,1)
                    posicao[0] = 1;
                    posicao[1] = 1;
                }
            }
        }
        return posicao;
    }

    public void tell(int i, int j) {
        caminho[i][j] = true; // Marca a sala como caminho percorrido
    }
}
