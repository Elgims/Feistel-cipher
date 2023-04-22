/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chiffrement;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Chiffrement {
   public static void main(String[] args) throws Exception {
      String plainText = "This is a secret message";
      
      // Generate a secret key
      KeyGenerator keyGen = KeyGenerator.getInstance("AES");
      keyGen.init(8);
      SecretKey secretKey = keyGen.generateKey();
      
      // Create a cipher object
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      
      // Initialize the cipher object with the secret key
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      
      // Encrypt the plain text
      byte[] cipherText = cipher.doFinal(plainText.getBytes());
      
      // Print the encrypted text
      System.out.println("Cipher text: " + new String(cipherText));
   }
}

