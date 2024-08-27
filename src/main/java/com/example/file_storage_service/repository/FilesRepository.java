package com.example.file_storage_service.repository;

import com.example.file_storage_service.entities.FileInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends JpaRepository<FileInfo, Long>, PagingAndSortingRepository<FileInfo, Long> {

    FileInfo findFileById(Long id);

    @Override
    @NonNull
    Page<FileInfo> findAll(@NonNull Pageable pageable);

    @Override
    @NonNull
    <S extends FileInfo> S save(@NonNull S file);
}
