const fetch = require('node-fetch');
const readline = require('readline');

const URL = 'http://localhost:8080/funcionarios';

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

function menu() {
  console.log('=== Menu ===');
  console.log('1. Listar funcionários');
  console.log('2. Cadastrar novo funcionário');
  console.log('3. Sair');
  rl.question('Escolha uma opção: ', async (opcao) => {
    switch (opcao.trim()) {
      case '1':
        await listarFuncionarios();
        menu();
        break;
      case '2':
        await cadastrarFuncionario();
        menu();
        break;
      case '3':
        console.log('Saindo...');
        rl.close();
        break;
      default:
        console.log('Opção inválida.\n');
        menu();
    }
  });
}

async function listarFuncionarios() {
  try {
    const res = await fetch(URL);
    if (res.ok) {
      const funcionarios = await res.json();
      if (!funcionarios.length) {
        console.log('\nNenhum funcionário cadastrado.\n');
      } else {
        console.log('\nLista de funcionários:');
        funcionarios.forEach(f => {
          console.log(`ID: ${f.id ?? '?'}, Nome: ${f.nome}, Cargo: ${f.tipo ?? f.cargo}`);
        });
        console.log();
      }
    } else {
      console.log('Erro ao listar:', res.status);
    }
  } catch (err) {
    console.log('Erro de conexão:', err.message);
  }
}

async function cadastrarFuncionario() {
  return new Promise((resolve) => {
    rl.question('Digite o nome do funcionário: ', (nome) => {
      rl.question('Digite o cargo do funcionário: ', async (cargo) => {
        const funcionario = {
          nome: nome.trim(),
          cargo: cargo.trim()
        };
        try {
          const res = await fetch(URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(funcionario)
          });
          if (res.ok) {
            console.log('\nFuncionário cadastrado com sucesso!\n');
          } else {
            console.log('\nErro ao cadastrar:', res.status);
          }
        } catch (err) {
          console.log('Erro de conexão:', err.message);
        }
        resolve();
      });
    });
  });
}

menu();
