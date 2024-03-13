from Banco import Banco
from Employee import Employee
from BankAccount import BankAccount

def main():
    banco = Banco()

    while True:
        print("\nMenu:")
        print("1. Agregar empleado con cuenta bancaria")
        print("2. Mostrar a todos los usuarios con su información")
        print("3. Mostrar la información de algún usuario en específico")
        print("4. Listar todas las cuentas bancarias existentes")
        print("5. Mostrar información de alguna cuenta bancaria en específico")
        print("6. Salir")

        opcion = int(input("Ingrese la opción: "))

        if opcion == 1:
            nombre = input("Ingrese el nombre del empleado: ")
            edad = int(input("Ingrese la edad del empleado: "))
            salario = float(input("Ingrese el salario del empleado: "))
            num_cuentas = int(input("Ingrese la cantidad de cuentas bancarias para el empleado: "))

            empleado = Employee(nombre, edad, salario)
            for _ in range(num_cuentas):
                numero_cuenta = int(input("Ingrese el número de cuenta bancaria: "))
                empleado.add_account(BankAccount(numero_cuenta))

            banco.agregar_empleado(empleado)
            print("Empleado y cuentas bancarias agregados con éxito.")
        elif opcion == 2:
            banco.mostrar_todos_los_usuarios()
        elif opcion == 3:
            nombre_usuario = input("Ingrese el nombre del usuario: ")
            banco.mostrar_informacion_usuario(nombre_usuario)
        elif opcion == 4:
            banco.listar_todas_las_cuentas()
        elif opcion == 5:
            numero_cuenta = int(input("Ingrese el número de cuenta bancaria: "))
            banco.mostrar_informacion_cuenta(numero_cuenta)
        elif opcion == 6:
            print("Saliendo del programa. ¡Hasta luego!")
            break
        else:
            print("Opción no válida. Por favor, elija una opción válida.")

if __name__ == "__main__":
    main()