package com.java.mymobile.repositories;

        import java.util.Optional;
        import java.util.UUID;
        import com.java.mymobile.domain.entities.OfferEntity;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
        import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long>,
        JpaSpecificationExecutor<OfferEntity> {
    Optional<OfferEntity> findOfferEntityByOfferId(UUID uuid);

}