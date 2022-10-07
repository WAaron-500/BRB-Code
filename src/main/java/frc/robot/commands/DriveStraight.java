package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain.DriveBase;

public class DriveStraight extends CommandBase {
    private final DriveBase drive;
    private final double speed;

    public DriveStraight(DriveBase drive, double speed) {
        setName("DriveStraight");
        addRequirements(drive);
        this.drive = drive;
        this.speed = speed;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        drive.driveBase.curvatureDrive(speed, 0, false);
    }

    @Override
    public void end(boolean interrupted) {
        drive.driveSpeed(0.0, 0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
