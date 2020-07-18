package com.slotvinskiy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/read")
public class ReadRecordServlet extends HttpServlet {

    private AddressBookDao addressBookDao;

    @Override
    public void init() throws ServletException {
        addressBookDao = AddressBookDao.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/read-record.jsp");
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String address = addressBookDao.read(firstName, lastName);
        request.setAttribute("first-name", firstName);
        request.setAttribute("last-name", lastName);

        if (address == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            request.getRequestDispatcher("/WEB-INF/no-such-record-error.jsp").forward(request, response);
        }
        request.setAttribute("address", address);
        requestDispatcher.forward(request, response);
    }
}