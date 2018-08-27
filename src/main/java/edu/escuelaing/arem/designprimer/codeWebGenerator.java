/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.designprimer;

import edu.escuelaing.arem.standardDeviation.standardDeviation;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import spark.Request;
import spark.Response;

/**
 *
 * @author camilolopez
 */
public class codeWebGenerator {

    private String allCode, inHtml, finHtml,
            inBody, finBody, input, inForm,
            finForm, nameInput, resultButton,
            numbersInText, codeDeviation;
    private standardDeviation staDevi;
    private Request req;
    private Response res;

    public codeWebGenerator() {
        inHtml = "<HTML>";
        finHtml = "</HTML>";
        inBody = "<BODY>";
        finBody = "</BODY>";
        inForm = "<form action='results'>";
        finForm = "</form>";
        nameInput = "<p>Inserte numeros, deben ir separados por espacios, los decimales "
                + "deben ir con punto (.) no con coma (,) y debe finalizar con un espacio</p>";
        input = "<input type='text' name='numbers'>";
        resultButton = "<input type='submit' value='Calcular'>";
        allCode = inHtml + inBody + inForm + nameInput + input + resultButton + finForm + finBody + finHtml;
    }

    public String codeDeviationGenerator() throws FileNotFoundException, UnsupportedEncodingException {
        getResults();
        textToAFile();
        staDevi = new standardDeviation();
        return inHtml + inBody + staDevi.getStandardDeviation() + finBody + finHtml;
    }

    public String getAllCode(Request req, Response res) {
        this.req = req;
        this.res = res;
        return allCode;
    }

    public void getResults() {
        numbersInText = req.queryParams("numbers");
    }

    public void textToAFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter pw = new PrintWriter("file.txt", "UTF-8");
        String number = "";
        for (int i = 0; i < numbersInText.length(); i++) {            
            if (" ".equals(String.valueOf(numbersInText.charAt(i)))) {
                pw.println(number);                
                number = "";
            } else {
                number += numbersInText.charAt(i);
            }
        }        
        pw.close();
    }

    public void setAllCode(String allCode) {
        this.allCode = allCode;
    }

    public String getCodeDeviation() {
        return codeDeviation;
    }

    public void setCodeDeviation(String codeDeviation) {
        this.codeDeviation = codeDeviation;
    }

    public String getNumbersInText() {
        return numbersInText;
    }

    public void setNumbersInText(String numbersInText) {
        this.numbersInText = numbersInText;
    }

}
