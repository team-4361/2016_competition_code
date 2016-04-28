package org.usfirst.frc.team4361.robot;

public class TurnControl {
	double Cal;
	double angle;
	double targetAngle;
	double speed;
	
	public TurnControl(double angle)
	{
		speed = 0;
		Cal=angle;
		this.angle=angle-Cal;
	}
	public double turnAngle(double current, double target)
	{
		//get angle and ensure its 0<angle<=360
		angle =current-Cal;
		resetAngle();
		angle =current-Cal;

		//circumvents divide by 0 error
		if(target==0)
		{
			target =.1;
		}
		if(target<0)
		{
			target+=360;
		}
		double ratio = (angle-target)/target;
		
		//print statements for testing
		System.out.print("Cal is " + Cal+ " ");
		System.out.print("angle is "+ angle + " ");
		System.out.print("ratio is " + ratio + " ");
		
		//set ratio and ensure speed is between .15 and .65		
		if(Math.abs(ratio)<.08)
		{
			speed = 0;
		}
		else if(Math.abs(ratio)<.22)
		{
			speed=.24;
		}
		else if(Math.abs(ratio)>.45)
		{
			speed =.45;
		}
		else
		{
			speed = Math.abs(ratio);
		}
		
		//make sure speed is set properly for negative and positive
		if(ratio<0)
		{
			speed*=-1;
		}
		return speed;
		
	}
	//get angle and ensure its 0<angle<=360
	public void resetAngle()
	{
		if(angle>=370)
		{
			Cal+=360;
		}
		if(angle<=-370)
		{
			Cal-=360;
		}
	}

}
