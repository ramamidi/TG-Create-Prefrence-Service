package com.rama.createpreference.service.impl;

import com.rama.createpreference.dto.GetMarketingPreferenceDTO;
import com.rama.createpreference.dto.PostMarketingPreferenceDTO;
import com.rama.createpreference.dto.UpdateMarketingPreferenceDTO;
import com.rama.createpreference.entity.MarketingPreference;
import com.rama.createpreference.repository.MarketingPreferenceRepository;
import com.rama.createpreference.service.MarketingPreferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link com.rama.createpreference.entity.MarketingPreference}.
 */
@Service
public class MarketingPreferenceServiceImpl implements MarketingPreferenceService {

    private final Logger log = LoggerFactory.getLogger(MarketingPreferenceServiceImpl.class);

    private final MarketingPreferenceRepository marketingPreferenceRepository;

    @Autowired
    public MarketingPreferenceServiceImpl(final MarketingPreferenceRepository marketingPreferenceRepository) {
        this.marketingPreferenceRepository = marketingPreferenceRepository;
    }

    /**
     * Save a MarketingPreference.
     *
     * @param marketingPreference the entity to save.
     * @return the persisted entity.
     */
    @Override
    public GetMarketingPreferenceDTO save(PostMarketingPreferenceDTO marketingPreference) {
        return marketingPreferenceRepository.save(marketingPreference.toMarketingPreference()).toGetMarketingPreferenceDTO().get();
    }

    /**
     * SavUpdatee a MarketingPreference.
     *
     * @param marketingPreference the entity to update.
     * @return the persisted entity.
     */
    @Override
    public GetMarketingPreferenceDTO update(UpdateMarketingPreferenceDTO marketingPreference) {
        return marketingPreferenceRepository.save(marketingPreference.toMarketingPreference()).toGetMarketingPreferenceDTO().get();
    }

    /**
     * Delete the MarketingPreference by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Integer id) {
        log.debug("Request to delete Marketing Preferences : {}", id);
        marketingPreferenceRepository.deleteById(id);
    }

    /**
     * Find one Marketing Preference by Id
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public Optional<GetMarketingPreferenceDTO> findOne(Integer id) {
        Optional<MarketingPreference> optionalMarketingPreference = marketingPreferenceRepository.findById(id);
        if (optionalMarketingPreference.isPresent()) {
            return optionalMarketingPreference.get().toGetMarketingPreferenceDTO();
        }
        return Optional.empty();
    }
}
