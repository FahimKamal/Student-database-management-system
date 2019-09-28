/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.Random;

/**
 *
 * @author Fahim
 */
public class AutoNumber {

    public static int getRandomNumberInts(int min, int max){
    Random random = new Random();
    return random.ints(min,(max+1)).findFirst().getAsInt();
}
    public static void main(String[] args) {
        System.out.println("Auto number in the range: (10000000 - 99999999)" + getRandomNumberInts(10000000, 99999999));
    }
    
}
