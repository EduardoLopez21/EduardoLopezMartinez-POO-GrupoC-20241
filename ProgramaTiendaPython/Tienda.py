import random
from datetime import datetime
from Cliente import Cliente
from Producto import Limpieza, Maquillaje, Alimento, Electrodomestico
from Compra import Compra


class Tienda:
    def __init__(self):
        self.clientes = []
        self.productos = []
        self.productosMaquillaje = []
        self.productosLimpieza = []
        self.productosAlimento = []
        self.productosElectrodomestico = []
        self.compras = []
        self.random = random

    def registrar_cliente(self):
        id = self.validar_id_cliente()
        print("Ingresa el nombre: ")
        nombre = input()
        print("Ingresa la direccion: ")
        direccion = input()

        cliente = Cliente(id, nombre, direccion)
        self.clientes.append(cliente)

        print("¡Cliente registrado con exito!")

    def consultar_clientes(self):
        print("¨*** CLIENTES ***")
        for cliente in self.clientes:
            print(cliente.obtener_informacion())

    def validar_id_cliente(self):
        id_valido = True
        id = self.random.randint(1, 1000)

        while True:
            for cliente in self.clientes:
                if id == cliente.getId():
                    id_valido = False
                    id = self.random.randint(1, 1000)
                    break

            if id_valido:
                break

        return id

    def registrar_datos_comun(self):
        datos = []
        print("Ingresa un nombre: ")
        nombre = input()
        datos.append(nombre)

        print("Ingresa el precio: ")
        precio = float(input())
        datos.append(str(precio))

        print("Ingresa la fecha de importacion: ")
        fecha = input()
        datos.append(fecha)

        print("Ingresa el stock del producto: ")
        stock = int(input())
        datos.append(str(stock))

        return datos

    def registrar_producto_limpieza(self):
        print("\n *** Elegiste registrar un producto de la categoria limpieza ***")

        datos_usuario = self.registrar_datos_comun()
        nombre = datos_usuario[0]
        precio = float(datos_usuario[1])
        fecha = datos_usuario[2]
        stock = int(datos_usuario[3])

        print("Ingresa la marca: ")
        marca = input()

        limpieza = Limpieza(nombre, precio, fecha, stock, marca)

        self.productosLimpieza.append(limpieza)

    def consultar_productos_limpieza(self):
        print("*** PRODUCTOS LIMPIEZA***")
        for producto in self.productosLimpieza:
            print(producto.obtener_informacion_con_marca())

    def registrar_producto_maquillaje(self):
        print("\n *** Elegiste registrar un producto de la categoria Maquillaje ***")

        datos_usuario = self.registrar_datos_comun()
        nombre = datos_usuario[0]
        precio = float(datos_usuario[1])
        fecha = datos_usuario[2]
        stock = int(datos_usuario[3])

        print("Ingresar el color: ")
        color = input()

        maquillaje = Maquillaje(nombre, precio, fecha, stock, color)

        self.productosMaquillaje.append(maquillaje)

    def consultar_productos_maquillaje(self):
        print("*** PRODUCTOS MAQUILLAJE***")
        for producto in self.productosMaquillaje:
            print(producto.obtener_informacion_con_color())

    def registrar_producto_electrodomestico(self):
        print("\n *** Elegiste registrar un producto de la categoria Electrodomestico ***")

        datos_usuario = self.registrar_datos_comun()
        nombre = datos_usuario[0]
        precio = float(datos_usuario[1])
        fecha = datos_usuario[2]
        stock = int(datos_usuario[3])

        print("Ingresar el voltaje: ")
        voltaje = input()

        electrodomestico = Electrodomestico(nombre, precio, fecha, stock, voltaje)

        self.productosElectrodomestico.append(electrodomestico)

        print("\n PRODUCTO REGISTRADO CON EXITO \n")

    def consultar_productos_electrodomestico(self):
        print("*** PRODUCTOS ELECTRODOMESTICOS***")
        for producto in self.productosElectrodomestico:
            print(producto.obtener_informacion_con_voltaje())

    def registrar_producto_alimento(self):
        print("\n *** Elegiste registrar un producto de la categoria Alimentos ***")

        datos_usuario = self.registrar_datos_comun()
        nombre = datos_usuario[0]
        precio = float(datos_usuario[1])
        fecha = datos_usuario[2]
        stock = int(datos_usuario[3])

        print("Ingresar la caducidad: ")
        caducidad = input()

        alimento = Alimento(nombre, precio, fecha, stock, caducidad)

        self.productosAlimento.append(alimento)

        print("\n PRODUCTO REGISTRADO CON EXITO \n")

    def consultar_productos_alimento(self):
        print("*** PRODUCTOS ELECTRODOMESTICOS***")
        for producto in self.productosAlimento:
            print(producto.obtener_informacion_con_caducidad())

    def eliminar_cliente(self, id_cliente):
        cliente = self.buscar_cliente_por_id(id_cliente)
        if cliente is not None:
            if not self.cliente_tiene_compras_asociadas(cliente):
                self.clientes.remove(cliente)
                print("Cliente eliminado exitosamente.")
            else:
                print("No se puede eliminar el cliente porque tiene compras asociadas.")
        else:
            print("Cliente no encontrado.")

    def eliminar_producto(self):
        print("Selecciona la categoría del producto que deseas eliminar:")
        print("1. Limpieza")
        print("2. Electrodomésticos")
        print("3. Alimentos")
        print("4. Maquillaje")
        opcion_categoria = int(input())

        if opcion_categoria == 1:
            self.eliminar_producto_limpieza()
        elif opcion_categoria == 2:
            self.eliminar_producto_electrodomestico()
        elif opcion_categoria == 3:
            self.eliminar_producto_alimento()
        elif opcion_categoria == 4:
            self.eliminar_producto_maquillaje()
        else:
            print("Opción no válida.")

    def eliminar_producto_limpieza(self):
        print("Ingrese el ID del producto de limpieza a eliminar: ")
        id_producto = int(input())
        self.eliminar_producto_por_categoria(self.productosLimpieza, id_producto)

    def eliminar_producto_electrodomestico(self):
        print("Ingrese el ID del producto electrodoméstico a eliminar: ")
        id_producto = int(input())
        self.eliminar_producto_por_categoria(self.productosElectrodomestico, id_producto)

    def eliminar_producto_alimento(self):
        print("Ingrese el ID del producto de alimento a eliminar: ")
        id_producto = int(input())
        self.eliminar_producto_por_categoria(self.productosAlimento, id_producto)

    def eliminar_producto_maquillaje(self):
        print("Ingrese el ID del producto de maquillaje a eliminar: ")
        id_producto = int(input())
        self.eliminar_producto_por_categoria(self.productosMaquillaje, id_producto)

    def eliminar_producto_por_categoria(self, lista_productos, id_producto):
        encontrado = False
        for i, producto in enumerate(lista_productos):
            if producto.getId() == id_producto:
                if not self.producto_tiene_compras_asociadas(producto):
                    lista_productos.pop(i)
                    print("Producto eliminado exitosamente.")
                    encontrado = True
                else:
                    print("No se puede eliminar el producto porque tiene compras asociadas.")
                    encontrado = True
                break

        if not encontrado:
            print("Producto no encontrado.")

    def cliente_tiene_compras_asociadas(self, cliente):
        for compra in self.compras:
            if compra.getCliente().getId() == cliente.getId():
                return True
        return False

    def producto_tiene_compras_asociadas(self, producto):
        for compra in self.compras:
            for p in compra.getProductos():
                if p.getNombre().lower() == producto.getNombre().lower():
                    return True
        return False

    def buscar_cliente_por_id(self, id):
        for cliente in self.clientes:
            if cliente.getId() == id:
                return cliente
        return None

    def buscar_producto_por_nombre(self, nombre):
        for producto in self.productos:
            if producto.getNombre().lower() == nombre.lower():
                return producto
        return None

    def agregar_stock_limpieza(self):
        print("Ingrese el ID del producto de limpieza al que desea agregar más stock: ")
        id_producto = int(input())
        producto = self.buscar_producto_por_id(self.productosLimpieza, id_producto)
        if producto is not None:
            print("Ingrese la cantidad de stock a agregar: ")
            cantidad = int(input())
            producto.agregar_stock(cantidad)
            print("Stock agregado correctamente.")
        else:
            print("Producto no encontrado.")

    def buscar_producto_por_id(self, lista_productos, id_producto):
        for producto in lista_productos:
            if producto.getId() == id_producto:
                return producto
        return None

    def agregar_stock_electrodomestico(self):
        print("Ingrese el ID del producto electrodoméstico al que desea agregar más stock: ")
        id_producto = int(input())
        producto = self.buscar_producto_por_id(self.productosElectrodomestico, id_producto)
        if producto is not None:
            print("Ingrese la cantidad de stock a agregar: ")
            cantidad = int(input())
            producto.agregar_stock(cantidad)
            print("Stock agregado correctamente.")
        else:
            print("Producto no encontrado.")

    def agregar_stock_alimento(self):
        print("Ingrese el ID del producto de alimento al que desea agregar más stock: ")
        id_producto = int(input())
        producto = self.buscar_producto_por_id(self.productosAlimento, id_producto)
        if producto is not None:
            print("Ingrese la cantidad de stock a agregar: ")
            cantidad = int(input())
            producto.agregar_stock(cantidad)
            print("Stock agregado correctamente.")
        else:
            print("Producto no encontrado.")

    def agregar_stock_maquillaje(self):
        print("Ingrese el ID del producto de maquillaje al que desea agregar más stock: ")
        id_producto = int(input())
        producto = self.buscar_producto_por_id(self.productosMaquillaje, id_producto)
        if producto is not None:
            print("Ingrese la cantidad de stock a agregar: ")
            cantidad = int(input())
            producto.agregar_stock(cantidad)
            print("Stock agregado correctamente.")
        else:
            print("Producto no encontrado.")

    def disminuir_stock_limpieza(self):
        print("Ingrese el ID del producto de limpieza al que desea quitarle stock: ")
        id_producto = int(input())
        producto = self.buscar_producto_por_id(self.productosLimpieza, id_producto)
        if producto is not None:
            print("Ingrese la cantidad de stock que desea quitar: ")
            cantidad = int(input())
            producto.eliminar_stock(cantidad)
            print("Stock del producto de limpieza actualizado correctamente.")
        else:
            print("Producto de limpieza no encontrado.")

    def disminuir_stock_electrodomestico(self):
        print("Ingrese el ID del producto electrodoméstico al que desea quitarle stock: ")
        id_producto = int(input())
        producto = self.buscar_producto_por_id(self.productosElectrodomestico, id_producto)
        if producto is not None:
            print("Ingrese la cantidad de stock que desea quitar: ")
            cantidad = int(input())
            producto.eliminar_stock(cantidad)
            print("Stock del producto electrodoméstico actualizado correctamente.")
        else:
            print("Producto electrodoméstico no encontrado.")

    def disminuir_stock_alimento(self):
        print("Ingrese el ID del producto de alimento al que desea quitarle stock: ")
        id_producto = int(input())
        producto = self.buscar_producto_por_id(self.productosAlimento, id_producto)
        if producto is not None:
            print("Ingrese la cantidad de stock que desea quitar: ")
            cantidad = int(input())
            producto.eliminar_stock(cantidad)
            print("Stock del producto de alimento actualizado correctamente.")
        else:
            print("Producto de alimento no encontrado.")

    def disminuir_stock_maquillaje(self):
        print("Ingrese el ID del producto de maquillaje al que desea quitarle stock: ")
        id_producto = int(input())
        producto = self.buscar_producto_por_id(self.productosMaquillaje, id_producto)
        if producto is not None:
            print("Ingrese la cantidad de stock que desea quitar: ")
            cantidad = int(input())
            producto.eliminar_stock(cantidad)
            print("Stock del producto de maquillaje actualizado correctamente.")
        else:
            print("Producto de maquillaje no encontrado.")

    def realizar_compra(self):
        print("Ingrese el ID del cliente que realiza la compra: ")
        id_cliente = int(input())
        cliente = self.buscar_cliente_por_id(id_cliente)
        if cliente is None:
            print("Cliente no encontrado.")
            return

        print("Seleccione la categoría del producto:")
        print("1. Limpieza")
        print("2. Maquillaje")
        print("3. Alimento")
        print("4. Electrodoméstico")
        opcion_categoria = int(input())
        lista_productos = None
        if opcion_categoria == 1:
            lista_productos = self.productosLimpieza
        elif opcion_categoria == 2:
            lista_productos = self.productosMaquillaje
        elif opcion_categoria == 3:
            lista_productos = self.productosAlimento
        elif opcion_categoria == 4:
            lista_productos = self.productosElectrodomestico
        else:
            print("Opción inválida.")
            return

        print("Productos disponibles:")
        for producto in lista_productos:
            print(producto.obtener_informacion())

        print("Ingrese el ID del producto que desea comprar: ")
        id_producto = int(input())
        producto_seleccionado = self.buscar_producto_por_id(lista_productos, id_producto)
        if producto_seleccionado is None:
            print("Producto no encontrado.")
            return

        cantidad_compra = int(input("Ingrese la cantidad que desea comprar: "))
        if cantidad_compra > producto_seleccionado.getStock():
            print("La cantidad seleccionada supera el stock disponible.")
        else:
            total_compra = producto_seleccionado.getPrecio() * cantidad_compra
            compra = Compra(cliente, [producto_seleccionado], cantidad_compra, total_compra)
            compra.agregar_producto(producto_seleccionado)
            cliente.agregar_compra(compra)
            producto_seleccionado.disminuir_stock(cantidad_compra)
            self.compras.append(compra)
            print("Compra realizada con éxito.")
            pass

    def mostrar_compras_registradas(self):
        if not self.compras:
            print("No hay compras registradas.")
        else:
            for compra in self.compras:
                print(compra.obtener_informacion())

    def eliminar_producto_por_categoria(self, lista_productos, id_producto):
        producto_eliminado = None
        for producto in lista_productos:
            if producto.getId() == id_producto:
                if not self.producto_tiene_compras_asociadas(producto):
                   lista_productos.remove(producto)
                   producto_eliminado = producto
            else:
                print("No se puede eliminar el producto porque tiene compras asociadas.")
            break
        if producto_eliminado:
           print(f"Producto {producto_eliminado.getNombre()} eliminado correctamente.")
        else:
           print("Producto no encontrado.")


    def producto_tiene_compras_asociadas(self, producto):
        for compra in self.compras:
            if producto in compra.productos:
                return True
        return False



def buscar_cliente_por_id(self, id):
    for cliente in self.clientes:
        if cliente.get_id() == id:
            return cliente
    return None
