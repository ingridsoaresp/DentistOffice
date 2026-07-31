<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.dentistoffice.Patient" %>

<%
    Patient p = (Patient) session.getAttribute("patient");

    String userId = "Unknown";

    if (p != null) {
        userId = p.getPatId();
    }
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login Error</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; background: #f4f6f8; color: #222; }
        main { max-width: 700px; margin: 40px auto; padding: 0 18px; }
        .card { background: white; border-radius: 12px; padding: 35px; box-shadow: 0 4px 14px rgba(0,0,0,.08); text-align: center; }
        img { width: 220px; max-width: 100%; height: auto; display: block; margin: 0 auto 18px; }
        h1 { color: #b42318; margin-bottom: 10px; }
        h2 { color: #0b3a66; margin-bottom: 8px; }
        p { color: #555; margin-bottom: 24px; font-size: 17px; }
        a.button { background: #16a6b6; color: white; padding: 12px 22px; text-decoration: none; border-radius: 8px; font-weight: bold; display: inline-block; }
        a.button:hover { background: #118c99; }
        footer { text-align: center; padding: 18px; color: #666; font-size: 14px; }
    </style>
</head>
<body>

<main>
    <div class="card">

        <img src="images/dentistlogo.png" alt="Dentist Office Logo" />

        <h1>Login Error</h1>

        <h2>Invalid Login Attempt</h2>

        <p>
            User with ID <strong><%= userId %></strong>, invalid password or account not found.
        </p>

        <a class="button" href="login.jsp">Back to Login</a>

    </div>
</main>

<footer>
    © 2026 Dentist Office. All rights reserved.
</footer>

</body>
</html>