<h2>Academic Keeper</h2>

<h2>Описание</h2>
Это веб-приложение в формате электронного дневника, 
разработанное как pet-проект на Java с использованием Apache Tomcat.
Оно решает простую, но актуальную задачу: дать учителям удобный инструмент для постановки заданий, а студентам — прозрачный способ отслеживать свою учебную нагрузку. 
Никаких лишних сложностей — только регистрация, роли, задания и чистый интерфейс.

<h2>Возможности</h2>

👩‍🏫 Для учителя
```text
Регистрация и вход в личный кабинет
Создание заданий с описанием, сроком и приоритетом
Управление списком студентов
Просмотр статуса выполнения заданий
```

🎓 Для студента
```text
Регистрация и авторизация
Просмотр актуальных заданий от преподавателей
Отметка о выполнении
История по предметам
```

🔐 Общее
```text
Разграничение прав доступа по ролям (учитель / студент)
Хеширование паролей
Сессии и защита приватных страниц
```

<h2>Стэк технологий</h2>

```text
-Java
-Apache Tomcat 10
-Maven
-PostgreSQL
-HTML/CSS
```

<h2>Архитектура</h2>

```text
│   │   │           ├───contoller
│   │   │           │   │   StudentPageController.java
│   │   │           │   │   TaskPageController.java
│   │   │           │   │   TeacherPageController.java
│   │   │           │   │   
│   │   │           │   ├───authenticaton_controllers
│   │   │           │   │       LoginController.java
│   │   │           │   │       RegistrationController.java
│   │   │           │   │       
│   │   │           │   ├───error_status_type
│   │   │           │   │       Status.java
│   │   │           │   │       
│   │   │           │   ├───exceptions
│   │   │           │   │       EmptyParameterException.java
│   │   │           │   │       
│   │   │           │   ├───filters
│   │   │           │   │       StudentPageFilter.java
│   │   │           │   │       TaskPageFilter.java
│   │   │           │   │       TeacherPageFilter.java
│   │   │           │   │       
│   │   │           │   └───redirectors
│   │   │           │           RedirectStatusController.java
│   │   │           │           RedirectTaskController.java
│   │   │           │           
│   │   │           ├───model
│   │   │           │   ├───database
│   │   │           │   │   ├───connection
│   │   │           │   │   │       ConnectionManager.java
│   │   │           │   │   │       
│   │   │           │   │   ├───dao
│   │   │           │   │   │       IDao.java
│   │   │           │   │   │       StudentDao.java
│   │   │           │   │   │       TaskDao.java
│   │   │           │   │   │       TeacherDao.java
│   │   │           │   │   │       
│   │   │           │   │   ├───entity
│   │   │           │   │   │   │   Task.java
│   │   │           │   │   │   │   
│   │   │           │   │   │   ├───enumtype
│   │   │           │   │   │   │       StatusType.java
│   │   │           │   │   │   │       SysRole.java
│   │   │           │   │   │   │       
│   │   │           │   │   │   └───users
│   │   │           │   │   │           Student.java
│   │   │           │   │   │           Teacher.java
│   │   │           │   │   │           User.java
│   │   │           │   │   │           
│   │   │           │   │   ├───exceptions
│   │   │           │   │   │       ResultSetEmptyException.java
│   │   │           │   │   │       
│   │   │           │   │   └───tools
│   │   │           │   │           PropertiesTool.java
│   │   │           │   │           
│   │   │           │   └───service
│   │   │           │       │   StudentPageService.java
│   │   │           │       │   TaskPageService.java
│   │   │           │       │   TeacherPageService.java
│   │   │           │       │   
│   │   │           │       ├───authentication
│   │   │           │       │       AbstractAuthentication.java
│   │   │           │       │       LoginService.java
│   │   │           │       │       RegistrationService.java
│   │   │           │       │       
│   │   │           │       └───exceptions
│   │   │           │               ExistenceException.java
│   │   │           │               IncorrectPasswordException.java
│   │   │           │               RegisteredException.java
│   │   │           │               
│   │   │           └───tools
│   │   │                   PathsHandler.java
│   │   │                   
│   │   ├───resources
│   │   │       db.properties
│   │   │       
│   │   └───webapp
```
<h2>База данных<h2>

### Таблица `students`
| Поле | Тип | Ключ | Описание |
|------|-----|------|----------|
| `login` | `varchar(30)` | 🔑 PK | Логин студента |
| `name` | `varchar(30)` | | Имя |
| `surname` | `varchar(30)` | | Фамилия |
| `password` | `varchar(30)` | | Пароль |
| `person_sysrole` | `sysrole` | | Роль в системе |

### Таблица `teachers`
| Поле | Тип | Ключ | Описание |
|------|-----|------|----------|
| `login` | `varchar(30)` | 🔑 PK | Логин учителя |
| `name` | `varchar(30)` | | Имя |
| `surname` | `varchar(30)` | | Фамилия |
| `password` | `varchar(30)` | | Пароль |
| `person_sysrole` | `sysrole` | | Роль в системе |

### Таблица `tasks`
| Поле | Тип | Ключ | Описание |
|------|-----|------|----------|
| `task_id` | `integer` | 🔑 PK | ID задания |
| `status` | `statustype` | | Статус выполнения |
| `creation_time` | `date` | | Дата создания |
| `deadline` | `date` | | Дедлайн |
| `description` | `varchar(60)` | | Описание задания |
| `student_login` | `varchar(30)` | 🔗 FK → `students.login` | Кому назначено |
| `teacher_login` | `varchar(30)` | 🔗 FK → `teachers.login` | Кто создал |


<h2>Запуск проекта</h2>

```text
git clone https://github.com/SanechkaProg/AcademicKeeper.git
cd AcademicKeeper
mvn clean package
$TOMCAT_HOME/bin/startup.sh
