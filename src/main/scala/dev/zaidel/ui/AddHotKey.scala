package dev.zaidel.ui

import java.awt.Checkbox
import java.awt.event.ActionEvent
import javax.swing.{AbstractAction, JComponent, JPanel, KeyStroke}

trait AddHotKey extends JPanel {
  protected def setKey(keyEvent: Int, identifier: String, checkbox: Checkbox): Unit = {
    getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
      KeyStroke.getKeyStroke(keyEvent, 0), identifier
    )
    getActionMap().put(identifier, new AbstractAction() {
      override def actionPerformed(e: ActionEvent): Unit =  {
        checkbox.setState(!checkbox.getState)
      }
    })
  }
}
