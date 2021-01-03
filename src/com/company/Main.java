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

public class Main {

    public static void main(String[] args) throws ClientAccountException, BankAccountException {

        new Menu().menuPrincipal();

    }
}
