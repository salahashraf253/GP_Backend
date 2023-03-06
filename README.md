# GP_Backend

### API Endpoints
| HTTP Verbs | Endpoints | Action |
| --- | --- | --- |
| GET | ```/users/{userId}``` | To get user|
| POST | ```/users``` | to create a user |
| POST | ```/users/login``` | to login the user|
| PUT | ```/users/{userId}/hotels/preferences/{hotelPreferenceId}``` | to add hotel preference for user|
| PUT | ```/users/{userId}/restaurants/cuisines/{cuisineId}``` | to add restaurants cuisine for user|
| DELETE | ```/users/userId``` | to delete user by ID |

### Code Example
Here's an example of how to add new user using the UserController:
```java 
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

}
```


