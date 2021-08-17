package com.tarabut.createpreference.entity;

import com.tarabut.createpreference.dto.GetMarketingPreferenceDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

/**
 * A MarketingPreference.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MarketingPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer customerId;
    private boolean email;
    private boolean sms;
    private boolean post;

    public Optional<GetMarketingPreferenceDTO> toGetMarketingPreferenceDTO() {
        Optional<GetMarketingPreferenceDTO> optionalGetMarketingPreferenceDTO = Optional.empty();
        if (!ObjectUtils.isEmpty(this)) {
            GetMarketingPreferenceDTO getMarketingPreferenceDTO = GetMarketingPreferenceDTO.builder()
                    .customerId(this.getCustomerId())
                    .id(this.getId())
                    .post(this.isPost())
                    .sms(this.isSms())
                    .email(this.isEmail()).build();
            optionalGetMarketingPreferenceDTO = Optional.of(getMarketingPreferenceDTO);
        }
        return optionalGetMarketingPreferenceDTO;
    }
}
