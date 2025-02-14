package com.oauth.system.oauthapisystem.domain.api;

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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailApiController {

    private final EmailService emailService;
    @PostMapping("/save")
    public ResponseEntity<String> saveEmailData(@RequestBody EmailSaveDTO emailSaveDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof OAuth2Authentication) {
            OAuth2Authentication oauthAuth = (OAuth2Authentication) authentication;
            String clientId = oauthAuth.getOAuth2Request().getClientId(); // ✅ clientId 가져오기
            emailSaveDTO.setClientId(clientId);
        }
        emailService.save(emailSaveDTO);
        return ResponseEntity.ok("Data saved successfully");
    }

    @GetMapping
    public ResponseEntity<List<EmailResponseDTO>> getEmailDataList() {
        List<EmailResponseDTO> emailResponseDTOList = emailService.getEmailDataList();
        return ResponseEntity.ok(emailResponseDTOList);
    }

    @GetMapping("/{idx}")
    public ResponseEntity<EmailResponseDTO> getEmailData(@PathVariable Long idx) {
        EmailResponseDTO emailResponseDTO = emailService.getEmailData(idx);
        return ResponseEntity.ok(emailResponseDTO);
    }


}
