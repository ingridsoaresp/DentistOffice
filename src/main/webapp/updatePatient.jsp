<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.dentistoffice.Patient" %>

<%
    Patient p = (Patient) session.getAttribute("patient");

    if (p == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Update Patient Information</title>
    <style>
        body { font-family: 'Trebuchet MS', 'Segoe UI', sans-serif; margin: 0; background: linear-gradient(135deg, #0f9aa8, #e9f7f8); color: #222; min-height: 100vh; }
        main { max-width: 700px; margin: 40px auto; padding: 0 18px; }
        .card { background: white; border-radius: 12px; padding: 35px; box-shadow: 0 4px 14px rgba(0,0,0,.08); text-align: center; }
        img { width: 300px; max-width: 100%; height: auto; display: block; margin: 0 auto -50px; }
        h1 { color: #0b3a66; margin-top: 8px; margin-bottom: 8px; font-size: 45px; }
        h2 { color: #0b3a66; margin-top: 35px; margin-bottom: 18px; }
        p { color: #555; margin-bottom: 26px; font-size: 17px; }
        .form-group { text-align: left; margin-bottom: 18px; }
        label { display: block; margin-bottom: 6px; font-weight: bold; color: #0b3a66; }
        input { width: 100%; padding: 12px; font-size: 16px; border: 1px solid #cfd6de; border-radius: 8px; box-sizing: border-box; }
        input:focus { outline: none; border-color: #16a6b6; }
        .btn-group { margin-top: 30px; display: flex; gap: 12px; justify-content: center; flex-wrap: wrap; }
        button { width: 100%; padding: 12px; background: #16a6b6; color: white; border: none; border-radius: 8px; font-size: 16px; font-weight: bold; cursor: pointer; margin-top: 8px; }
        button:hover { background: #118c99; }
        .back-link { display: inline-block; margin-top: 18px; color: #0b3a66; text-decoration: none; font-weight: bold; }
        footer { text-align: center; padding: 18px; color: #666; font-size: 14px; }
    </style>
</head>
<body>

<main>
    <div class="card">

        <img src="images/dentistlogo.png" alt="Dentist Office Logo" />

        <h1>Update Patient Information</h1>

        <p>
            Edit your personal information below.
        </p>

        <form action="PatientUpdateServlet" method="post">

            <div class="form-group">
                <label for="firstName">First Name</label>
                <input type="text" id="firstName" name="firstName" value="<%= p.getFirstName() %>" />
            </div>

            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input type="text" id="lastName" name="lastName" value="<%= p.getLastName() %>" />
            </div>

            <div class="form-group">
                <label for="addr">Address</label>
                <input type="text" id="addr" name="addr" value="<%= p.getAddr() %>" />
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" id="email" name="email" value="<%= p.getEmail() %>" />
            </div>

            <div class="form-group">
                <label for="insCo">Insurance Company</label>
                <input type="text" id="insCo" name="insCo" value="<%= p.getInsCo() %>" />
            </div>

            <div class="btn-group">
                <button type="submit" >Update Information</button>
            </div>

        </form>

        <a class="back-link" href="patientHome.jsp">← Back to Patient Home</a>

    </div>
</main>

<footer>
    © 2026 Dentist Office. All rights reserved.
</footer>

</body>
</html>