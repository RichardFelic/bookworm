package com.lectura.bookworm.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias("name")
        String name,

        @JsonAlias("birth_year")
        int birth_year,

        @JsonAlias("death_year")
        int death_year
) {
}
