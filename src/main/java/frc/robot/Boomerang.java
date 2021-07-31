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


}
