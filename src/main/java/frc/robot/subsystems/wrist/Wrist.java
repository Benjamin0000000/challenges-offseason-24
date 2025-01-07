package frc.robot.subsystems.wrist;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wrist extends SubsystemBase {
  // For instructions on how to implement this class, refer to the README.md file
  private WristIO m_io;
  private WristInputsAutoLogged m_inputs;
  private PIDController m_controller;
  private double desiredAngle;

  public Wrist(WristIO io, PIDController controller) {
    // TODO: Implement the constructor
    m_io = io;
    m_controller = controller;
    m_inputs = new WristInputsAutoLogged();
    desiredAngle = 0.0;
    // 3° tollerance
  }

  @Override
  public void periodic() {
    m_io.updateInputs(m_inputs);
    m_io.setVoltage(m_controller.calculate(m_io.getAngle().getDegrees(), desiredAngle));
    // TODO: Implement this method
  }

  public void setDesiredAngle(Rotation2d angle) {
    // TODO: Implement this method
    desiredAngle = angle.getDegrees();
  }

  public Command setDesiredAngleCommand(Rotation2d angle) {
    // TODO: Implement this method
    return runOnce(() -> setDesiredAngle(angle));
  }

  public boolean withinTolerance() {
    // TODO: Implement this method
    return m_controller.atSetpoint();
  }

  public WristInputsAutoLogged getInputs() {
    // TODO: Implement this method
    return m_inputs;
  }
}
