package main.java.com.example;

public class App {
    public static void main(String[] args) {
        UserService userService = new UserService();
        try {
            userService.findUser("john");
            userService.deleteUser("john");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
