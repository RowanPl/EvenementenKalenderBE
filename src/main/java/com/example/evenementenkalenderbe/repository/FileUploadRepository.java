package com.example.evenementenkalenderbe.repository;


import com.example.evenementenkalenderbe.model.FileUploadResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileUploadRepository extends JpaRepository<FileUploadResponse, String> {
    Optional<FileUploadResponse> findByFileName(String fileName);

}
