class Banco:
    def __init__(self):
        self.empleados = []

    def agregar_empleado(self, empleado):
        self.empleados.append(empleado)

    def mostrar_todos_los_usuarios(self):
        print("Información de todos los usuarios:")
        for empleado in self.empleados:
            print(empleado.get_data())
            for cuenta in empleado.get_accounts():
                print("  " + cuenta.get_account_info())
            print()

    def mostrar_informacion_usuario(self, nombre):
        for empleado in self.empleados:
            if empleado.get_name() == nombre:
                print(empleado.get_data())
                for cuenta in empleado.get_accounts():
                    print("  " + cuenta.get_account_info())
                return
        print("Usuario no encontrado.")

    def listar_todas_las_cuentas(self):
        print("Listado de todas las cuentas bancarias:")
        for empleado in self.empleados:
            for cuenta in empleado.get_accounts():
                print(cuenta.get_account_info())

    def mostrar_informacion_cuenta(self, numero_cuenta):
        for empleado in self.empleados:
            for cuenta in empleado.get_accounts():
                if cuenta.get_account_number() == numero_cuenta:
                    print(cuenta.get_account_info())
                    return
        print("Cuenta no encontrada.")





# Ejemplo de uso:
# banco = Banco()
# empleado1 = Employee("Juan Perez", 35, 60000, 123456789)
# empleado2 = Employee("Maria Rodriguez", 28, 75000, 987654321)
# banco.agregar_empleado(empleado1)
# banco.agregar_empleado(empleado2)
# banco.mostrar_todos_los_usuarios()
# banco.mostrar_informacion_usuario("Juan Perez")
# banco.listar_todas_las_cuentas()
# banco.mostrar_informacion_cuenta(123456789)
