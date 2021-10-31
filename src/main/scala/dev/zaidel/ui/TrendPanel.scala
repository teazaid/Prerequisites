package dev.zaidel.ui

import java.awt.GridLayout
import javax.swing.{JPanel, JRadioButton}

class TrendPanel(trend: String) extends JPanel {
  import javax.swing.ButtonGroup

  setLayout(new GridLayout(1, 1))

  val group = new ButtonGroup()
  private val shortButton = new JRadioButton(s"${trend} Шорт")
  group.add(shortButton)
  private val longButton = new JRadioButton(s"${trend} Лонг")
  group.add(longButton)

  add(shortButton)
  add(longButton)
}
