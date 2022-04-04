package com.rama.createpreference.controller;

import com.rama.createpreference.dto.GetMarketingPreferenceDTO;
import com.rama.createpreference.dto.PostMarketingPreferenceDTO;
import com.rama.createpreference.dto.UpdateMarketingPreferenceDTO;
import com.rama.createpreference.entity.MarketingPreference;
import com.rama.createpreference.service.MarketingPreferenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * REST controller for managing {@link MarketingPreference}.
 */
@RestController
@Api("Create Preference API")
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
    @ApiOperation("Creates Marketing preference and saves into datatbase.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created successfully"),
            @ApiResponse(code = 500, message = "Internal Server error")

    })
    @PostMapping(value = "/marketing-preferences")
    public ResponseEntity<GetMarketingPreferenceDTO> add(@Valid @RequestBody PostMarketingPreferenceDTO marketingPreference) {
        log.debug("REST request to save MarketingPreference : {}", marketingPreference);
        GetMarketingPreferenceDTO result = marketingPreferenceService.save(marketingPreference);
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(result);
    }

    /**
     * {@code PUT  /marketing-preferences} : Updates an existing MarketingPreference.
     *
     * @param marketingPreference: the marketingPreference with the Id to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated marketingPreference.
     */
    @ApiOperation("Updates existing Marketing Preference with the given input.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Updated successfully"),
            @ApiResponse(code = 500, message = "Internal Server error")

    })
    @PutMapping(value = "/marketing-preferences")
    public ResponseEntity<GetMarketingPreferenceDTO> update(@Valid @RequestBody UpdateMarketingPreferenceDTO marketingPreference) {
        log.debug("REST request to update MarketingPreference : {}", marketingPreference);
        marketingPreferenceService.findOne(marketingPreference.getId()).
                orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(marketingPreferenceService.update(marketingPreference));
    }

    /**
     * {@code DELETE  /marketing-preferences/:id} : the "id" preference.
     *
     * @param id the id of the preference to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/marketing-preferences/{id}")
    @ApiOperation("Deletes Marketing Preference taking the given id, if exists.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deleted successfully"),
            @ApiResponse(code = 500, message = "Internal Server error")

    })
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        log.debug("REST request to delete Equipment : {}", id);
        marketingPreferenceService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
