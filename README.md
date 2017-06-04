# JSP_BBS
My JSP/Servlet BBS Project


2017.05.28<br>
프로젝트 구성 및 git연동<br>
개발환경 : tomcat 8.5, maria DB(DB명 jsp_board), Java 1.8, jQuery, BootStrap <br>
<br>
2017.05.29<br>
로그인 및 회원가입 프로세스 구현.(session 체크를 위해 filter 연동)<br>
개발환경 : tomcat 8.5, maria DB(DB명 jsp_board), Java 1.8, jQuery, BootStrap <br>
<br>
2017.06.04<br>
bbs_info 라는 테이블 생성 및 BoardInfoBean 및 BoardInfoDao 작성 + 글 작성 시, insert 되는 기능 구현.<br>
session 값 변경(userInfoBean) + jsp/servlet 호출 시, 리소스 경로 충돌나서 El 내장객체를 사용해서 해결 ${pageContext.request.contextPath}<br>
개발환경 : tomcat 8.5, maria DB(DB명 jsp_board), Java 1.8, jQuery, BootStrap <br>