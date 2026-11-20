# Análise do Problema da Mochila 0/1

## Por que esse problema pode ser resolvido por programação dinâmica?

O Problema da Mochila 0/1 consiste em selecionar um conjunto de itens, cada um com um peso e um valor, buscando maximizar o valor total sem ultrapassar a capacidade máxima da mochila. Como cada item pode ser escolhido apenas uma vez, é necessário analisar diferentes combinações para encontrar a melhor solução possível.

Esse problema pode ser resolvido por programação dinâmica porque apresenta duas características fundamentais: **subestrutura ótima e subproblemas sobrepostos**.

A subestrutura ótima ocorre porque a solução ideal de um problema pode ser construída a partir das soluções ideais de problemas menores. No caso da mochila, para cada item, existem duas possibilidades: incluí-lo ou deixá-lo de fora. A escolha depende de qual alternativa proporciona o maior valor, respeitando a capacidade disponível.

Os subproblemas sobrepostos aparecem quando diferentes caminhos da recursão precisam resolver novamente situações que já foram analisadas, considerando a mesma quantidade de itens e a mesma capacidade restante. Na recursão ingênua, esses cálculos são repetidos, aumentando o tempo de execução.

A programação dinâmica permite evitar essas repetições por meio de duas abordagens: **Top-down com memoização**, que armazena os resultados das chamadas recursivas, e **Bottom-up com tabulação**, que constrói as soluções a partir dos menores subproblemas utilizando uma tabela.

Na implementação por recursão ingênua, todas as possibilidades necessárias são exploradas sem armazenar resultados anteriores. Por isso, sua complexidade de tempo no pior caso é exponencial, O(2ⁿ), sendo n a quantidade de itens. Já as abordagens de programação dinâmica podem resolver o problema em O(n × W), considerando n itens e uma capacidade inteira W.

Portanto, o Problema da Mochila 0/1 é adequado para programação dinâmica porque pode ser dividido em subproblemas menores, apresenta cálculos repetidos e permite construir a solução ótima a partir de decisões anteriores. Dessa forma, a programação dinâmica reduz o trabalho computacional necessário em comparação com a recursão ingênua.