import requests

URL = 'http://localhost:8080/funcionarios'

def listar_funcionarios():
    response = requests.get(URL)
    if response.ok:
        funcionarios = response.json()
        if not funcionarios:
            print("\nNenhum funcionário cadastrado.\n")
        else:
            print("\nLista de funcionários:")
            for f in funcionarios:
                print(f"ID: {f.get('id', '?')}, Nome: {f.get('nome')}, Cargo: {f.get('tipo')}")
            print()
    else:
        print("Erro ao listar:", response.status_code)

def cadastrar_funcionario():
    nome = input("Digite o nome do funcionário: ").strip()
    cargo = input("Digite o cargo do funcionário: ").strip()
 
    funcionario = {
        "nome": nome,
        "id": 1,
        "tipo": cargo
    }

    response = requests.post(URL, json=funcionario)
    if response.ok:
        print("\nFuncionário cadastrado com sucesso!\n")
    else:
        print("\nErro ao cadastrar:", response.status_code)

def menu():
    while True:
        print("=== Menu ===")
        print("1. Listar funcionários")
        print("2. Cadastrar novo funcionário")
        print("3. Sair")

        escolha = input("Escolha uma opção: ").strip()

        if escolha == "1":
            listar_funcionarios()
        elif escolha == "2":
            cadastrar_funcionario()
        elif escolha == "3":
            print("Saindo...")
            break
        else:
            print("Opção inválida. Tente novamente.\n")

if __name__ == "__main__":
    menu()
