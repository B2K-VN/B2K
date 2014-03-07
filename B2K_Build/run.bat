@echo off
rem set JAVA_HOME=.\jdk
rem set ANT_HOME=.\ANT
rem set PATH=%ANT_HOME%\bin
REM cmd.vbs
rem "ant {ten may} {port} {toa do x hien thi text} {toa do y hien thi text}"
ant -Darg0=localhost -Darg1=8642
pause
