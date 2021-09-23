/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;

/**
 *
 * @author itsra
 */
public class Utilities {
    
 
    protected static String hexToBinary(String hex){
        long val = Long.parseUnsignedLong(hex, 16);
        String binary = Long.toBinaryString(val);
        
        while(binary.length() < hex.length() * 4){
            binary = "0" + binary;
        }
        
        return binary;
    }
    
    

    protected static String BinaryToHex(String binary){
        long val = Long.parseUnsignedLong(binary, 2);
        String hex = Long.toHexString(val);
        
        while(hex.length() < (int) binary.length() / 4){
            hex = "0" + hex;
        }
        
        return hex;
    }
    
    protected static String permute(String text, int[] pattern, int nBits){
        
        String out = "";
        for (int i = 0; i < nBits; i++){
            out = out + text.charAt(pattern[i] - 1);
        }
        
        return out;
        
    }
    
    protected static String rotateLeft(String text, int nShifts){
        String last = text.substring(0, nShifts);
        String first = text.substring(nShifts);
        
        return first + last;
    }
    
    protected static String xor(String A, String B){
        String ret = "";
        
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == B.charAt(i)){
                ret = ret + "0";
            }
            else{
                ret = ret + "1";
            }
        }
        

        return ret;
        
       
    }
    

    
    
    
}
