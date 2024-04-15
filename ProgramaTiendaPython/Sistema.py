from collections import defaultdict
from typing import List, Dict
from Producto import Producto
from Tienda import Tienda


class Sistema:
    def __init__(self):
        self.CONTRASEÑA = "H1/m"
        self.tienda = Tienda()
        self.inventario: Dict[int, Dict[int, Producto]] = self.inicializar_inventario()
        self.compras: Dict[int, Dict[int, int]] = defaultdict(dict)
        self.clienteID = 0

    def inicializar_inventario(self) -> Dict[int, Dict[int, Producto]]:
        return defaultdict(dict)

    def ejecutar_programa(self):
        contraseña_valida = False

        while not contraseña_valida:
            print("*** BIENVENIDO ***")
            contraseña = input("INGRESA LA CONTRASEÑA PARA PODER ACCEDER AL SISTEMA: ")

            if self.validar_contraseña(contraseña):
                contraseña_valida = True
                self.mostrar_menu_sistema()
            else:
                print("Contraseña inválida. Intenta de nuevo.\n")

    def validar_contraseña(self, contraseña: str) -> bool:
        return contraseña == self.CONTRASEÑA


    def mostrar_menu_sistema(self):
        opcion = 0
        mi_tienda = Tienda()

        while opcion != 13:
            print("\n ELIGE UNA OPCION PARA CONTINUAR\n ")
            print("*** BIENVENIDOS ***")
            print("1.- Agregar cliente")  # YA QUEDO
            print("2.- Agregar producto")  # YA QUEDO
            print("3.- Añadir a stock")  # YA QUEDO
            print("4.- Disminuir stock")  # YA QUEDO
            print("5.- Listar clientes")  # YA QUEDO
            print("6.- Listar productos")  # YA QUEDO
            print("7.- Consultar productos por categoria")  # YA QUEDO
            print("8.- Realizar compras")  # YA QUEDO
            print("9.- Consultar compras")  # YA QUEDO
            print("10.- Consultar total de productos y clientes")
            print("11.- Eliminar producto")  # YA QUEDO
            print("12.- Eliminar cliente")  # YA QUEDO
            print("13.- Salir")  # YA QUEDO

            opcion = int(input("Ingresa la opción: "))

            if opcion == 1:
                print("*** HAZ SELECCIONADO LA OPCION DE AGREGAR CLIENTES \n")
                self.tienda.registrar_cliente()
            elif opcion == 2:
                print("*** HAZ SELECCIONADO LA OPCION DE AGREGAR PRODUCTO \n")
                print("Ingresa el tipo de producto que deseas agregar: ")
                print("1.- Limpieza")
                print("2.- Electrodomesticos")
                print("3.- Alimento")
                print("4.- Maquillaje")
                opcion_producto = int(input("Ingresar opción: "))

                if opcion_producto == 1:
                    self.tienda.registrar_producto_limpieza()
                elif opcion_producto == 2:
                    self.tienda.registrar_producto_electrodomestico()
                elif opcion_producto == 3:
                    self.tienda.registrar_producto_alimento()
                elif opcion_producto == 4:
                    self.tienda.registrar_producto_maquillaje()
            elif opcion == 3:
                print("*** HAZ SELECCIONADO LA OPCION DE AGREGAR STOCK \n")
                print("Ingresa el tipo de producto al que deseas agregarle más stock: ")
                print("1.- Limpieza")
                print("2.- Electrodomesticos")
                print("3.- Alimento")
                print("4.- Maquillaje")
                opcion_producto = int(input("Ingresar opción: "))

                if opcion_producto == 1:
                    print("***Seleccionaste agregarle más stock a Limpieza***")
                    self.tienda.agregar_stock_limpieza()
                elif opcion_producto == 2:
                    print("***Seleccionaste agregarle más stock a Electrodomestico***")
                    self.tienda.agregar_stock_electrodomestico()
                elif opcion_producto == 3:
                    print("***Seleccionaste agregarle más stock a Alimento***")
                    self.tienda.agregar_stock_alimento()
                elif opcion_producto == 4:
                    print("***Seleccionaste agregarle más stock a Maquillaje***")
                    self.tienda.agregar_stock_maquillaje()
                else:
                    print("Selecciona una opción válida :D")
            elif opcion == 4:
                print("*** HAZ SELECCIONADO LA OPCION DE DISMINUIR STOCK \n")
                print("Ingresa el tipo de producto al que deseas quitarle más stock: ")
                print("1.- Limpieza")
                print("2.- Electrodomesticos")
                print("3.- Alimento")
                print("4.- Maquillaje")
                opcion_producto = int(input("Ingresar opción: "))

                if opcion_producto == 1:
                    print("***Seleccionaste disminuir más stock a Limpieza***")
                    self.tienda.disminuir_stock_limpieza()
                elif opcion_producto == 2:
                    print("***Seleccionaste disminuir más stock a Electrodomestico***")
                    self.tienda.disminuir_stock_electrodomestico()
                elif opcion_producto == 3:
                    print("***Seleccionaste disminuir más stock a Alimento***")
                    self.tienda.disminuir_stock_alimento()
                elif opcion_producto == 4:
                    print("***Seleccionaste disminuir más stock a Maquillaje***")
                    self.tienda.disminuir_stock_maquillaje()
                else:
                    print("Selecciona una opción válida :D")
            elif opcion == 5:
                print("*** HAZ SELECCIONADO LA OPCION DE CONSULTAR CLIENTES\n")
                self.tienda.consultar_clientes()
            elif opcion == 6:
                print("*** HAZ SELECCIONADO LA OPCION DE CONSULTAR PRODUCTOS \n")
                print("***PRODUCTOS DE LIMPIEZA***")
                if not self.tienda.productosLimpieza:
                    print("No hay productos de limpieza registrados.")
                else:
                    self.tienda.consultar_productos_limpieza()

                print("***PRODUCTOS DE ELECTRODOMESTICOS***")
                if not self.tienda.productosElectrodomestico:
                    print("No hay productos de electrodomésticos registrados.")
                else:
                    self.tienda.consultar_productos_electrodomestico()

                print("***PRODCUTOS DE ALIMENTOS***")
                if not self.tienda.productosAlimento:
                    print("No hay productos de alimentos registrados.")
                else:
                    self.tienda.consultar_productos_alimento()

                print("***PRODCUTOS DE MAQUILLAJE***")
                if not self.tienda.productosMaquillaje:
                    print("No hay productos de maquillaje registrados.")
                else:
                    self.tienda.consultar_productos_maquillaje()
            elif opcion == 7:
                print("*** HAZ SELECCIONADO LA OPCION DE CONSULTAR PRODUCTOS \n")
                print("Ingresa el tipo de producto que deseas consultar")
                print("1.- Limpieza")
                print("2.- Electrodomesticos ")
                print("3.- Alimento ")
                print("4.- Maquillaje")
                opcion_producto_consulta = int(input("Ingresar opción: "))

                if opcion_producto_consulta == 1:
                    self.tienda.consultar_productos_limpieza()
                elif opcion_producto_consulta == 2:
                    self.tienda.consultar_productos_electrodomestico()
                elif opcion_producto_consulta == 3:
                    self.tienda.consultar_productos_alimento()
                elif opcion_producto_consulta == 4:
                    self.tienda.consultar_productos_maquillaje()
            elif opcion == 8:
                self.tienda.realizar_compra()
            elif opcion == 9:
                self.tienda.mostrar_compras_registradas()
            elif opcion == 10:
                print("***CLIENTES***")
                self.tienda.consultar_clientes()

                print("***PRODUCTOS***")

                print("***PRODUCTOS DE LIMPIEZA***")
                if not self.tienda.productosLimpieza:
                    print("No hay productos de limpieza registrados.")
                else:
                    self.tienda.consultar_productos_limpieza()

                print("***PRODUCTOS DE ELECTRODOMESTICOS***")
                if not self.tienda.productosElectrodomestico:
                    print("No hay productos de electrodomésticos registrados.")
                else:
                    self.tienda.consultar_productos_electrodomestico()

                print("***PRODCUTOS DE ALIMENTOS***")
                if not self.tienda.productosAlimento:
                    print("No hay productos de alimentos registrados.")
                else:
                    self.tienda.consultar_productos_alimento()

                print("***PRODCUTOS DE MAQUILLAJE***")
                if not self.tienda.productosMaquillaje:
                    print("No hay productos de maquillaje registrados.")
                else:
                    self.tienda.consultar_productos_maquillaje()

            elif opcion == 11:
                print("*** HAZ SELECCIONADO LA OPCION DE ELIMINAR PRODUCTO \n")
                print("Seleccione la categoría del producto a eliminar:")
                print("1. Limpieza")
                print("2. Maquillaje")
                print("3. Alimento")
                print("4. Electrodoméstico")
                opcion_categoria = int(input())

                if opcion_categoria == 1:
                    lista_productos = self.tienda.productosLimpieza
                elif opcion_categoria == 2:
                    lista_productos = self.tienda.productosMaquillaje
                elif opcion_categoria == 3:
                    lista_productos = self.tienda.productosAlimento
                elif opcion_categoria == 4:
                    lista_productos = self.tienda.productosElectrodomestico
                else:
                    print("Opción inválida.")
                    continue

                id_producto = int(input("Ingrese el ID del producto a eliminar: "))
                self.tienda.eliminar_producto_por_categoria(lista_productos, id_producto)

            elif opcion == 12:
                 print("*** HAZ SELECCIONADO LA OPCION DE ELIMINAR CLIENTE \n")
                 id_cliente_eliminar = int(input("Ingrese el ID del cliente a eliminar: "))
                 self.tienda.eliminar_cliente(id_cliente_eliminar)
            elif opcion == 13:
                 print("Saliendo del programa....")

            else:
                 print("Ingresa una opción válida por favor :D\n")
