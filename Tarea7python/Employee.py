class BankAccount:
    def __init__(self, account_number):
        self.account_number = account_number


class Employee:
    def __init__(self, name, age, salary):
        self.name = name
        self.age = age
        self.salary = salary
        self.accounts = []

    def get_name(self):
        return self.name

    def get_age(self):
        return self.age

    def get_salary(self):
        return self.salary

    def get_accounts(self):
        return self.accounts

    def get_data(self):
        return f"Nombre: {self.get_name()}, Edad: {self.get_age()}, Salario: {self.get_salary()}"

    def add_account(self, account):
        self.accounts.append(account)


# Ejemplo de uso:
# employee1 = Employee("John Doe", 30, 50000)
# employee2 = Employee("Jane Smith", 25, 60000, 123456789)
# print(employee1.get_data())
# print(employee2.get_data())
