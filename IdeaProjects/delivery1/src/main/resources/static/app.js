let selectedStoreId = null;

document.addEventListener("DOMContentLoaded", async () => {
    await loadStores();
});

async function loadStores() {
    const response = await fetch("/api/stores");
    const stores = await response.json();

    const storeList = document.getElementById("storeList");
    storeList.innerHTML = "";

    stores.forEach(store => {
        const button = document.createElement("button");
        button.textContent = `${store.id}. ${store.name}`;
        button.onclick = () => loadMenus(store.id, store.name);
        storeList.appendChild(button);
    });
}

async function loadMenus(storeId, storeName) {
    selectedStoreId = storeId;

    const response = await fetch(`/api/stores/${storeId}/menus`);
    const menus = await response.json();

    document.getElementById("menuTitle").textContent = `${storeName} 메뉴 목록`;

    const tbody = document.getElementById("menuTableBody");
    tbody.innerHTML = "";

    if (menus.length === 0) {
        tbody.innerHTML = `<tr><td colspan="4">메뉴가 없습니다.</td></tr>`;
        return;
    }

    menus.forEach(menu => {
        const tr = document.createElement("tr");

        tr.innerHTML = `
            <td>${menu.id}</td>
            <td>${menu.name}</td>
            <td>${menu.price.toLocaleString()}원</td>
            <td>
                <button class="order-btn" onclick="createOrder(${storeId}, ${menu.id}, '${menu.name}')">
                    주문하기
                </button>
            </td>
        `;

        tbody.appendChild(tr);
    });
}

async function createOrder(storeId, menuId, menuName) {
    const response = await fetch("/api/orders", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            storeId: storeId,
            menuId: menuId,
            quantity: 1
        })
    });

    const result = await response.json();

    document.getElementById("orderResult").innerHTML = `
        <strong>주문 성공</strong><br>
        메시지: ${result.message}<br>
        가게 ID: ${result.storeId}<br>
        메뉴 ID: ${result.menuId}<br>
        메뉴명: ${menuName}<br>
        수량: ${result.quantity}
    `;
}