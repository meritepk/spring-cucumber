package pk.merite.webapp.steps;

import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import pk.merite.webapp.WebApp;

@SpringBootTest(classes = WebApp.class)
@ContextConfiguration(classes = WebApp.class, loader = SpringBootContextLoader.class)
public class Stepdefs {

}
