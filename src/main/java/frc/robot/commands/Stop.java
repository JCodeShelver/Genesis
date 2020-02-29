// BlitzCreek 3770 - Genesis Project
// DriveHuman Command
// Allows player input of drivetrain

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSystem;

public class Stop extends CommandBase 
{
  private DriveSystem driveSystem;

  public Stop(DriveSystem d)
  {
    driveSystem = d;
    addRequirements(driveSystem);
  }

  @Override
  public void execute()
  {
    driveSystem.kill();
  }
}
