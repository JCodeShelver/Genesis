// BlitzCreek 3770 - Genesis Project
// DriveSystem Subsystem
// Controlls the drivetrain

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Counter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

import frc.robot.Constants;

public class DriveSystem extends SubsystemBase
{
  private TalonSRX leftMotor1, leftMotor2;
  private TalonSRX rightMotor1, rightMotor2;
  private Counter leftEncoder, rightEncoder;
  
  public DriveSystem()
  {
    leftMotor1  = new TalonSRX(Constants.LEFT_MOTOR1_CAN_ID);
    leftMotor2  = new TalonSRX(Constants.LEFT_MOTOR2_CAN_ID);
    rightMotor1 = new TalonSRX(Constants.RIGHT_MOTOR1_CAN_ID);
    rightMotor2 = new TalonSRX(Constants.RIGHT_MOTOR2_CAN_ID);

    leftEncoder = new Counter(Constants.LT_ENCODER_CAN_ID);
    rightEncoder = new Counter(Constants.RT_ENCODER_CAN_ID);
  }

  public void drive(double left, double right)
  {
    leftMotor1.set(ControlMode.PercentOutput, left);
    leftMotor2.set(ControlMode.PercentOutput, left);
    rightMotor1.set(ControlMode.PercentOutput, right);
    rightMotor2.set(ControlMode.PercentOutput, right);
  }

  public void kill()
  {
    leftMotor1.set(ControlMode.PercentOutput, 0);
    leftMotor2.set(ControlMode.PercentOutput, 0);
    rightMotor1.set(ControlMode.PercentOutput, 0);
    rightMotor2.set(ControlMode.PercentOutput, 0);
  }
}
