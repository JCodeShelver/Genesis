// BlitzCreek 3770 - Genesis Project
// Robot Container file
// Controlls Button bindings and 
// sets commands.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

// Import Commands
import frc.robot.commands.Auton;
import frc.robot.commands.DriveHuman;
import frc.robot.commands.Stop;

// Import Subsystems
import frc.robot.subsystems.DriveSystem;

public class RobotContainer
{
  // Set vars
  Joystick leftStick        = new Joystick(Constants.LEFT_STICK_USB_PORT);
  Joystick rightStick       = new Joystick(Constants.RIGHT_STICK_USB_PORT);
  XboxController controller = new XboxController(Constants.CONTROLLER_USB_PORT);

  private final DriveSystem driveSystem = new DriveSystem();
  
  // Constructor
  public RobotContainer()
  {
    configureButtonBindings();

    // Set the command to run when no other is used with the drivesystem with user input.
    driveSystem.setDefaultCommand(new DriveHuman(
      driveSystem,
      () -> leftStick.getY(),
      () -> rightStick.getY()));
  }

  // Configure button bindings.
  private void configureButtonBindings() 
  {
    // Pressing A will kill the motors.
    new JoystickButton(controller, XboxController.Button.kA.value).whileHeld(new Stop(driveSystem));
  }

  public Command getAutonomousCommand()
  {
    Command autonCommandChoice = new Auton(driveSystem);
    return autonCommandChoice;
  }
}
