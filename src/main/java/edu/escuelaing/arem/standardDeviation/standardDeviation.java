/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.standardDeviation;

import edu.escuelaing.arem.linkedList.LinkedList;
import edu.escuelaing.arem.linkedList.Node;
import java.util.ArrayList;

/**
 *
 * @author camilolopez
 */
public class standardDeviation {

    private LinkedList numbers;
    private readFile numbersFile;
    private double mean, standardDeviation;

    public standardDeviation() {
        numbersFile = new readFile();
        calculateTheMean();
        calculateStandardDeviation();
    }

    private void calculateTheMean() {
        double numbersSum = 0;
        numbers = numbersFile.getListLinked();
        Node nextNode = numbers.nextNode();
        while (nextNode != null) {
            numbersSum += nextNode.getInfoNode();
            nextNode = nextNode.getNextNode();
        }
        mean = numbersSum / numbers.getCountNodes();
    }

    private void calculateStandardDeviation() {
        double totalSum = 0;
        numbers = numbersFile.getListLinked();
        Node nextNode = numbers.nextNode();
        while (nextNode != null) {
            totalSum += Math.pow(nextNode.getInfoNode() - mean, 2);
            nextNode = nextNode.getNextNode();
        }
        totalSum = totalSum / (numbers.getCountNodes() - 1);
        standardDeviation = Math.sqrt(totalSum);
    }

    public readFile getNumbersFile() {
        return numbersFile;
    }

    public void setNumbersFile(readFile numbersFile) {
        this.numbersFile = numbersFile;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

}
