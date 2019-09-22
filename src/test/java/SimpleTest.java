

import org.junit.Test;
import simpleshop.entity.User;
import java.util.concurrent.Callable;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class SimpleTest extends BaseTest{

    private User saveTestClient(final String role, final String name, final String password) {
        return performTransaction(new Callable<User>() {
            public User call() throws Exception {
                User client = new User(role, name, password);
                em.persist(client);
                return client;
            }
        });
    }

    @Test
    public void testPersistAndFind() {
        User client = saveTestClient("client", "client", "client");

        long id = client.getId();
        assertTrue(id > 0);

        // find existing
        User other = em.find(User.class, id);
        assertNotNull(other);
        assertEquals(client.getLogin(), other.getLogin());
        assertEquals(client.getPassword(), other.getPassword());
//
//        // clear context
//        em.clear();
//
//        // entity was already loaded by find()
//        other = em.getReference(User.class, id);
//        assertNotNull(other);
//        assertEquals(client.getLogin(), other.getLogin());
//        assertEquals(client.getPassword(), other.getPassword());
    }
}


