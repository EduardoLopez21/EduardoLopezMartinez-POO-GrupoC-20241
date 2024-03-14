class Libro:
    def __init__(self, id, titulo, autor):
        self.id = id
        self.titulo = titulo
        self.autor = autor
        self.es_rentado = False

    def __str__(self):
        return f"Libro: id: {self.id}, titulo: {self.titulo}, autor: {self.autor}, es_rentado: {self.es_rentado}"
