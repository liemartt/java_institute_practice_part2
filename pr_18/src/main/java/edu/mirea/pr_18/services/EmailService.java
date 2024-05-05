package edu.mirea.pr_18.services;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
