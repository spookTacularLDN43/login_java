package it.login.gui;

import it.login.database.UsersRepository;

import java.util.Scanner;

public class GUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMainMenu() {
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");

        switch (scanner.nextLine()) {
            case "1":
                showLoginScreen();
                showMainMenu();
                break;
            case "2":
                showRegisterScreen();
                showMainMenu();
                break;
            case "3":
                System.exit(0);
            default:
                System.out.println("Enter 1 or 2");
                showMainMenu();
        }
    }

    private static void showLoginScreen() {
        System.out.println("Enter login");
        String login = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();

        boolean authenticationResult = UsersRepository.getInstance().authenticate(login, password);
        if (authenticationResult) {
            System.out.println("Logged in");
        } else {
            System.out.println("Incorrect data");
        }
    }
    private static void showRegisterScreen(){
        System.out.println("Enter login");
        String login = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();

        boolean registerResult = UsersRepository.getInstance().register(login,password);
        if(registerResult){
            System.out.println("Registration successful");
        }else {
            System.out.println("Login already in use");
        }
    }
}
