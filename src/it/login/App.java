package it.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        userList.add(new User("admin", "admin"));
        userList.add(new User("user", "user"));

        System.out.println("Enter login");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();

        boolean authenticationResult = authenticate(login, password);
        if(authenticationResult){
            System.out.println("Logged in");
        } else {
            System.out.println("Incorrect data");
        }
    }
    public static boolean authenticate(String login, String password){
        for (User currentUser : userList) {
            if(currentUser.getLogin().equals(login)){
                if(currentUser.getPass().equals(password)){
                    return true;
                }else {
                   return false;
                }
            }
        }
        return false;
    }
}
