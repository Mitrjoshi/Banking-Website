<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Profile</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"
    />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@300;400&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="icons.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400&display=swap"
      rel="stylesheet"
    />

    <style>
      /* Custom CSS */
      body {
        background-color: #141414;
        color: #fff;
        font-family: montserrat;
      }

      .nav-link {
        color: #fff;
      }

      .nav-link:hover {
        color: #fff;
        background-color: #111;
      }

      .material-symbols-outlined {
        font-variation-settings: "FILL" 1, "wght" 600, "GRAD" 0, "opsz" 48;
      }

      .navbar-nav {
        display: flex;
        flex-direction: column;
      }

      .dropdown-menu li {
        background-color: #316d3a;
        border: none;
      }

      .nav-link {
        width: 300px;
        height: 60px;
        display: flex;
        align-items: center;
        background-color: #44444420;
        border: solid;
        border-radius: 10px;
        border-width: 1px;
        border-color: #4e4e4e;
      }
    </style>
  </head>

  <body>
    <% HttpSession Session = request.getSession(); String profileName = (String)
    Session.getAttribute("username"); String cardNumber = (String)
    Session.getAttribute("cardNumber"); String expirydate = (String)
    Session.getAttribute("expirydate"); String cardHolder = (String)
    Session.getAttribute("cardHolder"); int newBalance = (Integer)
    Session.getAttribute("newBalance"); String invested = (String)
    Session.getAttribute("invested"); %>

    <nav
      class="navbar"
      style="background-color: #316d3a; position: sticky; top: 0; z-index: 1000"
    >
      <div class="container">
        <div>
          <button class="btn">
            <span
              type="button"
              style="color: white; border: none; font-size: 35px"
              data-bs-toggle="offcanvas"
              data-bs-target="#offcanvasExample"
              aria-controls="offcanvasExample"
              class="material-symbols-outlined"
            >
              menu
            </span>
          </button>

          <div
            class="offcanvas offcanvas-start"
            tabindex="-1"
            id="offcanvasExample"
            aria-labelledby="offcanvasExampleLabel"
          >
            <div class="offcanvas-header" style="background-color: #080808">
              <h5 class="offcanvas-title mt-2 mb-2" id="offcanvasExampleLabel">
                Mumbo Jumbo Bank
              </h5>
              <button
                type="button"
                class="material-symbols-outlined d-grid justify-content-center align-content-center"
                data-bs-dismiss="offcanvas"
                style="background-color: #080808; color: white; border: none"
              >
                close
              </button>
            </div>

            <div class="offcanvas-body" style="background-color: #141414">
              <ul class="d-block navbar-nav mb-2 mb-lg-0">
                <div class="col d-flex mt-1">
                  <span
                    class="material-symbols-outlined d-grid justify-content-center align-content-center"
                    style="margin-right: 20px"
                  >
                    home
                  </span>
                  <li class="nav-item" style="color: aliceblue">
                    <a
                      class="nav-link"
                      style="padding-left: 15px"
                      href="homepage.html"
                      >Home</a
                    >
                  </li>
                </div>

                <div class="col d-flex mt-3">
                  <span
                    class="material-symbols-outlined d-grid justify-content-center align-content-center"
                    style="margin-right: 20px"
                  >
                    call
                  </span>
                  <li class="nav-item" style="color: aliceblue">
                    <a class="nav-link" style="padding-left: 15px" href="#"
                      >Contact Us</a
                    >
                  </li>
                </div>

                <div class="col d-flex mt-3">
                  <span
                    class="material-symbols-outlined d-grid justify-content-center align-content-center"
                    style="margin-right: 20px"
                  >
                    paid
                  </span>
                  <li class="nav-item" style="color: aliceblue">
                    <a
                      class="nav-link"
                      style="padding-left: 15px"
                      href="payment.html"
                      >Pay</a
                    >
                  </li>
                </div>

                <div class="col d-flex mt-3">
                  <span
                    class="material-symbols-outlined d-grid justify-content-center align-content-center"
                    style="margin-right: 20px"
                  >
                    <span class="material-symbols-outlined">
                      <span class="material-symbols-outlined">
                        attach_money
                      </span>
                    </span>
                  </span>
                  <li class="nav-item" style="color: aliceblue">
                    <a
                      class="nav-link"
                      style="padding-left: 15px"
                      href="deposit.html"
                      >Deposit</a
                    >
                  </li>
                </div>

                <div class="col d-flex mt-3">
                  <span
                    class="material-symbols-outlined d-grid justify-content-center align-content-center"
                    style="margin-right: 20px"
                  >
                    <span class="material-symbols-outlined">
                      <span class="material-symbols-outlined"> savings </span>
                    </span>
                  </span>
                  <li class="nav-item" style="color: aliceblue">
                    <a
                      class="nav-link"
                      style="padding-left: 15px"
                      href="history.jsp"
                      >History</a
                    >
                  </li>
                </div>
              </ul>
            </div>
          </div>

          <a
            href="homepage.html"
            class="navbar-brand"
            style="color: aliceblue; font-size: 25px; margin-left: 10px"
            >Mumbo Jumbo Bank</a
          >
        </div>

        <div style="display: flex" class="m-2 mt-0 mb-0">
          <a
            href="profile.jsp"
            class="material-symbols-outlined d-grid justify-content-center align-content-center"
            style="
              font-size: 30px;
              margin: 5px;
              text-decoration: none;
              color: white;
            "
          >
            account_circle
          </a>
          <a
            href="settings.jsp"
            class="material-symbols-outlined d-grid justify-content-center align-content-center"
            style="
              font-size: 30px;
              margin: 5px;
              text-decoration: none;
              color: white;
            "
          >
            settings
          </a>
          <a href="login.html" class="btn btn-outline-dark" style="margin: 5px">
            Log out
          </a>
        </div>
      </div>
    </nav>

    <div
      class="jumbotron text-center d-grid justify-content-center align-content-center"
      style="margin-top: 50px; margin-bottom: 50px"
    >
      <h1>Profile</h1>
    </div>

    <hr style="margin: 0px" />

    <div class="container mb-3">
      <div class="col">
        <div class="row mt-5">
          <div
            class="col m-5 mt-0 mb-0 d-grid justify-content-center align-content-center"
          >
            <p class="mb-1">Profile</p>
            <h1 class="mt-0 mb-1"><%=profileName%></h1>
          </div>
          <div
            class="col m-5 mt-0 mb-0 d-grid justify-content-center align-content-center"
          >
            <p class="mb-1">Balance</p>
            <h1 class="mt-0">&#8377;<%=newBalance%></h1>
          </div>
          <div
            class="col m-5 mt-0 mb-0 d-grid justify-content-center align-content-center"
          >
            <p class="mb-1">Invested</p>
            <h1 class="mt-0 mb-1">&#8377;<%=invested%></h1>
          </div>

          <div
            class="col m-5 d-grid justify-content-center align-content-center"
          >
            <div
              class="card-group"
              style="
                height: 250px;
                width: 420px;
                top: 50%;
                left: 50%;
                margin-top: 0px;
                font-size: 24px;
              "
            >
              <div
                class="card"
                style="
                  border-radius: 25px;
                  background: #090909;
                  backdrop-filter: blur(30px);
                  border: 2px solid rgba(255, 255, 255, 0.1);
                  box-shadow: 0 0 40px rgba(0, 0, 0, 0.2);
                  overflow: hidden;
                "
              >
                <div class="logo">
                  <img
                    style="
                      top: 35px;
                      right: 40px;
                      width: 80px;
                      height: auto;
                      opacity: 0.8;
                      position: absolute;
                    "
                    src="https://raw.githubusercontent.com/dasShounak/freeUseImages/main/Visa-Logo-PNG-Image.png"
                    alt="Visa"
                  />
                </div>
                <div class="chip">
                  <img
                    style="
                      top: 120px;
                      left: 40px;
                      width: 50px;
                      height: auto;
                      opacity: 0.8;
                      position: absolute;
                    "
                    src="https://raw.githubusercontent.com/dasShounak/freeUseImages/main/chip.png"
                    alt="chip"
                  />
                </div>
                <div
                  class="number"
                  style="
                    left: 40px;
                    bottom: 65px;
                    top: 160px;
                    font-family: Nunito, sans-serif;
                    color: rgba(255, 255, 255, 0.8);
                    font-weight: 400;
                    letter-spacing: 2px;
                    text-shadow: 0 0 2px rgba(0, 0, 0, 0.6);
                    position: absolute;
                  "
                >
                  <%=cardNumber%>
                </div>
                <div
                  class="name"
                  style="
                    left: 40px;
                    bottom: 35px;
                    font-size: 0.6em;
                    color: rgba(255, 255, 255, 0.8);
                    font-weight: 400;
                    top: 200px;
                    letter-spacing: 2px;
                    text-shadow: 0 0 2px rgba(0, 0, 0, 0.6);
                    position: absolute;
                  "
                >
                  <%=cardHolder%>
                </div>
                <div
                  class="to"
                  style="
                    bottom: 35px;
                    right: 40px;
                    font-size: 0.6em;
                    color: rgba(255, 255, 255, 0.8);
                    font-weight: 400;
                    letter-spacing: 2px;
                    top: 200px;
                    text-shadow: 0 0 2px rgba(0, 0, 0, 0.6);
                    position: absolute;
                  "
                >
                  <%=expirydate%>
                </div>
                <div
                  class="ring"
                  style="
                    height: 500px;
                    width: 500px;
                    border-radius: 50%;
                    background: transparent;
                    border: 50px solid rgba(255, 255, 255, 0.1);
                    bottom: -250px;
                    right: -250px;
                    box-sizing: border-box;
                    position: absolute;
                  "
                ></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="container mb-5 p-5">
      <div class="row">
        <div class="col m-3 d-grid justify-content-center">
          <a
            type="button"
            style="
              background-color: #6d3164;
              color: aliceblue;
              width: 200px;
              height: 60px;
              display: flex;
              justify-content: center;
              align-items: center;
            "
            class="btn btn-lg"
            href="payment.html"
          >
            Payment
          </a>
        </div>

        <div class="col m-3 d-grid justify-content-center">
          <a
            type="button"
            style="
              background-color: #6d3164;
              color: aliceblue;
              width: 200px;
              height: 60px;
              display: flex;
              justify-content: center;
              align-items: center;
            "
            class="btn btn-lg"
            href="deposit.html"
          >
            Deposit
          </a>
        </div>

        <div class="col m-3 d-grid justify-content-center">
          <a
            href="withdrawal.html"
            type="button"
            style="
              background-color: #6d3164;
              color: aliceblue;
              width: 200px;
              height: 60px;
              display: flex;
              justify-content: center;
              align-items: center;
            "
            class="btn btn-lg"
          >
            Withdrawal
          </a>
        </div>

        <div class="col m-3 d-grid justify-content-center">
          <a
            type="button"
            href="history.jsp"
            style="
              background-color: #6d3164;
              color: aliceblue;
              width: 200px;
              height: 60px;
              display: flex;
              justify-content: center;
              align-items: center;
            "
            class="btn btn-lg"
          >
            History
          </a>
        </div>

        <div class="col m-3 d-grid justify-content-center">
          <a
            type="button"
            href="invest.html"
            style="
              background-color: #6d3164;
              color: aliceblue;
              width: 200px;
              height: 60px;
              display: flex;
              justify-content: center;
              align-items: center;
            "
            class="btn btn-lg"
          >
            Invest
          </a>
        </div>
      </div>
    </div>

    <hr style="margin: 0px" />

    <div
      style="
        background-color: #080808;
        display: grid;
        justify-content: center;
        align-items: center;
      "
    >
      <div class="container mt-0">
        <div class="row">
          <div class="col mt-5">
            <h5>Explore</h5>
            <p style="color: #555; margin-top: 5px">Investor</p>
            <p style="color: #555; margin-top: 5px">
              Regulatory Disclosure Section
            </p>
            <p style="color: #555; margin-top: 5px">RBI Awareness Campaign</p>
            <p style="color: #555; margin-top: 5px">Mumbo Jumbo Bank Answers</p>
            <p style="color: #555; margin-top: 5px">Safe Banking</p>
            <p style="color: #555; margin-top: 5px">RBI Kehta Hai</p>
            <p style="color: #555; margin-top: 5px">
              RBI: Beware of Fictitious Offers
            </p>
            <p style="color: #555; margin-top: 5px">Money Transfer to India</p>
            <p style="color: #555; margin-top: 5px">Internet Banking</p>
            <p style="color: #555; margin-top: 5px">Mobile Banking</p>
          </div>

          <div class="col mt-5">
            <h5>POPULAR PRODUCTS</h5>
            <p style="color: #555; margin-top: 5px">Savings Accounts</p>
            <p style="color: #555; margin-top: 5px">Current Accounts</p>
            <p style="color: #555; margin-top: 5px">Credit Cards</p>
            <p style="color: #555; margin-top: 5px">Home Loan</p>
            <p style="color: #555; margin-top: 5px">Car Loan</p>
            <p style="color: #555; margin-top: 5px">Gold Loan</p>
            <p style="color: #555; margin-top: 5px">Fixed Deposit</p>
          </div>

          <div class="col mt-5">
            <h5>RATES AND CHARGES</h5>
            <p style="color: #555; margin-top: 5px">Interest Rates</p>
            <p style="color: #555; margin-top: 5px">Service Charges and Fees</p>
          </div>

          <div class="col mt-5">
            <h5>OTHERS</h5>
            <p style="color: #555; margin-top: 5px">Customer Care</p>
            <p style="color: #555; margin-top: 5px">
              List of Unclaimed Accounts
            </p>
            <p style="color: #555; margin-top: 5px">Form center</p>
            <p style="color: #555; margin-top: 5px">Notice Board</p>
            <p style="color: #555; margin-top: 5px">News Room</p>
            <p style="color: #555; margin-top: 5px">Online Assist</p>
            <p style="color: #555; margin-top: 5px">
              Compliments and Complaints
            </p>
            <p style="color: #555; margin-top: 5px">Site map</p>
            <p style="color: #555; margin-top: 5px">About Us</p>
            <p style="color: #555; margin-top: 5px">
              Account activation process
            </p>
            <p style="color: #555; margin-top: 5px">
              Customer Literature on NPAs and SMAs
            </p>
          </div>
        </div>
      </div>
    </div>

    <div
      style="
        background-color: #080808;
        display: flex;
        justify-content: center;
        align-items: center;
      "
    >
      <div class="container m-4 text-center">
        <div class="row">
          <h4>Connect with us</h4>
        </div>
        <div class="col m-2">
          <span>
            <a href="#" class="fa-brands fa-facebook fa-xl m-2"></a>
          </span>
          <span>
            <a href="#" class="fa-brands fa-instagram fa-xl m-2"></a>
          </span>
          <span> <a class="fa-brands fa-linkedin fa-xl m-2"></a> </span>
          <span> <a href="#" class="fa-brands fa-twitter fa-xl m-2"></a> </span>
          <span> <a href="#" class="fa-brands fa-youtube fa-xl m-2"></a> </span>
          <span> <a href="#" class="fa-brands fa-quora fa-xl m-2"></a> </span>
        </div>
      </div>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://kit.fontawesome.com/f153892680.js"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
