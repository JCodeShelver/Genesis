// BlitzCreek 3770 - Genesis Project
// Robot Container file
// Controlls Button bindings and 
// sets commands.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.DriveHuman;
import frc.robot.commands.Auton;

import frc.robot.subsystems.DriveSystem;

public class RobotContainer
{
  Joystick leftStick        = new Joystick(Constants.LEFT_STICK_USB_PORT);
  Joystick rightStick       = new Joystick(Constants.RIGHT_STICK_USB_PORT);
  XboxController controller = new XboxController(Constants.CONTROLLER_USB_PORT);

  private final DriveSystem driveSystem = new DriveSystem();

  
  public RobotContainer()
  {
    driveSystem.setDefaultCommand(new DriveHuman(
      driveSystem,
      () -> leftStick.getY(),
      () -> rightStick.getY()));

    configureButtonBindings();
  }

  private void configureButtonBindings() 
  {
    
  }

  public Command getAutonomousCommand()
  {
    Command autonCommandChoice;
    autonCommandChoice = new Auton();
    return autonCommandChoice;
  }
}
