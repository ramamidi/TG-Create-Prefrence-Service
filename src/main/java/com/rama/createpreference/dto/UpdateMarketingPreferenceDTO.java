package com.rama.createpreference.dto;

import com.rama.createpreference.entity.MarketingPreference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMarketingPreferenceDTO extends PostMarketingPreferenceDTO {

    @Min(value = 1, message = "id value should be greater than 0")
    @NotNull
    private Integer id;

    @Override
    public MarketingPreference toMarketingPreference() {
        MarketingPreference marketingPreference = super.toMarketingPreference();
        marketingPreference.setId(this.getId());
        return marketingPreference;
    }
}
