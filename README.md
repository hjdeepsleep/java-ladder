# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

---

## 사다리 게임 만들기

## 기능 요구사항
1. step2
    * 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
    * 사람 이름은 쉼표(,)를 기준으로 구분한다.
    * 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
    * 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
        * |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
1. step3
    * 사다리 실행 결과를 출력해야 한다.
    * 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

## 프로그래밍 요구사항
1. step2
    * 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
    * 규칙 6: 모든 엔티티를 작게 유지한다.
1. step3
    * 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
    * 규칙 6: 모든 엔티티를 작게 유지한다.
    * 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.    

## 실행 결과
* 위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
    ```text
    참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
    pobi,honux,crong,jk
    
    실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
    꽝,5000,꽝,3000
    
    최대 사다리 높이는 몇 개인가요?
    5
    
    사다리 결과
    
    pobi  honux crong   jk
        |-----|     |-----|
        |     |-----|     |
        |-----|     |     |
        |     |-----|     |
        |-----|     |-----|
    꽝    5000  꽝    3000
    
    결과를 보고 싶은 사람은?
    pobi
    
    실행 결과
    꽝
    
    결과를 보고 싶은 사람은?
    all
    
    실행 결과
    pobi : 꽝
    honux : 3000
    crong : 꽝
    jk : 5000
    ```
## 힌트  
1. step2
    * 2차원 배열을 ArrayList, Generic을 적용해 구현하면 ArrayList<ArrayList<Boolean>>와 같이 이해하기 어려운 코드가 추가된다.
    * 사다리 게임에서 한 라인의 좌표 값을 가지는 객체를 추가해 구현해 본다.  
1. step3
    * 각 로직을 구현하기 위해 필요한 데이터를 가지는 객체를 분리하기 위해 노력해본다. 로직 구현에 필요한 데이터를 가지는 객체를 잘 분리하면 의외로 쉽게 문제를 해결할 수 있다.
    * 각 객체가 2개 이하의 인스턴스 변수만을 가지도록 구현해 본다.
