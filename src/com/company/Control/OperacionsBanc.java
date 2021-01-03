package com.company.Control;

import com.company.Exceptions.BankAccountException;
import com.company.Exceptions.ClientAccountException;
import com.company.Model.CompteEstalvi;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.Exceptions.ExceptionMessage.ACCOUNT_NOT_FOUND;
import static com.company.Exceptions.ExceptionMessage.WRONG_DNI;
import static com.company.Exceptions.ExceptionMessage.TRANSFER_ERROR;

public class OperacionsBanc{

    public static List<CompteEstalvi> compteEstalviList = new ArrayList<>();

    public static boolean verifyDNI(String dni) throws ClientAccountException{
        Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher matcher = pattern.matcher(dni);

        boolean correcto = false;

        if (matcher.matches()) {
            String letra = matcher.group(2);
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            int index = Integer.parseInt(matcher.group(1));
            index = index % 23;
            String reference = letras.substring(index, index + 1);

            if (reference.equalsIgnoreCase(letra)) {
                correcto = true;
            } else {
                correcto = false;
                throw new ClientAccountException(WRONG_DNI);
            }
        }
        return correcto;
    }
    public static boolean verifyAccount(CompteEstalvi numCompte) throws BankAccountException {

        if(!compteEstalviList.contains(numCompte)){
            throw new BankAccountException(ACCOUNT_NOT_FOUND);
        }else{
            return false;
        }
    }
    public static void transferencia(CompteEstalvi cuenta1, CompteEstalvi cuenta2, double dinero) throws BankAccountException {
        if (cuenta1.getSaldo() >= dinero) {
            cuenta1.treure(dinero);
            cuenta2.ingressar(dinero);
        } else {
            throw new BankAccountException(TRANSFER_ERROR);
        }
    }
}

