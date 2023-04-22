/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dechiffrement;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Dechiffrement {

  public static void main(String[] args) {

    final String message = "Mon message a traiter";

    KeyGenerator keyGen;
    try {
      keyGen = KeyGenerator.getInstance("DESede");
      keyGen.init(168);
      SecretKey cle = keyGen.generateKey();
      System.out.println("cle : " + new String(cle.getEncoded()));

      byte[] enc = encrypter(message, cle);

      String dec = decrypter(enc, cle);
      System.out.println("texte dechiffrer : " + dec);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static byte[] encrypter(final String message, SecretKey cle)
      throws NoSuchAlgorithmException, NoSuchPaddingException,
      InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    Cipher cipher = Cipher.getInstance("DESede");
    cipher.init(Cipher.ENCRYPT_MODE, cle);
    byte[] donnees = message.getBytes();

    return cipher.doFinal(donnees);
  }

  public static String decrypter(final byte[] donnees, SecretKey cle)
      throws NoSuchAlgorithmException, NoSuchPaddingException,
      InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    Cipher cipher = Cipher.getInstance("DESede");
    cipher.init(Cipher.DECRYPT_MODE, cle);

    return new String(cipher.doFinal(donnees));
  }

}
/**
 *
 * @author GIMENA
 */
