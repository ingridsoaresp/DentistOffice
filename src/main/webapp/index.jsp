<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dentist Office</title>
    <style>
        body { font-family: 'Trebuchet MS', 'Segoe UI', sans-serif; margin: 0; background: linear-gradient(135deg, #0f9aa8, #e9f7f8); color: #222; min-height: 100vh; }
        main { max-width: 850px; margin: 40px auto; padding: 0 18px; }
        .card { background: white; border-radius: 12px; padding: 8px 35px 35px 35px; box-shadow: 0 4px 14px rgba(0,0,0,.08); text-align: center; }
        img { width: 300px; max-width: 100%; height: auto; display: block; margin: 0 auto -8px; }
        h1 { color: #0b3a66; margin-top: 0; margin-bottom: 8px; font-size: 45px; }
        p { color: #555; margin-bottom: 26px; font-size: 17px; }
        .options { display: flex; gap: 22px; justify-content: center; align-items: stretch; flex-wrap: wrap; margin-top: 18px; }
        .option-card { width: 280px; border: 1px solid #d9e1e6; border-radius: 12px; padding: 24px; background: #fbfdfe; display: flex; flex-direction: column; justify-content: space-between; }
        .option-card h2 { color: #0b3a66; margin-top: 0; }
        .option-card p { min-height: 70px; margin-bottom: 20px; }
        .button { background: #16a6b6; color: white; padding: 12px 22px; text-decoration: none; border-radius: 8px; font-weight: bold; display: inline-block; margin-top: auto; }
        .button:hover { background: #118c99; }
        footer { text-align: center; padding: 18px; color: white; font-size: 14px; }
    </style>
</head>
<body>

<main>
    <div class="card">

        <img src="images/dentistlogo.png" alt="Dentist Office Logo" />

        <h1>Welcome to Dentist Office</h1>

        <p>
            A simple and secure appointment system for patients and dentists.
        </p>

        <div class="options">

            <div class="option-card">
                <div>
                    <h2>Patient Portal</h2>
                    <p>
                        View your information and manage your dental appointments.
                    </p>
                </div>
                <a class="button" href="login.jsp">Patient Login</a>
            </div>

            <div class="option-card">
                <div>
                    <h2>Dentist Portal</h2>
                    <p>
                        Access dentist records and view upcoming appointments.
                    </p>
                </div>
                <a class="button" href="login.jsp">Dentist Login</a>
            </div>

        </div>

    </div>
</main>

<footer>
    © 2026 Dentist Office. All rights reserved.
</footer>

</body>
</html>