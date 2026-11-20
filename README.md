
# AV3 - Problema da Mochila em Java

## Descrição

Este projeto apresenta a resolução do Problema da Mochila 0/1,
desenvolvido como atividade avaliativa AV3 da disciplina de
Construção e Análise de Algoritmos.

O objetivo é selecionar itens para uma mochila, maximizando
o valor total sem ultrapassar sua capacidade máxima.

Cada item possui um peso e um valor e pode ser selecionado
apenas uma vez.

## Algoritmos implementados

### 1. Recursão Ingênua
Explora recursivamente as possibilidades de incluir ou
não cada item, sem armazenar resultados anteriores.

- Classe: `MochilaRecursiva.java`
- Complexidade de tempo: O(2^n), no pior caso.

### 2. Top-down com Memoização
Utiliza recursão e armazena os resultados dos subproblemas
para evitar cálculos repetidos.

- Classe: `MochilaTopDown.java`
- Complexidade de tempo: O(n × W).

### 3. Bottom-up com Tabulação
Utiliza uma tabela de programação dinâmica, preenchida
iterativamente para encontrar a solução ótima.

- Classe: `MochilaBottomUp.java`
- Complexidade de tempo: O(n × W).

## Tecnologias

- Java
- IntelliJ IDEA
- Git e GitHub

## Estrutura do projeto

```text
AV3-Problema-da-Mochila-Java/
├── src/
│   ├── Main.java
│   ├── Item.java
│   ├── MochilaRecursiva.java
│   ├── MochilaTopDown.java
│   └── MochilaBottomUp.java
├── docs/
│   └── AnaliseDoProblema.md
├── .gitignore
└── README.md
```

## Itens utilizados

| Item | Peso | Valor |
|------|------|-------|
| Lanterna | 2 | 6 |
| Barraca | 4 | 10 |
| Faca | 1 | 3 |
| Cobertor | 3 | 7 |
| Cantil | 2 | 5 |
| Mapa | 1 | 4 |
| Corda | 5 | 9 |

## Resultados dos testes

As três implementações foram testadas utilizando
os mesmos itens e capacidades.

| Capacidade | Valor máximo | Peso total |
|------------|--------------|------------|
| 6 | 18 | 6 |
| 10 | 28 | 10 |
| 15 | 37 | 15 |

Todas as abordagens produziram os mesmos valores máximos.

## Como executar

1. Clone este repositório.
2. Abra o projeto no IntelliJ IDEA.
3. Configure o JDK.
4. Acesse `src/Main.java`.
5. Execute o método `main`.

O programa exibirá os resultados das três implementações,
incluindo valor máximo, peso total e itens escolhidos.

## Análise do problema

A explicação sobre a aplicação da programação dinâmica
está disponível em [Análise do Problema](docs/AnaliseDoProblema.md).

## Integrantes

- Samuel Batista Oliveira
- Pedro Lucas De Oliveira Duarte
