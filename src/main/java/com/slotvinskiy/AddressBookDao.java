package com.slotvinskiy;

import java.util.Iterator;

public class AddressBookDao {
    private static AddressBook addressBook;
    private static AddressBookDao addressBookDao= null;

    private AddressBookDao() {
        addressBook = AddressBook.getInstance();
    }

    public static AddressBookDao getInstance() {
        if (addressBookDao == null) {
            return new AddressBookDao();
        } else {
            return addressBookDao;
        }
    }

    public boolean create(String firstName, String lastName, String address) {
        return addressBook.create(firstName, lastName, address);
    }

    public boolean update(String firstName, String lastName, String address) {
        return addressBook.update(firstName, lastName, address);
    }

    public boolean delete(String firstName, String lastName) {
        return addressBook.delete(firstName, lastName);
    }

    public String read(String firstName, String lastName) {
        return addressBook.read(firstName, lastName);
    }

    public String[] readAll() {
        Iterator iterator = addressBook.iterator();
        String[] records = new String[addressBook.size()];
        int i = 0;
        while (iterator.hasNext()) {
            records[i++] = (String) iterator.next();
        }
        return records;
    }

    public void sort(SortOrder sortOrder) {
        addressBook.sortedBy(sortOrder);
    }
}
