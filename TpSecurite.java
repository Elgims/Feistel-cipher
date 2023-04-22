/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.securite;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class TpSecurite {

  public static void main(String[] args) {

    KeyGenerator keyGen;
    try {
      keyGen = KeyGenerator.getInstance("DESede");
      keyGen.init(168);
      SecretKey cle = keyGen.generateKey();
      System.out.println("cle (" + cle.getAlgorithm() + "," + cle.getFormat()
          + ") : " + new String(cle.getEncoded()));
    } catch (Exception e) {
      e.printStackTrace(); 
    }
  }
}/**
 *
 * @author GIMENA
 */

