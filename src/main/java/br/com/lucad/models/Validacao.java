package br.com.lucad.models;

import br.com.lucad.views.MainMenu;

import java.util.Scanner;

public class Validacao {

    public int checkIsANumber(Scanner userInput) {
        System.out.println("Escolha uma Opção: ");
        if (userInput.hasNextInt()) {
            return userInput.nextInt();
        } else {
            System.out.println("Digite Apenas Numeros!!!");
            MainMenu menu = new MainMenu();
            menu.menuInit();
            return 6;
        }
    }
}
