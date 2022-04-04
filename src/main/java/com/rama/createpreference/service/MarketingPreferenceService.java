package com.rama.createpreference.service;

import com.rama.createpreference.dto.GetMarketingPreferenceDTO;
import com.rama.createpreference.dto.PostMarketingPreferenceDTO;
import com.rama.createpreference.dto.UpdateMarketingPreferenceDTO;

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
    GetMarketingPreferenceDTO save(PostMarketingPreferenceDTO marketingPreference);

    /**
     * Update a MarketingPreference.
     *
     * @param marketingPreference the entity to update.
     * @return the persisted entity.
     */
    GetMarketingPreferenceDTO update(UpdateMarketingPreferenceDTO marketingPreference);

    /**
     * Find one Marketing Preference by Id
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<GetMarketingPreferenceDTO> findOne(Integer id);


    /**
     * Delete the MarketingPreference by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Integer id);

}
