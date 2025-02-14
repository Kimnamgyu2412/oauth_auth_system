package com.oauth.system.oauthapisystem.domain.api.service;

import com.oauth.system.oauthapisystem.domain.api.Entity.Email;
import com.oauth.system.oauthapisystem.domain.api.Entity.EmailRepository;
import com.oauth.system.oauthapisystem.domain.api.dto.EmailResponseDTO;
import com.oauth.system.oauthapisystem.domain.api.dto.EmailSaveDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;
    @Transactional
    public void save(EmailSaveDTO emailSaveDTO){
        emailRepository.save(emailSaveDTO.toEntity());
    }
    public List<EmailResponseDTO> getEmailDataList() {
        return emailRepository.findAll().stream() // findAll()은 Iterable 반환, 이를 Stream으로 변환
                .map(EmailResponseDTO::new)  // 조회한 엔티티를 DTO로 변환
                .collect(Collectors.toList());  // 최종적으로 List로 변환
    }

    public EmailResponseDTO getEmailData(Long id){
        return emailRepository.findById(id)
                .map(EmailResponseDTO::new)  // 조회한 엔티티를 DTO로 변환
                .orElseThrow(() -> new EntityNotFoundException("Email not found with id: " + id));
    }
}
