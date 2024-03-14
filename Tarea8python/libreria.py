class libreria:
    def __init__(self):
        self.usuarios = []
        self.libros = []

    def registrar_usuario(self, usuario):
        self.usuarios.append(usuario)

    def registrar_libro(self, libro):
        self.libros.append(libro)

    def rentar_libro(self, usuario, libro):
        if not libro.es_rentado:
            libro.es_rentado = True
            usuario.agregar_libro_rentado(libro)
        else:
            print("El libro ya está rentado.")

    def listar_usuarios(self):
        for usuario in self.usuarios:
            print(usuario)

    def listar_libros(self):
        for libro in self.libros:
            print(libro)

    def listar_usuarios_con_libros(self):
        for usuario in self.usuarios:
            if usuario.libros_rentados:
                print(usuario)

    def listar_libros_no_rentados(self):
        for libro in self.libros:
            if not libro.es_rentado:
                print(libro)

    def listar_libros_rentados(self):
        for libro in self.libros:
            if libro.es_rentado:
                print(libro)