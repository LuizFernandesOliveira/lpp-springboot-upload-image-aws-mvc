package com.upload_image.repositories;

import com.upload_image.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findAllByUserId(Long userId);

}