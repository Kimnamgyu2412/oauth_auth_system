package com.oauth.system.oauthapisystem.domain.api.dto;

import com.oauth.system.oauthapisystem.domain.api.Entity.Email;
import lombok.Data;

import javax.persistence.Lob;

@Data
public class EmailSaveDTO {
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

    public Email toEntity() {
        return Email.builder()
                .senderEmail(this.senderEmail)
                .senderName(this.senderName)
                .personIdx(this.personIdx)
                .personGubun(this.personGubun)
                .personEmail(this.personEmail)
                .title(this.title)
                .body(this.body)
                .campaignIdx(this.campaignIdx)
                .clientId(this.clientId)
                .build();
    }
}

