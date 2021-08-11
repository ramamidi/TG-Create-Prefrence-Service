package com.tarabut.createpreference.controller;

import com.tarabut.createpreference.entity.MarketingPreference;
import com.tarabut.createpreference.service.MarketingPreferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * REST controller for managing {@link MarketingPreference}.
 */
@RestController
public class MarketingPreferenceController {

    private final Logger log = LoggerFactory.getLogger(MarketingPreferenceController.class);

    private MarketingPreferenceService marketingPreferenceService;

    @Autowired
    public MarketingPreferenceController(final MarketingPreferenceService marketingPreferenceService) {
        this.marketingPreferenceService = marketingPreferenceService;
    }

    /**
     * {@code POST  /marketing-preferences} : Create a new MarketingPreference.
     *
     * @param marketingPreference: the marketingPreference to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new marketingPreference.
     */
    @PostMapping("/marketing-preferences")
    public ResponseEntity<MarketingPreference> add(@RequestBody MarketingPreference marketingPreference) {
        log.debug("REST request to save MarketingPreference : {}", marketingPreference);
        MarketingPreference result = marketingPreferenceService.save(marketingPreference);
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(result);
    }

    /**
     * {@code PUT  /marketing-preferences} : Updates an existing MarketingPreference.
     *
     * @param marketingPreference: the marketingPreference with the Id to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated marketingPreference.
     */
    @PutMapping("/marketing-preferences")
    public ResponseEntity<MarketingPreference> update(@RequestBody MarketingPreference marketingPreference) {
        log.debug("REST request to update MarketingPreference : {}", marketingPreference);
        marketingPreferenceService.findOne(marketingPreference.getId()).
                orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(marketingPreferenceService.save(marketingPreference));
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
