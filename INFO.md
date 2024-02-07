    Подключение зависимостей
1. Необходимо изменить путь до расположения keycloak
2. Развернуть и подключиться к базе данных
3. Обновить maven


    Запуск проекта
1. Запуск сервера
2. Запуск клиентов
3. Запуск gateway


    Запуск keycloak
                    (искать информацию на https://www.keycloak.org/documentation)
1. C://{путь к папке bin}/bin/kc.bat start-dev
    (в консоли, перед этим желательно создать переменную среды JAVA_HOME)
2. Проверить свободные порты (в cmd) netstat -aon
3. Сменить порт на запуске --http-port=(желаемый порт)
4.1. Новая ui в KeyCloak, поэтому нет поля access type. За это отвечает boolean значение у поля Client authentication. 
     if on, то будет confidential access type, else public, после save появится вкладка Credentials
4. 