class Usuario:
    def __init__(self, id, nombre, edad):
        self.id = id
        self.nombre = nombre
        self.edad = edad
        self.libros_rentados = []

    def agregar_libro_rentado(self, libro):
        self.libros_rentados.append(libro)

    def __str__(self):
        return f"Usuario: id: {self.id}, nombre: {self.nombre}, edad: {self.edad}"
