### 제목
장군

### 문제
<p>오랜만에 휴가를 나온 호근이는 문득 동아리방에 있는 장기가 하고 싶어졌다. 하지만 장기를 오랫동안 하지 않은 탓인지 예전에는 잘 쓰던 상을 제대로 쓰는 것이 너무 힘들었다. 호근이를 위해 상을 어떻게 써야 할지 도와주자.</p>

![ALT_TEXT](https://github.com/ISKU/2nd-Thinking-PC/blob/master/E/img/IMG_01.png)

<p>위 그림은 10&times;9 크기의 장기판을 나타내며, 상은 (5, 4)에, 왕은 (1, 4)에 자리 잡고 있는 기물이다. (0, 3)과 (2, 5)를 꼭짓점으로 하는 사각형과, (7, 3)과 (9, 5)를 꼭짓점으로 하는 사각형은 왕이 위치할 수 있는 궁성이라고 한다. 상은 위 그림과 같이 8가지 방법으로 움직일 수 있는데, 상, 하, 좌, 우로 한 칸을 이동한 후에 같은 방향 쪽 대각선으로 두 칸 이동한다.</p>

![ALT_TEXT](https://github.com/ISKU/2nd-Thinking-PC/blob/master/E/img/IMG_02.png)

<p>만약 상이 이동하는 경로에 위 그림과 같이 다른 기물이 있다면 상은 그쪽으로 이동할 수 없다. 또한, 상이 장기판을 벗어날 수도 없다.</p>

<p>10&times;9 크기의 장기판 위에 상과 왕의 처음 위치가 주어졌을 때, 상이 왕에게 도달할 수 있는 최소 이동 횟수를 구하여라.</p>

### 입력
<p>첫 번째 줄에는 상의 위치를 의미하는 정수 <em>R<sub>1</sub></em>, <em>C<sub>1</sub></em>이 주어진다.</p>

<p>두 번째 줄에는 왕의 위치를 의미하는 정수 <em>R<sub>2</sub></em>, <em>C<sub>2</sub></em>가 주어진다. 장기판에서 <em>R<sub>i</sub></em> (0 &le; <em>R<sub>i</sub></em> &le; 9)는 행을, <em>C<sub>i</sub></em> (0 &le; <em>C<sub>i</sub></em> &le; 8)는 열을 의미한다.</p>

<p>왕은 항상 궁성에 자리 잡고 있으며, 상과 왕의 위치는 겹치지 않는다.</p>

### 출력
<p>상이 왕에게 도달할 수 있는 최소 이동 횟수를 출력한다. 만약 도달할 수 없다면 <code>-1</code>을 출력한다.</p>

### 예제 입력 1
```
4 2
2 5
```

### 예제 출력 1
```
1
```

![ALT_TEXT](https://github.com/ISKU/2nd-Thinking-PC/blob/master/E/img/IMG_03.png)

### 예제 입력 2
```
0 1
8 4
```

### 예제 출력 2
```
3
```

![ALT_TEXT](https://github.com/ISKU/2nd-Thinking-PC/blob/master/E/img/IMG_04.png)

### 예제 입력 3
```
0 2
1 4
```

### 예제 출력 3
```
5
```

![ALT_TEXT](https://github.com/ISKU/2nd-Thinking-PC/blob/master/E/img/IMG_05.png)

### 분류
BFS

### 만든이
충남대학교 컴퓨터공학과 이종화 ([willook@GitHub](https://github.com/willook), [willook@BOJ](https://www.acmicpc.net/user/willook))
