package frc.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class MatthewControls implements UserControls {

    private final Joystick leftDriverJoystick;
    private final Joystick rightDriverJoystick;

    public MatthewControls(int leftDriverJoystickPort, int rightDriverJoystickPort) {
        this.leftDriverJoystick = new Joystick(leftDriverJoystickPort);
        this.rightDriverJoystick = new Joystick(rightDriverJoystickPort);
    }

    @Override
    public double getLeftDriveX() {
        return leftDriverJoystick.getX();
    }

    @Override
    public double getLeftDriveY() {
        return leftDriverJoystick.getY();
    }

    @Override
    public double getRightDriveX() {
        return rightDriverJoystick.getX();
    }

    @Override
    public double getRightDriveY() {
        return rightDriverJoystick.getY();
    }

    @Override
    public Trigger ClimbUpButton() {
        return new Trigger(() -> rightDriverJoystick.getRawButton(1));
    }

    @Override
    public Trigger ClimbDownButton() {
        return new Trigger(() -> leftDriverJoystick.getRawButton(1));
    }

    @Override
    public Trigger getIntakeRunInButton() {
        return new Trigger(() -> rightDriverJoystick.getRawButton(3));
    }

    @Override
    public Trigger getIntakeRunOutButton() {
        return new Trigger(() -> leftDriverJoystick.getRawButton(3));
    }

}
