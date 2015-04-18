package controllers;
 
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({MoveTableauToFoundationControllerTest.class, MoveWasteToTableauControllerTest.class, MoveWasteToFoundationControllerTest.class, MoveDeckToWasteControllerTest.class, StartGameControllerTest.class})
public class AllTest {

}