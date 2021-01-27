// BlitzCreek 3770 - Genesis Project
// DriveHuman Command
// Allows player input of drivetrain

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

// Import Subsystem
import frc.robot.subsystems.DriveSystem;

public class Stop extends CommandBase 
{
  // Set vars
  private DriveSystem driveSystem;

  // Constructor
  public Stop(DriveSystem d)
  {
    driveSystem = d;
    addRequirements(driveSystem);
  }

  // Stops every motor
  @Override
  public void execute()
  {
    driveSystem.kill();
  }
}
