// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

import org.xero1425.base.XeroRobot;
import org.xero1425.base.controllers.AutoController;
/**
 * The VM is configured to automatically run this class. If you change the name of this class or the
 * package after creating this project, you must also update the build.gradle file in the project.
 */
public class Boomerang extends XeroRobot /*extends RobotBase*/ {
  
  public Boomerang() {
    super(0.02);
  }

  public String getName() {
    return "Boomerang";
  }

  public AutoController createAutoController() {
    return null ;
  }

  protected void hardwareInit() throws Exception {
  }

  //
  // BUTCH: Note, all of the methods below here should be removed.  These are implemented
  //        in our base class XeroRobot so each new robot using our framework should not
  //        implement them.  As you move forward with this project you will add code to the
  //        hardware init.
  //
  //////////////////////////////////

  public void robotInit() {}

  public void disabled() {}

  public void autonomous() {}

  public void teleop() {}

  public void test() {}

  private volatile boolean m_exit;

  @SuppressWarnings("PMD.CyclomaticComplexity")
  @Override
  public void startCompetition() {
    robotInit();

    // Tell the DS that the robot is ready to be enabled
    HAL.observeUserProgramStarting();

    while (!Thread.currentThread().isInterrupted() && !m_exit) {
      if (isDisabled()) {
        m_ds.InDisabled(true);
        disabled();
        m_ds.InDisabled(false);
        while (isDisabled()) {
          m_ds.waitForData();
        }
      } else if (isAutonomous()) {
        m_ds.InAutonomous(true);
        autonomous();
        m_ds.InAutonomous(false);
        while (isAutonomousEnabled()) {
          m_ds.waitForData();
        }
      } else if (isTest()) {
        LiveWindow.setEnabled(true);
        Shuffleboard.enableActuatorWidgets();
        m_ds.InTest(true);
        test();
        m_ds.InTest(false);
        while (isTest() && isEnabled()) {
          m_ds.waitForData();
        }
        LiveWindow.setEnabled(false);
        Shuffleboard.disableActuatorWidgets();
      } else {
        m_ds.InOperatorControl(true);
        teleop();
        m_ds.InOperatorControl(false);
        while (isOperatorControlEnabled()) {
          m_ds.waitForData();
        }
      }
    }
  }

  @Override
  public void endCompetition() {
    m_exit = true;
  }

  /////////////////////////////////////////////

}
