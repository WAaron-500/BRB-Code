package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class DriveIOBRB implements DriveIO {

    public VictorSP leftMotors;
    public VictorSP rightMotors;

    public DriveIOBRB() {
        this.leftMotors = new VictorSP(0);
        this.rightMotors = new VictorSP(1);

        leftMotors.setInverted(true);
    }

    @Override
    public VictorSP getLeftMotor() {
        return leftMotors;
    }

    @Override
    public VictorSP getRightMotor() {
        return rightMotors;
    }

    @Override
    public void setSpeed(double leftSpeed, double rightSpeed) {
        // controlmode.setSpeed
        leftMotors.set(leftSpeed);
        rightMotors.set(rightSpeed);
    }
}
