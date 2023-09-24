#### **정적 메소드**

객체 레퍼런스 변수 대신 클래스명을 사용하여 호출

힙에 그 메소드가 들어있는 클래스의 인스턴스가 없어도 호출할 수 있음

특정 인스턴스와는 연관되지 않기에 어떤 인스턴스 변수값도, 메소드도 사용할 수 없음

#### **정적 변수**

[##_Image|kage@DZkfZ/btsvDk7DsXd/nivW8W9LRETOtSBdtfwZ1K/img.jpg|CDM|1.3|{"originWidth":503,"originHeight":356,"style":"alignLeft"}_##]

해당 클래스에 속하는 모든 객체에서 공유하는 변수

#### **상수**

final로 지정한 변수값은 값을 한번 대입하면 바꿀 수 없어 변수가 아닌 상수임

선언할 때 또는 생성자에서 대입해야 함

확장, 오버라이드 불가능

#### **Math 클래스**

해당 클래스에 들어있는 메소드에서는 인스턴스 변수의 값을 전혀 사용하지 않음

정적 메소드이기 때문, 따라서 해당 클래스에서는 인스턴스 변수를 필요 없음

\- random(): 0.0 이상 1.0 미만의 값 리턴

\- abs(): 주어진 인자의 절대값 리턴

\- round(): 주어진 수를 반올림하여 가장 가까운 int, long을 리턴

\- min(): 두 인자 중 더 작은 값 리턴

\- max(): 두 인자 중 더 큰 값 리턴

#### **래퍼**

원시 형식을 객체처럼 다뤄야 할 때 사용하는 방법

Boolean, Character, Byte, Short, Integer, Long... 등이 있다.

+

정적 유틸리티 메소드 지원

다양한 래퍼 클래스들은 정적 유틸리티 메소드를 지원하여 해당 메소드를 이용해 형변환을 가능하게 만들어준다.

ex) Integer.parseInt("2") 는 2의 값을 리턴한다.

#### **오토박싱**

원시값과 객체 사이의 경계를 없애는 것

자동 형변환 기능으로, 굳이 어떤 형으로 변환하겠다는 코드를 작성하지 않아도 알아서 형변환해주는 것을 의미한다.

ex) 메소드 인자, 리턴값, 부울 표현식, 수에 대한 연산, 대입 등에서 자주 일어난다.

#### **포매팅**

```
String s = String.format("%, d", 100000000);
```

\-> 숫자를 표기할 때 , 를 통해 표기하기 위한 방법

위처럼 포매팅 지시사항인 부분과 지시 대상 인자 값을 통해 format 함수로 포매팅을 진행할 수 있다.

다양한 포매팅 방법은 찾아보면서 알아가면 좋을 것 같다.

 [Formatter (Java Platform SE 8 )

'e' '\\u0065' Requires the output to be formatted using computerized scientific notation. The localization algorithm is applied. The formatting of the magnitude m depends upon its value. If m is NaN or infinite, the literal strings "NaN" or "Infinity", resp

docs.oracle.com](https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html)

#### **날짜 표현**

지금 날짜와 시각에 대한 타임스탬프를 원한다면 Date 클래스를 다른 용도는 Calendar 클래스 사용을 추천

 [Calendar (Java Platform SE 8 )

Adds or subtracts (up/down) a single unit of time on the given time field without changing larger fields. For example, to roll the current date up by one day, you can achieve it by calling: roll(Calendar.DATE, true). When rolling on the year or Calendar.YE

docs.oracle.com](https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html)

[https://taejunejoung.github.io/2020/01/08/java-static/](https://taejunejoung.github.io/2020/01/08/java-static/)
