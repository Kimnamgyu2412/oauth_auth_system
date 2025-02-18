package com.oauth.system.oauthapisystem.domain.api.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * 이메일 엔터티
 */
@Getter
@NoArgsConstructor
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String senderEmail;
    private String senderName;

    private Long personIdx;
    private String personEmail;
    private String personGubun;

    private String title;
    @Lob
    private String body;

    private Long campaignIdx;

    private boolean noRequest;
    private String noRequestReason;

    private String sentDate;
    private String sentResultCode;

    private String messageId;
    private String lastEventType;
    private String clientId;




    @Builder
    public Email(String senderEmail, String senderName
        , Long personIdx, String personGubun, String personEmail
        , String title, String body
        , Long campaignIdx,String clientId) {
        this.senderEmail = senderEmail;
        this.senderName = senderName;
        this.personIdx = personIdx;
        this.personGubun = personGubun;
        this.personEmail = personEmail;
        this.title = title;
        this.body = body;
        this.campaignIdx = campaignIdx;
        this.clientId = clientId;
    }


}
