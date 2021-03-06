// BlitzCreek 3770 - Genesis Project
// DriveSystem Subsystem
// Controls the drivetrain

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Counter;

// External Library Imports
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

// Import Constants
import frc.robot.Constants;

public class DriveSystem extends SubsystemBase
{
  // Set vars
  private TalonSRX leftMotor1, leftMotor2;
  private TalonSRX rightMotor1, rightMotor2;
  private Counter leftEncoder, rightEncoder;

  private double adjustedLeft, adjustedRight;
  
  // Constructor
  public DriveSystem()
  {
    leftMotor1  = new TalonSRX(Constants.LEFT_MOTOR1_CAN_ID);
    leftMotor2  = new TalonSRX(Constants.LEFT_MOTOR2_CAN_ID);
    rightMotor1 = new TalonSRX(Constants.RIGHT_MOTOR1_CAN_ID);
    rightMotor2 = new TalonSRX(Constants.RIGHT_MOTOR2_CAN_ID);

    leftEncoder = new Counter(Constants.LT_ENCODER_CAN_ID);
    rightEncoder = new Counter(Constants.RT_ENCODER_CAN_ID);

    // Set the left motors to be inverted, because the motors face opposite directions.
    leftMotor1.setInverted(true);
    leftMotor2.setInverted(true);
    rightMotor1.setInverted(false);
    rightMotor2.setInverted(false);
  }

  // A quadratic function on the input lets small inputs be small, and large inputs be representative.
  public void quadDrive(double left, double right)
  {
    // We still have to keep the direction of the input (-x^2 = x^2)
    if (left < 0)
      adjustedLeft = -left * left;
    else
      adjustedLeft = left * left;
      
    if (right < 0)
      adjustedRight = -right * right;
    else
      adjustedRight = right * right;

    leftMotor1.set(ControlMode.PercentOutput, adjustedLeft);
    leftMotor2.set(ControlMode.PercentOutput, adjustedLeft);
    rightMotor1.set(ControlMode.PercentOutput, adjustedRight);
    rightMotor2.set(ControlMode.PercentOutput, adjustedRight);
  }

  // A kill function to stop every motor.
  public void kill()
  {
    leftMotor1.set(ControlMode.PercentOutput, 0);
    leftMotor2.set(ControlMode.PercentOutput, 0);
    rightMotor1.set(ControlMode.PercentOutput, 0);
    rightMotor2.set(ControlMode.PercentOutput, 0);
  }

  // A function to reset the motor encoders.
  public void zeroEncoder()
  {
    leftEncoder.reset();
    rightEncoder.reset();
  }
}
