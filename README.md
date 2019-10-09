# SWExpertAcademy_D3_Java_7675

## SW Expert Academy D3 7675. 통역사 성경이

### 1. 문제설명

출처: https://swexpertacademy.com/main/code/problem/problemList.do

input으로 문장의 갯수 `N`과, 다음줄에 `N`개의 문장이 온다. 문장은 구두점 `.`, `?`, `!`으로 나누어 지며 각 문장마다의 이름의 개수를 return하는 문제. 이름은 첫글자가 대문자 알파벳으로 시작하며 나머지는 소문자 알파벳으로 구성되어있다. 예외적으로 마지막 단어가 구두점일 경우에도 이름이며, 대문자 한 글자도 이름이다. 

[입력]
> 첫 번째 줄에 테스트 케이스의 수 `T(1 ≤ T ≤ 11)`가 주어진다.
> 각 테스트 케이스의 첫 번째 줄에는 문장의 개수 `N(1 ≤ N ≤ 5)`이 주어진다.
> 두 번째 줄에는 `N`개의 문장이 주어지며, 총 문자의 개수는 `1,000`개 이하이다.


[출력]
> 각 테스트 케이스마다 `#x`(`x`는 테스트케이스 번호를 의미하며 `1`부터 시작한다)를 출력하고,
> `N`개의 수를 공백 하나로 구분하여 출력해야 하며, 각수는 각 문장에 속한 이름의 개수여야 한다.

### 2. 풀이

문장마다 이름의 갯수를 카운트하기 위해 `N`개의 정수형 배열을 선언하였다. 문장이 들어오면 공백으로 토큰을 나누어 검사한다. 검사의 순서는 구두점, 대문자여부, 나머지 문자가 모두 소문자인가 순서로 진행된다. `endsWith()`를 이용하여 구두점이 있다면 해당 토큰의 검사가 끝난후 다음 문장에서 이름의 갯수를 세기 위하여 `index`가 넘어갈 것이라는 플래그를 `on`시킨다. 구두점 검사 후, 해당 토큰이 대문자로 시작하면 이름일 수 있으므로 다음 검사를 진행한다. 문자열의 각 위치에서`for`문을 돌며 `Character.isLowerCase()`함수를 이용하여 소문자 여부를 검사하였다. 만약 하나라도 맞지 않는다면 이름이 아니므로 카운트를 하지않고 모든 글자가 소문자라면 이름이라는 플래그를 `on`시켜 토큰의 검사가 끝난후 이름갯수를 한개 증가시킨다.

```java

int N = Integer.parseInt(sc.nextLine());
String sentences = sc.nextLine();
StringTokenizer st = new StringTokenizer(sentences);
int[] nameCount = new int[N];
int nameCountIdx = 0;
boolean isEnd = false;

while (st.hasMoreTokens()) {
  String tok = st.nextToken();

  if (tok.endsWith(".") || tok.endsWith("!") || tok.endsWith("?")) {
    tok = tok.substring(0, tok.length()-1);
    isEnd = true;
  }

  if (Character.isUpperCase(tok.charAt(0))) {
    tok = tok.substring(1);
    boolean isName = true;

    for (int i = 0; i < tok.length(); i++) {
      if (Character.isLowerCase(tok.charAt(i))) {
        continue;
      } else {
        isName = false;
        break;
      }
    }

    if (isName) {
      nameCount[nameCountIdx]++;
    }
  } 
  if (isEnd) {
    nameCountIdx++;
    isEnd = false;
  }
}

StringBuilder result = new StringBuilder("#"+test_case+" ");
for (int i = 0; i < N; i++) {
  result.append(nameCount[i]+" ");
}
System.out.println(result.toString());


```
