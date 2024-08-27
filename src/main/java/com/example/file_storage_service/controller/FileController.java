package com.example.file_storage_service.controller;

import com.example.file_storage_service.entities.FileInfo;
import com.example.file_storage_service.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/getFile/{id}")
    @Operation(summary = "Getting file by id")
    public FileInfo getFileById(@PathVariable Long id) {
        return fileService.getFileById(id);
    }

    @PostMapping("/create")
    @Operation(description = "Creating a new file")
    public Long createFile(@RequestBody FileInfo fileInfo) {
        return fileService.saveFile(fileInfo);
    }

    @GetMapping("/")
    public Page<FileInfo> getFilesPage(@RequestParam(defaultValue = "1")Integer page,
                                       @RequestParam(defaultValue = "5")Integer size) {
        return fileService.getAllFiles(PageRequest.of(page - 1, size));
    }
}

