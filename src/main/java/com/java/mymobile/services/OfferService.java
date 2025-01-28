package com.java.mymobile.services;

import com.java.mymobile.domain.dtos.model.SearchOfferDTO;
import com.java.mymobile.domain.dtos.veiw.OfferDetailsViewDTO;
import com.java.mymobile.domain.entities.OfferEntity;
import com.java.mymobile.domain.enums.UserRoleEnum;
import com.java.mymobile.repositories.OfferRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;





@Service
public class OfferService {
    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public OfferDetailsViewDTO getOfferById(UUID offerId) {
        // TODO: test case
        var offerEntity = offerRepository.findOfferEntityByOfferId(offerId).orElseThrow(() ->
                new ObjectNotFoundException("Offer " + offerId + " not found", offerId));

        return map(offerEntity);
    }

    public Page<OfferDetailsViewDTO> getAllOffers(Pageable pageable) {
        return
                offerRepository.
                        findAll(pageable).
                        map(this::map);
    }

    private OfferDetailsViewDTO map(OfferEntity offerEntity) {
        return new OfferDetailsViewDTO().
                setOfferId(offerEntity.getOfferId()).
                setImageUrl(offerEntity.getImageUrl()).
                setDescription(offerEntity.getDescription()).
                setEngine(offerEntity.getEngine()).
                setModel(offerEntity.getModel().getName()).
                setModel(offerEntity.getModel().getBrand().getName()).
                setMileage(offerEntity.getMileage()).// TODO -> int
                        setPrice(offerEntity.getPrice()).// TODO -> big decimal
                        setTransmission(offerEntity.getTransmission()).
                setYear(offerEntity.getYear());//todo -> int
    }

    public void deleteOfferByUUID(UUID id) {
        offerRepository.
                findOfferEntityByOfferId(id).
                ifPresent(offerRepository::delete);
    }

   // public List<OfferDetailsViewDTO> findOffers(SearchOfferDTO filter) {
      //  return
        ///        offerRepository.findAll(new OfferSpecification(filter)).
        //               stream().
         //             map(this::map).
          //          toList();
  //  }

    public boolean isOwner(UserDetails userDetails, UUID id) {
        if (id == null || userDetails == null) {
            return  false;
        }

        var offer = offerRepository.
                findOfferEntityByOfferId(id).
                orElse(null);

        if (offer == null) {
            return false;
        }

        return userDetails.getUsername().equals(offer.getSeller().getEmail()) ||
                isUserAdmin(userDetails);
    }

    private boolean isUserAdmin(UserDetails userDetails) {
        return userDetails.getAuthorities().
                stream().
                map(GrantedAuthority::getAuthority).
                anyMatch(a -> a.equals("ROLE_" + UserRoleEnum.ADMIN.name()));
    }
}
