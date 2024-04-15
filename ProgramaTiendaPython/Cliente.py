class Cliente:
    def __init__(self, id_cliente, nombre, direccion):
        self.id = id_cliente
        self.nombre = nombre
        self.direccion = direccion
        self.compras = []

    def get_id(self):
        return self.id

    def get_nombre(self):
        return self.nombre

    def agregar_compra(self, compra):
        self.compras.append(compra)

    def get_compras(self):
        return self.compras

    def getId(self):
        return self.id



    def obtener_informacion(self):
        return f"Id: {self.id} Nombre: {self.nombre} y dirección: {self.direccion}"
