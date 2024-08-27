package com.example.file_storage_service.service;

import com.example.file_storage_service.entities.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.file_storage_service.repository.FilesRepository;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class FileService {

    private final FilesRepository filesRepository;

    @Autowired
    public FileService(FilesRepository filesRepository) {
        this.filesRepository = filesRepository;
    }

    public Long saveFile(FileInfo fileInfo) {
        fileInfo.setCreationDate(LocalDateTime.now());
        return filesRepository.save(fileInfo).getId();
    }

    public FileInfo getFileById(Long id) {
        return filesRepository.findFileById(id);
    }

    public Page<FileInfo> getAllFiles(Pageable pageable) {
        return filesRepository.findAll(pageable);
    }
}
