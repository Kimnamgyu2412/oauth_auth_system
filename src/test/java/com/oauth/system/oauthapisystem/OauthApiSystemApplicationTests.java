package com.oauth.system.oauthapisystem;

import com.oauth.system.oauthapisystem.domain.api.dto.EmailResponseDTO;
import com.oauth.system.oauthapisystem.email.config.AwsSettingConfig;
import com.oauth.system.oauthapisystem.email.oauth.OAuthClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@EnableConfigurationProperties({AwsSettingConfig.class})
@ActiveProfiles("localhost")
class OauthApiSystemApplicationTests {

    @Autowired
    private OAuthClientService oAuthClientService;

    @Test
    void testApiWithToken() {
        String mailContent = "[{\n" +
                "\"senderEmail\": \"nick1961@micehub.com\",\n" +
                "\"senderName\": \"김남규\",\n" +
                "\"receiverEmail\": \"nick1961@micehub.com\",\n" +
                "\"subject\": \"Test Email11111\",\n" +
                "\"body\": \"<html><body style='font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px;'><table role='presentation' style='width: 100%; max-width: 600px; margin: auto; border: 1px solid #e1e1e1; border-radius: 8px; background-color: #ffffff;'><tr style='background-color: #007BFF; color: white; text-align: center;'><td style='padding: 20px; font-size: 24px; font-weight: bold;'>Test Email Notification</td></tr><tr><td style='padding: 20px;'><p style='font-size: 16px; color: #333333;'>Hi,</p><p style='font-size: 16px; color: #333333;'>This is a test message to showcase an <b>HTML formatted</b> email with a nice layout. Please find more details below:</p><table style='width: 100%; border-top: 2px solid #007BFF; padding-top: 15px;'><tr><td><strong>Sender:</strong> 김남규</td></tr><tr><td><strong>Subject:</strong> Test Email11111</td></tr><tr><td><strong>Body:</strong> This is a test email to check the layout and formatting. You can add more custom content here!</td></tr></table><p style='margin-top: 20px;'>Best regards,</p><p><i>김남규</i></p><p style='font-size: 12px; color: #777777;'>This is a demo email. If you have any questions, feel free to contact us.</p></td></tr><tr style='background-color: #f1f1f1;'><td style='text-align: center; padding: 10px; font-size: 12px; color: #777777;'>You received this email because you are subscribed to our service.</td></tr></table></body></html>\"\n" +
                "}]";
//        List<Map<String,Object>> paramList = new ArrayList<>();
//        Map<String,Object> paramMap2 = new HashMap<>();
//        paramMap2.put("senderEmail","nick1961@micehub.com");
//        paramMap2.put("senderName","김남규");
//        paramMap2.put("receiverEmail","nick1961@micehub.com");
//        paramMap2.put("subject","Test Email");
//        paramMap2.put("body","<html><body style='font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px;'><table role='presentation' style='width: 100%; max-width: 600px; margin: auto; border: 1px solid #e1e1e1; border-radius: 8px; background-color: #ffffff;'><tr style='background-color: #007BFF; color: white; text-align: center;'><td style='padding: 20px; font-size: 24px; font-weight: bold;'>Test Email Notification</td></tr><tr><td style='padding: 20px;'><p style='font-size: 16px; color: #333333;'>Hi,</p><p style='font-size: 16px; color: #333333;'>This is a test message to showcase an <b>HTML formatted</b> email with a nice layout. Please find more details below:</p><table style='width: 100%; border-top: 2px solid #007BFF; padding-top: 15px;'><tr><td><strong>Sender:</strong> 김남규</td></tr><tr><td><strong>Subject:</strong> Test Email11111</td></tr><tr><td><strong>Body:</strong> This is a test email to check the layout and formatting. You can add more custom content here!</td></tr></table><p style='margin-top: 20px;'>Best regards,</p><p><i>김남규</i></p><p style='font-size: 12px; color: #777777;'>This is a demo email. If you have any questions, feel free to contact us.</p></td></tr><tr style='background-color: #f1f1f1;'><td style='text-align: center; padding: 10px; font-size: 12px; color: #777777;'>You received this email because you are subscribed to our service.</td></tr></table></body></html>");
//        paramList.add(paramMap2);
//        Map<String,Object> paramMap = new HashMap<>();
//        paramMap.put("senderEmail","nick1961@micehub.com");
//        paramMap.put("senderName","김남규");
//        paramMap.put("receiverEmail","nick1961@micehub.com");
//        paramMap.put("subject","Test Email@@@@@@");
//        paramMap.put("body","<html><body style='font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px;'><table role='presentation' style='width: 100%; max-width: 600px; margin: auto; border: 1px solid #e1e1e1; border-radius: 8px; background-color: #ffffff;'><tr style='background-color: #007BFF; color: white; text-align: center;'><td style='padding: 20px; font-size: 24px; font-weight: bold;'>Test Email Notification</td></tr><tr><td style='padding: 20px;'><p style='font-size: 16px; color: #333333;'>Hi,</p><p style='font-size: 16px; color: #333333;'>This is a test message to showcase an <b>HTML formatted</b> email with a nice layout. Please find more details below:</p><table style='width: 100%; border-top: 2px solid #007BFF; padding-top: 15px;'><tr><td><strong>Sender:</strong> 김남규</td></tr><tr><td><strong>Subject:</strong> Test Email11111</td></tr><tr><td><strong>Body:</strong> This is a test email to check the layout and formatting. You can add more custom content here!</td></tr></table><p style='margin-top: 20px;'>Best regards,</p><p><i>김남규</i></p><p style='font-size: 12px; color: #777777;'>This is a demo email. If you have any questions, feel free to contact us.</p></td></tr><tr style='background-color: #f1f1f1;'><td style='text-align: center; padding: 10px; font-size: 12px; color: #777777;'>You received this email because you are subscribed to our service.</td></tr></table></body></html>");
//        paramList.add(paramMap);
//        SesDto test = new SesDto();
//        test.setBodyHtml("test");
        //newEmailService.sendMailBulk(mailContent);
        //EmailResponseDTO emailResponseDTO = oAuthClientService.callApiWithToken("/api/email/"+3, HttpMethod.GET,null,EmailResponseDTO.class);
        List<EmailResponseDTO> emailResponseDTOList = oAuthClientService.callApiWithToken("/api/email", HttpMethod.GET,null, ArrayList.class);
        System.out.println(emailResponseDTOList);
    }

}
