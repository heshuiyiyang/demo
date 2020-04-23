// BookManager.aidl
package com.android.dell.myservice;

// Declare any non-default types here with import statements
import com.android.dell.myservice.Book;

interface BookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    List<Book> getbooks();
    void addbook(in Book book);

}
