package com.example.utilities;

import com.example.collections.Students;
import com.example.exception.ArrayListNullException;

import java.util.ArrayList;


public class CollectionsUtilities {
    // Проверка массива на инициализацию
    public static boolean isArrayListNotNull(ArrayList<Students> inArrayList) throws ArrayListNullException {
        if (inArrayList == null) {
            throw new ArrayListNullException();
        }
        return true;
    }

}
