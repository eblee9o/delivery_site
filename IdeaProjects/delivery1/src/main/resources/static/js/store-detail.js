const params = new URLSearchParams(window.location.search);
const storeId = params.get("storeId");

const storeIdText = document.getElementById("storeIdText");
const menuTableBody = document.getElementById("menuTableBody");
const cartMessage = document.getElementById("cartMessage");
const errorMessage = document.getElementById("errorMessage");

console.log("현재 URL:", window.location.href);
console.log("읽어온 storeId:", storeId);

if (!storeId) {
    errorMessage.textContent = "storeId가 없습니다. 가게 목록에서 다시 진입해주세요.";
} else {
    storeIdText.textContent = "선택한 가게 ID: " + storeId;
    loadMenus();
}

async function loadMenus() {
    try {
        const url = `/api/stores/${storeId}/menus`;
        console.log("호출할 API:", url);

        const response = await fetch(url);
        console.log("응답 상태:", response.status);

        if (!response.ok) {
            throw new Error("메뉴 조회 실패: " + response.status);
        }

        const menus = await response.json();
        console.log("받아온 메뉴 데이터:", menus);

        menuTableBody.innerHTML = "";

        if (!menus || menus.length === 0) {
            menuTableBody.innerHTML = `
                <tr>
                    <td colspan="5">등록된 메뉴가 없습니다.</td>
                </tr>
            `;
            return;
        }

        menus.forEach(menu => {
            const row = document.createElement("tr");

            row.innerHTML = `
                <td>
                    <img class="menu-image" src="${menu.imageUrl}" alt="${menu.name}">
                </td>
                <td>${menu.name}</td>
                <td>${Number(menu.price).toLocaleString()}원</td>
                <td>${menu.amount}</td>
                <td>
                    <button class="cart-btn" onclick="addToCart(${menu.id}, '${menu.name}')">
                        장바구니 담기
                    </button>
                </td>
            `;

            menuTableBody.appendChild(row);
        });
    } catch (error) {
        console.error("에러 발생:", error);
        errorMessage.textContent = "메뉴를 불러오지 못했습니다: " + error.message;
    }
}

function addToCart(menuId, menuName) {
    cartMessage.textContent = menuName + " 메뉴가 장바구니에 담겼습니다.";
}