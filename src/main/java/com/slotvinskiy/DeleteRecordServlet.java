package com.slotvinskiy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/delete")
public class DeleteRecordServlet extends HttpServlet {

    private AddressBookDao addressBookDao;

    @Override
    public void init() throws ServletException {
        addressBookDao = AddressBookDao.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/record-list.jsp");
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        addressBookDao.delete(firstName, lastName);
        response.sendRedirect("/records/list");
    }
}
