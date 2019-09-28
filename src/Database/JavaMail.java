/**
 * Class to sent mail from application
 * Date : 17.09.19
 * Last Modified: 18.09.19
 */
package Database;

import Test.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Fahim
 */
public class JavaMail {
    public static void sendMail(String recepient, String user, String verificationNumber) throws MessagingException{
        System.out.println("Preparing to sent email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "fahimkamalpub@gmail.com";
        String password = "fahimkamal12456";
        
        Session session = Session.getInstance(properties,new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        Message massage = prepareMessage(session, myAccountEmail, recepient, user, verificationNumber);
        Transport.send(massage);
        System.out.println("Email sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String user, String verificationNumber) {
        String template = 
"<!DOCTYPE html>\n" +
"<html lang=\"en-us\">\n" +
"<head>\n" +
"	<title>\n" +
"		Password Verification\n" +
"		\n" +
"	</title>\n" +
"<meta charset=\"utf-8\">\n" +
"</head>\n" +
"<body style=\"margin: 0;padding: 0;\">\n" +
"	<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#F6F6F6\">\n" +
"		<tr>\n" +
"			<td>\n" +
"				<table cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#FFFFFF\" align=\"center\" width=\"598\">\n" +
"					<tr>\n" +
"						<td valign=\"top\">\n" +
"							<table cellspacing=\"0\" cellpadding=\"0\" align=\"center\" width=\"100%\" border=\"0\">\n" +
"								<tr>\n" +
"									<td>\n" +
"										<table cellspacing=\"0\" cellpadding=\"0\" align=\"center\" width=\"100%\" border=\"0\" bgcolor=\"#F6F6F6\">\n" +
"											<tr>\n" +
"												<td align=\"center\" style=\"padding-top: 15px; padding-bottom: 15px\">\n" +
"													<a href=\"#\" target=\"_blank\"><img src=\"https://i.imgur.com/BLdQNp1.png\" width=\"107px\"></a>\n" +
"												</td>												\n" +
"											</tr>\n" +
"											<TR>\n" +
"												<td bgcolor=\"#FFFFFF\" height=\"30\" valign=\"top\" align=\"center\" style=\"font-size: 30px; font-family: Calibri; padding-top: 15px; padding-bottom: 15px\">\n" +
"													Password Recover\n" +
"												</td>\n" +
"											</TR>\n" +
"											<tr>\n" +
"												<td height=\"50px\" bgcolor=\"#FFFFFF\" valign=\"top\" align=\"left\" style=\"font-size: 15px; font-family: Calibri; padding-top: 15px; padding-bottom: 15px; padding-left: 20px; padding-right: 20px\">\n" +
"													Hi "+user+", <br>\n" +
"\n" +
"													Seems like you have forget your password for Student database management system. If this is true, then copy the code below and paste it in the program.\n" +
"												</td>\n" +
"											</tr>\n" +
"											<tr>\n" +
"												<td align=\"center\" bgcolor=\"white\">\n" +
"													<table cellpadding=\"0\" cellspacing=\"0\" width=\"270px\" border=\"0\">\n" +
"														<tr>\n" +
"															<td bgcolor=\"#2bde73\" align=\"center\" style=\"padding: 17px; font-size: 20px; color: white;border-radius: 5px;\"><a style=\"color: white; text-decoration: none; \" target=\"_blank\"><strong>"+verificationNumber+"</strong></a></td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<br><br>\n" +
"												</td>\n" +
"											</tr>\n" +
"											<tr>\n" +
"												<td height=\"30px\" bgcolor=\"#FFFFFF\" valign=\"top\" align=\"left\" style=\"font-size: 15px; font-family: Calibri; padding-top: 15px; padding-bottom: 15px; padding-left: 20px\">\n" +
"													If you did not forgot your password your can safely ignore this email.\n" +
"												</td>\n" +
"											</tr>\n" +
"											<tr>\n" +
"												<td height=\"30px\" valign=\"top\" align=\"center\" style=\"font-size: 15px; font-family: Calibri; padding-top: 15px; padding-bottom: 15px; padding-left: 20px\">\n" +
"													PUNDRA UNIVERSITY OF SCIENCE & TECHNOLOGY<br>\n" +
"													Rangpur Road, Gokul, Bogra-5800\n" +
"												</td>\n" +
"											</tr>\n" +
"											<tr>\n" +
"												<td height=\"30px\" valign=\"top\" align=\"center\" style=\"font-size: 15px; font-family: Calibri; padding-top: 15px; padding-bottom: 15px; padding-left: 20px\">\n" +
"													Powered by <br>\n" +
"													Fahim Kamal Ahmed\n" +
"												</td>\n" +
"											</tr>\n" +
"										</table>\n" +
"									</td>\n" +
"								</tr>\n" +
"							</table>\n" +
"						</td>\n" +
"					</tr>\n" +
"				</table>				\n" +
"			</td>\n" +
"		</tr>\n" +
"	</table>\n" +
"</body>\n" +
"</html>";
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("User verification Email");
            //message.setText("Hey there, \nThis a automated Email. Created by the application. \n regards from Fahim");
            message.setContent(template, "text/html");
            return message; 
        } catch (Exception ex) {
            Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
}
