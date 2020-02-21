# Spring Security and Login By jQuery
This project is just for showing that how can we setup 
an html and jquery front-end project 
which connects to spring boot secured back-end project.

## How to run the application  
In order to run application you only need to run `spring boot` application and then
go to [http://localhost:9002](http://localhost:9002) address in your web browser.  
**Alternative method**  
Run `spring boot` application then run `index.html` file in `JetBrain Live Server` you know it how!  
**Setup database**  
Although in this project database has not been needed yet, 
you need to notice `application.properties` file to be informed about database name.
 

## Notices
**First Notice two files first:** `SpringSecurityConfig.java` and `login.js`.
    
        
In **`login.js`** notice this code:  
```javascript
headers: {
    "Authorization": "Basic " + btoa(username + ":" + password)
}  
```
> it shows that how we are able to send username and password to spring boot security service.  
  
then we need waiting for response whether user is authenticated or not by this code:  
```javascript
success: function (data, textStatus) {
            if (data.isAuthenticated === true) {
                loginSuccessful(username, password);
            } else {
                loginFailed();
            }
        },
        error: function (errorMessage) {
            loginFailed();
        }
```    
look into `loginSuccessful()` method. we have to put `username` and `password` in 
`shared value window container`. because further we need then for restful request in other pages.

```javascript
window.authenticatedUsername = username;
window.authenticatedPassword = password;
```  
---
In `SpringSecurityConfig.java` class notice that how we configure `CORS` by this code  
```java
@Bean
public CorsConfigurationSource corsConfigurationSource() {
    final CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration.setAllowedMethods(Arrays.asList("HEAD",
            "GET", "POST", "PUT", "DELETE", "PATCH"));
    // setAllowCredentials(true) is important, otherwise:
    // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
    configuration.setAllowCredentials(true);
    // setAllowedHeaders is important! Without it, OPTIONS preflight request
    // will fail with 403 Invalid CORS request
    configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
}
```
Also we need put this bellow code to enable CORS for spring security.  
``` java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .cors()
            .and()
            .csrf().disable()
...
```
---
And Finally notice what happened in desktop.js file. For sending request `username` and `password` 
are taken from shared variable window. Use this code where ever you want to send request to secured spring boot.
```javascript
function receiveFirstLoginMessage() {
    // receive username and password from shared values window container
    const username = window.authenticatedUsername;
    const password = window.authenticatedPassword;
    // create command
    const command = {"whoIAm": username};
    $.ajax({
        url: serverUrl() + "/message/first-login",
        type: "POST",
        data: JSON.stringify(command),
        contentType: "application/json; charset=utf-8",
        headers: {
            "Authorization": "Basic " + btoa(username + ":" + password)
        },
        success: function (data, status) {
            showFirstMessage(data.message);
        },
        error: function (errorMessage) {
            alert("Some thing wrong happened!")
        }
    });
}
```
