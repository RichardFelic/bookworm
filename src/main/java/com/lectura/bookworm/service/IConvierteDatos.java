package com.lectura.bookworm.service;

public interface IConvierteDatos {
    <T> T convertir(String json, Class<T> clazz);
}
