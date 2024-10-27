package com.lectura.bookworm.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("title")
        String title,
        @JsonAlias("authors")
        List<DatosAutor> authors,
        @JsonAlias("languages")
        List<String> languages,
        @JsonAlias("download_count")
        Double download_count
) {
}
