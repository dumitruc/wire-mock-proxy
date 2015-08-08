package com.dumitruc.exercises;


import com.dumitruc.exercises.stepdefs.StepDefBase;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dumitruc on 12/12/2014.
 */
public class Hooks extends StepDefBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setup(Scenario scenario){
        LOGGER.info("Before scenario = " + scenario.getId());
    }
}
