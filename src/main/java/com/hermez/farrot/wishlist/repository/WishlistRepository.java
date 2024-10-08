package com.hermez.farrot.wishlist.repository;

import com.hermez.farrot.wishlist.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer>, WishlistRepositoryCustom {

}
