package com.tarabut.createpreference.service;

import com.tarabut.createpreference.entity.MarketingPreference;
import com.tarabut.createpreference.errors.NotFoundException;
import com.tarabut.createpreference.repository.MarketingPreferenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for managing {@link com.tarabut.createpreference.entity.MarketingPreference}.
 */
@Service
public class MarketingPreferenceService {

    private final Logger log = LoggerFactory.getLogger(MarketingPreferenceService.class);

    @Autowired
    MarketingPreferenceRepository marketingPreferenceRepository;

    /**
     * Save a MarketingPreference.
     *
     * @param marketingPreference the entity to save.
     * @return the persisted entity.
     */
    public MarketingPreference save(MarketingPreference marketingPreference) {
        return marketingPreferenceRepository.save(marketingPreference);
    }

    /**
     * Update a MarketingPreference.
     *
     * @param marketingPreference the entity to update.
     * @return the persisted entity.
     */
    public MarketingPreference updateMarketingPreference(MarketingPreference marketingPreference) throws NotFoundException {
        marketingPreferenceRepository.findById(marketingPreference.getId())
                .orElseThrow(() -> new NotFoundException("Not Found"));
        return marketingPreferenceRepository.save(marketingPreference);
    }

    /**
     * Delete the MarketingPreference by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Integer id) {
        log.debug("Request to delete Marketing Preferences : {}", id);
        marketingPreferenceRepository.deleteById(id);
    }
}
