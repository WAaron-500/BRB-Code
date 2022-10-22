package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveIOBRB implements DriveIO {

    public WPI_TalonSRX leftMotors;
    public WPI_TalonSRX rightMotors;

    public DriveIOBRB() {
        this.leftMotors = new WPI_TalonSRX(0);
        this.rightMotors = new WPI_TalonSRX(1);

        leftMotors.setInverted(false);
        rightMotors.setInverted(true);
    }

    @Override
    public WPI_TalonSRX getLeftMotors() {
        return leftMotors;
    }

    @Override
    public WPI_TalonSRX getRightMotors() {
        return rightMotors;
    }

    @Override
    public void setSpeed(double leftSpeed, double rightSpeed) {
        // controlmode.setSpeed
        leftMotors.set(leftSpeed);
        rightMotors.set(rightSpeed);
    }
}
