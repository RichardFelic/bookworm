package com.lectura.bookworm.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T convertir(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json.toString(), clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
