package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class IntakeIOBRB implements IntakeIO {

    private VictorSP intakeMotor;

    public IntakeIOBRB() {
        this.intakeMotor = new VictorSP(2);
    }

    @Override
    public void runIntake(double velocity) {
        intakeMotor.set(velocity);
    }

    @Override
    public void stopIntake() {
        intakeMotor.stopMotor();
    }
}
