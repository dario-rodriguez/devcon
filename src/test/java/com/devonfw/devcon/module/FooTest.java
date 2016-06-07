package com.devonfw.devcon.module;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.devonfw.devcon.input.InputConsole;

/**
 * Class for prototype tests
 *
 * @author pparrado
 */
public class FooTest {
  InputConsole input;

  /**
   * Checks if a simple command is launched successfully
   */
  @Test
  public void simpleCommand() {

    String[] args = { "-np", "foo", "farewell" };
    this.input = new InputConsole(args);
    assertTrue(this.input.parse());
  }

  /**
   * Checks if simple command fails
   */
  @Test
  public void simpleCommandFail() {

    String[] args = { "-np", "foo", "fakeCommand" };
    this.input = new InputConsole(args);
    assertFalse(this.input.parse());
  }

  /**
   * Checks if a command with one parameter is launched successfully
   */
  @Test
  public void commandWithOneParameter() {

    String[] args = { "-np", "foo", "customFarewell", "-name", "Jason" };
    this.input = new InputConsole(args);
    assertTrue(this.input.parse());
  }

  /**
   * Checks if a command with one parameter fails
   */
  @Test
  public void commandWithOneParameterFail() {

    String[] args = { "-np", "foo", "customFarewell" };
    this.input = new InputConsole(args);
    assertFalse(this.input.parse());
  }

  /**
   * Checks if a command with wrong parameter fails
   */
  @Test
  public void commandWithWrongParameterFail() {

    String[] args = { "-np", "foo", "customFarewell", "-surname", "Jason" };
    this.input = new InputConsole(args);
    assertFalse(this.input.parse());
  }

  /**
   * Checks if a command with several parameters is launched successfully
   */
  @Test
  public void commandWithSeveralParams() {

    String[] args = { "-np", "foo", "largeCustomFarewell", "-name", "Jason", "-surname", "Lytle" };
    this.input = new InputConsole(args);
    assertTrue(this.input.parse());
  }

  /**
   * Checks if a command with less parameters than needed fails
   */
  @Test
  public void commandWithSeveralParamsFail() {

    String[] args = { "-np", "foo", "largeCustomFarewell", "-name", "Jason" };
    this.input = new InputConsole(args);
    assertFalse(this.input.parse());
  }

  @Test
  public void wrongModule() {

    String[] args = { "-np", "wrongModule", "command" };
    this.input = new InputConsole(args);
    assertFalse(this.input.parse());
  }

  /**
   * Checks if the help info of a module is launched successfully
   */
  @Test
  public void moduleHelp() {

    String[] args = { "foo", "-help" };
    this.input = new InputConsole(args);
    assertTrue(this.input.parse());
  }

  /**
   * Checks if the help info of a command is launched successfully
   */
  @Test
  public void commandHelp() {

    String[] args = { "foo", "farewell", "-h" };
    this.input = new InputConsole(args);
    assertTrue(this.input.parse());
  }

  /**
   * Checks if the help info of a command is launched successfully
   */
  @Test
  public void commandWithParametersHelp() {

    String[] args = { "foo", "largeCustomFarewell", "-h" };
    this.input = new InputConsole(args);
    assertTrue(this.input.parse());
  }

  /**
   * Checks if the help info of a wrong command fails
   */
  @Test
  public void commandHelpFail() {

    String[] args = { "foo", "fakeCommand", "-help" };
    this.input = new InputConsole(args);
    assertFalse(this.input.parse());
  }

}