// BlitzCreek 3770 - Genesis Project
// DriveHuman Command
// Allows player input of drivetrain

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

// Import Subsystems
import frc.robot.subsystems.DriveSystem;

public class DriveHuman extends CommandBase 
{
  // Set vars
  private final DriveSystem driveSystem;
  private DoubleSupplier leftValue;
  private DoubleSupplier rightValue;

  // Constructor
  public DriveHuman(DriveSystem d, DoubleSupplier left, DoubleSupplier right)
  {
    driveSystem = d;
    leftValue = left;
    rightValue = right;
    addRequirements(driveSystem);
  }

  // Passes user input into drive subsystem.
  @Override
  public void execute()
  {
    driveSystem.quadDrive(leftValue.getAsDouble(), rightValue.getAsDouble());
  }
}
