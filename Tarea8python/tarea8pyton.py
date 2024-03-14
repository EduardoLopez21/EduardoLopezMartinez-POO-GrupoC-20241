from libreria import libreria
from Usuario import Usuario
from Libro import Libro

lib = libreria()

while True:
    print("*** BIENVENIDO AL GESTOR DE LIBRERÍA ***")
    print("Menú:")
    print("1. Registrar usuario")
    print("2. Registrar libro")
    print("3. Rentar libro")
    print("4. Listar usuarios")
    print("5. Listar libros")
    print("6. Listar usuarios con libros")
    print("7. Listar libros no rentados")
    print("8. Listar libros rentados")
    print("9. Salir del programa")

    opcion = int(input("INGRESA UNA OPCION: "))

    if opcion == 1:
        nombre_usuario = input("Ingrese el nombre del usuario: ")
        edad_usuario = int(input("Ingrese la edad del usuario: "))
        usuario = Usuario(len(lib.usuarios) + 1, nombre_usuario, edad_usuario)
        lib.registrar_usuario(usuario)

    elif opcion == 2:
        titulo_libro = input("Ingrese el título del libro: ")
        autor_libro = input("Ingrese el autor del libro: ")
        libro = Libro(len(lib.libros) + 1, titulo_libro, autor_libro)
        lib.registrar_libro(libro)

    elif opcion == 3:
        id_usuario = int(input("Ingrese el id del usuario: "))
        id_libro = int(input("Ingrese el id del libro: "))
        lib.rentar_libro(lib.usuarios[id_usuario - 1], lib.libros[id_libro - 1])

    elif opcion == 4:
        lib.listar_usuarios()

    elif opcion == 5:
        lib.listar_libros()

    elif opcion == 6:
        lib.listar_usuarios_con_libros()

    elif opcion == 7:
        lib.listar_libros_no_rentados()

    elif opcion == 8:
        lib.listar_libros_rentados()

    elif opcion == 9:
        print("Saliendo del programa, Bye bye :D")
        break

    else:
        print("Opción no válida.")
