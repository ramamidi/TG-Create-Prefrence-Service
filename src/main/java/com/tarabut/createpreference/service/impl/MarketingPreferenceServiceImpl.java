package com.tarabut.createpreference.service.impl;

import com.tarabut.createpreference.entity.MarketingPreference;
import com.tarabut.createpreference.repository.MarketingPreferenceRepository;
import com.tarabut.createpreference.service.MarketingPreferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link com.tarabut.createpreference.entity.MarketingPreference}.
 */
@Service
public class MarketingPreferenceServiceImpl implements MarketingPreferenceService {

    private final Logger log = LoggerFactory.getLogger(MarketingPreferenceServiceImpl.class);

    @Autowired
    MarketingPreferenceRepository marketingPreferenceRepository;

    /**
     * Save a MarketingPreference.
     *
     * @param marketingPreference the entity to save.
     * @return the persisted entity.
     */
    @Override
    public MarketingPreference save(MarketingPreference marketingPreference) {
        return marketingPreferenceRepository.save(marketingPreference);
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
    public Optional<MarketingPreference> findOne(Integer id) {
        return marketingPreferenceRepository.findById(id);
    }
}
