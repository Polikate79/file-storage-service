# File Storage Microservice

## 1. Описание решения

**Данный микросервис предназначен для хранения различных файлов и их атрибутов.** Он предоставляет HTTP API для создания и получения файлов в формате JSON.

### Методы API:

**Создание файла (POST /files):**
- **Входные данные:** JSON, содержащий файл в формате base64 и его атрибуты:
  - `title`: Название файла (строка).
  - `creation_date`: Дата и время отправки (строка в формате ISO 8601).
  - `description`: Краткое описание файла (строка).
  - `file`: Сам файл в формате base64.
- **Выходные данные:** JSON, содержащий `id` созданного файла.

**Получение файла (GET /files/{id}):**
- **Входные данные:** `id` файла (строка).
- **Выходные данные:** JSON, содержащий файл в формате base64 и его атрибуты:
  - `title`: Название файла.
  - `creation_date`: Дата и время отправки.
  - `description`: Краткое описание файла.
  - `file`: Сам файл в формате base64.

**Пагинированный список всех файлов, хранящихся в системе (GET /files/):**
- **Входные данные:**
  - `page` (integer, опционально, по умолчанию: 1): Указывает номер страницы с результатами, которую вы хотите получить.
  - `size` (integer, опционально, по умолчанию: 5): Указывает количество файлов, отображаемых на одной странице.


# Инструкция по запуску локального микросервиса File Storage Service

## Требования

1. **PostgreSQL**: Установите PostgreSQL на своем устройстве. Для этого используйте [инструкции по установке PostgreSQL](https://www.postgresql.org/download/) для вашей операционной системы.
2. **JDK 17**: Установите JDK 17. Для этого посетите [страницу загрузки JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) и следуйте инструкциям.

## Шаги по настройке и запуску

### 1. Настройка PostgreSQL

1. **Создайте базу данных**:
   - Назовите базу данных `mydatabase`.
   - Используйте следующую команду в командной строке для создания базы данных:
     ```bash
     createdb mydatabase
     ```

2. **Убедитесь, что PostgreSQL запущен**:
   - На macOS/Linux проверьте статус сервиса PostgreSQL и запустите его при необходимости:
     ```bash
     sudo service postgresql start
     ```
   - На Windows убедитесь, что служба PostgreSQL запущена через "Службы" в Панели управления или используйте следующую команду в командной строке:
     ```bash
     net start postgresql-x64-14
     ```

3. **Проверьте, что база данных пуста**:
   - Убедитесь, что база данных `mydatabase` пуста на момент первого запуска приложения. Это необходимо для успешного применения миграций Flyway.

### 2. Настройка переменных окружения

1. **Установите пароль для базы данных**:
   - Создайте переменную окружения с именем `DATABASE_PASSWORD` и установите в нее пароль вашей базы данных.
   - На macOS/Linux это можно сделать следующим образом:
     ```bash
     export DATABASE_PASSWORD=ваш_пароль
     ```
   - На Windows создайте переменную окружения через "Системные переменные" в настройках системы:
     - Откройте Панель управления → Система и безопасность → Система → Дополнительные параметры системы.
     - Нажмите "Переменные среды".
     - В разделе "Переменные пользователя" нажмите "Создать" и введите `DATABASE_PASSWORD` в качестве имени переменной и ваш пароль в качестве значения.

### 3. Настройка файла `application.properties`

1. **Откройте файл `application.properties`**:
   - Убедитесь, что имя пользователя указано как `postgres` или другой существующий пользователь. Пример строки:
     ```properties
     spring.datasource.username=postgres
     ```

### 4. Запуск приложения

1. **Запуск из IntelliJ IDEA**:
   - Откройте проект и запустите основной класс `FileStorageServiceApplication`.

2. **Запуск из консоли**:
   - На macOS/Linux, перейдите в корневую папку проекта и выполните команду:
     ```bash
     ./gradlew bootRun
     ```
   - На Windows, откройте командную строку (cmd) или PowerShell, перейдите в корневую папку проекта и выполните команду:
     ```cmd
     .\gradlew bootRun
     ```

3. Примеры тестовых запросов
Проверка запросов на скриншотах ниже сделала с помощью Swagger (Open API)
POST-запрос
File Storage Microservice
1. Описание решения
Данный микросервис предназначен для хранения различных файлов и их атрибутов. Он предоставляет HTTP API для создания и получения файлов в формате JSON.

Методы API:
Создание файла (POST /files):
Входные данные: JSON, содержащий файл в формате base64 и его атрибуты:
title: Название файла (строка).
creation_date: Дата и время отправки (строка в формате ISO 8601).
description: Краткое описание файла (строка).
file: Сам файл в формате base64.
Выходные данные: JSON, содержащий id созданного файла.


Получение файла (GET /files/{id}):
Входные данные: id файла (строка).
Выходные данные: JSON, содержащий файл в формате base64 и его атрибуты:
title: Название файла.
creation_date: Дата и время отправки.
description: Краткое описание файла.
file: Сам файл в формате base64.

Пагинированный список всех файлов, хранящихся в системе GET /files/

Входные данные:
page (integer, опционально, по умолчанию: 1): Указывает номер страницы с результатами, которую вы хотите получить.
size (integer, опционально, по умолчанию: 5): Указывает количество файлов, отображаемых на одной странице.

2. Инструкция по запуску приложения
# Инструкция по запуску локального микросервиса File Storage Service

## Требования

1. **PostgreSQL**: Установите PostgreSQL на своем устройстве. Для этого используйте [инструкции по установке PostgreSQL](https://www.postgresql.org/download/) для вашей операционной системы.
2. **JDK 17**: Установите JDK 17. Для этого посетите [страницу загрузки JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) и следуйте инструкциям.

## Шаги по настройке и запуску

### 1. Настройка PostgreSQL

1. **Создайте базу данных**:
   - Назовите базу данных `mydatabase`.
   - Используйте следующую команду в командной строке для создания базы данных:
     ```bash
     createdb mydatabase
     ```

2. **Убедитесь, что PostgreSQL запущен**:
   - На macOS/Linux проверьте статус сервиса PostgreSQL и запустите его при необходимости:
     ```bash
     sudo service postgresql start
     ```
   - На Windows убедитесь, что служба PostgreSQL запущена через "Службы" в Панели управления или используйте следующую команду в командной строке:
     ```bash
     net start postgresql-x64-14
     ```

3. **Проверьте, что база данных пуста**:
   - Убедитесь, что база данных `mydatabase` пуста на момент первого запуска приложения. Это необходимо для успешного применения миграций Flyway.

### 2. Настройка переменных окружения

1. **Установите пароль для базы данных**:
   - Создайте переменную окружения с именем `DATABASE_PASSWORD` и установите в нее пароль вашей базы данных.
   - На macOS/Linux это можно сделать следующим образом:
     ```bash
     export DATABASE_PASSWORD=ваш_пароль
     ```
   - На Windows создайте переменную окружения через "Системные переменные" в настройках системы:
     - Откройте Панель управления → Система и безопасность → Система → Дополнительные параметры системы.
     - Нажмите "Переменные среды".
     - В разделе "Переменные пользователя" нажмите "Создать" и введите `DATABASE_PASSWORD` в качестве имени переменной и ваш пароль в качестве значения.

### 3. Настройка файла `application.properties`

1. **Откройте файл `application.properties`**:
   - Убедитесь, что имя пользователя указано как `postgres` или другой существующий пользователь. Пример строки:
     ```properties
     spring.datasource.username=postgres
     ```

### 4. Запуск приложения

1. **Запуск из IntelliJ IDEA**:
   - Откройте проект и запустите основной класс `FileStorageServiceApplication`.

2. **Запуск из консоли**:
   - На macOS/Linux, перейдите в корневую папку проекта и выполните команду:
     ```bash
     ./gradlew bootRun
     ```
   - На Windows, откройте командную строку (cmd) или PowerShell, перейдите в корневую папку проекта и выполните команду:
     ```cmd
     .\gradlew bootRun
     ```

# Примеры тестовых запросов
## Проверка запросов на скриншотах ниже сделала с помощью Swagger(Open API)
### POST-запрос
![Screenshot 2024-08-27 at 19 24 34](https://github.com/user-attachments/assets/6d724514-ee3b-49b5-9e1d-58139631df16)

### GET-запрос 
![image](https://github.com/user-attachments/assets/913c0280-4541-4682-b860-4cf456d67ebd)

### GET-запрос(список всех файлов)
![image](https://github.com/user-attachments/assets/e1c18642-af02-4a83-80fb-2d295081b6bb)

 
