class BankAccount:
    def __init__(self, account_number):
        self.account_number = account_number
        self.amount = 0.0

    def get_account_number(self):
        return self.account_number

    def get_amount(self):
        return self.amount

    def set_amount(self, amount):
        self.amount = amount

    def get_account_info(self):
        return f"Número de cuenta: {self.get_account_number()}, Saldo: {self.get_amount()}"



# Ejemplo de uso:
# account1 = BankAccount(123456789)
# account1.set_amount(1000.50)
# print(account1.get_account_info())
