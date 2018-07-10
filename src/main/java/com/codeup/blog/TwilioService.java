package com.codeup.blog;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TwilioService {

    /**
     * The @Value annotation lets us access a value from the
     * application.properties file, this code will error out at runtime if the
     * specified value is not in the application.properties file
     *
     * Moving forward, I would probably move the "from" phone number obtained
     * from twilio into the application.properties file as well
     */
    @Value("${twilio.account-sid}")
    private String ACCOUNT_SID;
    @Value("${twilio.auth-token}")
    private String AUTH_TOKEN;

    private String

    @PostConstruct
    public void init() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public String sendTextToRyan(String content) {
        Message message = Message.creator(
            new PhoneNumber("+12108675309"), // not ryan's real phone number
            new PhoneNumber("+12253073695"), // "from" phone number obtained from twilio
            content
        ).create();

        return message.getSid();
    }

    public String sendTextToZach(String content) {
        Message message = Message.creator(
            new PhoneNumber("+12108675309"), // not zach's real phone number
            new PhoneNumber("+12253073695"), // "from" phone number obtained from twilio
            content
        ).create();

        return message.getSid();
    }

}
