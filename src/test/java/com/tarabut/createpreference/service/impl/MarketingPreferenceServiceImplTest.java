package com.tarabut.createpreference.service.impl;

import com.tarabut.createpreference.dto.GetMarketingPreferenceDTO;
import com.tarabut.createpreference.dto.PostMarketingPreferenceDTO;
import com.tarabut.createpreference.entity.MarketingPreference;
import com.tarabut.createpreference.repository.MarketingPreferenceRepository;
import com.tarabut.createpreference.service.MarketingPreferenceService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MarketingPreferenceServiceImplTest {

    private static MarketingPreferenceService marketingPreferenceService;
    private static MarketingPreferenceRepository marketingPreferenceRepository;

    @BeforeAll
    public static void setupOnce() {
        marketingPreferenceRepository = mock(MarketingPreferenceRepository.class);
        marketingPreferenceService = new MarketingPreferenceServiceImpl(marketingPreferenceRepository);
    }

    @Test
    public void shouldAbleToSaveMarketPreference() {
        // Arrange
        MarketingPreference marketingPreference = new MarketingPreference();
        marketingPreference.setCustomerId(1);
        marketingPreference.setEmail(true);
        marketingPreference.setPost(true);
        marketingPreference.setSms(true);

        PostMarketingPreferenceDTO postMarketingPreference = new PostMarketingPreferenceDTO();
        postMarketingPreference.setCustomerId(1);
        postMarketingPreference.setEmail(true);
        postMarketingPreference.setPost(true);
        postMarketingPreference.setSms(true);
        when(marketingPreferenceRepository.save(any(MarketingPreference.class))).thenReturn(marketingPreference);

        // Act
        GetMarketingPreferenceDTO serviceResponse = marketingPreferenceService.save(postMarketingPreference);

        // Assert

        assertThat(serviceResponse).isNotNull();
        assertThat(serviceResponse.getCustomerId()).isEqualTo(1);
        assertThat(serviceResponse.isEmail()).isEqualTo(true);
        assertThat(serviceResponse.isPost()).isEqualTo(true);
        assertThat(serviceResponse.isSms()).isEqualTo(true);
    }

    @Test
    public void shouldAbleToFindMarketPreferenceWithValidId() {
        // Arrange
        MarketingPreference marketingPreference = new MarketingPreference();
        marketingPreference.setCustomerId(1);
        marketingPreference.setEmail(true);
        marketingPreference.setPost(true);
        marketingPreference.setSms(true);
        when(marketingPreferenceRepository.findById(eq(1))).thenReturn(Optional.of(marketingPreference));

        // Act
        Optional<GetMarketingPreferenceDTO> optionalMarketingPreference = marketingPreferenceService.findOne(1);

        // Assert
        assertThat(optionalMarketingPreference.isPresent()).isTrue();
    }

    @Test
    public void shouldGetEmptyValueForInvalidId() {
        // Arrange
        when(marketingPreferenceRepository.findById(any())).thenReturn(Optional.empty());

        // Act
        Optional<GetMarketingPreferenceDTO> optionalMarketingPreference = marketingPreferenceService.findOne(1);

        // Assert
        assertThat(optionalMarketingPreference.isPresent()).isFalse();
    }

    @Test
    public void shouldAbleToDeleteMarketPreference() {
        // Arrange
        boolean hasExecutedWithoutAnyErrors = false;
        doNothing().when(marketingPreferenceRepository).delete(any());

        // Act
        try {
            marketingPreferenceService.delete(1);
            hasExecutedWithoutAnyErrors = true;
        } catch (Exception ex) {

        }

        // Assert
        assertThat(hasExecutedWithoutAnyErrors).isTrue();
    }


}