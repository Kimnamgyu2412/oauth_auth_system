package com.oauth.system.oauthapisystem.domain.api.dto;

import com.oauth.system.oauthapisystem.domain.api.Entity.Email;
import lombok.Getter;

@Getter
public class EmailResponseDTO {

    private String senderEmail;
    private String senderName;

    private Long personIdx;
    private String personEmail;
    private String personGubun;

    private String title;
    private String body;

    private Long campaignIdx;

    private boolean noRequest;
    private String noRequestReason;

    private String sentDate;
    private String sentResultCode;

    private String messageId;
    private String lastEventType;
    private String clientId;

    // Email 엔티티를 받아서 EmailResponseDTO로 변환하는 생성자
    public EmailResponseDTO(Email email) {
        this.senderEmail = email.getSenderEmail();
        this.senderName = email.getSenderName();

        this.personIdx = email.getPersonIdx();
        this.personEmail = email.getPersonEmail();
        this.personGubun = email.getPersonGubun();

        this.title = email.getTitle();
        this.body = email.getBody();

        this.campaignIdx = email.getCampaignIdx();

        this.noRequest = email.isNoRequest();
        this.noRequestReason = email.getNoRequestReason();

        this.sentDate = email.getSentDate();
        this.sentResultCode = email.getSentResultCode();

        this.messageId = email.getMessageId();
        this.lastEventType = email.getLastEventType();
        this.clientId = email.getClientId();
    }
}
