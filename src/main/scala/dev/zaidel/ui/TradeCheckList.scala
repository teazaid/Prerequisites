package dev.zaidel.ui

import javax.swing.SwingUtilities

object TradeCheckList extends App {
  val checkListPanel = new CheckListPanel()
  SwingUtilities.invokeLater(new Runnable() {
    override def run(): Unit = {
      checkListPanel.showPanel()
    }
  })
}