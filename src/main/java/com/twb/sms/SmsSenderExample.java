//package com.twb.sms;
//
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//
//public class SmsSenderExample {
//
//    // Find your Account Sid and Auth Token at twilio.com/console
//    public static final String ACCOUNT_SID = "ACfcef49fec9a63ffe38cbfba737eac6c3";
//    public static final String AUTH_TOKEN = "d093d7e3e162e0da1e27cd964f828abe";
//
//    public static void main(String[] args) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//
//        Message message = Message
//                .creator(new PhoneNumber("+237698191491"), // to
////                        new PhoneNumber("+237698191491"), // from
//                        new PhoneNumber("+18317049712"), // from
//                        "Hi here")
//                .create();
//
//        System.out.println(message.getSid());
////        System.out.println(message.toString());
//    }
//}
