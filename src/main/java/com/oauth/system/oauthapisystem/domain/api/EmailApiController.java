package com.oauth.system.oauthapisystem.domain.api;

import com.oauth.system.oauthapisystem.config.oauth.dto.ClientContext;
import com.oauth.system.oauthapisystem.domain.api.Entity.Email;
import com.oauth.system.oauthapisystem.domain.api.dto.EmailResponseDTO;
import com.oauth.system.oauthapisystem.domain.api.dto.EmailSaveDTO;
import com.oauth.system.oauthapisystem.domain.api.service.EmailService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailApiController {

    private final EmailService emailService;
    private final TokenStore tokenStore;

    @PostMapping
    public ResponseEntity<String> saveEmailData(@RequestBody EmailSaveDTO emailSaveDTO) {
        emailSaveDTO.setClientId(ClientContext.getClientId());
        emailService.save(emailSaveDTO);
        return ResponseEntity.ok("Data saved successfully");
    }

    @GetMapping
    public ResponseEntity<List<EmailResponseDTO>> getEmailDataList(@RequestHeader("Authorization") String authorizationHeader) {
        List<EmailResponseDTO> emailResponseDTOList = emailService.getEmailDataList(ClientContext.getClientId());
        return ResponseEntity.ok(emailResponseDTOList);
    }

    @GetMapping("/{idx}")
    public ResponseEntity<EmailResponseDTO> getEmailData(@PathVariable Long idx) {
        EmailResponseDTO emailResponseDTO = emailService.getEmailData(idx,ClientContext.getClientId());
        return ResponseEntity.ok(emailResponseDTO);
    }


}
