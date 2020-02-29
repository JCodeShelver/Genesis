// BlitzCreek 3770 - Genesis Project
// DriveHuman Command
// Allows player input of drivetrain

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import frc.robot.subsystems.DriveSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveHuman extends CommandBase 
{
  private final DriveSystem driveSystem;
  private DoubleSupplier leftValue;
  private DoubleSupplier rightValue;

  public DriveHuman(DriveSystem d, DoubleSupplier left, DoubleSupplier right)
  {
    driveSystem = d;
    leftValue = left;
    rightValue = right;
    addRequirements(driveSystem);
  }

  @Override
  public void execute()
  {
    driveSystem.drive(leftValue.getAsDouble(), rightValue.getAsDouble());
  }
}
