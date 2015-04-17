package klondike;
 
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({MoveWasteToFoundationControllerTest.class, MoveDeckToWasteControllerTest.class, StartGameControllerTest.class})
public class AllTest {

}