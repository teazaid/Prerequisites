package dev.zaidel.ui

import javax.swing.SwingUtilities

object PrerequisitesWindow extends App {
  val prerequisitesPanel = new PrerequisitesPanel()
  SwingUtilities.invokeLater(new Runnable() {
    override def run(): Unit = {
      prerequisitesPanel.showPanel()
    }
  })
}
