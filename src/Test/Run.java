/**
 * Class to test the encryption class
 * Date : 12.09.19
 * Last Modified: 17.09.19
 */
package Test;
import static Encryption.AESEncryption.decrypt;
import static Encryption.AESEncryption.encrypt;
import static Encryption.AESEncryption.hashPassword;
import static Encryption.BCrypt.checkpw;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author Fahim
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String ... args)  {
        Scanner input = new Scanner(System.in);
        //  Data Encryption part
        final String secretKey = "I have now secret.";
        System.out.print("Enter data to encrypt: ");
        String originalString = input.nextLine();
        //String originalString = "fahimkamal63@gmail.com";
        String encryptedString = encrypt(originalString, secretKey) ;
        String decryptedString = decrypt(encryptedString, secretKey) ;
     
        System.out.println( "Before Encryption: " + originalString + " " + originalString.length());
        System.out.println( "After Encryption: " + encryptedString+ " " + encryptedString.length());
        System.out.println("After decryption: "+ decryptedString);
        
        //  Password hassing part
        System.out.println();
        System.out.print("Enter password: ");
        String originalPassword = input.nextLine();
        System.out.print("Re-enter password: ");
        String check = input.nextLine();
        //String originalPassword = "fahimkamal63@gmail.com";
        String generatedSecuredPasswordHash = null;
        boolean matched = false;
        
        try{
           generatedSecuredPasswordHash = hashPassword(originalPassword); 
           matched = checkpw(check, generatedSecuredPasswordHash);
        }catch(NoSuchAlgorithmException e){ System.out.println("Error while decrypting: " + e.toString()); }
         
        System.out.println("Original Password: "+ originalPassword+ " " + originalPassword.length());
        
        System.out.println("After hashing: " + generatedSecuredPasswordHash+ " " + generatedSecuredPasswordHash.length());
        System.out.print("Status: ");
        System.out.println(matched);
    }
    
}