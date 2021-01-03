package com.company;

import com.company.Control.OperacionsBanc;
import com.company.Exceptions.BankAccountException;
import com.company.Exceptions.ClientAccountException;
import com.company.Model.Client;
import com.company.Model.CompteEstalvi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    public void menuPrincipal () throws ClientAccountException, BankAccountException {
        while (true) {
            System.out.println("------------------");
            System.out.println("  MENU PRINCIPAL  ");
            System.out.println("------------------");
            System.out.println("1. MENU DE LOS ERRORES");
            System.out.println("2. MENU INTERACTIVO");
            System.out.println("0. Salir");

            System.out.print("Escoge una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                menuErrores();
            } else if (opcion == 2) {
                menuInteractivo();
            } else if (opcion == 0) {
                break;
            }
        }
        System.out.println("FELIZZZZZZZ AÑO...");
    }

    public void menuErrores() throws ClientAccountException, BankAccountException {


        CompteEstalvi cuenta1 = new CompteEstalvi("23072001");
        CompteEstalvi cuenta2 = new CompteEstalvi("18072008");
        CompteEstalvi cuenta3 = new CompteEstalvi( "25101996");

        cuenta1.ingressar(1300);
        cuenta2.ingressar(2000);

        OperacionsBanc.compteEstalviList.add(cuenta1);
        OperacionsBanc.compteEstalviList.add(cuenta2);

        //lo añadimos luego
        Client client = null;

        int opcion;

        do {
            System.out.println();
            System.out.println("..........MENU DONDE PODRÁS VER CADA UNA DE LAS EXCEPCIONES..........");
            System.out.println("BANK ACCOUNT MESSAGES");
            System.out.println("1. Error - ACCOUNT_NOT_FOUND = Compte inexistent");
            System.out.println("2. Error - ACCOUNT_OVERDRAFT = Compte al descobert");
            System.out.println("3. Error - ACCOUNT_ZERO_USER = Compte sense usuari");
            System.out.println("CLIENT MESSAGES");
            System.out.println("4. Error - WRONG_DNI = DNI incorrecte");
            System.out.println("OPERATIONS");
            System.out.println("5. Error - TRANSFER_ERROR = Error en la transferència");
            System.out.println("6. Sortir - FELIZ NAVIDAD");
            System.out.println("");
            System.out.print("Introduïu l'opció: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    //SI saltará la exception porque la cuenta 3 no esta añadida
                    OperacionsBanc.verifyAccount(cuenta3);
                    break;
                case 2:
                    //NO saltará la exception porque hay suficiente dinero y no se quedara al "descobert"
                    cuenta2.treure(2100);
                    break;
                case 3:
                    cuenta1.getLlista_usuaris();
                    break;
                case 4:
                    //NO saltará el error porque el DNI es CORRECTO
                    client = new Client("Elvis", "Lara", "54907423Y");
                    break;

                case 5:
                    //SÍ saltará el error porque no hay suficiente dinero
                    OperacionsBanc.transferencia(cuenta1, cuenta2, 9999999);
                    break;
                case 6:
                    System.out.println("FELIZ NAVIDAD");
                    break;

                default:
                    System.out.println("SOLO PUEDE ELEGIR UNA OPCION VALIDA");
            }
        } while (opcion != 6);
    }

    public void menuInteractivo() throws ClientAccountException, BankAccountException {

        OperacionsBanc operacionsBanc = new OperacionsBanc();

        Client elvis = new Client("Elvis", "Lara", "54907423Y");
        Client nashe = new Client("Nashe", "Mr", "54907423Y");

        System.out.println("Introduce el numero de tu cuenta (Ex: 123456)");
        String cuenta = scanner.next();
        CompteEstalvi compteEstalvi = new CompteEstalvi(cuenta);
        CompteEstalvi cuenta1 = new CompteEstalvi("666");
        CompteEstalvi cuenta2 = new CompteEstalvi("2021");

        cuenta1.ingressar(4000);
        cuenta2.ingressar(2021);

        System.out.println("Introduce el Nombre");
        String nom = scanner.next();
        System.out.println("Introduce el Apellido");
        String apellido = scanner.next();
        System.out.println("Introduce el DNI");
        String dni = scanner.next();

        Client client = new Client(nom, apellido, dni);
        compteEstalvi.addUser(client);
        compteEstalvi.addUser(elvis);
        compteEstalvi.addUser(nashe);

        int opcion;

        do {
            System.out.println("Que quieres hacer hoy?");
            System.out.println("----------------------------------");
            System.out.println("1. Ingresar Dinero");
            System.out.println("2. Sacar Dinero");
            System.out.println("3. Borrar Usuario");
            System.out.println("4. Transferencia");
            System.out.println("5. Ver Informacion Cuentas");
            System.out.println("6. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Cuanto dinero quieres ingresar: ");
                    double dineroIngresar = scanner.nextDouble();
                    compteEstalvi.ingressar(dineroIngresar);
                    System.out.println("Saldo disponible: " + compteEstalvi.getSaldo());
                    break;

                case 2:
                    System.out.print("Cuanto dinero quieres sacar?: ");
                    double dineroTreure = scanner.nextDouble();
                    compteEstalvi.treure(dineroTreure);
                    System.out.println("Saldo disponible: " + compteEstalvi.getSaldo());
                    break;

                case 3:
                    System.out.println("Usuarios:");
                    for (Client e : compteEstalvi.getLlista_usuaris()) {
                        System.out.println(e.getNom());
                    }

                    System.out.print("Que usuario quieres borrar: ");
                    String user = scanner.next();
                    compteEstalvi.removeUser(user);
                    System.out.println();
                    System.out.println("BORRADO!!!!");
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.println("Numero de la cuenta 1: (tu cuenta)");
                    String compte1 = scanner.nextLine();

                   // compte1 = String.valueOf(OperacionsBanc.verifyAccount(compteEstalvi));

                    System.out.println("Numero de la cuenta 2: (escriba 666)");
                    String compte2 = scanner.nextLine();
                    //compte2 = String.valueOf(OperacionsBanc.verifyAccount(cuenta1));

                    System.out.println("De cuanto es la transferencia??: ");
                    Double transf = scanner.nextDouble();

                    operacionsBanc.transferencia(compteEstalvi, cuenta1, transf);
                    break;

                case 5:
                    System.out.println("Informacion de Cuentas");
                    System.out.println("----------------------------------");
                    System.out.println("Numero Compte: " + compteEstalvi.getNumCompte() + " Saldo: " + compteEstalvi.getSaldo());
                    System.out.println("Numero Compte: " + cuenta1.getNumCompte() + " Saldo: " + cuenta1.getSaldo());
                    System.out.println("Numero Compte: " + cuenta2.getNumCompte() + " Saldo: " + cuenta2.getSaldo());

                case 6:
                    System.out.println("BYE, BUENAS NOCHES");

                default:
                    System.out.println("Introduce un numero entre 1-6");
            }
        } while (opcion != 6);
    }
}
