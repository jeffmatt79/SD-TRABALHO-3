import requests

URL = 'http://localhost:8080/funcionarios'

def listar_funcionarios():
    response = requests.get(URL)
    if response.ok:
        print("Lista de funcionários:")
        print(response.json())
    else:
        print("Erro ao listar:", response.status_code)

def cadastrar_funcionario(nome, cargo):
    funcionario = {
        "nome": nome,
        "cargo": cargo
    }
    response = requests.post(URL, json=funcionario)
    if response.ok:
        print("Funcionário cadastrado:", response.text)
    else:
        print("Erro ao cadastrar:", response.status_code)

if __name__ == "__main__":
    cadastrar_funcionario("Ana", "125")
    listar_funcionarios()

