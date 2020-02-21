#Spring Security and Login By jQuery
This project is just for showing that how can we setup 
an html and jquery front-end project 
which connects to spring boot secured back-end project.

## Notices
**Notice two files first:** SpringSecurityConfig.java and login.js.
    
        
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
also we need put this bellow code to enable CORS for spring security.  
``` java
@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
...
```