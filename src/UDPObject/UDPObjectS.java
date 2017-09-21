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
public class UDPObjectS implements Serializable{
    private int number;
    public UDPObjectS(int number1, int number2){
        this.number = number1 + number2;
    }
    public int getNumber(){
        return number;
    }
}
