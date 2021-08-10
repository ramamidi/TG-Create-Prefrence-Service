package com.tarabut.createpreference.controller;

import com.tarabut.createpreference.entity.MarketingPreference;
import com.tarabut.createpreference.service.MarketingPreferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing {@link MarketingPreference}.
 */
@RestController
public class MarketingPreferenceController {

    private final Logger log = LoggerFactory.getLogger(MarketingPreferenceController.class);

    @Autowired
    private MarketingPreferenceService marketingPreferenceService;

    /**
     * {@code POST  /marketing-preferences} : Create a new MarketingPreference.
     *
     * @param marketingPreference: the marketingPreference to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new marketingPreference.
     */
    @PostMapping("/marketing-preferences")
    public ResponseEntity<MarketingPreference> add(@RequestBody MarketingPreference marketingPreference){
        log.debug("REST request to save MarketingPreference : {}", marketingPreference);
        MarketingPreference result = marketingPreferenceService.save(marketingPreference);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code PUT  /marketing-preferences} : Updates an existing MarketingPreference.
     *
     * @param marketingPreference:  the marketingPreference to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated marketingPreference.
     */
    @PutMapping("/marketing-preferences")
    public ResponseEntity<MarketingPreference> update(@RequestBody MarketingPreference marketingPreference){
        log.debug("REST request to update MarketingPreference : {}", marketingPreference);
        MarketingPreference result = marketingPreferenceService.updateMarketingPreference(marketingPreference);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /marketing-preferences/:id} : the "id" preference.
     *
     * @param id the id of the preference to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/marketing-preferences/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        log.debug("REST request to delete Equipment : {}", id);
        marketingPreferenceService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
