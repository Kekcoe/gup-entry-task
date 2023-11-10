Инструкция по запуску проекта тестового задания:
1. Создать проект из удаленного репозитория с помощь git clone https://github.com/Kekcoe/gup-entry-task.git.
2. Собрать проект  mvn clean install.
3. В рут кталоге проекта запустить команду docker-compose up --build. Дождаться создания образа и запуска контейнера;
4. Для отправки rest запроса используем  Постман. Header автогенеретэд. Запрос POST http://localhost:8081/calculation-service/api/calc/?a=3&b=4&c=1.
Либо curl -X POST -d "a=3" -d "b=4" -d "c=1" -d "d=4" http://localhost:8081/calculation-service/api/calc/
5. Для проверки дискриминанта < 0 послать запрос POST http://localhost:8081/calculation-service/api/calc/?a=3&b=5&c=11
Либо curl -X POST -d "a=3" -d "b=4" -d "c=1" -d "d=11" http://localhost:8081/calculation-service/api/calc/
6. При необходимости запуска микроервисов локально на машине необходимо в IDEA -> RUN -> Edit Confguration  в поле active profile прописать local 
для использования актульных для этого профиля application.properties.