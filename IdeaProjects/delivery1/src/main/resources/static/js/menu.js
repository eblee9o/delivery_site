const params = new URLSearchParams(window.location.search);
const storeId = params.get("storeId");

const storeIdText = document.getElementById("storeIdText");
const menuListContainer = document.getElementById("menuListContainer");
const cartMessage = document.getElementById("cartMessage");
const errorMessage = document.getElementById("errorMessage");

console.log("현재 URL:", window.location.href);
console.log("읽어온 storeId:", storeId);

if (!storeId) {
    if (errorMessage) {
        errorMessage.textContent = "storeId가 없습니다. index 페이지에서 다시 진입해주세요.";
    }
} else {
    if (storeIdText) {
        storeIdText.textContent = `선택한 가게 ID: ${storeId}`;
    }
    loadMenus();
}

async function loadMenus() {
    try {
        const url = `/api/stores/${storeId}/menus`;
        console.log("호출할 API URL:", url);

        const response = await fetch(url);
        console.log("응답 상태:", response.status);

        if (!response.ok) {
            throw new Error("메뉴 조회 실패: " + response.status);
        }

        const menus = await response.json();
        console.log("받아온 메뉴 데이터:", menus);

        if (!menuListContainer) {
            throw new Error("menuListContainer 요소를 찾을 수 없습니다.");
        }

        menuListContainer.innerHTML = "";

        if (!menus || menus.length === 0) {
            menuListContainer.innerHTML = `
                <div class="col-12 text-center">
                    <p>등록된 메뉴가 없습니다.</p>
                </div>
            `;
            return;
        }

        menus.forEach(menu => {
            const col = document.createElement("div");
            col.className = "col-lg-4 col-md-6 col-12";

            col.innerHTML = `
                <div class="menu-thumb">
                    <div class="menu-image-wrap">
                        <img src="${menu.imageUrl}" class="img-fluid menu-image" alt="${menu.name}">
                        <span class="menu-tag bg-warning">수량 ${menu.amount}</span>
                    </div>

                    <div class="menu-info d-flex flex-wrap align-items-center">
                        <h4 class="mb-0">${menu.name}</h4>

                        <span class="price-tag bg-white shadow-lg ms-4">
                            <small>₩</small>${Number(menu.price).toLocaleString()}
                        </span>

                        <div class="d-flex flex-wrap align-items-center w-100 mt-2">
                            <p class="reviews-text mb-0">재고 ${menu.amount}개</p>
                        </div>

                        <div class="w-100 mt-3">
                            <button
                                class="custom-btn btn btn-danger w-100 add-cart-btn"
                                data-menu-id="${menu.id}"
                                data-menu-name="${menu.name}"
                                data-menu-price="${menu.price}"
                                data-menu-image="${menu.imageUrl}">
                                장바구니 담기
                            </button>
                        </div>
                    </div>
                </div>
            `;

            menuListContainer.appendChild(col);
        });

        bindCartButtons();
    } catch (error) {
        console.error("에러 발생:", error);
        if (errorMessage) {
            errorMessage.textContent = "메뉴를 불러오지 못했습니다: " + error.message;
        }
    }
}

function bindCartButtons() {
    const buttons = document.querySelectorAll(".add-cart-btn");

    buttons.forEach(button => {
        button.addEventListener("click", function () {
            const menu = {
                id: Number(this.dataset.menuId),
                name: this.dataset.menuName,
                price: Number(this.dataset.menuPrice),
                imageUrl: this.dataset.menuImage,
                storeId: Number(storeId),
                quantity: 1
            };

            addToCart(menu);
        });
    });
}

function addToCart(menu) {
    const cart = JSON.parse(localStorage.getItem("cart")) || [];
    const existing = cart.find(item => item.id === menu.id);

    if (existing) {
        existing.quantity += 1;
    } else {
        cart.push(menu);
    }

    localStorage.setItem("cart", JSON.stringify(cart));

    if (cartMessage) {
        cartMessage.textContent = `${menu.name} 메뉴가 장바구니에 담겼습니다.`;
    }
}