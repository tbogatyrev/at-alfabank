# Tests for https://alfabank.ru/ :star:

## UI Tests

### Main Page tests

:white_check_mark: Checking that there is a main block with slides on the page    
:white_check_mark: Checking that search results are displayed    
:white_check_mark: Checking that the 'Popular Products' block with the list of products is displayed    
:white_check_mark: Checking a block with a special offer    
:white_check_mark: Checking the dependence of the deposit rate on the term of the deposit    

## Technology Stack

| <a href="https://www.jetbrains.com/idea/"><img alt="IDEA" height="40" src="https://github.com/tbogatyrev/icons/blob/main/icons/Intelij_IDEA.png?raw=true" width="40"/></a> | <a href="https://www.jetbrains.com/idea/"><img alt="Java" height="40" src="https://github.com/tbogatyrev/icons/blob/main/icons/Java.png?raw=true" width="40"/></a> | <a href="https://www.jetbrains.com/idea/"><img alt="JUnit 5" height="40" src="https://github.com/tbogatyrev/icons/blob/main/icons/JUnit5.png?raw=true" width="40"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://github.com/tbogatyrev/icons/blob/main/icons/Gradle.png?raw=true" width="40" height="40"  alt="Gradle"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://github.com/tbogatyrev/icons/blob/main/icons/Selenide.png?raw=true" width="40" height="40"  alt="Selenide"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://github.com/tbogatyrev/icons/blob/main/icons/Selenoid.png?raw=true" width="40" height="40"  alt="Selenoid"/></a> | <a href="https://www.jetbrains.com/idea/"><img alt="Allure" height="40" src="https://github.com/tbogatyrev/icons/blob/main/icons/Allure_Report.png?raw=true" width="40"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://github.com/tbogatyrev/icons/blob/main/icons/Jenkins.png?raw=true" width="40" height="40"  alt="Jenkins"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="https://github.com/tbogatyrev/icons/blob/main/icons/Github.png?raw=true" width="40" height="40"  alt="Github"/></a> |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|                                                                                    IDEA                                                                                    |                                                                                Java                                                                                |                                                                                 Junit5                                                                                  |                                                                                 Gradle                                                                                  |                                                                                  Selenide                                                                                   | Selenoid                                                                                                                                                                    | Allure                                                                                                                                                                        | Jenkins                                                                                                                                                                   | Github                                                                                                                                                                  |

## Run tests

```bash
    clean
     ${TASK}
    -Dbrowser=${BROWSER}
    -DbrowserVersion=${VERSION}
    -DbrowserSize=${BROWSER_SIZE}
    -DbaseUrls=${ENVIRONMENT}
    -DremoteDriverUrl=${SELENOID_HUB}
```

where:
> - [x] *Dbrowser - browser type (default chrome)*
>- [x] *DbrowserVersion - browser version(default 98.0)*
> -[x] *DbrowserSize - browser size(default 1920x1080)*
>- [x] *DremoteDriverUrl - remote url to run tests (default https://host.docker.internal:8080/wd/hub)*
>- [x] *DbaseUrl - the main address of the test stand (default https://alfabank.ru/)*
>

### - Video sample with passing test case

![Video](https://github.com/tbogatyrev/at-alfabank/blob/master/img/alfabank-test.gif?raw=true)

## Screenshots:

### - Jenkins reports

![Jenkins](https://github.com/tbogatyrev/at-alfabank/blob/master/img/jenkins.png?raw=true)

### - Allure reports

![Allure1](https://github.com/tbogatyrev/at-alfabank/blob/master/img/allure_report.png?raw=true)
![Allure2](https://github.com/tbogatyrev/at-alfabank/blob/master/img/allure_report_suites.png?raw=true)

### - Telegram reports

![Telegram_1](https://github.com/tbogatyrev/at-alfabank/blob/master/img/telegram.png?raw=true)

