package dev.zaidel.ui

import java.awt.event.{ActionEvent, KeyEvent}
import javax.swing.{AbstractAction, JCheckBox, JComponent, JPanel, KeyStroke}

trait AddHotKey extends JPanel {
  protected val reservedKeyEvents = List(
    KeyEvent.VK_1,
    KeyEvent.VK_2,
    KeyEvent.VK_3,
    KeyEvent.VK_4,
    KeyEvent.VK_5,
    KeyEvent.VK_6,
    KeyEvent.VK_7,
    KeyEvent.VK_8,
    KeyEvent.VK_9,
    KeyEvent.VK_0,
    KeyEvent.VK_Q,
    KeyEvent.VK_W,
    KeyEvent.VK_E,
    KeyEvent.VK_R,
    KeyEvent.VK_T,
    KeyEvent.VK_Y,
    KeyEvent.VK_U,
    KeyEvent.VK_I,
    KeyEvent.VK_O,
    KeyEvent.VK_P
  ).zipWithIndex.map { case (k, v) => v -> k }.toMap

  protected def setKey(keyEvent: Int, identifier: String, checkbox: JCheckBox): Unit = {
    getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
      KeyStroke.getKeyStroke(keyEvent, 0), identifier
    )
    getActionMap().put(identifier, new AbstractAction() {
      override def actionPerformed(e: ActionEvent): Unit = {
        checkbox.setSelected(!checkbox.isSelected)
      }
    })
  }
}
