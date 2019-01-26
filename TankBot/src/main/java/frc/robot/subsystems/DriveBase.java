/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DriveDefault;

/**
 * Add your docs here.
 */
public class DriveBase extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX rightT = new WPI_TalonSRX(3);
  private WPI_TalonSRX rightFollower = new WPI_TalonSRX(4);

  private WPI_TalonSRX leftT = new WPI_TalonSRX(1);
  private WPI_TalonSRX leftFollower = new WPI_TalonSRX(2);

  //private PIDController speedController;

  public void drive(double left, double right) {
    this.rightT.set(ControlMode.PercentOutput, right);
    //this.rightFollower.set(ControlMode.PercentOutput, right);
    this.rightFollower.set(ControlMode.Follower, rightT.getMotorOutputPercent());
    
    this.leftT.set(ControlMode.PercentOutput, left);
    //this.leftFollower.set(ControlMode.PercentOutput, left);
    this.leftFollower.set(ControlMode.Follower, leftT.getMotorOutputPercent());
  }

  public void stop() {
    this.rightT.set(ControlMode.PercentOutput, 0.0);
    this.rightFollower.set(ControlMode.PercentOutput, 0.0);
    
    this.leftT.set(ControlMode.PercentOutput, 0.0);
    this.leftFollower.set(ControlMode.PercentOutput, 0.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveDefault());
  }
}
