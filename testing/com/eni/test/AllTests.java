package com.eni.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CoffreFortTestAjout.class, CoffreFortTestFermeture.class, CoffreFortTestOuverture.class,
		CoffreFortTestRetrait.class })
public class AllTests {

}
