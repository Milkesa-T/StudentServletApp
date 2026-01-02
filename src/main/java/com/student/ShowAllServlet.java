package com.student;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/show_all")
public class ShowAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Students List</title>");
        out.println("<style>");
        out.println("body{font-family:Arial;background:#f4f6f8;margin:0}");
        out.println("nav{background:#007bff;color:white;padding:15px;display:flex;justify-content:space-between}");
        out.println("nav a{color:white;text-decoration:none;margin:0 10px;font-weight:bold}");
        out.println(".container{width:80%;margin:30px auto;background:white;padding:25px;border-radius:8px;box-shadow:0 0 10px rgba(0,0,0,0.1)}");
        out.println("table{width:100%;border-collapse:collapse}");
        out.println("th,td{padding:12px;border:1px solid #007bff}");
        out.println("th{background:#007bff;color:white}");
        out.println("tr:nth-child(even){background:#f2f2f2}");
        out.println(".btn{padding:8px 14px;border:none;border-radius:4px;cursor:pointer;font-weight:bold}");
        out.println(".btn-delete{background:#dc3545;color:white}");
        out.println(".btn-register{background:#28a745;color:white;text-decoration:none}");
        out.println("</style></head><body>");

        // NAV
        out.println("<nav>");
        out.println("<div>Student Management</div>");
        out.println("<div>");
        out.println("<a href='index.jsp'>Register</a>");
        out.println("<a href='show_all'>Students List</a>");
        out.println("</div></nav>");

        out.println("<div class='container'>");
        out.println("<h2>Registered Students</h2>");

        try (Connection con = DBUtil.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            out.println("<table>");
            out.println("<tr><th>Name</th><th>Email</th><th>Year</th><th>Action</th></tr>");

            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                out.println("<tr>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getInt("year") + "</td>");
                out.println("<td>");
                out.println("<form action='delete' method='post' style='margin:0'>");
                out.println("<input type='hidden' name='id' value='" + rs.getInt("id") + "'>");
                out.println("<button class='btn btn-delete'>Remove</button>");
                out.println("</form>");
                out.println("</td>");
                out.println("</tr>");
            }

            if (!hasData) {
                out.println("<tr><td colspan='4'>No students registered</td></tr>");
            }

            out.println("</table>");

        } catch (Exception e) {
            out.println("<p style='color:red'>Error loading students</p>");
        }

        // REGISTER BUTTON
        out.println("<br>");
        out.println("<a href='index.jsp' class='btn btn-register'>➕ Register New Student</a>");

        out.println("</div></body></html>");
    }
}
