# Bookworm
Aplicación de lectura de libros en línea

## Descripción
Bookworm es una aplicación de lectura de libros en línea que consume datos de una API externa y los muestra en una interfaz de usuario. La aplicación permite a los usuarios explorar y leer libros en línea, y ofrece características como la búsqueda de libros por título, autor o idioma.

## Características
- Consumo de datos de una API externa (Gutendex)
- Muestra de información sobre libros, incluyendo títulos, autores, idiomas y estadísticas de descargas
- Búsqueda de libros por título, autor o idioma
- Interfaz de usuario intuitiva y fácil de usar

## Tecnologías utilizadas
- Java
- Spring Boot
- Jackson para la serialización y deserialización de JSON
- API de HttpClient para realizar solicitudes HTTP a la API externa

## Estructura del proyecto
- **Principal**: clase principal de la aplicación, que muestra un menú con opciones para el usuario
- **ConsumoAPI**: clase que se encarga de consumir los datos de la API externa y devolverlos en formato JSON
- **ConvierteDatos**: clase que se encarga de convertir los datos JSON en objetos Java
- **Datos**: clase que representa un libro, con campos como título, autores, idiomas y estadísticas de descargas
- **DatosLibros**: clase que representa una lista de libros

## Contribuciones
Si deseas contribuir al proyecto, por favor sigue los siguientes pasos:

1. Haz un fork del repositorio en tu cuenta de GitHub
2. Crea una rama nueva para tu contribución
3. Realiza los cambios necesarios y haz un commit
4. Haz un pull request para que podamos revisar tus cambios
