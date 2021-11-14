package facades;

import entities.User;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;
import entities.RenameMe;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Uncomment the line below, to temporarily disable this test
@Disabled
public class UserFacadeTest {

    private static EntityManagerFactory emf;
    private static UserFacade facade;

    public UserFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = UserFacade.getUserFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new User("wehba", "alltoone"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testgetVeryfiedUse() throws Exception {
        EntityManager em = emf.createEntityManager();
        User user;

            user= em.find(User.class, "alltoone");

        assertEquals(user.verifyPassword("alltoone"), "true");
    }
    

}
