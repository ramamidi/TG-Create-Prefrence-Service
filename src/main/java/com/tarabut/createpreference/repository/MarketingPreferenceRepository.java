package com.tarabut.createpreference.repository;

import com.tarabut.createpreference.entity.MarketingPreference;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data  repository for the MarketingPreference entity.
 */
public interface MarketingPreferenceRepository extends JpaRepository<MarketingPreference, Integer> {
}


