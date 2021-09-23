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
public class run {
    public static void main(String[] args)  throws Exception{

        String text = "422456ABCD132536453465ACFD132516";
        String key = "AFBC05182236CDB8";
        
        String binCipherText = DES.encrypt(text, key);
        
        String cipherText = "";
        for(int i = 0; i < binCipherText.length(); i += 64){
            String curPart = binCipherText.substring(i, i + 64);
            cipherText += Utilities.BinaryToHex(curPart).toUpperCase();
        }
                
        
        //System.out.println(binCipherText);
        System.out.println(cipherText);
        
        System.out.println();
        
        String bindecrypted = DES.decrypt(cipherText, key);
        String decrypt = "";
                
        
        for(int i = 0; i < bindecrypted.length(); i += 64){
            String curPart = bindecrypted.substring(i, i + 64);
            decrypt += Utilities.BinaryToHex(curPart).toUpperCase();
        }
        
        System.out.println(decrypt);
        System.out.println(decrypt.equals(text));
        
        
    }
}
