package com.csidigital.rh.shared.dto.response;
import com.csidigital.rh.shared.enumeration.LanguageLevel;
import lombok.Data;
@Data
public class LanguageResponse {

    private com.csidigital.rh.shared.enumeration.Language language;
    private LanguageLevel languageLevel;
    private String additionalInformation;
    private Long technicalFileId;
}