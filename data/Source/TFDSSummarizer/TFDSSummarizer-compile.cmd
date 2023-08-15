:COMPILE
  del "%~dp0\www\TFDSSummarizer\*.*" /s /Q
  java -cp "%~dp0\src;%~dp0\bin;C:/gwt-windows-1.4.60/gwt-user.jar;C:/gwt-windows-1.4.60/gwt-dev-windows.jar" com.google.gwt.dev.GWTCompiler -out "%~dp0\www" %* TFDSSummarizer

:DEPLOY
  SET TOMCAT_PATH=C:\Program Files\Apache Software Foundation\Tomcat 5.0\webapps\TFDSSummarizer
  SET GWT_PATH=C:\gwt-windows-1.4.60
  rem del "%TOMCAT_PATH%\*.*" /S /Q 
  rd "%TOMCAT_PATH%" /S /Q
  md "%TOMCAT_PATH%"
  xcopy "%~dp0\src\web.xml" "%TOMCAT_PATH%\WEB-INF" /y
  md "%TOMCAT_PATH%\WEB-INF\classes"
  md "%TOMCAT_PATH%\WEB-INF\classes\server"
  md "%TOMCAT_PATH%\WEB-INF\classes\client"
  md "%TOMCAT_PATH%\WEB-INF\classes\client\service"
  md "%TOMCAT_PATH%\WEB-INF\lib"
  xcopy "%~dp0\bin\server\*.*" "%TOMCAT_PATH%\WEB-INF\classes\server" /s /y 
  xcopy "%~dp0\bin\client\Sentence.class" "%TOMCAT_PATH%\WEB-INF\classes\client" /y
  xcopy "%~dp0\bin\client\service\*.class" "%TOMCAT_PATH%\WEB-INF\classes\client\service" /y
  xcopy "%~dp0\www\TFDSSummarizer\*.*" "%TOMCAT_PATH%\" /s
  xcopy "%GWT_PATH%\gwt-servlet.jar" "%TOMCAT_PATH%\WEB-INF\lib" /y