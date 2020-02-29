// BlitzCreeek 3770 - Genesis Project
// GyroPID Subsystem
// Controlls Gyroscope

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

import frc.robot.Constants;

public class GyroPID extends PIDSubsystem
{
    private ADXRS450_Gyro gyro;

    private double pidOutput, currentSetpoint;

    public GyroPID()
    {
        super(new PIDController(Constants.GYRO_PID_P, Constants.GYRO_PID_I, Constants.GYRO_PID_D));
        gyro = new ADXRS450_Gyro(SPI.Port.kMXP);

        getController().setTolerance(Constants.GYRO_PID_TOLERANCE);   // Degree tolerance for set point
    }
    
	// Primary action to get current gyro angle measure.  Defined as abstract and there
	// mandated.  Automatically called periodically.
	@Override
	public double getMeasurement() 
	{
    	return gyro.getAngle(); 
	}

	// Consumes output of PID controller using current set point.  Automatically called
	// periodically.
	@Override
	public void useOutput(double output, double setpoint)
	{
		pidOutput        = output;
		currentSetpoint  = setpoint;
	}

	// Getter action to retrieve calculated PID output.
	public double getOutput()
	{
		return pidOutput;
	}

	// Getter action to retrieve current setpoint
	public double getSetpoint()
	{
		return currentSetpoint;
	}		

	// Zero gyro reading
	public void resetGyro()
	{	
        gyro.reset();
    }

    // Adjust "P" value
	public void setPvalue(double newP)
	{
		getController().setP(newP);
	}
}