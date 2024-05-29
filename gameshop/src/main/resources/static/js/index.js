/* (public static main() { */
const url = "http://localhost:8080/products";
//then()함수
//promise 연결 함수 // then은 앞쪽에 있는 promise 코드가 끝나면 실행된다. (앞에 할 일을 적는다.)
//사용예 : axios.get(url).then(할일 = 익명함수).then(할일).then(할일).catcjh(에러처리); -> 이러한 문법을 자바에서 promise then 이라고 부른다.
axios
  .get(url)
  .then((response) => {
    console.log("응답 Response : ", response);
    displayProduct(response.data);
  })
  .catch((error) => {
    console.log("에러발생 : ", error);
  });

function displayProduct(gameData) {
  console.log(gameData.length);
  if (gameData.length > 0) {
    const content = document.querySelector(".content");
    gameData.forEach((data) => {
      const game = document.createElement("div");
      game.classList.add("game");
      const img = document.createElement("img");
      img.classList.add("image");
      img.src = data.image;
      game.appendChild(img);
      const title = document.createElement("p");
      const genre = document.createElement("p");
      const price = document.createElement("p");
      title.textContent = "게임 타이틀 : " + data.title;
      genre.textContent = "게임 장르 : " + data.genre;
      price.textContent = "게임 가격 : " + data.price + "원";
      game.appendChild(title);
      game.appendChild(genre);
      game.appendChild(price);
      game.addEventListener("click", () => {
        window.location.href = "singleProduct.html?id=" + data.id;
      });
      content.appendChild(game);
    });
  }
}
