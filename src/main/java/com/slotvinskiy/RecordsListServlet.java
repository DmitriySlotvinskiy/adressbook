package com.slotvinskiy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records/list")
public class RecordsListServlet extends HttpServlet {

    private AddressBookDao addressBookDao;

    @Override
    public void init() throws ServletException {
        addressBookDao = AddressBookDao.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/records-list.jsp");
        String sortMethod = request.getParameter("sort");
        if (sortMethod != null) {
            if (sortMethod.equals("asc")) {
                addressBookDao.sort(SortOrder.ASC);
            } else {
                addressBookDao.sort(SortOrder.DESC);
            }
        }
        request.setAttribute("records", addressBookDao.readAll());
        requestDispatcher.forward(request, response);
    }
}