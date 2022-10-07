package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    private final IntakeIO intakeIO;

    public Intake(IntakeIO intakeIO) {
        this.intakeIO = intakeIO;
    }

    /** Run the roller at the specified percentage. */
    public void runIntakeVelocity(double velocity) {
        intakeIO.runIntake(velocity);
    }

    public void stop() {
        intakeIO.stopIntake();
    }
}
