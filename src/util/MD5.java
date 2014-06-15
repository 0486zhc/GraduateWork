package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
   public static String afterMd5(String input){
      MessageDigest digest;
      StringBuilder builder = new StringBuilder(32);
      try
      {
         digest = MessageDigest.getInstance("MD5");
         byte[] ciphertext = digest.digest(input.getBytes());
         
         //convert 8 bytes cipher text to 16 bytes cipher text
         int temp; 
        
         for(int i = 0; i < ciphertext.length; i ++){
            temp = ciphertext[i];
            if(temp < 0){
               temp += 256;
            }
            if(temp<16){
               builder.append("0"); 
            }
            builder.append(Integer.toHexString(temp));
         }
      } catch (NoSuchAlgorithmException e)
      {
         e.printStackTrace();
      }

      return builder.toString().substring(8, 24);
}   
}
