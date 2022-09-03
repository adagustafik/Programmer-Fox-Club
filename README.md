# Programmer Fox Club

## Main functionality
At Programmer Fox Club you can have your very own fox. It's like a virtual tamagochi, you can feed and train your lil' one. 
You just have to provide a name of your pet and here you go, you can play with your cutie pie.

1. Registration + Login/Logout with Spring Security
2. Create a new Fox
3. Change default nutrition for your pet (food & drink)
4. Trick Center - teach your pet tricks
5. Create Action history


## Deployed on heroku
https://myfoxclubsql.herokuapp.com/login


## Tech Stack
**Java 11**
**Gradle + Gradle Daemon**
automation build tools

**Spring framework + Spring Boot**
spring module for RAD (Rapid App Development)
**Spring Security**
**Spring Validation**

**MySQL**
**Hibernate + Spring Data JPA**
persistance API

**Lombok**
library of decorators for automated build tools

**Thymeleaf**
template engine


## Architecture
### DB Entities
**User**
@OneToMany -> Fox

**Fox**
@ManyToOne -> User
@ElementCollection -> Trick
@OneToMany -> Action

**Trick**

**Action**
@ManyToOne -> Fox


### Basic data flows
* GET Spring Security WebMvcConfig templates/login ->
  - [on success] UserApiDto received + autContext setup (apiKey, avatarUrl, channels) -> redirect root ->
  - MainController get authenticated user -> diplay templates/index (logout, all pets, new)
  - [on error] Spring Security handles -> redirect login displaying error

* GET templates/create -> POST FoxController -> Spring validation (name -> length & pattern) ->
  - [on success] FoxService selectFox -> new Fox persisted in DB + saved to autContextFox -> redirect information
  - [on error] redirect create displaying BindingResult errors

* GET information -> GET FoxController showFox -> FoxService getSelectedFox from autContextFox  + add to model 
-> ActionService actionsByFox + actionRepository -> add actions to model -> templates/information (known Tricks displayed via Fox)

* GET Trick Center -> GET TricksController showTricks -> FoxService getSelectedFox from autContextFox + add to model 
-> add all Trick.values() to model -> templates/feature 
  - only unknown Tricks are displayed

* POST Trick Center -> POST TricksController learnTricks -> FoxService learnFoxTricks -> get Fox from repository & reset autContextFox
-> add Trick & save Fox to repository -> save new Action to repository -> redirect information


## Lessons learned  
1. A taste of Spring Security access-control setup
   - providing custom login page to display validation errors
   - debugging not permitted stylesheet issue (thymeleaf generated URL vs project folder structure)
2. Encryption with BCryptPasswordEncoder (2 UserService interfaces needed due to circular dependencies)
3. Leveraging AuthContext for app optimization (storing selected Fox as @Component)
4. @Transactional to execute multiple DB calls in one session
5. Enum conversions/comparisons Enum.valueOf(), @ElementCollection persistance
6. Thymeleaf templates - conditional rendering, fragments
7. Thymeleaf - limit via th:each interation index, dynamic display of pre-selected values