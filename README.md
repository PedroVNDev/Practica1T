# Aplicación Moviles 1 Trimestre, 2ºDAM

Aplicación movil para android que muestra nuestra ubicación actual y mediante una API obtiene información de polideportivos y piscinas de madrid en un radio de 8KM alrededor de nuestra ubicacion guardada, con la capacidad de mostrarlos en un mapa y marcar sus ubicaciones también tiene la posibilidad de visualizar en una lista de favoritos nuestras piscinas y polideportivos que hayamos guardado, dispone también de una seccion de paginas de interes relacionadas con el deporte en Madrid, la aplicación cuenta con una pantalla de carga estilo Whatsaap (SplashScreen) y es posible navegar a traves de las opciones en un menu lateral.


### Pre-requisitos 📋

* Android 6.0 Marshmallow o Superior. 


### Instalación 🔧

Puedes descargar el proyecto mediante el botón CODE o clonando el repositorio con git bash
--> $ git clone https://github.com/PinguExtremo/Practica1T_Moviles


## Ejecución del programa ⚙️

Desde Android Studio si disponemos de un emulador con android 6.0 o superior, podremos ejecutarlo desde ahi.
Otra opción es conectar nuestro dispositivo android y activar la depuración USB ademas de permitir instalar aplicaciones externas.
* [Como Activar la Depuracion USB en Android](https://www.youtube.com/watch?v=w5e5aTMWgjQ)

Una vez instalada la aplicación ya la podemos ejecutar sin necesidad de un IDE.


### Instrucciones de uso ⌨️

1. Lo primero que veremos al instalar la aplicacion es un mensaje que nos pedira concederle permisos de ubicación, es muy importante que aceptemos esta opcion ya que sin ella la aplicación no funcionara correctamente y le faltaran funcionalidades.

<a href="https://imgur.com/e2Q8muP"><img src="https://i.imgur.com/e2Q8muP.png" title="source: imgur.com" /></a>

2. Ya dentro de la aplicación podremos observar arriba a la izquierda un icono con 3 barras si pulsamos en el podremos desplegar el menu de opciones

<a href="https://imgur.com/DjNerKT"><img src="https://i.imgur.com/DjNerKT.png" title="source: imgur.com" /></a>

<a href="https://imgur.com/71qaKIf"><img src="https://i.imgur.com/71qaKIf.png" title="source: imgur.com" /></a>

3. Si pulsamos dentro de Ubicación Actual, podremos observar la ubicación real de donde nos encontramos (En emulador tendremos que asignarlo manualmente) también cuenta con un boton para guardar la ubicación, esta opcion nos sera util para la siguiente opción del menu desplegable.

<a href="https://imgur.com/3rY6S89"><img src="https://i.imgur.com/3rY6S89.png" title="source: imgur.com" /></a>

4. Dentro de la opción Guardar Ubicación dispondremos de un boton que al pulsarlo nos mostrara la ultima ubicación guardada, ¡IMPORTANTE! Si no hemos guardado ninguna ubicación en la anterior opción del menu desplegable no nos mostrara nada y en cambio la aplicación nos informara que tenemos que guardar una ubicacíon, la ubicación se guarda en un archivo por lo que al cerrar la aplicación seguira disponible.

<a href="https://imgur.com/k6vhO8J"><img src="https://i.imgur.com/k6vhO8J.png" title="source: imgur.com" /></a>

<a href="https://imgur.com/4fBEooT"><img src="https://i.imgur.com/4fBEooT.png" title="source: imgur.com" /></a>

<a href="https://imgur.com/a1n2Bqd"><img src="https://i.imgur.com/a1n2Bqd.png" title="source: imgur.com" /></a>

5. Las opciones de Instalaciones Deportivas y Piscinas son muy parecidas con la diferencia que disponen de distinta información al entrar podremos observar las piscinas y polideportivos alrededor de nuestra ubicación guardada <-- IMPORTANTE guardar la ubicación antes de ir a estas opciones ya que si no no podremos visualizar ninguna piscina ni polideportivo alrededor nuestra en un radio de 8KM, en caso de no haber ningun centro deportivo alrededor la aplicacion mostrara un mensaje, Aviso --> Dependiendo de donde nos encontremos la aplicación puede tardar 10 segundos en cargar todos los centros deportivos. Por ultimo si todo esto se cumple tendremos una opción en un botón para poder visualizar la localizacion de los centros y si clickamos en alguno de los centros de la lista tendremos la posibilidad de agregarlo a la lista de favoritos.

<a href="https://imgur.com/gryueBd"><img src="https://i.imgur.com/gryueBd.png" title="source: imgur.com" /></a>

<a href="https://imgur.com/eZPzOuV"><img src="https://i.imgur.com/eZPzOuV.png" title="source: imgur.com" /></a>

<a href="https://imgur.com/OIhjaGB"><img src="https://i.imgur.com/OIhjaGB.png" title="source: imgur.com" /></a>

<a href="https://imgur.com/vDQuJ0v"><img src="https://i.imgur.com/vDQuJ0v.png" title="source: imgur.com" /></a>

6. La opción de paginas de interes nos mostrar un listado con 5 paginas web relacionadas con el deporte en Madrid, son paginas orientadas sobre todo a la infomación deportiva que pueden interesar al usuario.

<a href="https://imgur.com/8a7W2Rm"><img src="https://i.imgur.com/8a7W2Rm.png" title="source: imgur.com" /></a>

<a href="https://imgur.com/ISbBuuz"><img src="https://i.imgur.com/ISbBuuz.png" title="source: imgur.com" /></a>

7. La ultima opción nos permite visualizar la lista de favoritos que hemos agregado en el quinto paso, si no tenemos ningún favorito agregado la lista estara vacia.

<a href="https://imgur.com/1NuPhEm"><img src="https://i.imgur.com/1NuPhEm.png" title="source: imgur.com" /></a>


## Construido con 🛠️

* [Android Studio](https://developer.android.com/studio?hl=es) - Entorno de desarrollo.
* [Flaticon](https://www.flaticon.es) - Libreria de Iconos en formato PNG.
* [Maven](https://mvnrepository.com) - Libreria de dependencias online.
* [Gradle](https://maven.apache.org/) - Manejador de dependencias.
* [Datos Abiertos Madrid](https://datos.madrid.es/portal/site/egob/) - Portal de datos abiertos de la comunidad de Madrid.
* [Retrofit](https://square.github.io/retrofit/) - Cliente de servidores REST para Android.
* [Postman](https://www.postman.com) -Aplicación de peticiones API.


## Creado por ✒️

* **Pedro Vicente** - *Desarrollador* - [PinguExtremo](https://github.com/PinguExtremo)
* **Alejandro Casado** - *Desarrollador* - [janovm](https://github.com/janovm)
