@echo on
set path_old = %path%
set path="C:\Program Files\MySQL\MySQL Server 8.0\bin"
mysqldump -u %1 -p%2 Academy_Primal > "C:\WorksSpaces\ProjectGymUNESC\ClassLibrary\Backup\"AcademyBackup.sql
set path=%path_old%
exit