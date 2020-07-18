package com.slotvinskiy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/update")
public class UpdateRecordServlet extends HttpServlet {

    private AddressBookDao addressBookDao;

    private String firstName;
    private String lastName;

    @Override
    public void init() throws ServletException {
        addressBookDao = AddressBookDao.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        firstName = request.getParameter("first-name");
        lastName = request.getParameter("last-name");
        request.setAttribute("first-name", firstName);
        request.setAttribute("last-name", lastName);
        if (addressBookDao.read(firstName, lastName) == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            request.getRequestDispatcher("/WEB-INF/no-such-record-error.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/update-record.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = request.getParameter("address");
        addressBookDao.update(firstName, lastName, address);
        response.sendRedirect("/records/list");
    }
}
