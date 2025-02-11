function confirmarExclusao() {
  if (confirm("Tem certeza que deseja excluir este cliente?")) {
    alert("Cliente excluído!");
  }
}

document.addEventListener("DOMContentLoaded", async function () {
  try {
    const response = await fetch("/api/clientes");
    if (!response.ok) {
      throw new Error("Erro ao buscar clientes");
    }
    const clientes = await response.json();

    const clientesTableBody = document.getElementById("clientes");
    clientes.forEach((cliente, index) => {
      const row = document.createElement("tr");

      row.innerHTML = `
        <td class="border p-2 text-center">${index + 1}</td>
        <td class="border p-2 text-blue-500 underline cursor-pointer">${
          cliente.nome
        }</td>
        <td class="border p-2 text-center">${cliente.telefone}</td>
        <td class="border p-2 text-center">${cliente.whatsapp}</td>
        <td class="border p-2 text-center">${new Date(
          cliente.nascimento
        ).toLocaleDateString("pt-BR")}</td>
        <td class="border p-2 text-center">
          <button class="bg-yellow-500 text-white px-3 py-1 rounded hover:bg-yellow-600">Editar</button>
          <button class="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600" onclick="confirmarExclusao()">Excluir</button>
          <button class="bg-green-500 text-white px-3 py-1 rounded hover:bg-green-600">Agendar</button>
        </td>
      `;

      clientesTableBody.appendChild(row);
    });
  } catch (error) {
    console.error("Erro ao buscar clientes", error);
  }
});
