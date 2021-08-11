package com.tarabut.createpreference.service;

import com.tarabut.createpreference.entity.MarketingPreference;

import java.util.Optional;

/**
 * Service Interface for managing MarketingPreference.
 */
public interface MarketingPreferenceService {

    /**
     * Save a MarketingPreference.
     *
     * @param marketingPreference the entity to save.
     * @return the persisted entity.
     */
    MarketingPreference save(MarketingPreference marketingPreference);

    /**
     * Find one Marketing Preference by Id
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<MarketingPreference> findOne(Integer id);


    /**
     * Delete the MarketingPreference by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Integer id);

}
