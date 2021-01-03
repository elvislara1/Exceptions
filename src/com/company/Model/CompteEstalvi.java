package com.company.Model;

import com.company.Exceptions.BankAccountException;
import com.company.Exceptions.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

import static com.company.Exceptions.ExceptionMessage.ACCOUNT_ZERO_USER;

public class CompteEstalvi {

    private String numCompte;
    private double saldo;
    private List<Client> llista_usuaris;

    public CompteEstalvi(String numCompte) {
        this.numCompte = numCompte;
        saldo = 0;
        llista_usuaris = new ArrayList<>();
    }
    //TODO
        /**
         Afegeix un usuari d'aquest compte
         @param client
         @return quantitat d'usuaris que té el compte
         **/
    public int addUser(Client client) {
        llista_usuaris.add(client);
        return llista_usuaris.size();
    }

    //TODO
        /**
         Elimina un usuari d'aquest compte,
         Com que no pot quedar un compte sense usuari, si és l'ùltim és llança una excepció
         @param dni
         @return quantitat d'usuaris que té el compte
         @throws BankAccountException
         **/
    public int removeUser(String dni) throws BankAccountException {
        //leer el "T0D0" para entender bien esta parte!
        if (llista_usuaris.size() <= 1){
            //saltará la exception si es el ultimo usuario
            throw new BankAccountException(ACCOUNT_ZERO_USER);
        } else{
            //si no es el ultimo usuario entonces lo eliminará ->
            llista_usuaris.removeIf(u -> dni.equals(u.getDNI()));
        }
        return llista_usuaris.size();
    }

    /**
     * Afegeix m diners al saldo
     * @param m
     */
    public void ingressar(double m) {
        saldo += m;
    }

    //TODO
        /**
         * Treu m diners del compte si n'hi han suficient sinó es llança l'excepció
         * @param m
         * @throws BankAccountException
         */
    public void treure(double m) throws BankAccountException {
        //si no hay saldo suficiente...salta la exception
        if (saldo - m < 0){
            throw new BankAccountException(ExceptionMessage.ACCOUNT_OVERDRAFT);
        } else {
            saldo -= m;
        }
    }

    public String getNumCompte() {
        return numCompte;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Client> getLlista_usuaris() {
        return llista_usuaris;
    }
}
