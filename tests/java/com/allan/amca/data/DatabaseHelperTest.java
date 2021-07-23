package com.allan.amca.data;

import com.allan.amca.data.DatabaseHelper;
import com.allan.amca.user.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class DatabaseHelperTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void onCreate() {
    }

    @Test
    void addClient() {
        final DatabaseHelper db = DatabaseHelper.getInstance();
        final Client client1 = new Client("Allan", "Aranzaso", "allanaranzaso");
        final Client client2 = new Client("Jungkook", "Jeon", "jeonjungkookkkk4");

        db.addClient(client1);
        db.addClient(client2);

//        assertFalse(db.checkIfClientExists(451901L));
//        assertTrue(db.checkIfClientExists(client2.getClientID()));

    }

    @Test
    void updateClient() {
    }

    @Test
    void deleteClient() {
    }
}