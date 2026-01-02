<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
    <style>
        /* General page styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8; /* light gray background */
            margin: 0;
            padding: 0;
        }

        /* Navigation bar */
        nav {
            background-color: #007bff;
            color: white;
            padding: 15px;
            display: flex;
            justify-content: space-between;
        }
        nav a {
            color: white;
            text-decoration: none;
            margin: 0 10px;
            font-weight: bold;
        }
        nav a:hover {
            text-decoration: underline;
        }

        /* Container */
        .container {
            width: 80%;
            margin: 30px auto;
            background: white;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        /* Form styling */
        form input[type="text"],
        form input[type="email"],
        form input[type="number"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 20px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        form input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
        }
        form input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* Table styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #007bff;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        /* Footer spacing */
        .footer {
            margin-top: 20px;
            text-align: center;
            font-size: 14px;
            color: #666;
        }
    </style>
</head>
<body>

<nav>
    <div>Student Management</div>
    <div>
        <a href="index.jsp">Register</a>
        <a href="show_all">Students List</a>
    </div>
</nav>

<div class="container">
    <h2>Register Student</h2>

    <form action="register" method="post">
        Name:
        <input type="text" name="name" required placeholder="Enter full name">

        Email:
        <input type="email" name="email" required placeholder="Enter a valid email">

        Year:
        <input type="number" name="year" required min="1" max="5" placeholder="1 - 5">

        <input type="submit" value="Register">
    </form>
</div>

</body>
</html>
