package com.example.file_storage_service.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "files")
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "creation_date")
    @Setter
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    LocalDateTime creationDate;

    @Column(name = "description")
    String description;

    @Column(name = "file_data")
    String fileData;
}
