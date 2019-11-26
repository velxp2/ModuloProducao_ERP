package br.com.senac.erp.sendEmail;

import br.com.senac.erp.model.OrdemProducao;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailApp {

    public static void dispararEmail(OrdemProducao ordemproducao) {

        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("erp.mproducao@gmail.com", "Senac2019");
                    }
                });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("erp.mproducao@gmail.com"));
            //Remetente

            if (ordemproducao.getStatu().equals("Em produção")) {

                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse("erp.mproducao@gmail.com, teste@teste.com, adm.efmm@gmail.com, erp.materiais.tads@gmail.com, erp.tfinanceiro@gmail.com, logistica.erpp@gmail.com");
                String texto = ordemproducao.toString();
                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Ordem " + ordemproducao.getId() + " em Produção");//Assunto
                message.setText("A produçao da Ordem foi iniciada!!!\n"
                        + texto);

            }
            if (ordemproducao.getStatu().equals("Pendente")) {

                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse("erp.mproducao@gmail.com, teste@teste.com, adm.efmm@gmail.com, erp.materiais.tads@gmail.com, erp.tfinanceiro@gmail.com, logistica.erpp@gmail.com ");
                String texto = ordemproducao.toString();
                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Ordem " + ordemproducao.getId() + " Pendente");//Assunto
                message.setText("A produçao da Ordem esta pendente Aguardando lieração do time financeiro!!!\n"
                        + texto);
            }
            if (ordemproducao.getStatu().equals("Aguardando manutenção de ativo")) {

                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse("erp.mproducao@gmail.com, teste@teste.com, adm.efmm@gmail.com, erp.materiais.tads@gmail.com, erp.tfinanceiro@gmail.com, logistica.erpp@gmail.com ");
                String texto = ordemproducao.toString();
                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Ordem " + ordemproducao.getId() + " aguardando manutenção de ativo");//Assunto
                message.setText("A produçao da Ordem esta pendente, aguardando manutenção de ativo!!!\n"
                        + texto);

            }
            if (ordemproducao.getStatu().equals("Aguardando recurso")) {

                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse("erp.materiais.tads@gmail.com");

                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Ordem " + ordemproducao.getId() + " esta aguardando recursos");//Assunto
                message.setText("A produçao da Ordem esta pendente, aguardando o time materiais realizar a compra de Recurso!!!");

            }
            if (ordemproducao.getStatu().equals("Finalizado")) {

                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse("erp.mproducao@gmail.com, teste@teste.com, adm.efmm@gmail.com, erp.materiais.tads@gmail.com, erp.tfinanceiro@gmail.com, logistica.erpp@gmail.com ");
                String texto = ordemproducao.toString();
                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Ordem " + ordemproducao.getId() + " finalizada");//Assunto
                message.setText("A produçao foi finalizada!!!\n"
                        + texto);

            }
            if (ordemproducao.getStatu().equals("Cancelado")) {

                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse("erp.mproducao@gmail.com, teste@teste.com, adm.efmm@gmail.com, erp.materiais.tads@gmail.com, erp.tfinanceiro@gmail.com, logistica.erpp@gmail.com ");
                String texto = ordemproducao.toString();
                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Ordem " + ordemproducao.getId() + " Cancelada");//Assunto
                message.setText("A ordem de produção foi cancelada!!!\n"
                        + texto);

            }

            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
