class Producto:
    CANTIDAD_PRODUCTOS = 0

    def __init__(self, nombre, precio, fecha_importacion, stock):
        Producto.CANTIDAD_PRODUCTOS += 1
        self.id = Producto.CANTIDAD_PRODUCTOS
        self.nombre = nombre
        self.precio = precio
        self.fecha_importacion = fecha_importacion
        self.stock = stock
        self.numero_serie = Producto.CANTIDAD_PRODUCTOS

    def agregar_stock(self, cantidad):
        self.stock += cantidad

    def eliminar_stock(self, cantidad):
        if not self.validar_stock():
            self.stock -= cantidad

    def validar_stock(self):
        return self.stock == 0

    def disminuir_stock(self):
        if self.stock > 0:
            self.stock -= 1

    def getStock(self):
        return self.stock

    def obtener_informacion(self):
        print(f"Producto registrado con ID: {self.id}")
        return f"ID: {self.id}, Nombre: {self.nombre}, Precio: {self.precio}, Fecha de importacion: {self.fecha_importacion}, Stock: {self.stock}, Numero de serie: {self.numero_serie}"


class Electrodomestico(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, voltaje):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.voltaje = voltaje

    def getId(self):
          return self.id

    def getStock(self):
        return self.stock

    def getPrecio(self):
        return self.precio

    def getNombre(self):
        return self.nombre

    def disminuir_stock(self, cantidad):
        if self.stock >= cantidad:
            self.stock -= cantidad
            print("Stock disminuido correctamente.")
        else:
            print("No hay suficiente stock disponible.")

    def obtener_informacion_con_voltaje(self):
        return super().obtener_informacion() + f", Voltaje: {self.voltaje}"


class Alimento(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, caducidad):
            super().__init__(nombre, precio, fecha_importacion, stock)
            self.caducidad = caducidad
    def getId(self):
        return self.id

    def getStock(self):
        return self.stock

    def getPrecio(self):
        return self.precio

    def getNombre(self):
        return self.nombre

    def disminuir_stock(self, cantidad):
        if self.stock >= cantidad:
            self.stock -= cantidad
            print("Stock disminuido correctamente.")
        else:
            print("No hay suficiente stock disponible.")

    def obtener_informacion_con_caducidad(self):
        return f"{super().obtener_informacion()} Caducidad: {self.caducidad}"


class Limpieza(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, marca):
            super().__init__(nombre, precio, fecha_importacion, stock)
            self.marca = marca
    def getId(self):
        return self.id

    def getStock(self):
        return self.stock

    def getPrecio(self):
        return self.precio

    def getNombre(self):
        return self.nombre

    def disminuir_stock(self, cantidad):
        if self.stock >= cantidad:
            self.stock -= cantidad
            print("Stock disminuido correctamente.")
        else:
            print("No hay suficiente stock disponible.")

    def obtener_informacion_con_marca(self):
        return f"{super().obtener_informacion()} Marca: {self.marca}"


class Maquillaje(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, color):
            super().__init__(nombre, precio, fecha_importacion, stock)
            self.color = color
    def getId(self):
        return self.id

    def getStock(self):
        return self.stock

    def getPrecio(self):
        return self.precio

    def getNombre(self):
        return self.nombre

    def disminuir_stock(self, cantidad):
        if self.stock >= cantidad:
            self.stock -= cantidad
            print("Stock disminuido correctamente.")
        else:
            print("No hay suficiente stock disponible.")

    def obtener_informacion_con_color(self):
        return f"{super().obtener_informacion()} Color: {self.color}"

