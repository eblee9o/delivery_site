async function loadStores() {
    const response = await fetch("/api/stores");
    const stores = await response.json();
    const tableBody = document.getElementById("storeTableBody");

    tableBody.innerHTML = "";

    stores.forEach(store => {
        const row = document.createElement("tr");


        row.innerHTML = `
            <td>${store.id}</td>
            <td>${store.name}</td>
            <td>${store.category}</td>
            <td>
                <button onclick="goToStoreDetail(${store.id})">주문하기</button>
            </td>
        `;

        tableBody.appendChild(row);
    });
}

function goToStoreDetail(storeId) {
    location.href = `/store-detail.html?storeId=${storeId}`;
}

loadStores();