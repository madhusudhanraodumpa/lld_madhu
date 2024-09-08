package com.pattern.observer.withoutObserver;

public class SmsService {
    public void sendSMS(String to, String body) {
        System.out.println(
                "Sending SMS to " + to + " with body: " + body
        );
    }
}
