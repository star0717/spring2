const urlLogin = "http://localhost:8080/user/login";
const urlLogout = "http://localhost:8080/user/logout";
const urlSignup = "http://localhost:8080/user/signup";
let userId = "";
let password = "";

let userEmail = "";
let userName = "";
// let signupEmail = "";
// let signupName = "";

// 유효성 검사 테스트
// let elInputUsername = document.querySelector("#signupId");
// let elInputPassword = document.querySelector("#signupPassword");
// let elSuccessMessage = document.querySelector(".success-message");
// let elFailureMessage = document.querySelector(".failure-message");

// function idLength(value) {
//   return value.length >= 4 && value.length <= 12;
// }

// function strongPassword(str) {
//   return { 4: 8 }(str);
// }

// elInputUsername.onkeyup = function () {
//   if (idLength(elInputUsername.value) === false) {
//     elSuccessMessage.classList.add("hidden");
//     elFailureMessage.classList.remove("hidden");
//   } else if (idLength(elInputUsername.value)) {
//     elSuccessMessage.classList.remove("hidden");
//     elFailureMessage.classList.add("hidden");
//   } else {
//     elSuccessMessage.classList.add("hidden");
//     elFailureMessage.classList.add("hidden");
//   }
// };

// if (elInputPassword.value.length !== 0) {
//   if (strongPassword(elInputPassword.value)) {
//     elStrongPasswordMessage.classList.add("hidden");
//   } else {
//     elStrongPasswordMessage.classList.remove("hidden");
//   }
// }

// else {
//   elStrongPasswordMessage.classList.add("hide");
// }

document.querySelector("#userId").addEventListener("change", (e) => {
  console.log(e.target.value);
  userId = e.target.value;
});
document.querySelector("#password").addEventListener("change", (e) => {
  console.log(e.target.value);
  password = e.target.value;
});

document.querySelector(".loginBtn").addEventListener("click", () => {
  const data = {
    userId: userId,
    password: password,
  };
  axios
    .post(urlLogin, data, { withCredentials: true })
    .then((response) => {
      console.log("데이터: ", response);
      sessionCurrent();
    })
    .catch((error) => {
      console.log("에러 발생: ", error);
    });
});

// 회원가입
document.querySelector("#signupId").addEventListener("change", (e) => {
  console.log(e.target.value);
  userId = e.target.value;
});
document.querySelector("#signupPassword").addEventListener("change", (e) => {
  console.log(e.target.value);
  password = e.target.value;
});
document.querySelector("#signupEmail").addEventListener("change", (e) => {
  console.log(e.target.value);
  userEmail = e.target.value;
});
document.querySelector("#signupName").addEventListener("change", (e) => {
  console.log(e.target.value);
  userName = e.target.value;
});

document.querySelector(".signupFinishBtn").addEventListener("click", () => {
  const data = {
    userId: userId,
    password: password,
    userEmail: userEmail,
    userName: userName,
  };
  axios
    .post(urlSignup, data, { withCredentials: true })
    .then((response) => {
      if (data.userId != "" && data.password != "") {
        console.log("데이터: ", response);
        confirm("회원가입이 완료되었습니다.로그인 화면으로 이동할까요?");
        location.href = "login.html";
      }
      if (data.userId == "" && data.password == "") {
        alert("아이디와 패스워드는 필수 사항입니다");
      }
    })
    .catch((error) => {
      console.log("에러 발생 나야나 ", error);
    });

  // document.getElementById("myLink").onclick = function () {
  //   location.href = "index.html";
  // };
  // if (confirm("회원가입이 완료되었습니다.로그인 화면으로 이동할까요?")) {
  //   location.href = "login.html";
  // }
});

document.querySelector(".signupBtn").addEventListener("click", () => {
  document.querySelector(".login-box").classList.add("hidden");
  document.querySelector(".signup-box").classList.remove("hidden");
});

document.querySelector(".logoutBtn").addEventListener("click", () => {
  if (confirm("로그아웃 하시겠습니까?")) {
    axios
      .post(urlLogout, {}, { withCredentials: true })
      .then((response) => {
        console.log("데이터", response);
        if (response.status == 200) {
          document.querySelector(".login-box").classList.remove("hidden");
          document.querySelector(".user-box").classList.add("hidden");
        }
      })
      .catch((error) => {
        console.log("에러 발생", error);
      });
  }
});

function sessionCurrent() {
  axios
    .get("http://localhost:8080/user/current", { withCredentials: true })
    .then((response) => {
      console.log("데이터 : ", response);
      if (response.status == 200) {
        console.log("세션유지");
        if (response.status == 200) {
          document.querySelector(".login-box").classList.add("hidden");
          document.querySelector(".user-box").classList.remove("hidden");
          document.querySelector(".user-box p").textContent =
            response.data + "님, 환영합니다.";
        }
      }
    })
    .catch((error) => {
      console.log("에러발생 : ", error);
    });
}

//js 파일이 로드 될때 호출됨
sessionCurrent();
