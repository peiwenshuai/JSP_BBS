# JSP_BBS
My JSP/Servlet BBS Project<br>
개인적으로, JSP/Servlet 학습을 위해 가볍게 CRUD 게시판을 제작.<br>
개발환경 : tomcat 8.5, maria DB(DB명 jsp_board), Java 1.8, jQuery, BootStrap <br>

Servlet ?
> - 서블릿은 웹서버가 동적인 페이지를 제공할 수 있도록 도와주는 어플리케이션<br>
> - 서블릿이란, 자바 기반으로 만드는 웹 어플리케이션 프로그래밍 기술(자바로 구현된, CGI(Common Gateway Interface))<br>
> - 서블릿이란, 자바를 사용하여 웹 페이지를 동적으로 생성하는 서버측 프로그램 혹은 그 사양을 의미.<br>
> - 결론적으로, 서블릿은 자바를 이용해 웹 페이지를 동적으로 처리하는 기술인 것을 알 수가 있다.(기본적으로 웹 페이지는 정적이다.)<br>

- 정적 페이지 / 동적 페이지 ?<br>
Static Web Page : 서버에 저장된, HTML 파일, 이미지, JavaScript 등에 컨텐츠들이 그대로 전달되는 웹 페이지를 말한다. 사용자는 서버에 저장된 컨텐츠가 변경되지 않는 한 고정된 웹 페이지만을 볼 수 있다.<br>
Dynamic Web Page : 서버에 저장된, 컨텐츠 또는 데이터들을 가공처리한 후 생성되어 전달 되는 웹 페이지. 사용자는 시간 또는 요청 등에 따라 달라지는 웹 페이지를 보게 됨.<br>


<br>
Servlet 생명 주기<br>
> - Init() 초기화<br>
> - Service() 준비작업<br>
> - doGet() / doPost() 알고리즘<br>
> - Destroy() 소멸<br>

0. 서블릿 컨테이너 클래스 로딩 -> 로딩 된, 서블릿 클래스 인스턴스 화 
1. Init() : 생성자 다음으로, 딱 1번 호출
2. Service() : 서비스는 여러번 호출.
3. Service()는 doGet() 또는 doPost() 형태로 호출 : 비즈니스 로직 처리.
4. Destroy() : 서버가 내려갈때, 소멸. 소멸 되기 전까지는 계속 서비스 뺑글뺑글 돈다.

<br>
? Servlet 과 Java Class 와 뭐가 다른가요? 똑같은 클래스 인데 ^^?? <br>
- 서블릿은 서버에서 실행될 수 있도록 서블릿 사양을 준수하는 자바 클래스를 의미.<br>
-> Servlet Interface를 구현한, GenericServlet 클래스를 상속받은 클래스라고도 할 수 도 있을거 같네요 ㅎㅎ<br>


JSP (Java Server Page) ?<br>
- HTML 문서 내에, Java Code가 들어가는 구조를 갖는 웹 어플리케이션 프로그래밍 기술.
- Java 언어를 기반으로 하는, 서버사이드 스크립트 언어.
- JSP는 하나의 서블릿으로 변환이 된다.

<br>
- 작업 완료 List <br>
1. 회원 가입 기능 완료
2. 로그인 기능 완료
3. 로그아웃 기능 완료
4. 미로그인 사용자 관련 필터 처리 완료
5. 게시판 목록 불러오기 완료
6. 게시판 목록 페이징 처리 완료
7. 게시판 작성 완료
8. 게시판 조회수 증가 완료

<br>
- 작업 예정 List(솔직히, 언제 할지는 모르겠다.) <br>
1. ID 쿠키 처리
2. 회원 정보 수정 및 탈퇴
3. 게시글 수정 및 삭제
4. modal 창 close 시, input 태그 초기화
5. 코드정련 및 리팩토링