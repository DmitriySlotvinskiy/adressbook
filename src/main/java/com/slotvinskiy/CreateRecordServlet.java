package com.slotvinskiy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/create")
public class CreateRecordServlet extends HttpServlet {

    private AddressBookDao addressBookDao;

    @Override
    public void init() throws ServletException {
        addressBookDao = AddressBookDao.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/create-record.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        boolean isCreated = false;
        if (!firstName.isBlank() && !lastName.isBlank() && !address.isBlank()) {
            isCreated = addressBookDao.create(firstName, lastName, address);
        }

        if (!isCreated) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            request.setAttribute("error", "Ann error occurred! Please try again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/create-record.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/records/list");
        }

    }
}
