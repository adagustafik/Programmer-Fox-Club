# Programmer Fox Club

## Main functionality
At Programmer Fox Club you can have your very own fox. It's like a virtual tamagochi, you can feed and train your lil' one. 
You just have to provide a name of your pet & you can start to play.

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
**User**\
@OneToMany -> Fox

**Fox**\
@ManyToOne -> User\
@ElementCollection -> Trick\
@OneToMany -> Action

**Trick**

**Action**\
@ManyToOne -> Fox


### Basic data flows
* LOGIN: GET Spring Security WebMvcConfig templates/login ->
  - [on success] UserApiDto received + autContext setup (apiKey, avatarUrl, channels) -> redirect root ->
  MainController get authenticated user -> generate templates/index (logout, all pets, new)
  - [on error] Spring Security handles -> redirect login displaying error

* CREATE NEW FOX: GET templates/create -> POST FoxController -> Spring validation ->
  - [on success] FoxService selectFox -> new Fox persisted in DB + saved to autContextFox -> redirect information
  - [on error] redirect create displaying BindingResult errors

* FOX INFORMATION: GET FoxController showFox -> FoxService getSelectedFox from autContextFox  + add to model 
-> ActionService actionsByFox + actionRepository -> add actions to model -> generate templates/information (known Tricks displayed via Fox)

* SELECT ANOTHER FOX: GET MainController templates/index -> PathVariable ID for each Fox -> GET FoxController switchFox
-> FoxService switchFox -> get Fox from repository & set the autContextFox-> same as above...

* SHOW TRICK CENTER: GET TricksController showTricks -> FoxService getSelectedFox from autContextFox + add to model 
-> add all Trick.values() to model -> templates/feature (only unknown Tricks are displayed)

* LEARN NEW TRICK: POST TricksController learnTricks -> FoxService learnFoxTricks -> get Fox from repository & reset autContextFox
-> add Trick & save Fox to repository -> save new Action to repository -> redirect information


## Lessons learned  
1. A taste of Spring Security access-control setup
   - providing custom login page to display validation errors
   - debugging not permitted stylesheet issue (thymeleaf generated URL vs project folder structure)
2. Encryption with BCryptPasswordEncoder (2 UserService interfaces needed due to circular dependencies)
3. Leveraging AuthContext for app optimization (storing selected Fox as @Component)
4. Bad practice - reusing entity between requests & transactions (instead get Fox from repo -> then save the Tricks to repo)
5. @Transactional to execute multiple DB calls in one session
6. Enum conversions/comparisons Enum.valueOf(), @ElementCollection persistance
7. Thymeleaf templates - conditional rendering, fragments
8. Thymeleaf - limit via th:each interation index, dynamic display of pre-selected values
