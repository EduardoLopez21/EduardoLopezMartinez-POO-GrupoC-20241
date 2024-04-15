from datetime import datetime

class Compra:
    def __init__(self, cliente, productos, cantidad, total, fecha_compra=None):
        self.cliente = cliente
        self.productos = productos
        self.cantidad = cantidad
        self.total = total
        self.fecha_compra = fecha_compra if fecha_compra else datetime.now().strftime("%Y-%m-%d")

    def agregar_producto(self, producto):
        self.productos.append(producto)

    def getCliente(self):
        return self.cliente

    def obtener_informacion(self):
        return f"Compra realizada por el cliente {self.cliente.id}, productos comprados: {len(self.productos)}, total de la compra: {self.total}"
