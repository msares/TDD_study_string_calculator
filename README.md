# 문자열 덧셈 계산기
문자열 덧셈 계산기를 통한 TDD/리팩토링 실습

### 기능_요구사항
1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)


### 프로그래밍 요구사항
1. indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.   
depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
2. 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.   
method가 한 가지 일만 하도록 최대한 작게 만들어라.
else를 사용하지 마라.

<hr/>

### 기능 요구사항 분리 및 힌트
> 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)   
   if (text == null) {}   
   if (text.isEmpty()) {}   

> 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)   
   int number = Integer.parseInt(text);

> 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)   
   String[] numbers = text.split(",");   
   // 앞 단계의 구분자가 없는 경우도 split()을 활용해 구현할 수 있는지 검토해 본다.  

> 4.  구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)   
> String[] tokens= text.split(",|:");   

> 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
>>  // java.util.regex 패키지의 Matcher, Pattern import
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);   
    if (m.find()) {   
    String customDelimiter = m.group(1);   
    String[] tokens= m.group(2).split(customDelimiter);   
    // 덧셈 구현   
    }
