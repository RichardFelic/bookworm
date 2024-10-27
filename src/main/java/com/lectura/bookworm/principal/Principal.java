package com.lectura.bookworm.principal;

import com.lectura.bookworm.model.Datos;
import com.lectura.bookworm.model.DatosLibros;
import com.lectura.bookworm.service.ConsumoAPI;
import com.lectura.bookworm.service.ConvierteDatos;

import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);


    public void muestraElMenu() {
        var json = consumoApi.obtenerDatos(URL_BASE);
        var datos = conversor.convertir(json, Datos.class);
//        Prueba para imprimir la lista del json
//        System.out.println(datos.toString());

        // Top 10 libros con más descargas
        AtomicInteger index = new AtomicInteger();
        System.out.println("+------ Top 10 libros con mas descargas -------+");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::download_count).reversed())
                .limit(10)
                .forEach(libro -> System.out.println((index.incrementAndGet()) + "- " + libro.title().toString()));

//        Busqueda de libros por nombre https://gutendex.com/books/?search=book
        System.out.println("+---------------- Busqueda de libros por nombre ----------------+");
        System.out.println("Ingresa el nombre de un libro: ");
        var libro = teclado.nextLine().toLowerCase();
        var jsonLibro = consumoApi.obtenerDatos(URL_BASE + "?search=" + libro.replace(" ", "+"));
        var busquedaDatosLibro = conversor.convertir(jsonLibro, Datos.class);
        Optional<DatosLibros> datoBusqueda = busquedaDatosLibro.resultados().stream()
                .filter(l -> l.title().toLowerCase().contains(libro))
                .findFirst();
        if (datoBusqueda.isPresent()) {
            System.out.println("Libro encontrado: ");
            System.out.println(datoBusqueda.get());
        } else System.out.println("Libro no encontrado");

//        Trabajar con las estadisticas de descargas con DoubleSummaryStatistics
        System.out.println("+---------------- Estadisticas de descargas ----------------+");
        var estadisticas = datos.resultados().stream()
                .mapToDouble(DatosLibros::download_count)
                .summaryStatistics();
        System.out.println("Maximo de descargar: " + estadisticas.getMax());
        System.out.println("Minimo de descargar: " + estadisticas.getMin());
        System.out.println("Promedio de descargar: " + estadisticas.getAverage());
        System.out.println("Total de descargar: " + estadisticas.getSum());
        System.out.println("Cantidad de registro evaluados para calcular las estadisticas: " + estadisticas.getCount());
    }
}
