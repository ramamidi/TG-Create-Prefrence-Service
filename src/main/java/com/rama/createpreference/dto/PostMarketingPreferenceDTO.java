package com.rama.createpreference.dto;

import com.rama.createpreference.entity.MarketingPreference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PostMarketingPreferenceDTO {

    @Min(value = 1, message = "customerId value should be greater than 0")
    private Integer customerId;
    private boolean email;
    private boolean sms;
    private boolean post;

    public MarketingPreference toMarketingPreference() {
        return MarketingPreference.builder()
                .customerId(this.getCustomerId())
                .email(this.isEmail())
                .post(this.isPost())
                .sms(this.isSms()).build();
    }
}
