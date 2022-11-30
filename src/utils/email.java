/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author SBS
 */
public class email {
    
    public void sendEmail(String adress, String subject, String hash) throws MessagingException {
        String from = "sarbon1707@gmail.com";
        String password = "17071998Am";
        String[] to = {adress};
        String host = "smtp.gmail.com";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.user", from);
        prop.put("mail.smtp.password", password);

        Session session = Session.getDefaultInstance(prop);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from));
        InternetAddress[] toadress = new InternetAddress[to.length];
        for (int i = 0; i < to.length; i++) {
            toadress[i] = new InternetAddress(to[i]);
        }
        for (int i = 0; i < toadress.length; i++) {
            msg.setRecipient(Message.RecipientType.TO, toadress[i]);
        }
        msg.setSubject(subject);
        

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"\n" +
"      style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
"\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
"    <meta name=\"x-apple-disable-message-reformatting\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta content=\"telephone=no\" name=\"format-detection\">\n" +
"    <title>Giftstory-blog</title>\n" +
"    <!--[if (mso 16)]>\n" +
"    <style type=\"text/css\">\n" +
"        a {text-decoration: none;}\n" +
"    </style>\n" +
"    <![endif]-->\n" +
"    <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]-->\n" +
"    <!--[if gte mso 9]>\n" +
"    <xml>\n" +
"        <o:OfficeDocumentSettings>\n" +
"            <o:AllowPNG></o:AllowPNG>\n" +
"            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
"        </o:OfficeDocumentSettings>\n" +
"    </xml>\n" +
"    <![endif]-->\n" +
"    <style type=\"text/css\">\n" +
"        #outlook a {\n" +
"            padding: 0;\n" +
"        }\n" +
"\n" +
"        .ExternalClass {\n" +
"            width: 100%;\n" +
"        }\n" +
"\n" +
"        .ExternalClass,\n" +
"        .ExternalClass p,\n" +
"        .ExternalClass span,\n" +
"        .ExternalClass font,\n" +
"        .ExternalClass td,\n" +
"        .ExternalClass div {\n" +
"            line-height: 100%;\n" +
"        }\n" +
"\n" +
"        .es-button {\n" +
"            mso-style-priority: 100 !important;\n" +
"            text-decoration: none !important;\n" +
"        }\n" +
"\n" +
"        a[x-apple-data-detectors] {\n" +
"            color: inherit !important;\n" +
"            text-decoration: none !important;\n" +
"            font-size: inherit !important;\n" +
"            font-family: inherit !important;\n" +
"            font-weight: inherit !important;\n" +
"            line-height: inherit !important;\n" +
"        }\n" +
"\n" +
"        .es-desk-hidden {\n" +
"            display: none;\n" +
"            float: left;\n" +
"            overflow: hidden;\n" +
"            width: 0;\n" +
"            max-height: 0;\n" +
"            line-height: 0;\n" +
"            mso-hide: all;\n" +
"        }\n" +
"\n" +
"        @media only screen and (max-width:600px) {\n" +
"\n" +
"            p,\n" +
"            ul li,\n" +
"            ol li,\n" +
"            a {\n" +
"                font-size: 16px !important;\n" +
"                line-height: 150% !important\n" +
"            }\n" +
"\n" +
"            h1 {\n" +
"                font-size: 30px !important;\n" +
"                text-align: center;\n" +
"                line-height: 120% !important\n" +
"            }\n" +
"\n" +
"            h2 {\n" +
"                font-size: 26px !important;\n" +
"                text-align: center;\n" +
"                line-height: 120% !important\n" +
"            }\n" +
"\n" +
"            h3 {\n" +
"                font-size: 20px !important;\n" +
"                text-align: center;\n" +
"                line-height: 120% !important\n" +
"            }\n" +
"\n" +
"            h1 a {\n" +
"                font-size: 30px !important\n" +
"            }\n" +
"\n" +
"            h2 a {\n" +
"                font-size: 26px !important\n" +
"            }\n" +
"\n" +
"            h3 a {\n" +
"                font-size: 20px !important\n" +
"            }\n" +
"\n" +
"            .es-menu td a {\n" +
"                font-size: 16px !important\n" +
"            }\n" +
"\n" +
"            .es-header-body p,\n" +
"            .es-header-body ul li,\n" +
"            .es-header-body ol li,\n" +
"            .es-header-body a {\n" +
"                font-size: 16px !important\n" +
"            }\n" +
"\n" +
"            .es-footer-body p,\n" +
"            .es-footer-body ul li,\n" +
"            .es-footer-body ol li,\n" +
"            .es-footer-body a {\n" +
"                font-size: 16px !important\n" +
"            }\n" +
"\n" +
"            .es-infoblock p,\n" +
"            .es-infoblock ul li,\n" +
"            .es-infoblock ol li,\n" +
"            .es-infoblock a {\n" +
"                font-size: 12px !important\n" +
"            }\n" +
"\n" +
"            *[class=\"gmail-fix\"] {\n" +
"                display: none !important\n" +
"            }\n" +
"\n" +
"            .es-m-txt-c,\n" +
"            .es-m-txt-c h1,\n" +
"            .es-m-txt-c h2,\n" +
"            .es-m-txt-c h3 {\n" +
"                text-align: center !important\n" +
"            }\n" +
"\n" +
"            .es-m-txt-r,\n" +
"            .es-m-txt-r h1,\n" +
"            .es-m-txt-r h2,\n" +
"            .es-m-txt-r h3 {\n" +
"                text-align: right !important\n" +
"            }\n" +
"\n" +
"            .es-m-txt-l,\n" +
"            .es-m-txt-l h1,\n" +
"            .es-m-txt-l h2,\n" +
"            .es-m-txt-l h3 {\n" +
"                text-align: left !important\n" +
"            }\n" +
"\n" +
"            .es-m-txt-r img,\n" +
"            .es-m-txt-c img,\n" +
"            .es-m-txt-l img {\n" +
"                display: inline !important\n" +
"            }\n" +
"\n" +
"            .es-button-border {\n" +
"                display: block !important\n" +
"            }\n" +
"\n" +
"            a.es-button {\n" +
"                font-size: 20px !important;\n" +
"                display: block !important;\n" +
"                border-left-width: 0px !important;\n" +
"                border-right-width: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-btn-fw {\n" +
"                border-width: 10px 0px !important;\n" +
"                text-align: center !important\n" +
"            }\n" +
"\n" +
"            .es-adaptive table,\n" +
"            .es-btn-fw,\n" +
"            .es-btn-fw-brdr,\n" +
"            .es-left,\n" +
"            .es-right {\n" +
"                width: 100% !important\n" +
"            }\n" +
"\n" +
"            .es-content table,\n" +
"            .es-header table,\n" +
"            .es-footer table,\n" +
"            .es-content,\n" +
"            .es-footer,\n" +
"            .es-header {\n" +
"                width: 100% !important;\n" +
"                max-width: 600px !important\n" +
"            }\n" +
"\n" +
"            .es-adapt-td {\n" +
"                display: block !important;\n" +
"                width: 100% !important\n" +
"            }\n" +
"\n" +
"            .adapt-img {\n" +
"                width: 100% !important;\n" +
"                height: auto !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0 {\n" +
"                padding: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0r {\n" +
"                padding-right: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0l {\n" +
"                padding-left: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0t {\n" +
"                padding-top: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0b {\n" +
"                padding-bottom: 0 !important\n" +
"            }\n" +
"\n" +
"            .es-m-p20b {\n" +
"                padding-bottom: 20px !important\n" +
"            }\n" +
"\n" +
"            .es-mobile-hidden,\n" +
"            .es-hidden {\n" +
"                display: none !important\n" +
"            }\n" +
"\n" +
"            tr.es-desk-hidden,\n" +
"            td.es-desk-hidden,\n" +
"            table.es-desk-hidden {\n" +
"                width: auto !important;\n" +
"                overflow: visible !important;\n" +
"                float: none !important;\n" +
"                max-height: inherit !important;\n" +
"                line-height: inherit !important\n" +
"            }\n" +
"\n" +
"            tr.es-desk-hidden {\n" +
"                display: table-row !important\n" +
"            }\n" +
"\n" +
"            table.es-desk-hidden {\n" +
"                display: table !important\n" +
"            }\n" +
"\n" +
"            td.es-desk-menu-hidden {\n" +
"                display: table-cell !important\n" +
"            }\n" +
"\n" +
"            .es-menu td {\n" +
"                width: 1% !important\n" +
"            }\n" +
"\n" +
"            table.es-table-not-adapt,\n" +
"            .esd-block-html table {\n" +
"                width: auto !important\n" +
"            }\n" +
"\n" +
"            table.es-social {\n" +
"                display: inline-block !important\n" +
"            }\n" +
"\n" +
"            table.es-social td {\n" +
"                display: inline-block !important\n" +
"            }\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"\n" +
"<body\n" +
"        style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
"<div class=\"es-wrapper-color\" style=\"background-color:#FFFFFF\">\n" +
"    <!--[if gte mso 9]>\n" +
"    \\\\t\\\\t\\\\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
"        \\\\t\\\\t\\\\t\\\\t<v:fill type=\"tile\" src=\"https://ocizza.stripocdn.email/content/guids/CABINET_2c0e8a79e108f0a801edcf77ec0e3922/images/5381603381368239.png\" color=\"#fff\" origin=\"0.5, 0\" position=\"0.5,0\"></v:fill>\n" +
"        \\\\t\\\\t\\\\t</v:background>\n" +
"    \\\\t\\\\t<![endif]-->\n" +
"    <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"           background=\"https://ocizza.stripocdn.email/content/guids/CABINET_2c0e8a79e108f0a801edcf77ec0e3922/images/5381603381368239.png\"\n" +
"           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-image:url(https://ocizza.stripocdn.email/content/guids/CABINET_2c0e8a79e108f0a801edcf77ec0e3922/images/5381603381368239.png);background-repeat:no-repeat;background-position:center top\">\n" +
"        <tr style=\"border-collapse:collapse\">\n" +
"            <td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
"                <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-content-body\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"\n" +
"                                   cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\"\n" +
"                                        style=\"Margin:0;padding-top:15px;padding-bottom:15px;padding-left:20px;padding-right:20px\">\n" +
"                                        <!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
"                                        <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td class=\"es-infoblock\" align=\"left\"\n" +
"                                                                style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\">\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:14px;color:#FFFFFF\">\n" +
"                                                                    Nouveau poste en ligne </p>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                        <!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
"                                        <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"right\" class=\"es-infoblock\"\n" +
"                                                                style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\">\n" +
"                                                                <a href=\"https://giftstory-blog.com\" style=\"text-decoration:none;\" target=\"_blank\">\n" +
"                                                                    <p\n" +
"                                                                            style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:14px;color:#FFFFFF\">\n" +
"                                                                        giftstory-blog</p></a>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                        <!--[if mso]></td></tr></table><![endif]-->\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"                <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-content-body\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#9AAEA6;width:600px\"\n" +
"                                   cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#9aaea6\" align=\"center\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\" style=\"padding:0;Margin:0\">\n" +
"                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-radius:17px\"\n" +
"                                                           role=\"presentation\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td style=\"padding:0;Margin:0;position:relative\" align=\"center\"><img class=\"adapt-img\"\n" +
"                                                                                                                                 src=\"https://res.cloudinary.com/dpy824jnw/image/upload/v1603824281/emailAssets/Welcome_Email_apiara.png\"\n" +
"                                                                                                                                 alt=\"Happy Thanksgiving Day\" title=\"Happy Thanksgiving Day\" width=\"60%\"\n" +
"                                                                                                                                 style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\">\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"                <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\"\n" +
"                                        style=\"Margin:0;padding-bottom:10px;padding-top:30px;padding-left:40px;padding-right:40px\">\n" +
"                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:520px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                                                                <h3\n" +
"                                                                        style=\"Margin:0;line-height:26px;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:22px;font-style:normal;font-weight:normal;color:#DC0444\">\n" +
"                                                                   Bienvenue</h3>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\" style=\"padding:0;Margin:0;padding-top:15px\">\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:16px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#666666\">\n" +
"                                                                    "+adress+"</p>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\" style=\"padding:0;Margin:0;padding-top:15px;padding-bottom:15px\">\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:16px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#999999\">\n" +
"                                                                    <p style=\"line-height:150%\">Cliquer sur le bouton ci dessous pour verifier votre compte</p></p>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\"\n" +
"                                                                style=\"padding:0;Margin:0;padding-bottom:40px;padding-left:40px;padding-right:40px\">\n" +
"                                  <span class=\"es-button-border\"\n" +
"                                        style=\"border-style:solid;border-color:#9AAEA6;background:#DC0444;border-width:0px;display:inline-block;border-radius:5px;width:auto\"><a\n" +
"                                          href=\"\" class=\"es-button\" target=\"_blank\"\n" +
"                                          style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:18px;color:#FFFFFF;border-style:solid;border-color:#DC0444;border-width:15px;display:inline-block;background:#DC0444;border-radius:5px;font-weight:normal;font-style:normal;line-height:22px;width:auto;text-align:center\">\n" +
"                                      Vérifier mon compte </a></span></td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                    Si le bouton ne marche pas utiliser le lien ci-joint\n" +
"                                                    <br>\n" +
"                                                    <a style=\"line-height:250%\" href=\"http://localhost/healine/verifyUser?hash="+ hash +"\">http://localhost/healine/verifyUser?hash="+ hash +"</a>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"                <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-footer-body\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#DC0444;width:600px\"\n" +
"                                   cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#dc0444\" align=\"center\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\" style=\"padding:20px;Margin:0\">\n" +
"                                        <table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td align=\"left\" style=\"padding:0;Margin:0;width:560px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td class=\"es-m-txt-с\" align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px\"><h3 style=\"Margin:0;line-height:24px;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:20px;font-style:normal;font-weight:normal;color:#FFFFFF\">Suivez-nous</h3></td>\n" +
"                                                        </tr>\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\" style=\"padding:0;Margin:0;font-size:0\">\n" +
"                                                                <table class=\"es-table-not-adapt es-social\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                                    <tr style=\"border-collapse:collapse\">\n" +
"                                                                        <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a href=\"https://www.facebook.com\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666\"><img title=\"Facebook\" src=\"https://stripo.email/cabinet/assets/editor/assets/img/social-icons/circle-white/facebook-circle-white.png\" alt=\"Fb\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
"                                                                        <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a href=\"https://www.insta.com\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666\"><img title=\"Instagram\" src=\"https://ocizza.stripocdn.email/content/assets/img/social-icons/circle-white/instagram-circle-white.png\" alt=\"Ig\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
"                                                                        <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a href=\"https://www.gmail.com\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666\"><img title=\"Gmail\" src=\"https://ocizza.stripocdn.email/content/assets/img/other-icons/circle-white/gmail-circle-white.png\" alt=\"gm\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
"                                                                        <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0\"><a href=\"tel:126459789\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666\"><img title=\"Phone\" src=\"https://ocizza.stripocdn.email/content/assets/img/other-icons/circle-white/phone-circle-white.png\" alt=\"Phone\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
"                                                                    </tr>\n" +
"                                                                </table></td>\n" +
"                                                        </tr>\n" +
"                                                    </table></td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td style=\"padding:0;Margin:0;background-color:#FFFFFF\" bgcolor=\"#ffffff\" align=\"left\">\n" +
"                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td esdev-links-color=\"#666666\" align=\"center\" class=\"es-m-txt-с\"\n" +
"                                                                style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:20px\">\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#666666\">\n" +
"                                                                    Copyright © 2020&nbsp;giftstory, All rights reserved.</p>\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#666666\">\n" +
"                                                                    You are receiving this email because you have visited our site or asked us about\n" +
"                                                                    regular newsletter.</p>\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#666666\">\n" +
"                                                                    <a target=\"_blank\"\n" +
"                                                                       style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666;line-height:18px\"\n" +
"                                                                       class=\"unsubscribe\" href=\"\">Unsubscribe</a></p>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"                <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-content-body\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"\n" +
"                                   cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\"\n" +
"                                        style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px\">\n" +
"                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td class=\"es-infoblock made_with\" align=\"center\"\n" +
"                                                                style=\"padding:0;Margin:0;line-height:0px;font-size:0px;color:#CCCCCC\"><a\n" +
"                                                                    target=\"_blank\"\n" +
"                                                                    href=\"https://viewstripo.email/?utm_source=templates&utm_medium=email&utm_campaign=software&utm_content=thanksgiving\"\n" +
"                                                                    style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#CCCCCC\"><img\n" +
"                                                                    src=\"\"\n" +
"                                                                    alt width=\"125\"\n" +
"                                                                    style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"            </td>\n" +
"        </tr>\n" +
"    </table>\n" +
"</div>\n" +
"</body>\n" +
"\n" +
"</html>", "text/html");
        //messageBodyPart.setText(message);

        Multipart multipart = new MimeMultipart();
//
        multipart.addBodyPart(messageBodyPart);
//
//        messageBodyPart = new MimeBodyPart();
//        String filename = message;
//        DataSource source = new FileDataSource(filename);
//        messageBodyPart.setDataHandler(new DataHandler(source));
//        messageBodyPart.setFileName(filename);
//        multipart.addBodyPart(messageBodyPart);
//
//        // Send the complete message parts
        msg.setContent(multipart);

        Transport t = session.getTransport("smtp");
        t.connect(host, from, password);
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("mail envoyé avec succes");
        t.close();

    }
    
    public void sendEmailForgetPassword(String adress, String subject, int number) throws MessagingException {
        String from = "sarbon1707@gmail.com";
        String password = "17071998Am";
        String[] to = {adress};
        String host = "smtp.gmail.com";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.user", from);
        prop.put("mail.smtp.password", password);

        Session session = Session.getDefaultInstance(prop);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from));
        InternetAddress[] toadress = new InternetAddress[to.length];
        for (int i = 0; i < to.length; i++) {
            toadress[i] = new InternetAddress(to[i]);
        }
        for (int i = 0; i < toadress.length; i++) {
            msg.setRecipient(Message.RecipientType.TO, toadress[i]);
        }
        msg.setSubject(subject);
        

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"\n" +
"      style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
"\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
"    <meta name=\"x-apple-disable-message-reformatting\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta content=\"telephone=no\" name=\"format-detection\">\n" +
"    <title>Giftstory-blog</title>\n" +
"    <!--[if (mso 16)]>\n" +
"    <style type=\"text/css\">\n" +
"        a {text-decoration: none;}\n" +
"    </style>\n" +
"    <![endif]-->\n" +
"    <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]-->\n" +
"    <!--[if gte mso 9]>\n" +
"    <xml>\n" +
"        <o:OfficeDocumentSettings>\n" +
"            <o:AllowPNG></o:AllowPNG>\n" +
"            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
"        </o:OfficeDocumentSettings>\n" +
"    </xml>\n" +
"    <![endif]-->\n" +
"    <style type=\"text/css\">\n" +
"        #outlook a {\n" +
"            padding: 0;\n" +
"        }\n" +
"\n" +
"        .ExternalClass {\n" +
"            width: 100%;\n" +
"        }\n" +
"\n" +
"        .ExternalClass,\n" +
"        .ExternalClass p,\n" +
"        .ExternalClass span,\n" +
"        .ExternalClass font,\n" +
"        .ExternalClass td,\n" +
"        .ExternalClass div {\n" +
"            line-height: 100%;\n" +
"        }\n" +
"\n" +
"        .es-button {\n" +
"            mso-style-priority: 100 !important;\n" +
"            text-decoration: none !important;\n" +
"        }\n" +
"\n" +
"        a[x-apple-data-detectors] {\n" +
"            color: inherit !important;\n" +
"            text-decoration: none !important;\n" +
"            font-size: inherit !important;\n" +
"            font-family: inherit !important;\n" +
"            font-weight: inherit !important;\n" +
"            line-height: inherit !important;\n" +
"        }\n" +
"\n" +
"        .es-desk-hidden {\n" +
"            display: none;\n" +
"            float: left;\n" +
"            overflow: hidden;\n" +
"            width: 0;\n" +
"            max-height: 0;\n" +
"            line-height: 0;\n" +
"            mso-hide: all;\n" +
"        }\n" +
"\n" +
"        @media only screen and (max-width:600px) {\n" +
"\n" +
"            p,\n" +
"            ul li,\n" +
"            ol li,\n" +
"            a {\n" +
"                font-size: 16px !important;\n" +
"                line-height: 150% !important\n" +
"            }\n" +
"\n" +
"            h1 {\n" +
"                font-size: 30px !important;\n" +
"                text-align: center;\n" +
"                line-height: 120% !important\n" +
"            }\n" +
"\n" +
"            h2 {\n" +
"                font-size: 26px !important;\n" +
"                text-align: center;\n" +
"                line-height: 120% !important\n" +
"            }\n" +
"\n" +
"            h3 {\n" +
"                font-size: 20px !important;\n" +
"                text-align: center;\n" +
"                line-height: 120% !important\n" +
"            }\n" +
"\n" +
"            h1 a {\n" +
"                font-size: 30px !important\n" +
"            }\n" +
"\n" +
"            h2 a {\n" +
"                font-size: 26px !important\n" +
"            }\n" +
"\n" +
"            h3 a {\n" +
"                font-size: 20px !important\n" +
"            }\n" +
"\n" +
"            .es-menu td a {\n" +
"                font-size: 16px !important\n" +
"            }\n" +
"\n" +
"            .es-header-body p,\n" +
"            .es-header-body ul li,\n" +
"            .es-header-body ol li,\n" +
"            .es-header-body a {\n" +
"                font-size: 16px !important\n" +
"            }\n" +
"\n" +
"            .es-footer-body p,\n" +
"            .es-footer-body ul li,\n" +
"            .es-footer-body ol li,\n" +
"            .es-footer-body a {\n" +
"                font-size: 16px !important\n" +
"            }\n" +
"\n" +
"            .es-infoblock p,\n" +
"            .es-infoblock ul li,\n" +
"            .es-infoblock ol li,\n" +
"            .es-infoblock a {\n" +
"                font-size: 12px !important\n" +
"            }\n" +
"\n" +
"            *[class=\"gmail-fix\"] {\n" +
"                display: none !important\n" +
"            }\n" +
"\n" +
"            .es-m-txt-c,\n" +
"            .es-m-txt-c h1,\n" +
"            .es-m-txt-c h2,\n" +
"            .es-m-txt-c h3 {\n" +
"                text-align: center !important\n" +
"            }\n" +
"\n" +
"            .es-m-txt-r,\n" +
"            .es-m-txt-r h1,\n" +
"            .es-m-txt-r h2,\n" +
"            .es-m-txt-r h3 {\n" +
"                text-align: right !important\n" +
"            }\n" +
"\n" +
"            .es-m-txt-l,\n" +
"            .es-m-txt-l h1,\n" +
"            .es-m-txt-l h2,\n" +
"            .es-m-txt-l h3 {\n" +
"                text-align: left !important\n" +
"            }\n" +
"\n" +
"            .es-m-txt-r img,\n" +
"            .es-m-txt-c img,\n" +
"            .es-m-txt-l img {\n" +
"                display: inline !important\n" +
"            }\n" +
"\n" +
"            .es-button-border {\n" +
"                display: block !important\n" +
"            }\n" +
"\n" +
"            a.es-button {\n" +
"                font-size: 20px !important;\n" +
"                display: block !important;\n" +
"                border-left-width: 0px !important;\n" +
"                border-right-width: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-btn-fw {\n" +
"                border-width: 10px 0px !important;\n" +
"                text-align: center !important\n" +
"            }\n" +
"\n" +
"            .es-adaptive table,\n" +
"            .es-btn-fw,\n" +
"            .es-btn-fw-brdr,\n" +
"            .es-left,\n" +
"            .es-right {\n" +
"                width: 100% !important\n" +
"            }\n" +
"\n" +
"            .es-content table,\n" +
"            .es-header table,\n" +
"            .es-footer table,\n" +
"            .es-content,\n" +
"            .es-footer,\n" +
"            .es-header {\n" +
"                width: 100% !important;\n" +
"                max-width: 600px !important\n" +
"            }\n" +
"\n" +
"            .es-adapt-td {\n" +
"                display: block !important;\n" +
"                width: 100% !important\n" +
"            }\n" +
"\n" +
"            .adapt-img {\n" +
"                width: 100% !important;\n" +
"                height: auto !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0 {\n" +
"                padding: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0r {\n" +
"                padding-right: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0l {\n" +
"                padding-left: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0t {\n" +
"                padding-top: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0b {\n" +
"                padding-bottom: 0 !important\n" +
"            }\n" +
"\n" +
"            .es-m-p20b {\n" +
"                padding-bottom: 20px !important\n" +
"            }\n" +
"\n" +
"            .es-mobile-hidden,\n" +
"            .es-hidden {\n" +
"                display: none !important\n" +
"            }\n" +
"\n" +
"            tr.es-desk-hidden,\n" +
"            td.es-desk-hidden,\n" +
"            table.es-desk-hidden {\n" +
"                width: auto !important;\n" +
"                overflow: visible !important;\n" +
"                float: none !important;\n" +
"                max-height: inherit !important;\n" +
"                line-height: inherit !important\n" +
"            }\n" +
"\n" +
"            tr.es-desk-hidden {\n" +
"                display: table-row !important\n" +
"            }\n" +
"\n" +
"            table.es-desk-hidden {\n" +
"                display: table !important\n" +
"            }\n" +
"\n" +
"            td.es-desk-menu-hidden {\n" +
"                display: table-cell !important\n" +
"            }\n" +
"\n" +
"            .es-menu td {\n" +
"                width: 1% !important\n" +
"            }\n" +
"\n" +
"            table.es-table-not-adapt,\n" +
"            .esd-block-html table {\n" +
"                width: auto !important\n" +
"            }\n" +
"\n" +
"            table.es-social {\n" +
"                display: inline-block !important\n" +
"            }\n" +
"\n" +
"            table.es-social td {\n" +
"                display: inline-block !important\n" +
"            }\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"\n" +
"<body\n" +
"        style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
"<div class=\"es-wrapper-color\" style=\"background-color:#FFFFFF\">\n" +
"    <!--[if gte mso 9]>\n" +
"    \\\\t\\\\t\\\\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
"        \\\\t\\\\t\\\\t\\\\t<v:fill type=\"tile\" src=\"https://ocizza.stripocdn.email/content/guids/CABINET_2c0e8a79e108f0a801edcf77ec0e3922/images/5381603381368239.png\" color=\"#fff\" origin=\"0.5, 0\" position=\"0.5,0\"></v:fill>\n" +
"        \\\\t\\\\t\\\\t</v:background>\n" +
"    \\\\t\\\\t<![endif]-->\n" +
"    <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"           background=\"https://ocizza.stripocdn.email/content/guids/CABINET_2c0e8a79e108f0a801edcf77ec0e3922/images/5381603381368239.png\"\n" +
"           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-image:url(https://ocizza.stripocdn.email/content/guids/CABINET_2c0e8a79e108f0a801edcf77ec0e3922/images/5381603381368239.png);background-repeat:no-repeat;background-position:center top\">\n" +
"        <tr style=\"border-collapse:collapse\">\n" +
"            <td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
"                <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-content-body\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"\n" +
"                                   cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\"\n" +
"                                        style=\"Margin:0;padding-top:15px;padding-bottom:15px;padding-left:20px;padding-right:20px\">\n" +
"                                        <!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
"                                        <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td class=\"es-infoblock\" align=\"left\"\n" +
"                                                                style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\">\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:14px;color:#FFFFFF\">\n" +
"                                                                    Nouveau poste en ligne </p>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                        <!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
"                                        <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"right\" class=\"es-infoblock\"\n" +
"                                                                style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\">\n" +
"                                                                <a href=\"https://giftstory-blog.com\" style=\"text-decoration:none;\" target=\"_blank\">\n" +
"                                                                    <p\n" +
"                                                                            style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:14px;color:#FFFFFF\">\n" +
"                                                                        giftstory-blog</p></a>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                        <!--[if mso]></td></tr></table><![endif]-->\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"                <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-content-body\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#9AAEA6;width:600px\"\n" +
"                                   cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#9aaea6\" align=\"center\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\" style=\"padding:0;Margin:0\">\n" +
"                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-radius:17px\"\n" +
"                                                           role=\"presentation\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td style=\"padding:0;Margin:0;position:relative\" align=\"center\"><img class=\"adapt-img\"\n" +
"                                                                                                                                 src=\"https://res.cloudinary.com/dpy824jnw/image/upload/v1603824281/emailAssets/Welcome_Email_apiara.png\"\n" +
"                                                                                                                                 alt=\"Happy Thanksgiving Day\" title=\"Happy Thanksgiving Day\" width=\"60%\"\n" +
"                                                                                                                                 style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\">\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"                <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\"\n" +
"                                        style=\"Margin:0;padding-bottom:10px;padding-top:30px;padding-left:40px;padding-right:40px\">\n" +
"                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:520px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                                                                <h3\n" +
"                                                                        style=\"Margin:0;line-height:26px;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:22px;font-style:normal;font-weight:normal;color:#DC0444\">\n" +
"                                                                   Bienvenue</h3>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\" style=\"padding:0;Margin:0;padding-top:15px\">\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:16px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#666666\">\n" +
"                                                                    "+adress+"</p>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\" style=\"padding:0;Margin:0;padding-top:15px;padding-bottom:15px\">\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:16px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#999999\">\n" +
"                                                                    <p style=\"line-height:150%\">Cliquer sur le bouton ci dessous pour verifier votre compte</p></p>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\"\n" +
"                                                                style=\"padding:0;Margin:0;padding-bottom:40px;padding-left:40px;padding-right:40px\">\n" +
"                                  <span class=\"es-button-border\"\n" +
"                                        style=\"border-style:solid;border-color:#9AAEA6;background:#DC0444;border-width:0px;display:inline-block;border-radius:5px;width:auto\"><a\n" +
"                                          href=\"\" class=\"es-button\" target=\"_blank\"\n" +
"                                          style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:18px;color:#FFFFFF;border-style:solid;border-color:#DC0444;border-width:15px;display:inline-block;background:#DC0444;border-radius:5px;font-weight:normal;font-style:normal;line-height:22px;width:auto;text-align:center\">\n" +
"                                      Vérifier mon compte </a></span></td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                    Si le bouton ne marche pas utiliser le lien ci-joint\n" +
"                                                    <br>\n" +
"                                                    <a style=\"line-height:250%\" href=\"http://localhost/healine/verifyUser?hash="+ number +"\">"+ number +"</a>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"                <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-footer-body\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#DC0444;width:600px\"\n" +
"                                   cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#dc0444\" align=\"center\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\" style=\"padding:20px;Margin:0\">\n" +
"                                        <table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td align=\"left\" style=\"padding:0;Margin:0;width:560px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td class=\"es-m-txt-с\" align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px\"><h3 style=\"Margin:0;line-height:24px;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:20px;font-style:normal;font-weight:normal;color:#FFFFFF\">Suivez-nous</h3></td>\n" +
"                                                        </tr>\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\" style=\"padding:0;Margin:0;font-size:0\">\n" +
"                                                                <table class=\"es-table-not-adapt es-social\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                                    <tr style=\"border-collapse:collapse\">\n" +
"                                                                        <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a href=\"https://www.facebook.com\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666\"><img title=\"Facebook\" src=\"https://stripo.email/cabinet/assets/editor/assets/img/social-icons/circle-white/facebook-circle-white.png\" alt=\"Fb\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
"                                                                        <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a href=\"https://www.insta.com\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666\"><img title=\"Instagram\" src=\"https://ocizza.stripocdn.email/content/assets/img/social-icons/circle-white/instagram-circle-white.png\" alt=\"Ig\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
"                                                                        <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a href=\"https://www.gmail.com\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666\"><img title=\"Gmail\" src=\"https://ocizza.stripocdn.email/content/assets/img/other-icons/circle-white/gmail-circle-white.png\" alt=\"gm\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
"                                                                        <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0\"><a href=\"tel:126459789\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666\"><img title=\"Phone\" src=\"https://ocizza.stripocdn.email/content/assets/img/other-icons/circle-white/phone-circle-white.png\" alt=\"Phone\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
"                                                                    </tr>\n" +
"                                                                </table></td>\n" +
"                                                        </tr>\n" +
"                                                    </table></td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td style=\"padding:0;Margin:0;background-color:#FFFFFF\" bgcolor=\"#ffffff\" align=\"left\">\n" +
"                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td esdev-links-color=\"#666666\" align=\"center\" class=\"es-m-txt-с\"\n" +
"                                                                style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:20px\">\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#666666\">\n" +
"                                                                    Copyright © 2020&nbsp;giftstory, All rights reserved.</p>\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#666666\">\n" +
"                                                                    You are receiving this email because you have visited our site or asked us about\n" +
"                                                                    regular newsletter.</p>\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#666666\">\n" +
"                                                                    <a target=\"_blank\"\n" +
"                                                                       style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666;line-height:18px\"\n" +
"                                                                       class=\"unsubscribe\" href=\"\">Unsubscribe</a></p>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"                <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-content-body\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"\n" +
"                                   cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\"\n" +
"                                        style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px\">\n" +
"                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td class=\"es-infoblock made_with\" align=\"center\"\n" +
"                                                                style=\"padding:0;Margin:0;line-height:0px;font-size:0px;color:#CCCCCC\"><a\n" +
"                                                                    target=\"_blank\"\n" +
"                                                                    href=\"https://viewstripo.email/?utm_source=templates&utm_medium=email&utm_campaign=software&utm_content=thanksgiving\"\n" +
"                                                                    style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#CCCCCC\"><img\n" +
"                                                                    src=\"\"\n" +
"                                                                    alt width=\"125\"\n" +
"                                                                    style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"            </td>\n" +
"        </tr>\n" +
"    </table>\n" +
"</div>\n" +
"</body>\n" +
"\n" +
"</html>", "text/html");
        //messageBodyPart.setText(message);

        Multipart multipart = new MimeMultipart();
//
        multipart.addBodyPart(messageBodyPart);
//
//        messageBodyPart = new MimeBodyPart();
//        String filename = message;
//        DataSource source = new FileDataSource(filename);
//        messageBodyPart.setDataHandler(new DataHandler(source));
//        messageBodyPart.setFileName(filename);
//        multipart.addBodyPart(messageBodyPart);
//
//        // Send the complete message parts
        msg.setContent(multipart);

        Transport t = session.getTransport("smtp");
        t.connect(host, from, password);
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("mail envoyé avec succes");
        t.close();

    }
    
    public void sendEmailRebrique(String adress, String subject, String message) throws MessagingException {
        String from = "sarbon1707@gmail.com";
        String password = "17071998Am";
        String[] to = {adress};
        String host = "smtp.gmail.com";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.user", from);
        prop.put("mail.smtp.password", password);

        Session session = Session.getDefaultInstance(prop);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from));
        InternetAddress[] toadress = new InternetAddress[to.length];
        for (int i = 0; i < to.length; i++) {
            toadress[i] = new InternetAddress(to[i]);
        }
        for (int i = 0; i < toadress.length; i++) {
            msg.setRecipient(Message.RecipientType.TO, toadress[i]);
        }
        msg.setSubject(subject);
        

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"\n" +
"      style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
"\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
"    <meta name=\"x-apple-disable-message-reformatting\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta content=\"telephone=no\" name=\"format-detection\">\n" +
"    <title>Giftstory-blog</title>\n" +
"    <!--[if (mso 16)]>\n" +
"    <style type=\"text/css\">\n" +
"        a {text-decoration: none;}\n" +
"    </style>\n" +
"    <![endif]-->\n" +
"    <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]-->\n" +
"    <!--[if gte mso 9]>\n" +
"    <xml>\n" +
"        <o:OfficeDocumentSettings>\n" +
"            <o:AllowPNG></o:AllowPNG>\n" +
"            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
"        </o:OfficeDocumentSettings>\n" +
"    </xml>\n" +
"    <![endif]-->\n" +
"    <style type=\"text/css\">\n" +
"        #outlook a {\n" +
"            padding: 0;\n" +
"        }\n" +
"\n" +
"        .ExternalClass {\n" +
"            width: 100%;\n" +
"        }\n" +
"\n" +
"        .ExternalClass,\n" +
"        .ExternalClass p,\n" +
"        .ExternalClass span,\n" +
"        .ExternalClass font,\n" +
"        .ExternalClass td,\n" +
"        .ExternalClass div {\n" +
"            line-height: 100%;\n" +
"        }\n" +
"\n" +
"        .es-button {\n" +
"            mso-style-priority: 100 !important;\n" +
"            text-decoration: none !important;\n" +
"        }\n" +
"\n" +
"        a[x-apple-data-detectors] {\n" +
"            color: inherit !important;\n" +
"            text-decoration: none !important;\n" +
"            font-size: inherit !important;\n" +
"            font-family: inherit !important;\n" +
"            font-weight: inherit !important;\n" +
"            line-height: inherit !important;\n" +
"        }\n" +
"\n" +
"        .es-desk-hidden {\n" +
"            display: none;\n" +
"            float: left;\n" +
"            overflow: hidden;\n" +
"            width: 0;\n" +
"            max-height: 0;\n" +
"            line-height: 0;\n" +
"            mso-hide: all;\n" +
"        }\n" +
"\n" +
"        @media only screen and (max-width:600px) {\n" +
"\n" +
"            p,\n" +
"            ul li,\n" +
"            ol li,\n" +
"            a {\n" +
"                font-size: 16px !important;\n" +
"                line-height: 150% !important\n" +
"            }\n" +
"\n" +
"            h1 {\n" +
"                font-size: 30px !important;\n" +
"                text-align: center;\n" +
"                line-height: 120% !important\n" +
"            }\n" +
"\n" +
"            h2 {\n" +
"                font-size: 26px !important;\n" +
"                text-align: center;\n" +
"                line-height: 120% !important\n" +
"            }\n" +
"\n" +
"            h3 {\n" +
"                font-size: 20px !important;\n" +
"                text-align: center;\n" +
"                line-height: 120% !important\n" +
"            }\n" +
"\n" +
"            h1 a {\n" +
"                font-size: 30px !important\n" +
"            }\n" +
"\n" +
"            h2 a {\n" +
"                font-size: 26px !important\n" +
"            }\n" +
"\n" +
"            h3 a {\n" +
"                font-size: 20px !important\n" +
"            }\n" +
"\n" +
"            .es-menu td a {\n" +
"                font-size: 16px !important\n" +
"            }\n" +
"\n" +
"            .es-header-body p,\n" +
"            .es-header-body ul li,\n" +
"            .es-header-body ol li,\n" +
"            .es-header-body a {\n" +
"                font-size: 16px !important\n" +
"            }\n" +
"\n" +
"            .es-footer-body p,\n" +
"            .es-footer-body ul li,\n" +
"            .es-footer-body ol li,\n" +
"            .es-footer-body a {\n" +
"                font-size: 16px !important\n" +
"            }\n" +
"\n" +
"            .es-infoblock p,\n" +
"            .es-infoblock ul li,\n" +
"            .es-infoblock ol li,\n" +
"            .es-infoblock a {\n" +
"                font-size: 12px !important\n" +
"            }\n" +
"\n" +
"            *[class=\"gmail-fix\"] {\n" +
"                display: none !important\n" +
"            }\n" +
"\n" +
"            .es-m-txt-c,\n" +
"            .es-m-txt-c h1,\n" +
"            .es-m-txt-c h2,\n" +
"            .es-m-txt-c h3 {\n" +
"                text-align: center !important\n" +
"            }\n" +
"\n" +
"            .es-m-txt-r,\n" +
"            .es-m-txt-r h1,\n" +
"            .es-m-txt-r h2,\n" +
"            .es-m-txt-r h3 {\n" +
"                text-align: right !important\n" +
"            }\n" +
"\n" +
"            .es-m-txt-l,\n" +
"            .es-m-txt-l h1,\n" +
"            .es-m-txt-l h2,\n" +
"            .es-m-txt-l h3 {\n" +
"                text-align: left !important\n" +
"            }\n" +
"\n" +
"            .es-m-txt-r img,\n" +
"            .es-m-txt-c img,\n" +
"            .es-m-txt-l img {\n" +
"                display: inline !important\n" +
"            }\n" +
"\n" +
"            .es-button-border {\n" +
"                display: block !important\n" +
"            }\n" +
"\n" +
"            a.es-button {\n" +
"                font-size: 20px !important;\n" +
"                display: block !important;\n" +
"                border-left-width: 0px !important;\n" +
"                border-right-width: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-btn-fw {\n" +
"                border-width: 10px 0px !important;\n" +
"                text-align: center !important\n" +
"            }\n" +
"\n" +
"            .es-adaptive table,\n" +
"            .es-btn-fw,\n" +
"            .es-btn-fw-brdr,\n" +
"            .es-left,\n" +
"            .es-right {\n" +
"                width: 100% !important\n" +
"            }\n" +
"\n" +
"            .es-content table,\n" +
"            .es-header table,\n" +
"            .es-footer table,\n" +
"            .es-content,\n" +
"            .es-footer,\n" +
"            .es-header {\n" +
"                width: 100% !important;\n" +
"                max-width: 600px !important\n" +
"            }\n" +
"\n" +
"            .es-adapt-td {\n" +
"                display: block !important;\n" +
"                width: 100% !important\n" +
"            }\n" +
"\n" +
"            .adapt-img {\n" +
"                width: 100% !important;\n" +
"                height: auto !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0 {\n" +
"                padding: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0r {\n" +
"                padding-right: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0l {\n" +
"                padding-left: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0t {\n" +
"                padding-top: 0px !important\n" +
"            }\n" +
"\n" +
"            .es-m-p0b {\n" +
"                padding-bottom: 0 !important\n" +
"            }\n" +
"\n" +
"            .es-m-p20b {\n" +
"                padding-bottom: 20px !important\n" +
"            }\n" +
"\n" +
"            .es-mobile-hidden,\n" +
"            .es-hidden {\n" +
"                display: none !important\n" +
"            }\n" +
"\n" +
"            tr.es-desk-hidden,\n" +
"            td.es-desk-hidden,\n" +
"            table.es-desk-hidden {\n" +
"                width: auto !important;\n" +
"                overflow: visible !important;\n" +
"                float: none !important;\n" +
"                max-height: inherit !important;\n" +
"                line-height: inherit !important\n" +
"            }\n" +
"\n" +
"            tr.es-desk-hidden {\n" +
"                display: table-row !important\n" +
"            }\n" +
"\n" +
"            table.es-desk-hidden {\n" +
"                display: table !important\n" +
"            }\n" +
"\n" +
"            td.es-desk-menu-hidden {\n" +
"                display: table-cell !important\n" +
"            }\n" +
"\n" +
"            .es-menu td {\n" +
"                width: 1% !important\n" +
"            }\n" +
"\n" +
"            table.es-table-not-adapt,\n" +
"            .esd-block-html table {\n" +
"                width: auto !important\n" +
"            }\n" +
"\n" +
"            table.es-social {\n" +
"                display: inline-block !important\n" +
"            }\n" +
"\n" +
"            table.es-social td {\n" +
"                display: inline-block !important\n" +
"            }\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"\n" +
"<body\n" +
"        style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
"<div class=\"es-wrapper-color\" style=\"background-color:#FFFFFF\">\n" +
"    <!--[if gte mso 9]>\n" +
"    \\\\t\\\\t\\\\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
"        \\\\t\\\\t\\\\t\\\\t<v:fill type=\"tile\" src=\"https://ocizza.stripocdn.email/content/guids/CABINET_2c0e8a79e108f0a801edcf77ec0e3922/images/5381603381368239.png\" color=\"#fff\" origin=\"0.5, 0\" position=\"0.5,0\"></v:fill>\n" +
"        \\\\t\\\\t\\\\t</v:background>\n" +
"    \\\\t\\\\t<![endif]-->\n" +
"    <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"           background=\"https://ocizza.stripocdn.email/content/guids/CABINET_2c0e8a79e108f0a801edcf77ec0e3922/images/5381603381368239.png\"\n" +
"           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-image:url(https://ocizza.stripocdn.email/content/guids/CABINET_2c0e8a79e108f0a801edcf77ec0e3922/images/5381603381368239.png);background-repeat:no-repeat;background-position:center top\">\n" +
"        <tr style=\"border-collapse:collapse\">\n" +
"            <td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
"                <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-content-body\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"\n" +
"                                   cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\"\n" +
"                                        style=\"Margin:0;padding-top:15px;padding-bottom:15px;padding-left:20px;padding-right:20px\">\n" +
"                                        <!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
"                                        <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td class=\"es-infoblock\" align=\"left\"\n" +
"                                                                style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\">\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:14px;color:#FFFFFF\">\n" +
"                                                                    Nouveau poste en ligne </p>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                        <!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
"                                        <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"right\" class=\"es-infoblock\"\n" +
"                                                                style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\">\n" +
"                                                                <a href=\"https://giftstory-blog.com\" style=\"text-decoration:none;\" target=\"_blank\">\n" +
"                                                                    <p\n" +
"                                                                            style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:14px;color:#FFFFFF\">\n" +
"                                                                        giftstory-blog</p></a>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                        <!--[if mso]></td></tr></table><![endif]-->\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"                <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-content-body\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#9AAEA6;width:600px\"\n" +
"                                   cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#9aaea6\" align=\"center\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\" style=\"padding:0;Margin:0\">\n" +
"                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-radius:17px\"\n" +
"                                                           role=\"presentation\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td style=\"padding:0;Margin:0;position:relative\" align=\"center\"><img class=\"adapt-img\"\n" +
"                                                                                                                                 src=\"https://res.cloudinary.com/dpy824jnw/image/upload/v1603824281/emailAssets/Welcome_Email_apiara.png\"\n" +
"                                                                                                                                 alt=\"Happy Thanksgiving Day\" title=\"Happy Thanksgiving Day\" width=\"60%\"\n" +
"                                                                                                                                 style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\">\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"                <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\"\n" +
"                                        style=\"Margin:0;padding-bottom:10px;padding-top:30px;padding-left:40px;padding-right:40px\">\n" +
"                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:520px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                                                                <h3\n" +
"                                                                        style=\"Margin:0;line-height:26px;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:22px;font-style:normal;font-weight:normal;color:#DC0444\">\n" +
"                                                                   Bienvenue</h3>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\" style=\"padding:0;Margin:0;padding-top:15px\">\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:16px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#666666\">\n" +
"                                                                    "+adress+"</p>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\" style=\"padding:0;Margin:0;padding-top:15px;padding-bottom:15px\">\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:16px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#999999\">\n" +
"                                                                    <p style=\"line-height:150%\">Cliquer sur le bouton ci dessous pour verifier votre compte</p></p>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\"\n" +
"                                                                style=\"padding:0;Margin:0;padding-bottom:40px;padding-left:40px;padding-right:40px\">\n" +
"                                  <span class=\"es-button-border\"\n" +
"                                        style=\"border-style:solid;border-color:#9AAEA6;background:#DC0444;border-width:0px;display:inline-block;border-radius:5px;width:auto\"><a\n" +
"                                          href=\"\" class=\"es-button\" target=\"_blank\"\n" +
"                                          style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:18px;color:#FFFFFF;border-style:solid;border-color:#DC0444;border-width:15px;display:inline-block;background:#DC0444;border-radius:5px;font-weight:normal;font-style:normal;line-height:22px;width:auto;text-align:center\">\n" +
"                                      Vérifier mon compte </a></span></td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                    Si le bouton ne marche pas utiliser le lien ci-joint\n" +
"                                                    <br>\n" +
"                                                    <a style=\"line-height:250%\" href=\"http://localhost/healine/verifyUser?hash="+ message +"\">"+ message +"</a>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"                <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-footer-body\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#DC0444;width:600px\"\n" +
"                                   cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#dc0444\" align=\"center\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\" style=\"padding:20px;Margin:0\">\n" +
"                                        <table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td align=\"left\" style=\"padding:0;Margin:0;width:560px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td class=\"es-m-txt-с\" align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px\"><h3 style=\"Margin:0;line-height:24px;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:20px;font-style:normal;font-weight:normal;color:#FFFFFF\">Suivez-nous</h3></td>\n" +
"                                                        </tr>\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td align=\"center\" style=\"padding:0;Margin:0;font-size:0\">\n" +
"                                                                <table class=\"es-table-not-adapt es-social\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                                    <tr style=\"border-collapse:collapse\">\n" +
"                                                                        <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a href=\"https://www.facebook.com\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666\"><img title=\"Facebook\" src=\"https://stripo.email/cabinet/assets/editor/assets/img/social-icons/circle-white/facebook-circle-white.png\" alt=\"Fb\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
"                                                                        <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a href=\"https://www.insta.com\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666\"><img title=\"Instagram\" src=\"https://ocizza.stripocdn.email/content/assets/img/social-icons/circle-white/instagram-circle-white.png\" alt=\"Ig\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
"                                                                        <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;padding-right:10px\"><a href=\"https://www.gmail.com\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666\"><img title=\"Gmail\" src=\"https://ocizza.stripocdn.email/content/assets/img/other-icons/circle-white/gmail-circle-white.png\" alt=\"gm\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
"                                                                        <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0\"><a href=\"tel:126459789\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666\"><img title=\"Phone\" src=\"https://ocizza.stripocdn.email/content/assets/img/other-icons/circle-white/phone-circle-white.png\" alt=\"Phone\" width=\"32\" height=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
"                                                                    </tr>\n" +
"                                                                </table></td>\n" +
"                                                        </tr>\n" +
"                                                    </table></td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td style=\"padding:0;Margin:0;background-color:#FFFFFF\" bgcolor=\"#ffffff\" align=\"left\">\n" +
"                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td esdev-links-color=\"#666666\" align=\"center\" class=\"es-m-txt-с\"\n" +
"                                                                style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:20px\">\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#666666\">\n" +
"                                                                    Copyright © 2020&nbsp;giftstory, All rights reserved.</p>\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#666666\">\n" +
"                                                                    You are receiving this email because you have visited our site or asked us about\n" +
"                                                                    regular newsletter.</p>\n" +
"                                                                <p\n" +
"                                                                        style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#666666\">\n" +
"                                                                    <a target=\"_blank\"\n" +
"                                                                       style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#666666;line-height:18px\"\n" +
"                                                                       class=\"unsubscribe\" href=\"\">Unsubscribe</a></p>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"                <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"\n" +
"                       style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
"                    <tr style=\"border-collapse:collapse\">\n" +
"                        <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
"                            <table class=\"es-content-body\"\n" +
"                                   style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"\n" +
"                                   cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
"                                <tr style=\"border-collapse:collapse\">\n" +
"                                    <td align=\"left\"\n" +
"                                        style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px\">\n" +
"                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"\n" +
"                                               style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                            <tr style=\"border-collapse:collapse\">\n" +
"                                                <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\n" +
"                                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"\n" +
"                                                           style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
"                                                        <tr style=\"border-collapse:collapse\">\n" +
"                                                            <td class=\"es-infoblock made_with\" align=\"center\"\n" +
"                                                                style=\"padding:0;Margin:0;line-height:0px;font-size:0px;color:#CCCCCC\"><a\n" +
"                                                                    target=\"_blank\"\n" +
"                                                                    href=\"https://viewstripo.email/?utm_source=templates&utm_medium=email&utm_campaign=software&utm_content=thanksgiving\"\n" +
"                                                                    style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#CCCCCC\"><img\n" +
"                                                                    src=\"\"\n" +
"                                                                    alt width=\"125\"\n" +
"                                                                    style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a>\n" +
"                                                            </td>\n" +
"                                                        </tr>\n" +
"                                                    </table>\n" +
"                                                </td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"            </td>\n" +
"        </tr>\n" +
"    </table>\n" +
"</div>\n" +
"</body>\n" +
"\n" +
"</html>", "text/html");
        //messageBodyPart.setText(message);

        Multipart multipart = new MimeMultipart();
//
        multipart.addBodyPart(messageBodyPart);
//
//        messageBodyPart = new MimeBodyPart();
//        String filename = message;
//        DataSource source = new FileDataSource(filename);
//        messageBodyPart.setDataHandler(new DataHandler(source));
//        messageBodyPart.setFileName(filename);
//        multipart.addBodyPart(messageBodyPart);
//
//        // Send the complete message parts
        msg.setContent(multipart);

        Transport t = session.getTransport("smtp");
        t.connect(host, from, password);
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("mail envoyé avec succes");
        t.close();

    }
}
