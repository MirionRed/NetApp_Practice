/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDPObject;

import TCPObject.*;
import java.io.Serializable;

/**
 *
 * @author Red King
 */
public class UDPObjectC implements Serializable{
    public int number1, number2;
    public UDPObjectC(int number1, int number2){
        this.number1 = number1;
        this.number2 = number2;
    }
    public int getNumber1(){
        return number1;
    }
    
    public int getNumber2(){
        return number2;
    }
}
