/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author itsra
 */
public class DES {
    protected static String encrypt (String pT, String key) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        //System.out.println("Started");
        int i = 0;
        ArrayList<Future<String>> save = new ArrayList<>();
        //System.out.println("Started");
        while(i < pT.length()){
            String curPT = pT.substring(i, i + 16);
            DESBlock cur = new DESBlock(curPT, key, true);
            save.add(executor.submit(cur));
            i = i + 16;
        }
        //System.out.println("Started");
        
        String cipherText = "";
        
        for (Future<String> block: save){
            String cipherBlock = block.get();
            //System.out.println(cipherBlock);
            cipherText += cipherBlock;
        }
        
        executor.shutdown();
        
        return cipherText;
        
    }
    
    protected static String decrypt (String cipher, String key) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(8);
       
        int i = 0;
        ArrayList<Future<String>> save = new ArrayList<>();
        while(i < cipher.length()){
            String curCT = cipher.substring(i, i + 16);
            DESBlock cur = new DESBlock(curCT, key, false);
            save.add(executor.submit(cur));
            i = i + 16;
        }
        
        String pT = "";
        
        for (Future<String> block: save){
            String plainBlock = block.get();
            //System.out.println(plainBlock);
            pT += plainBlock;
        }
        
        executor.shutdown();
        
        return pT;
        
    }
}
