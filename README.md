programas
=========

Programa del algoritmo de Karatsuba, consiste en realizar multiplicación de números grandes, se realizo una interfaz 
de usuario donde el mismo ingresa los dos números y de acuerdo a una serie de validaciones realiza la multiplicación
respectiva imprimiendo en pantalla el resultado de la misma.

Poner en el path de búsqueda de ejecutables el directorio C:\Archivos de programa\Java\jdk1.5.0_06\bin, 
Abrir  una ventana de ms-dos. Ir  al directorio donde está nuestro proyecto o fuentes .java. Es importante tener en cuenta lo siguiente:
El fichero .java lleva dentro package paquete; debe crear el proyecto un subdirectorio paquete y meter dentro el fichero .java. El siguiente fuente debería ir en c:\path_mi_proyecto\karatsuba\karatsuba.java
Los package y los directorios deben coincidir.
Compilar así:
javac karatsuba\karatsuba.java
Ejecutar sin crear el .jar
.class generados, debe estar situado en el directorio de nuestro proyecto y, según sea la clase que contiene el main, debe ejecutar:
java karatsuba. karatsuba
Crear un jar:
Debe ejecutar el siguiente comando, situados, como siempre, en el directorio de nuestro proyecto
jar cf karatsuba.jar karatsuba.class karatsuba
Un jar generado se puede ejecutar, según qué fuente sea el que tenga el main, con
java -cp karatsuba.jar karatsuba. karatsuba
Hay que advertir que estamos en el directorio de nuestro proyecto, que es donde está el fichero.jar. También que hemos separado paquetes, subpaquetes y clases con punto y no con barras \, además que no hemos puesto .class detrás.
